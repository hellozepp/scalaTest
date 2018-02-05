import org.apache.spark.{SparkConf, SparkContext}

object Transformations {

  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("Transformations").setMaster("local")

    conf.set("spark.driver.allowMultipleContexts","true")

    val sc=new SparkContext(conf)
    //mapTransformation(sc)
   // filterTransformation(sc)
//    flatMapTransformation(sc)
//    reduceByKeyTransformation(sc)
//    groupByKeyTransformation(sc)
//    joinTransformation(sc)
    leftOuterJoinTransformation(sc)
    sc.stop()
  }

  /**
    * 将函数应用于RDD的每个元素，将返回值构成新的RDD
    * @param sc
    */
 def  mapTransformation(sc:SparkContext):Unit={
  val numbers=sc.parallelize(1 to 10) //根据集合构建RDD
   val mapped=numbers.map(item =>2 * item) //每个元素扩大2倍
   mapped.collect.foreach(println)

 }

  /**
    * 返回一个由通过filter()函数的元素组成的RDD，结果为true的元素会返回
    * @param sc
    */
  def filterTransformation(sc:SparkContext):Unit={
    val numbers=sc.parallelize(1 to 10)
    val filtered=numbers.filter(item=>item%2==0)
    filtered.collect.foreach(println)
  }

  /**
    * 将函数应用于RDD中的每个元素，将返回的迭代器的所有内容构成新的RDD。通常用来切分单词
    * @param sc
    */

  def flatMapTransformation(sc:SparkContext):Unit={
    val lines=Array("What makes life dreary is the want of motive\", \"Hello Spark\", \"Hello World")
    val linesRDD=sc.parallelize(lines)
    val words=linesRDD.flatMap(line=>line.split(" "))
    words.collect.foreach(println)
  }

  /**
    * reduceByKey必须用于元素是(key value)的元素，把key相同的元素进行merge操作
    * 它能够在本地进行merge操作，并且merge操作可以通过函数自定义
    * @param sc
    */
  def reduceByKeyTransformation(sc:SparkContext):Unit={
    val lines=Array("What makes life dreary is the want of motive\", \"Hello Spark\", \"Hello World")
    val linsRDD=sc.parallelize(lines)
    val words=linsRDD.flatMap(_.split(" ")).map(word=>(word,1))
    val wordCount=words.reduceByKey(_+_)
    wordCount.collect.foreach(println)

  }

  /**groupBykey也是对每个key进行合并操作，但是只生成一个sequence,
    * groupByKey本身不能自定义操作函数
    *
    * @param sc
    */
  def groupByKeyTransformation(sc:SparkContext):Unit={
    val data=Array(Tuple2("David","math"), Tuple2("David", "Music"),
      Tuple2("Mary", "Math"), Tuple2("Mary", "Art"),
      Tuple2("Allin", "Computer"))
    val dataRDD=sc.parallelize(data)
    val grouped=dataRDD.groupByKey()
    grouped.collect.foreach(println)
  }

  /**
    * 将两个RDD进行内链接
    * 只有两个RDD中都有的key才会输出
    * @param sc
    */
  def joinTransformation(sc:SparkContext):Unit={
  val idAndName = Array(Tuple2(1, "David"), Tuple2(2, "Mary"), Tuple2(3, "Allin"))
  val idAndScore = Array(Tuple2(1, 98), Tuple2(2, 90), Tuple2(3, 86))
  val names=sc.parallelize(idAndName)
  val scores=sc.parallelize(idAndScore)
  val nameAndScore=names.join(scores)
  nameAndScore.collect.foreach(println)
}

  /**
    * 对两个RDD进行连接操作，确保第一个RDD的键必须存在
    * 连接后，缺省的val为None
    * @param sc
    */
  def leftOuterJoinTransformation(sc:SparkContext):Unit={

    val idAndName = Array(Tuple2(1, "David"), Tuple2(2, "Mary"), Tuple2(3, "Allin"))
    val idAndScore = Array(Tuple2(1, 98), Tuple2(2, 90))

    val names = sc.parallelize(idAndName)
    val scores = sc.parallelize(idAndScore)
    val nameAndScore = names.leftOuterJoin(scores)
    nameAndScore.collect.foreach(println)
  }
  /**
    * 对两个RDD进行连接操作，确保第二个RDD的键必须存在，与leftOuterJoin正好相反
    * 输出结果：
    * (1,(Some(David),98))
    * (3,(None,86))
    * (2,(Some(Mary),90))
    * @param sc
    */
  def rightOuterJoinTransformation(sc: SparkContext): Unit = {
    val idAndName = Array(Tuple2(1, "David"), Tuple2(2, "Mary"))
    val idAndScore = Array(Tuple2(1, 98), Tuple2(2, 90), Tuple2(3, 86))

    val names = sc.parallelize(idAndName);
    val scores = sc.parallelize(idAndScore)
    val nameAndScore = names.rightOuterJoin(scores)
    nameAndScore.collect.foreach(println)
  }

  /**
    * 将两个RDD中用有相同键的数据分组到一起
    * 输出结果：
    * (1,(CompactBuffer(David, Frank),CompactBuffer(98, 93)))
    * (3,(CompactBuffer(Allin, Carry),CompactBuffer(86, 83)))
    * (2,(CompactBuffer(Mary, Duncan),CompactBuffer(90, 80)))
    * @param sc
    */
  def cogroupTransformation(sc: SparkContext): Unit = {
    val idAndName = Array(Tuple2(1, "David"), Tuple2(1, "Frank"),
      Tuple2(2, "Mary"), Tuple2(2, "Duncan"),
      Tuple2(3, "Allin"), Tuple2(3, "Carry"))
    val idAndScore = Array(Tuple2(1, 98), Tuple2(1, 93),
      Tuple2(2, 90), Tuple2(2, 80),
      Tuple2(3, 86), Tuple2(3, 83))

    val names = sc.parallelize(idAndName);
    val scores = sc.parallelize(idAndScore)
    val nameAndScore = names.cogroup(scores)
    nameAndScore.collect.foreach(println)
  }
}
