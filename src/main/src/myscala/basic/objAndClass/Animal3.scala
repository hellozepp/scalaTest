package myscala.basic.objAndClass

/**
  * 第三种情况，因为子类中没有对父类进行覆盖及其它操作，所以最后都是父类的值，即weight为100，doubleWeight为200。
  */
class Animal3 {
  val weight = 100
  val doubleWeight = 2 * weight
}

class Tiger3 extends Animal3 {
  //  override val weight: Int = 150
}

object OverridField3 {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger3
    println(tiger.doubleWeight) // 200
    println(tiger.weight) // 100
  }
}