package myscala.basic.objAndClass

/**
  * Scala:
  * 1. object 相当于java的单例，object中定义的都是静态的，相当于java工具类
  * 2. var可变， val 不可变
  * 3. Scala中每行后面都会有分号自动推断机制，不用写 ;
  * 4. scala中建议使用驼峰
  * 5. scala类中可以传参，需要指定类型，有了参数就有了默认的构造。参数默认私有，可以用val var修饰变成公有。
  * 属性默认有getter/setter，当然对于var的属性才可以setter。
  * 6. scala重写构造，重写的构造里的第一行 必须 先调用默认的构造
  * 7. scala中，new一个Person实例时，Person会从头到尾都执行，除了方法之外。   =》 如同js中的function
  * 8. 可设置类中属性为private
  * 9. 在同一个scala文件中，class名称和object可以一样，则两者为伴生关系，两者可以互相访问私有属性。
  * 10. object不能传参，但可以定义apply 来做传参。实现构造的功能。可以定义多个apply，重载
  *
  * @author zhanglin
  * @since 2020/4/27 20:01
  */
abstract class Humans() {
  hu =>
  println("=====Humans init===")
  val label = "10000"

  def doSth: String

  def fun2(): Unit = {
    println("Humans:" + hu.label)
  }

  def fun3(): Unit = {
    println("Humans:" + hu.doSth)
  }

  def fun4(): Unit = {
    println("Humans:" + doSth)
  }
}

class Person1() extends Humans {
  final val name = "a"
  override val label = "2"

  override def doSth: String = {
    "doSth Person"
  }
}

// Person
class Person(xname: java.lang.String, xage: Int) extends Humans {
  println("默认构造")
  override val label = "2"
  var age: Int = xage
  var gender = 'M' // set default value
  private var name = xname;

  override def doSth: String = {
    "doSth Person"
  }

  println(s"****************in Person（$this） start ***************")

  // 重写构造
  def this(yname: String, yage: Int, ygender: Char) {
    this(yname, yage) // 首先必须调用默认的构造
    println("重写构造")
    this.gender = ygender
  }

  def sayName(): Unit = {
    println("hello: " + name + ClassAndObj.name) // 伴生对象中的属性和方法都是静态的
    println("hello: " + name + ClassAndObj.age) // val var都是
    println("hello: " + name + new Person("a", 1).age) // 类只能new出来
    println("hello: " + name + new Person1().name) // 类只能new出来,不然编译报错
  }

  println("****************in Person end *=======================")
}

object ClassAndObj { // object 不支持直接加参数。但class可以

  println("top of obj") // 会执行。

  val name = " wangwang "
  var age = 16

  def main(args: Array[String]): Unit = {
    var hello = "hello"
    var hello1: java.lang.String = hello
    // 测试object的传参
    ClassAndObj(100) // 肯定有apply
    ClassAndObj(100, "aaa")

    println("hello world, i am scala");
    val a: Int = 100
    println(a)

    val p = new Person("anan", 12);
    p.age = 20;
    //println(p.name) // private访问不了
    println(p.age)

    p.sayName()
    println(p.gender)
    println("===========2============")
    val p1 = new Person("diaochan", 18, 'F')
    println(p1.gender)
    println("===========3============")
    //apply
    Console println "hello"(0)
    //输入：控制台读取
    //    val context = readLine("请输入内容：")
    //    print(context + "\n")
    println("===========4============")
    class A {
      val type1: String = "A"

      def method1: this.type = this
    }

    class B extends A {
      override val type1: String = "B"

      def method2: this.type = this
    }

    val b = new B
    println(b.method1.type1)
    println(b.method1.getClass)
    println(b.method2.method1.type1)
    val humans: Humans = new Person("xxx", 16)
    println(humans.label)
    humans.fun3()
    humans.fun4()
  }

  // object默认不能传参，但可以手动写一个apply 就能传参了
  def apply(i: Int): Unit = { // function都有一个 = 传递
    println("score: " + i)
  }

  def apply(i: Int, name: String): Unit = (
    println(i + "" + name)
    )
}

