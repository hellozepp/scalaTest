package myscala.basic.objAndClass

class Test13(val name: String, val age: Int, val face: Int) {

}

object Test13 {
  // 注入方法,在伴生对象之中,applay 相当于初始化方法！
  // 可以和构造器参数列表不统一
  def apply(name: String, age: Int, face: Int, gender: Int) =
    new Test13(name, age, face)

  // 使用 unapplay 用来提取固定数量的对象！
  def unapply(test13: Test13): Option[(String, Int, Int)] = {
    if (test13 == null) {
      None
    } else {
      // unapply 提取的对象封装给 Some 之中
      Some(test13.name, test13.age, test13.face)
    }
  }
}

object test {
  def main(args: Array[String]): Unit = {
    // 创建实例 执行的是 applay 的方法！
    val test13 = Test13("abc", 21, 0, 34)
    test13 match {
      // 此时隐式调用的是 unapplay方法！
      case Test13("abc", age, face) => println(s"age: $age")
      case _ => println("no mavhe")
    }
  }
}