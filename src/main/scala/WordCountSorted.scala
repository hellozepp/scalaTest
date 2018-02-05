import org.apache.spark.{SparkConf, SparkContext}

object WordCountSorted {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("WordCountSorted").setMaster("local[4]")
    conf.set("spark.driver.allowMultipleContexts","true")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("D:/studyCode/resource/wordcount.txt")
    val words = lines.flatMap(_.split(" ")).filter(word => word != " ")
    val pairs = words.map(word => (word, 1))

    /**
      * 在这里通过reduceByKey方法之后可以获得每个单词出现的次数
      * 第一个map将单词和出现的次数交换，将出现的次数作为key，使用sortByKey进行排序（false为降序）
      * 第二个map将出现的次数和单词交换，这样还是恢复到以单词作为key
      */
    val wordcount = pairs.reduceByKey(_ + _).map(pair => (pair._2, pair._1)).sortByKey(false).map(pair => (pair._2, pair._1))
    wordcount.collect.foreach(println)

    sc.stop()
  }
}
