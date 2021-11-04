package myscala.basic

/**
  * Created by docker on 2017/5/22.
  * 高阶函数
  */
class HighOrderFunction {

}

object HighOrderFunction extends App {


  println(apply(layout, 10))

  // 函数 f 和 值 a 作为参数，而函数 f 又调用了参数 a
  def layout[A](a: A): String = "[" + a + "]"

  def apply(f: Int => String, a: Int) = f(a) //apply用于返回一个对象或具体值 apply(里面定义参数用于接收值)

  //option some none
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "China" -> "Beijing")
  Console println (capitals get "France1") //Option[String] = Some(Paris) 没有None
  Console println (capitals get "France" get) //Option[String] = Some(Paris) 没有报错
  Console println capitals("France") //获取V 没有报错
  Console println (capitals get "North Pole") //Option[String] = None

  Console println ((capitals get "North Pole") getOrElse "Oops") //三目
  Console println ((capitals get "France") getOrElse "Oops")


  //模式匹配方式
  def showDetals(x: Option[String]) = x match {
    case Some(str) => str
    case None => "sorry!!!!!!!!!"
  }

  Console println (showDetals(capitals.get("North Pole")))

  println((0 /: (1 to 100)) (_ + _)) //左折叠
  (1 to 100).foldLeft(0)(_ + _)
  ((1 to 5) :\ 100) ((i, sum) => sum - i)
}

object aaa {
  def main(args: Array[String]): Unit = {
    new HighOrderFunction()
  }
}