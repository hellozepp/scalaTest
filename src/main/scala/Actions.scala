import org.apache.spark.{SparkConf, SparkContext}

object Actions {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("Actions").setMaster("local")
    conf.set("spark.driver.allowMultipleContexts","true")
    val sc=new SparkContext(conf)
//reduceAction(sc)
//    collectAction(sc)
//    countAction(sc)
//    topAction(sc)
//    countByValue(sc)
    saveAsTextFileAction(sc)
    sc.stop()
  }

  /**
    * 并行整合RDD中所有数据
    * @param sc
    */
  def reduceAction(sc:SparkContext):Unit={
    val numbers=sc.parallelize(1 to 5)
    val sum=numbers.reduce(_+_)
    println(sum)
  }

  def collectAction(sc:SparkContext):Unit={
    val numbers=sc.parallelize(1 to 10)
    val data=numbers.map(item =>item*2)
    val result=data.collect()
    result.foreach(println)
  }

  /**
    * RDD中元素的个数
    * @param sc
    */
  def countAction(sc:SparkContext):Unit={
    val numbers=sc.parallelize(1 to 100)
    val result=numbers.count()
    println(result)

  }

  /**
    * 从RDD中返回最前面的num个元素
    * @param sc
    */
  def topAction(sc:SparkContext):Unit={
    val numbers=sc.parallelize(1 to 100)
    val result=numbers.top(5)
    result.foreach(println)
  }

  /**
    * RDD中各个元素的个数
    * @param sc
    */
  def countByValue(sc:SparkContext):Unit={
    val numbers=sc.parallelize(Array(1,2,3,4,5,6,4,3,1,3))
    val result=numbers.countByValue()
    print(result)
  }

  /**
    * 将RDD保存到Hadoop，每个task都会保存成一个文件
    * 这个最好在集群中使用
    * 因此为了减少文件数量，可以使用repartition或者coalesce减少分区数量
    * repartition和coalesce是有区别的，repartition更倾向于增大分区，因为它使用了shuffle，需要单独写一遍博客对比它们的不同
    *
    * 注意: 保存的路径写到目录即可，而且该目录是不存在的
    * @param sc
    */
  def saveAsTextFileAction(sc: SparkContext): Unit = {
    val numbers = sc.parallelize(1 to 100)
    println("-------------start!------------")
    numbers.coalesce(1, false).saveAsTextFile("d:/home/num.txt")

    println("-------------start!------------")

  }
}
