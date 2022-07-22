
/**
  * Created by docker on 2017/5/22.
  */

class Function {

  //  Scala 函数传名调用
  def time(): Long = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }
}

object Function {
  def main(args: Array[String]) {
    printInt( 5, b = 7); //传递给指定参数
    printStrings("Runoob", "Scala", "Python");
    var increase = (x: Int) => x + 1 //x转化为x+1
    val increase1 = increase
    println(increase1(1))
    //Scala函数按函数名称调用
    delayed(new Function().time())
    // 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。
    //闭包通常来讲可以简单的认为是可以访问一个函数里面局部变量的另外一个函数。
    //定义的函数变量 multiplier 成为一个"闭包"，因为它引用到函数外面定义的变量
    var factor = 3
    val multiplier = (i: Int) => i * factor
    println("muliplier(1) value = " + multiplier(1))
    factor = 4
    println("muliplier(2) value = " + multiplier(2))
    //匿名函数的写法 相当于变量等于lambda公式,入参要写类型
    val func = (xx1: Int, yy1: Double) => (yy1, xx1)
    print(func(1, 4.0))
    //等价
    val func2: (Double, Int) => (Int, Double) = {
      (a, b) => (b, a)
    }
    val func3: (Double, Int) => (Int, Double) = { (yy1: Double, xx1: Int) => (xx1, yy1)}
    //这种写法格式 *定义lambda公式格式 ，里面也得返回lambda（相当于声明lambda返回类型，后面执行部分是lambda内容）
    //区别，设定了返回值格式
    val b: (Int, Int) => (Boolean, Boolean) = { (x, y) => (x > y, x < y) }
    val b2: ((Int, Int) => (Boolean)) = { (x, y) => {x > y} }
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => print(x))
    println
    someNumbers.filter((x: Int) => x > 0).foreach((x: Int) => print(x))
    println
    someNumbers.filter((x) => x > 0).foreach((x: Int) => print(x))
    println
    someNumbers.filter(x => x > 0).foreach((x: Int) => print(x))
    println
    someNumbers.filter(_ > 0).foreach((x: Int) => print(x))
    println
    val f = {
      // 单行表达式
      (_: Int) + (_: Int)
    }
    println(f(5, 10))

    //：后面为返回值，可以反lambda定义类型，或者直接诶写返回值类型
    def m2(name: String): Unit = {
      println(name)
    }

    //神奇的下划线 方法变成匿名函数
    val m2func = m2 _
    m2func("hehe")



    def add(x: Int, y: Int) {
      x + y
    }
    //    函数颗粒化
    def add1(x: Int) = (y: Int) => {
      x + y;
    }

    def add3(x: Int): (Int => Int) = (y: Int) => {
      x + y
    }


    def add4(x: Int) = {
      (y: Int) => {
        x + y
      }
    }


    def add2(x: Int)(y: Int) = {
      x + y
    }

    println("===测试颗粒化")
    //    ①
    val plus = add1(1)
    //    ②
    var res = plus(2);
    println(res)


  }

  def printInt(a: => Int, b: => Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }

  def printStrings(args: String*) = {
    //可变参数(可重复的参数)
    var i: Int = 0;
    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg);
      i = i + 1;
    }
  }

  def delayed(t: Long) = {
    //函数名传递参数，像多态
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  def time() = {
    println("伴生对象获取对象")
    System.nanoTime
  }

  //默认参数
  def aaa(x: Int = 5, y: Int = 4): Unit = {
    var sum: Int = 0
    sum = x.+(y)
    return sum
  }
}

/**
  * Created by docker on 2017/4/14.
  */
class Basic2 {

}

class Person {
  //  占位符
  var name: String = _
  //var会生成getter和setter
  val age = 10 //只会生成getter

  //  、、Scala 访问修饰符
  //作用域保护 对[]中包含的所有类和半生对象有效
  private[this] val gender = "male"

  //  用private关键字修饰，带有此标记的成员仅在包含了成员定义的类或对象内部可见，同样的规则还适用内部类。
  class Outer {
    println(gender)

    class Inner {
      println(gender)

      private def f() {
        println("f")
      }

      class InnerMost {
        f() // 正确
      }

    }

    class InnerFriend() extends Inner {
      //    println(f())//错误
    }

    //(new Inner).f() //错误
  }

}

//检测protected
package p {

  class Super {
    protected def f() {
      println("f")
    }
  }

  class Sub extends Super {
    f()
  }

  class Other {
    //    println(gender)
    //    (new Super).f() //错误
  }

}

//朱构造器：参数直接跟在类名后面（）即构造
//不带val 会 var 默认private
class Person1(val name: String, val age: Int) {
  println("this is the primary constructor!")

  override def toString: String = " toString..."

  var gender: String = _
  val school: String = "TUTE"

  //  定义附属构造器，要先执行父构造器
  def this(name: String, age: Int, gender: String) = {
    this(name = name, age) //先执行
    this.gender = gender
  }
}

class Student(name: String, age: Int, val major: String) extends Person1(name, age) {
  println("继承 ")

  //  override重写父类方法 方法用def 变量用var
  override def toString: String = "override ..."

  override val school: String = "TUTD"
}

object Basic2 {
  def main(args: Array[String]): Unit = {
    val p = new Person
    p.name = "jack"
    println(p.name + ":" + p.age)
    val p1 = new Person1("a", 10, "male")
    println(p1.name + p1.gender)

    val stu = new Student("xaingming", 12, "Math")
    println(stu.toString)
    println(stu.school)
  }
}

class Obj() {
  def dis() = {
    println("aaa")
  }
}

class Obj1() extends Obj {
  override def dis() = {
//    "asdasdasd" //不能修改返回值类型
  }
}

// 隐藏成员
import java.util.{HashMap => _} // 引入了util包的所有成员，但是HashMap被隐藏了

object Functions {
  def main(args: Array[String]): Unit ={
//    val map1 = new util.HashMap() // 访问不了
  }
}
