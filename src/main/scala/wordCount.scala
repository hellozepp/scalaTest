import org.apache.spark.{SparkConf, SparkContext}

object wordCount {
  def main(args: Array[String]): Unit = {
    /**
      * 1.创建spark的配置对象SparkConf,设置Spark程序运行时的配置信息
      * setMaster设置程序运行在本地还是运行在集群中，运行在本地可是使用local参数，也可以使用local[K]/local[*],
      * 可以去spark官网查看它们不同的意义。 如果要运行在集群中，以Standalone模式运行的话，需要使用spark://HOST:PORT
      * 的形式指定master的IP和端口号，默认是7077
      */

    //    System.setProperty("hadoop.home.dir", "E:\\studyTool\\hadoop-2.6.4\\hadoop-2.6.4")
       val conf=new SparkConf().setAppName("WordCount").setMaster("local[4]")
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
    val lines=sc.textFile("demo.txt") //读取本地文件

    //  val lines = sc.textFile("/library/wordcount/input")   // 读取HDFS文件，并切分成不同的Partition
    //  val lines = sc.textFile("hdfs://master:9000/libarary/wordcount/input")  // 或者明确指明是从HDFS上获取数据


    val words=lines.flatMap(_.split(" ")).filter(word => word!=" ") //拆分单词，并过滤掉空格

    val pairs=words.map(word=>(word,1)) //在单词拆分的基础上对每个单词实例计数为1，也就是word=>(word,1)


    val wordscount=pairs.reduceByKey(_+_) //在每个单词实例技术为1的基础之上统计每个单词在文件中出现的总次数
    //即key相同的value相加

    //val wordscount=pairs.reduceByKey((v1+v2)=>v1+v2)


    wordscount.collect().foreach(println) //打印结果，使用collect会将集群中的数据收集到当前运行drive的机器上，需要保证单台机器能放得下所有数据

    sc.stop() //释放资源

  }
}
