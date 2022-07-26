package myscala.basic.pattern_match


abstract class Person

/**
  * 样例类（case class）适合用于不可变的数据。它是一种特殊的类，能够被优化以用于模式匹配。
  * 1、初始化的时候可以不用new，当然你也可以加上，普通类一定需要加 new；
  * 2、toString的实现更漂亮；res5: Iteblog = Iteblog(iteblog_hadoop)
  * 3、默认实现了equals 和hashCode；
  * 4、默认是可以序列化的，也就是实现了Serializable ；
  * 5、自动从scala.Product中继承一些函数;
  * 6、case class构造函数的参数是public级别的，我们可以直接访问；
  * 7、支持模式匹配；
  *
  * case class和case object的区别
  * 类中有参和无参，当类有参数的时候，用case class，当类没有参数的时候用case object
  * @param age
  */
case class Student(age: Int) extends Person

case class Worker(var age: Int, salary: Double) extends Person

case object Shared extends Person

object case_class_object {

  def main(args: Array[String]) {


    def caseOps(person: Person) = person match {
      case Student(age) => println("I am " + age + "years old")
      case Worker(_, salary) => println("Wow, I got " + salary)
      case Shared => println("No property")
    }

    caseOps(Student(19))
    caseOps(Shared)

    val worker = Worker(29, 10000.1)
    worker.age = 10 // 默认内部为val
    println(worker)
    val worker2 = worker.copy(salary = 19.95)
    val worker3 = worker.copy(age = 30)
  }

}