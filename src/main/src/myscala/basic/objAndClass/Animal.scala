package myscala.basic.objAndClass

/**
  * 第一种情况，with在子类定义完之后，先执行子类再执行父类，这时父类中的方法会自动接收覆盖后的属性即weight为150，doubleWeight为300；
  */
abstract class Animal {
  val weight = 100
  val doubleWeight = 2 * weight
}

class Tiger extends {
  override val weight: Int = 150
} with Animal

object OverridField {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger
    println(tiger.doubleWeight) // 300
    println(tiger.weight) //150
  }
}