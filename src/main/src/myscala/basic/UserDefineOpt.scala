package myscala.basic

/**
  * 22/07/2022 hellozepp(lisheng.zhanglin@163.com)
  */
class UserDefineOpt {

}

/**
  * 从语法上来说scala是没有运算符的。scala的运算符实际上是方法名
  * 既然scala中看起来像运算符的东西都是方法，那么和运算符相关的一些内容，比如算数优先级，scala是怎样处理的呢？
  * scala中确实没有算数优先级、但是它定义了方法优先级：方法的优先级由方法名的第一个字符决定，如果表达式里有两个相同优先级的方法，
  * 那么左边的方法优先级更高。（scala的这个设定蛮有趣的，解决了算数优先级的问题，而且说不定什么地方就能带出一些惊喜来）。下面从
  * 低到高列出了scala中方法名首字符的优先级
  *
  *         |
  *        ^
  *         &
  *        < >
  *       =  !
  *        :
  *      +   -
  *     *  /  %
  */
object UserDefineOpt {
  val c1 = new Complex(1, 4)
  val c2 = new Complex(2, -3)
  val c3 = new Complex(2, 2)

  def main(args: Array[String]): Unit = {

  }
  println(c1 + c2 * c3)

  class Complex(val real: Int, val imaginary: Int) {

    def +(operand: Complex): Complex = {
      println("Calling +")
      new Complex(real + operand.real, imaginary + operand.imaginary)
    }


    def *(operand: Complex): Complex = {
      println("Calling *")
      new Complex(real * operand.real - imaginary * operand.imaginary, real * operand.imaginary + imaginary * operand.real)
    }

    override def toString(): String = {
      real + (if (imaginary < 0) "" else "+") + imaginary + "i"
    }
  }
}
