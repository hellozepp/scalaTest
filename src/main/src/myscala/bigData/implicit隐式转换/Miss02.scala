package myscala.bigData.implicit隐式转换

/**
  * Created by ZX on 2016/4/14.
  */
class Miss02[T] {

  //隐式视图：把一种类型隐式转换为目标类型
  def choose(first: T, second: T)(implicit ord: T => Ordered[T]): T = {
    if (first > second) first else second
  }

  //隐式转换一个函数
  def select(first: T, second: T)(implicit ord: Ordering[T]): T = {
    if (ord.gt(first, second)) first else second
  }

  //隐式转换一个类
  def random(first: T, second: T)(implicit ord: Ordering[T]): T = {
    import Ordered.orderingToOrdered
    if (first > second) first else second
  }

}

object Miss02 {
  def main(args: Array[String]) {
    val mr = new Miss02[Girl]
    val g1 = new Girl("hatanao", 98, 28)
    val g2 = new Girl("sora", 95, 33)

    import MyPreDef.girlToOrdered
    var g = mr.choose(g1, g2)
    println(g.name)
    import MyPreDef.girlOrdering
    g = mr.select(g1, g2)
    println(g.name)
  }
}
