package myscala.basic

import scala.io.Source

/**
  * Created by docker on 2017/4/14.18822623822
  */

//function
object Statement02 {
  //预定义
  //  【注：　对于递归函数，不能省略函数返回值类型。对于有返回值的函数，不能省略 等号 ；　】
  def hello(name: String = "china"): String = {
    "Hello : " + name
  }

  def apply(): Array[Int] = Array(1, 2, 3)

  //直接写main在外面优先执行
  //出让，该循环会构造出一个集合，每次迭代生成集合中的一个值
  println("==========yield============")

  val b = for (i <- 1 to 10) yield { // 闭区间
    i % 3
  }
  //生成 Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  println(b)
  println("========-分行for============")

  for {i <- 1 until 4 //使用大括号，使用换行来分隔组 相当于双重for
       j <- 1 until 4} {
    println(i, j)
  }
  println("==========lazy============")
  //  val被声明为lazy时，变量的初始化将被延迟，直到我们首次对变量取值
  lazy val fileContent = Source.fromFile("filename").mkString
  println(fileContent)
  println("==========匿名函数============")
  //(Int, Int) => Int即为匿名函数的格式
  var add: (Int, Int) => Int = (x: Int, y: Int) => {
    x + y
  }
  // 等价于下面
  add = (x: Int, y: Int) => {
    x + y
  }
  println(add(1, 2))

  //匿名函数
  def printEveryChar: String => Unit = (c: String) => {
    c.foreach(println(_))
  }

  // 等价于下面
  def printEveryChar1(c: String): Unit = {
    c.foreach(println(_))
  }

  printEveryChar("a")
  println("===================颗粒化===================")

  //  颗粒化
  def add1(x: Int)(y: Int) = x + y;
  val add2 = add1(1) _
  println(add2(2))

  println("==========match case============")
  var that1 = 1
  that1 match {
    case 1 => println("数值类型");
  }

  var that2 = "1"
  that2 match {
    case "1" => print("字符串1")
    case "1" => print("字符串2") //不会再被调用
    case "a" => print("a")
  }
  println("===========if 守卫===============")
  //if 守卫 if前的分号可以省略
  for (i <- 5 until 11 if i >= 7 if i >= 6) {
    print(" " + i)
  }
  println
  //多个守卫
  for {
    i <- 1 to 10
    if i != 3
    if i % 3 == 1
  } {
    print(" " + i)
  }
  println
  println("==========双重循环==========")
  //双重 for 循环
  for (a <- 1.to(3); b <- 1 to 3) {
    //双重循环
    println("Value of a: " + a);
    println("Value of b: " + b);
  }

  println("==========Array格式化输出==========")
  val aaaa = Array(1, 1, 1, 1, 1, 1)
  Console println aaaa.mkString("<", ",", ">")

  println("==========for 循环=============")
  val numList = List(1);
  for (a <- numList) {
    println("Value of a: " + a);
    //    break;没有
  }
  //    将 for 循环的返回值作为一个变量存储
  val li = List(1, 1, 1, 1, 1)
  lazy val ress: List[Int] = for {i1 <- li
                                  if i1 != 2} yield i1 * 3
  Console println ress.mkString("", ",", "")


  def main(args: Array[String]) {
    println("==============main函数启动==============")
    println(hello("scala"))
    println(hello())
    println("dddddddddddddddddd三目运算dddddddddddddddddddddd")
    var a = 1
    val x = if (a > 0) 1 else 0; //if(true或false)
    println(x);

    println("==============混合类型==============")
    var z = if (a > 1) 1 else "reeor"
    println(z.getClass)
    z = if (a > 1) 1 //else 返回Unit
    z = if (a > 1) 1 else ()
    //class scala.runtime.BoxedUnit
    println(z.getClass)

    println(1 until 10) //都是函数，开区间
    println(1 to 10) //闭区间

    println("==============breakable==============")
    import scala.util.control._
    val loop = new Breaks;
    loop.breakable {
      for (a1 <- 1 to 10) {
        println("Value of a: " + a1);
        if (a1 == 4) {
          loop.break;
        }
      }
    }
    println("==============breakable2==============")
    import util.control.Breaks._
    breakable {
      for (a1 <- Statement02()) {
        println("Value of a: " + a1)
        if (a1 == 4) {
          loop.break
        }
      }
    }


    //    while 累加到10
    var (n, r) = (10, 0)
    while (n > 0) {
      r = r + n
      n = n - 1
    }
    println(r)
  }

}






