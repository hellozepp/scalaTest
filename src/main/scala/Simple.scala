object Simple {
  def main(args: Array[String]): Unit = {
    val value=1 to 5
    val result=  value match{
      case Seq(_,_*) => 6100
      case _ =>"result"
    }
    println(result)
  }
}
