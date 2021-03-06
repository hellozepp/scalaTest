package myscala.bigData.implicit隐式转换

/**
  * Created by ZX on 2016/4/14.
  */
class Girl(val name: String, val faceValue: Int, val size: Int) {

}

//class MissLeft[T <% Ordered[T]] {
//
//  def choose(first: T, second: T) : T = {
//    if (first > second) first else second
//  }
//
//}
//Ordering里面有大于gt eq lt 方法
//ordered 有>= <=方法
class MissLeft[T: Ordering]() {

  def choose(first: T, second: T): T = {
    val ord = implicitly[Ordering[T]] // 隐式转换类
    if (ord.gt(first, second)) first else second
  }
}

object MissLeft {
  def main(args: Array[String]) {
    import MyPreDef.girlOrdering
    val ml = new MissLeft[Girl]()
    val g1 = new Girl("hatanao", 98, 28)
    val g2 = new Girl("sora", 95, 33)
    val g = ml.choose(g1, g2)
    println(g.name)
  }
}
