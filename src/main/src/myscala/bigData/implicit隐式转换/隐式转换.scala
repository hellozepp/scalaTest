package myscala.bigData.implicit隐式转换

class 隐式转换 {

}

object ContextDemo { //放调用者后面就不能用了，可以从外面导入
  implicit val name: String = "呵呵哒" //只根据类型模式匹配
}


object 隐式转换 {
  // 柯里化
  def sayHai()(implicit name: String = "默认值") {
    println(s"name is $name")
  }

  def main(args: Array[String]): Unit = {
    import ContextDemo._
    //   val a = sayHai()() //颗粒化的操作
    sayHai() //implicit的操作

  }
}