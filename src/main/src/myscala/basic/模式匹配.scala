package myscala.basic

/**
  * 模式匹配
  */
case class Class1(param1: String, param2: String)

case class Class2(param1: String)

/**
  *
  */
object Case {
  def main(args: Array[String]) {
    //通过模式匹配进行条件判断
    val test1: String = "1"
    val result1 = test1 match { //switch(test){case "1":return "one";break;}
      case "1" => {
        "one"
      }
      case "2" => "two"
      case _ => "other"
    }
    println(result1)

    //模式守卫 通过模式匹配进行条件判断，可自定义条件
    val test2: Int = 1;
    val result2 = test2 match {
      case i if i + 1 == 2 => "one"
      case i if i + 1 == 3 => "tow"
      case _ => "error"
    }
    println(result2)

    //通过模式匹配进行类型条件判断
    val t3 = 1
    println(Test3(t3))

    //通过模式匹配进行类型条件判断
    val t4 = "1"
    println(Test3((t4)))

    //通过模式匹配进行类的判断与执行
    val test5 = Class1("1", "2")
    ClassMatch(test5)

    val test6 = Class2("3")
    ClassMatch(test6)


    //  1.定义为case class 的类在实例化时，可以不使用new 关键字。
    //  2. 定义为case class 的类 默认实现了 equals 和hashcode 方法
    //
    //  3. 默认是可序列化的
    //
    //  4. 其构造函数的参数 是public 访问的。如  zhangsan.name
    case class People1(name: String, age: Int)
    val zhangsan = People1("zhangsan", 30)
    println(zhangsan)
    //    5.支持模式匹配：
    case class PhoneExt(name: String, ext: Int)
    val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
    println(extensions)
    extensions.filter { case PhoneExt(name, extension) => extension < 200 }
  }

  def ClassMatch(classTest: Any): Unit = {
    classTest match {
      case Class1(param1, param2) => {
        println("Class1:" + param1 + "_" + param2)
      }
      case Class2(param1) => {
        println("Class2:" + param1)
      }
      case _ => println("error")
    }
  }

  def Test3(data: Any): String = {
    data match {
      case x: Int => "Int" //使用类型推断传入值，推导为string"Int"
      case x: String => "String"
      case _ => "unkown"
    }
  }

  //密封类
  //特质（trait）和类（class）可以用sealed标记为密封的，这意味着其所有子类都必须与之定义在相同文件中，
  // 从而保证所有子类型都是已知的。
  sealed abstract class Furniture

  case class Couch() extends Furniture

  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

  // 案例类在比较的时候是按值比较而非按引用比较：
  // 尽管message2和message3引用不同的对象，但是他们的值是相等的，所以message2 == message3为true。
  case class Message(sender: String, recipient: String, body: String)

  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  Console println message2 == message3 // true

  // 你可以通过copy方法创建一个案例类实例的浅拷贝，同时可以指定构造参数来做一些改变。构造参数数量不变
  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  message5.sender // travis@washington.us
  message5.recipient // claire@bourgogne.fr
  message5.body // "Me zo o komz gant ma amezeg"

}