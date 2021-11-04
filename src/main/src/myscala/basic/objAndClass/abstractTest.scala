package myscala.basic.objAndClass

/**
  * Created by docker on 2017/4/14.
  */
class abstractTest {

}

abstract class Person3 {
  def speak()

  def name: String

  def age: Int

  def sex: String
}

abstract class Student1 extends Person3 {
  def speak(): Unit = {
    //unit 代表没有返回值
    println("speak")
  }
}

object abstractTest extends App {
  //继承抽象类，实现剩余方法
  val s = new Student1() {
    override def name: String = ??? //可以选择不实现

    override def age: Int = ???

    override def sex: String = ???
  }
  s.speak()
}


//闭包
object Test2 {
  //匿名类
  val vall2 = (x: Int) => {
    x + vall1
  }
  var vall1: Int = 3

  def main(args: Array[String]): Unit = {
    Console println vall2(1)

    new Test1().main1()

  }
}

class Test1 {
  val aa = 1

  def main1(): Unit = {
    /** 可改变var：长度能变
      * 不可变val：只能变值，长度不能变 */
    val arr = new Array[Int](4)
    arr(0) = 0
    arr(1) = 2
    println(arr.mkString(",")) //0,2,0,0
    //相当于但里的getInstance，藏得语法糖·
    //_占位符
    var arrr = Array(5, 6, 6, 6, 6, 6, 6)
    arrr = arrr.map(_ + 1) //顺序加1
    println(arrr.mkString(","))
  }
}