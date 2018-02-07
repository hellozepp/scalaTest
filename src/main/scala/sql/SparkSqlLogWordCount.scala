package sql

import java.io.File

import org.apache.spark.sql.{Row, SparkSession}

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

    val allIpCountSQL="select count(DISTINCT _c1 from log) "

    val ipCountSQL="select _c1 as IP,count(_c1) as ipCount from log group by _c1 order by ipCount desc limit 10"
    //查询独立ip总数
sparkSession.sql(allIpCountSQL).foreach(row=>println("独立IP总数:"+row.get(0)))

    //查看ip数前10
  sparkSession.sql(ipCountSQL).foreach(row=>println("IP:"+row.get(0)+"次数:"+row.get(1)))
  }

}
