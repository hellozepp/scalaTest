package myscala.basic.traitTest

/**
  * Created by docker on 2017/5/22.
  * 特质
  * trait: 接口和抽象类的整合
  * trait 不可以传参
  */
//作为接口使用
object Tezhi {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqu(p2)) //false
    println(p1.isNotEqu(p3)) //true
    println(p1.isNotEqu(2)) //true
  }

  // 特质必须先写extends，多继承一个extends多个with
  class Point(xc: Int, yc: Int) extends chuai with chuai2 {
    var x: Int = xc
    var y: Int = yc

    def isEquals(obj: Any): Boolean =
      obj.isInstanceOf[Point] &&
        obj.asInstanceOf[Point].x == x
  }

}

trait chuai2 {}

trait chuai {
  def isEquals(x: Any): Boolean

  def isNotEqu(x: Any): Boolean = !isEquals(x)

  def write(msg: String) {
    println(msg)
  } //特质可以写方法
}