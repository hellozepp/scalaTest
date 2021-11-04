package hello


object TupleOps {

  def main(args: Array[String]): Unit = {
    // tuple元祖
    var triple = (100, "Scala", "Spark")
    println(triple.getClass)
    println(triple._1)
    println(triple._2)
    println(triple._3)
    println("--------2---------")
    //triple = new Tuple3(1, 3.14, "Fred") //元祖定义好不支持重新赋值类型
    triple = new Tuple3(1, "", "Fred")
    println(triple._1)
  }

}