package myscala.basic.objAndClass

trait ApplyTest1 {
  def init(accessToken: String) {
    println("ApplyTestImpl this init---------")
  }
}

class ApplyTestImpl extends ApplyTest1 {

  def this(accessToken: String) {
    this()
    println("ApplyTestImpl this init---------")
  }

  println("ApplyTestImpl init---------")
}

object ApplyTestImpl {
  def main(args: Array[String]): Unit = {
    new ApplyTestImpl()
    new ApplyTestImpl("xxx")
  }
}