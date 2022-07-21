object Simple {
  def main(args: Array[String]): Unit = {
    /*val value=1 to 5
    val result=  value match{
      case Seq(_,_*) => 6100
      case _ =>"result"
    }
    println(result)*/

    val newList = List(1, 2, 3).map(x => x * 2)
    newList.foreach(println)
  }

  def doubles(x: => Int) = {
    println("Now doubling " + x)
    x * 2
  }

}