package myscala.basic

class 偏函数 {

}

object 偏函数 {
  def main(args: Array[String]): Unit = {
  }
  //  偏函数的操作：
  //  1、区分输入的值 isDefinedAt() apply()
  //  2、case区分不同条件
  //  3、orElse的两种操作
  //  4、andThen 管道操作
  var divide = (x: Int) => {
    100 / x
  } //输入0产生异常
  var divide1 = new PartialFunction[Int, Int] {
    //判断x是否等于0，当x = 0时返回false
    def isDefinedAt(x: Int): Boolean = x != 0

    def apply(x: Int): Int = 100 / x
  }
  private val bool = divide1.isDefinedAt(0)
  println(bool) //避免了异常
  //----------------------------------
  var divide2: PartialFunction[Int, Int] = {
    case x: Int if x != 0 => 100 / x
    case _ => -1
  }
  //----------------------------------
  var divider3: PartialFunction[Int, String] = {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }
  //-------------orelse---------------------
  val or1: PartialFunction[Int, String] = {
    case 1 => "One"
  }

  val or2: PartialFunction[Int, String] = {
    case 2 => "Two"
  }

  val or_ : PartialFunction[Int, String] = {
    case _ => "Other"
  }

  val or = or1 orElse or2 orElse or_ //使用orElse将多个偏结合起来
  println(or(1))
  println(or(20))
  //-------------orElse还可以直接连接case使用---------------------
  var orElsee: (Int => String) = or1 orElse { case _ => "other" }
  //-------------andThen链接部分函数---------------------
  // andThen是对函数做链接，范围更大，注意函数入参个数要一致
//  def andThen[C](k: (B) => C): PartialFunction[A, C]
  val at1: (Int => String) = {
    case cs if cs == 1 => "One"
  }
  val at2: PartialFunction[String, String] = {
    case cs if cs eq "One" => "The num is 1"
  }
  val num = at1 andThen at2
  println(num(1))

  // ---

  val f: (Int, Int) => Int = _ + _
  val g: Int => String = _ +  ""
  val h = f.tupled andThen g
  println(h(1,2))
}