package myscala.basic.objAndClass

import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

/**
  * 25/08/2021 hellozepp(lisheng.zhanglin@163.com)
  */
class ExtendAndWith {

}

object ExtendAndWith {
  def main(args: Array[String]): Unit = {

  }
}

//1 extend后面可以接类和特质（trait）,with 只能混入特质
class A {

}

trait B {

}

class C extends A {

}

class D extends B {

}

//2如果 extends和with同时使用则类比如放在前面
class WithClass extends A with B {

}

//下面错误：
//class WithClass extends B with A {
//
//}
//3比如先有extends后有with
//下面错误：
//class E with B{
//}
trait F {}

abstract class F1 extends B {}

//4trait的用发和class一样，trait可以继承class
trait G extends F1 with F {
}

object H extends F1 with F {
}
//trait（特质）和abstract class（抽象类）的区别？
//（1）一个类只能继承一个抽象类，但是可以通过with关键字继承多个特质；
//（2）抽象类有带参数的构造函数，特质不行（如 trait t（i：Int）{} ，这种声明是错误的）

//5静态对象也可以继承
object B extends A with B {

}

//6对象后面可以用with混入特质，但是不能用extends
object FF {
  def main(args: Array[String]): Unit = {
    new A() with F
  }
}

trait H {}

//7with可以有多个，extends只能有一个
object B1 extends A with B with H {

}
