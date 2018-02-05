import org.apache.spark.{SparkConf, SparkContext}

object StatCount {
  /**
    * 统计日志中文件访问数量
    * 功能：
    * 通过分析CDN或者Nginx的日志文件，统计出访问的PV\UV\IP地址、访问来源等相关数据
    * @param args
    */
  def main(args: Array[String]): Unit = {
    /**
      * 1.创建spark的配置对象SparkConf,设置Spark程序运行时的配置信息
      * setMaster设置程序运行在本地还是运行在集群中，运行在本地可是使用local参数，也可以使用local[K]/local[*],
      * 可以去spark官网查看它们不同的意义。 如果要运行在集群中，以Standalone模式运行的话，需要使用spark://HOST:PORT
      * 的形式指定master的IP和端口号，默认是7077
      */

    //    System.setProperty("hadoop.home.dir", "E:\\studyTool\\hadoop-2.6.4\\hadoop-2.6.4")
    val conf=new SparkConf().setAppName("StatCount").setMaster("local[4]")
    conf.set("spark.driver.allowMultipleContexts","true")

    //val conf=new SparkConf().setAppName("WordCount").setMaster("spark://10.1.170.61:8020") //运行在集群中

    /**
      * 2.创建SparkContext对象
      * SparkContext是Spark程序所有功能的唯一入口
      * SparkContext核心作用：初始化Spark应用程序运行所需要的核心组件，包括DAGScheduler、TaskScheduler、SchedulerBackend
      * 同时还会负责Spark程序往Master注册程序
      */

    val sc=new SparkContext(conf)

    /**
      * 3.根据具体的数据来源(HDFS\HBase\Local FS\DB\S3等)通过SparkContext来创建RDD
      * 创建RDD有三种基本方式：
      * ~根据数据来源
      * ~根据scala集合来使用SparkContext的parallelize方法
      * ~由其他RDD操作产生
      * 数据会被RDD 划分称为一系列的Partitions,分配到每个Partition的数据属于一个Task的处理范畴
      */
    val input=sc.textFile("D:/studyCode/sparkex/logs/count.log") //读取本地文件

    //匹配ip的正则
      val  IPPattern="((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))".r
      //统计独立ip数
    val ipNums=input.flatMap(x=>IPPattern findFirstIn(x)).map(x=>(x,1)).reduceByKey((x,y)=>x+y).sortBy(_._2,false)
    //输出ip访问数量前10位
    ipNums.take(10).foreach(println)
    println("独立ip数:"+ipNums.count())

  }

}
