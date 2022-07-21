package myscala.bigData.implicit隐式转换

class MyAddOperator {

}

class Systemx {
  def apply(): Systemx = { new Systemx}

  def cout(arg: String): Unit = {
    println(arg)
  }
}

object MyAddOperator{
  var i: Int = 5
  import PreDif._

  println(i++)
  val jiajia = 1 ++ () ++ () ++ () ++ () ++ () ++ ()
  println("jiajia:" + jiajia)
  2 -- ()
  println((3).+-(3)(2))

  (2 -+ 2) (3)
  // i = 6, 先用后加的特性
  Console print "迭代求和:" + ((((i ++) ++) ++) ++)
  i = 6
  i = ((((i ++) ++) ++) ++)
  Console println "迭代求和:" + i


  val x = 1
  println(x +++ 2 +++ 3)
  cout << "xxxxxx" << "vvvv" << endl;

  def main(args: Array[String]): Unit ={

  }
}

object PreDif {
  val cout = new Systemx()
  val endl = new Endl()

  class Endl {}

  implicit class SystemOut(i: Systemx) {
    def <<(value: String): String = {
      print(value)
      value
    }
  }

  implicit class SystemOut1(i: String) {
    def <<(value: String): String = {
      print(value)
      value
    }

    def <<(value: Endl): Unit = {
    }
  }

  implicit class opts(i: Int) {
    def ++(): Int = {
      i + 1
    }

    def +++(another: Int): Int = {
      i + another
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