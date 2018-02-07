package sql

import java.io.File
import java.sql.Date
import java.text.SimpleDateFormat

import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

/**
  * 学习链接 http://blog.csdn.net/whzhaochao/article/details/72529351
  */
object SparkSqlLogWordCount {
  def main(args: Array[String]): Unit = {

    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    val sparkSession = SparkSession
      .builder()
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()
    /**
      * 加载结构化数据
      */
    //获取文件路径
    val path=SparkSqlLogWordCount.getClass.getClassLoader.getResource("cdn.csv").getPath
    //读取文件
    val df=sparkSession.read.csv(path)
    //将加载的数据临时命名为log
    df.createOrReplaceTempView("log")

    val allIpCountSQL="select count(DISTINCT _c1) from log"

    val ipCountSQL="select _c1 as IP,count(_c1) as ipCount from log group by _c1 order by ipCount desc limit 10"
    //查询独立ip总数
sparkSession.sql(allIpCountSQL).foreach(row=>println("独立IP总数:"+row.get(0)))

    //查看ip数前10
  sparkSession.sql(ipCountSQL).foreach(row=>println("IP:"+row.get(0)+"次数:"+row.get(1)))

    //查询每个视频独立IP数
    val videoIpCount="select _c0,count(DISTINCT _c1) as count from log  group by _c0 order by count desc  limit 10 "
    sparkSession.sql(videoIpCount).foreach(row=>println("IP:"+row.get(0)+" 次数:"+row.get(1)))

    def  getHour(time:String)={
      val date=new Date(Integer.valueOf(time)*1000);
      val sf=new SimpleDateFormat("HH");
      sf.format(date)
    }

    //查询每个小时视频流量
    val hourCdnSQL="select _c4,_c8 from log "
    //取出时间和大小将格式化时间，RDD中格式为 (小时,大小)
    val dataRdd= sparkSession.sql(hourCdnSQL).rdd.map(row=>Row(getHour(row.getString(0)),java.lang.Long.parseLong(row.get(1).toString)))

    val schema=StructType(
      Seq(
        StructField("hour",StringType,true)
        ,StructField("size",LongType,true)
      )
    )

    //将dataRdd转成DataFrame
    val peopleDataFrame = sparkSession.createDataFrame(dataRdd,schema)
    peopleDataFrame.createOrReplaceTempView("cdn")
    //按小时分组统计
    val results = sparkSession.sql("SELECT hour , sum(size) as size  FROM cdn group by hour  order by hour ")
    results.foreach(row=>println(row.get(0)+"时 流量:"+row.getLong(1)/(1024*1024*1024)+"G"))
  }

}
