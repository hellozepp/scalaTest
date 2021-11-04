package myscala.basic.objAndClass

/**
  * 第二种情况在没有with的情况下，会先执行父类，这时因为子类override的存在weight还会用覆盖的值，但此时后没有经过子类进行覆盖赋值，默认weight为0，所以doubleWeight为0，等父类执行完成后在执行子类，所以最后weight为150；
  */
class Animal2 {
  val weight = 100
  val doubleWeight = 2 * weight
}

class Tiger2 extends Animal2 {
  override val weight: Int = 150
}

object OverridField2 {
  def main(args: Array[String]): Unit = {
    val tiger = new Tiger2
    println(tiger.doubleWeight) // 0
    println(tiger.weight) // 150
  }
}