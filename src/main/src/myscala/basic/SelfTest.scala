package myscala.basic

/**
  * @Author: zhanglin
  * @Date: 2021/8/7
  * @Time: 11:33 PM
  */
class SelfTest {

}

object SelfTest {
  //self 可以当做是this的别名
  self1 =>
  val num = 5

  def main(args: Array[String]): Unit = {
    println(this.num)
    println(self1.num)
  }

}