import org.apache.spark.{SparkConf, SparkContext}

object SecondarySortApp {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("SecondarySortApp").setMaster("local")

    conf.set("spark.driver.allowMultipleContexts","true")

    val sc=new SparkContext(conf)

    val lines=sc.textFile("D:/studyCode/resource/spark.txt")

    val pairRDD=lines.map(line=>{
      val splited=line.split(" ")
      val key=new SecondarySortKey(splited(0).toInt,splited(1).toInt)
      (key,line)
    })
    val sorted=pairRDD.sortByKey(false)
    val result=sorted.map(item =>item._2)
    result.collect().foreach(println)
  }

}
