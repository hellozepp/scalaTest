package myscala.basic

/**
  * Created by docker on 2017/5/22.
  */
class Operational {

}

object TestOpt {
  def main(args: Array[String]): Unit = {
    var a = 10;
    var b = 20;
    var c = 25;
    var d = 25;
    println("a + b = " + (a + b));
    println("a - b = " + (a - b));
    println("a * b = " + (a * b));
    println("b / a = " + (b / a));
    println("b % a = " + (b % a));
    println("c % a = " + (c % a));

    println("====================")
    println("a + b = " + (a + b));
    println("a - b = " + (a - b));
    println("a * b = " + (a * b));
    println("b / a = " + (b / a));
    println("b % a = " + (b % a));
    println("c % a = " + (c % a));
    println("====================")

    def sum(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }

    var total = sum(1, 2, 3, 4)
    println(total)

    println("====================")
    // :_*作为一个整体，告诉编译器你希望将某个参数当作参数序列处理！例如val s = sum(1 to 4:_*)就是将1 to 4当作参数序列处理。
    total = sum2(1 to 4: _*)
    println(total)

    //变长参数
    def sum2(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }

  }
}