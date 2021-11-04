package myscala.bigData.implicit隐式转换

class TransformTest {

}

object TransformTest extends App {

  import PreDiff._

  // 匿名视图绑定一个PreDiff的NothingTodo函数
  private val str = new String("1234").nope()
  println(str)
}

trait NothingTodo {
  def nope(): String
}

object PreDiff {
  // 返回是一个匿名函数NothingTodo
  implicit def transform(s: String): NothingTodo = new NothingTodo {
    override def nope(): String = "nothing to show "
  }

  def transform1(s: String): NothingTodo = {
    return new NothingTodo {
      override def nope(): String = "nothing to show "
    }
  }

  def main(args: Array[String]): Unit = {
    val tran: NothingTodo = transform1("111")
    println(tran.getClass)
    println(tran.nope())
  }
}