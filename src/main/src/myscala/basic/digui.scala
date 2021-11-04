package myscala.basic

/**
  * Created by docker on 2017/5/22.
  */

object digui {

  def factorial(i: BigInt): BigInt = {
    if (i <= 1)
      1
    else i * factorial(i - 1)
  }

  Console println factorial(10)


  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      println(i + " 的阶乘为 " + factorial(i))
    }
  }
}
