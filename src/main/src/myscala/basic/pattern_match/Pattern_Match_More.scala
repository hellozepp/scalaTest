package myscala.basic.pattern_match


/**
  * -------------------Scala中模式常量要以大写字母开头。所以这里一定要注意大小写,如果偏要使用这个值的话可以通过对象或类来引用(this)这个变量
  */
object Pattern_Match_More {

  def main(args: Array[String]) {

    def match_type(t: Any) = t match {
      case p: Int => println("It is Integer:" + p)
      case p: String => println("It is String, the content is : " + p)
      case m: Map[_, _] => m.foreach(println)
      case _ => println("Unknown type!!!")
    }

    println("-----------match_type(2)--------------")
    match_type(2)
    println("-----------match_type(\"Spark\")--------------")
    match_type("Spark")
    println("-----------match_type(Map--------------")
    match_type(Map("Scala" -> "Spark"))

    def match_list(lst: Any) = lst match {
      case 0 :: Nil => println("List:" + "0")
      case x :: y :: Nil => println("List:" + x + " " + y)
      case 0 :: tail => println("List:" + "0 ...")
      case _ => println("something else")
    }

    match_list(List(0))
    match_list(List(3, 4))
    match_list(List(0, 1, 2, 3, 4, 5))


    def match_tuple(tuple: Any) = tuple match {
      case (0, _) => println("Tuple:" + "0")
      case (x, 0) => println("Tuple:" + x)
      case _ => println("something else")
    }

    match_tuple((0, "Scala"))
    match_tuple((2, 0))
    match_tuple((0, 1, 2, 3, 4, 5))
    println("-----------match case常量和变量--------------")
    class Sample {
      var max = 100
      max = 1
      val MIN = 0
      def process(input: Int) {
        input match {
          case max => println("Don't try this at home")
          case MIN => println("You matched min")
          case _ => println("Unreachable!!")
        }
      }
    }
    new Sample().process(100)
    new Sample().process(0)
    new Sample().process(10)
  }

}