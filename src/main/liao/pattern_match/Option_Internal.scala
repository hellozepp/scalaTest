package pattern_match

import scala.util.control.Breaks._

object Option_Internal {

  def main(args: Array[String]) {
    // 只要我们有一个PartialFunction[X,R]很容易将其转换为返回的函数Option[R]，G.
    def pfToOptf[X, R](f: PartialFunction[X, R])(x: X): Option[R] =
      if (f.isDefinedAt(x)) Some(f(x))
      else None

    val ptToOp = pfToOptf(new PartialFunction[String, Int] {
      override def isDefinedAt(x: String): Boolean = x != null

      override def apply(v1: String): Int = if (v1 == "a") 1 else 2
    }) _
    println(ptToOp("1").get)

    //但是，如果任务是相反的呢？假设我有一个函数f获得X作为一种争论和回归Option[R]结果是。
    // 我想做一个PartialFunction[X,R]从里面出来。最好的方法是什么？
    //我想出的东西在我看来很难看：
    def optfToPf[X, R](f: X => Option[R]): PartialFunction[X, R] = {
      object extractor {
        def unapply(x: X): Option[R] = f(x)
      }

      {
        case extractor(r) => r
      }
    }

    val scores = Map("Alice" -> 99, "Spark" -> 100)

    def aaa(x: Option[Int]): Unit = x match {
      case Some(score) => println(score) // 会把option解开
      case None => println("No score")
    }

    aaa(scores.get("Spark"))
    aaa(scores.get("flink"))

    var somthing = Some(123)
    println(somthing.get)

    var aa = null
    println(Some(aa).get)

  }

}

class Option_Internal() {
  Array(1, 2, 3)
}