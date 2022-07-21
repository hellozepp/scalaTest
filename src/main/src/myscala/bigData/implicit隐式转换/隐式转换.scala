package myscala.bigData.implicit隐式转换

class 隐式转换 {

}

object ContextDemo { //放调用者后面就不能用了，可以从外面导入
  implicit val name: String = "呵呵哒" //只根据类型模式匹配
}
object ContextDemo1 { //放调用者后面就不能用了，可以从外面导入
  implicit val name1: String = "咯咯哒" //只根据类型模式匹配
}

object 隐式转换 {
  // 柯里化
  def sayHi()(implicit name: String = "默认值"): Unit = {
    println(s"name is $name")
  }

  def main(args: Array[String]): Unit = {
    import ContextDemo._
    //import ContextDemo1._ //X ambiguous implicit values:both value name in object ContextDemo of type => String
    sayHi()() //颗粒化的操作
    sayHi() //implicit的操作

  }
}