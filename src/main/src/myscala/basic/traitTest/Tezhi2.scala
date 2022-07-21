package myscala.basic.traitTest

/**
  * Created by docker on 2017/7/17.
  */
class Tezhi2 {

}

//相同方法采用深度遍历，后面的会覆盖前面的
// 用with连接多个类型,称为复合类型
object Tezhi2 {
  def main(args: Array[String]): Unit = {

    println("-----------default----------")
    val test = new Default // 类潜入
    test.get(1)

    println("-----------A----------")
    val test1 = new Default with A //with潜入特质
    test1.get(1)
    test1.get1(1)

    println("-----------B----------")
    val test2 = (new Default with A with B)
    test2.get(1)

    println("-----------A----------")
    val test3 = (new Default with B with A)
    test3.get(1)

    println("-----------C----------")
    val test4 = (new Default with B with A with C)
    test4.get(1)

    println("-----------A----------")
    val test5 = (new AbstractClazz with C with B with A) //不用继承也能揉一块，相同的get方法
    test5.get(1)

    //X illegal inheritance; superclass Noparm is not a subclass of the superclass AbstractClazz
    // 只有超类AbstractClazz的子类可以混入
//    val test6 = (new Noparm with C)
//    test6.get(1)
  }
}

abstract class AbstractClazz {
  def get(x: Int) {}
}

class Default extends AbstractClazz {
  override def get(x: Int): Unit = {
    println("default")
  }
   def get1(x: Int): Unit = {
    println("default get1")
  }
}

trait A extends AbstractClazz {
  abstract override def get(x: Int): Unit = {
    println("A")
  }
}

trait B extends AbstractClazz {
  abstract override def get(x: Int): Unit = {
    println("B")
  }
}

trait C extends AbstractClazz {
  abstract override def get(x: Int): Unit = {
    println("C")
  }
}

class Noparm {
  def get(x: Int) {}
}
