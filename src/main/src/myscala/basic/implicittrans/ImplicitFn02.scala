package myscala.basic.implicittrans


class Animal(name: String) {
  def canFly(): Unit = {
    println(s"$name can fly...")
  }
}

class Rabbit(xname: String) {
  val name: String = xname
}

/**
  * rabbit本身没有canFly方法。但是当定义了一个隐式转换函数，
  * 输入参数为Rabbit，输出的类型如果有canFly，则可以
  *
  * 装饰器模式
  *
  * @author zhanglin
  * @since 2020/4/28 20:35
  */
object ImplicitFn02 {

  implicit def RabbitToAnimal(r: Rabbit): Animal = {
    new Animal(r.name)
  }

  def main(args: Array[String]): Unit = {
    val r1: Rabbit = new Rabbit("r1")
    println(r1.getClass)
    r1.canFly()
    // rabbit本身没有canFly方法。但是当定义了一个隐式转换函数，
    // 输入参数为Rabbit，输出的类型如果有canFly，则可以
  }

}
