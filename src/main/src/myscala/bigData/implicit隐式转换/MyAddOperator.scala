package myscala.bigData.implicit隐式转换

class MyAddOperator {

}

object MyAddOperator extends App {
  var i: Int = 5

  import PreDif._

  println(i ++)
  val jiajia = 1 ++ () ++ () ++ () ++ () ++ () ++ ()
  println("jiajia:" + jiajia)
  2 -- ()
  println((3).+-(3)(2))
  (2 -+ 2) (3)
  // i = 6, 先用后加的特性
  Console print "迭代求和:" + ((((i ++) ++) ++) ++)
  i = 6
  i = ((((i ++) ++) ++) ++)
  Console print "迭代求和:" + i
}

object PreDif {

  implicit class opts(i: Int) {
    def ++(): Int = {
      i + 1
    }

    def --(): Int = {
      i - 1
    }

    def +-(x: Int)(y: Int): Int = {
      i + x - y
    }

    def -+(x: Int)(y: Int): Int = {
      i + y - x
    }
  }

}