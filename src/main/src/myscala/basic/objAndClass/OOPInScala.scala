package myscala.basic.objAndClass

// 私有化构造
class Teacher private(val name: String, val age: Int) {
  println("This is the primary constructor!!!")
  var gender: String = _
  println(gender)

  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
}


class Outer(val name: String) {
  outer =>
  def this(name: String, age: Int, gender: String) {
    this(name)
  }

  class Inner(val name: String) {
    def foo(b: Inner) = println("Outer: " + outer.name +
      " Inner: " + b.name)
  }

}

object OOPInScala {
  def main(args: Array[String]) {

    val outer1 = new Outer("Spark")
    val outer2 = new Outer("Hadoop")
    val inner1 = new outer1.Inner("Scala")
    val inner2 = new outer2.Inner("Java")
    inner1.foo(inner1);
    inner2.foo(inner2);
    println(outer1.name)

//    val p: Teacher = new Teacher("Spark", 5) //访问不了
//    println(" : " + p.age)

    val p1 = new Teacher("Spark", 5, "male")
    println(" : " + p1.age)
    println(" : " + p1.name)
    println(" : " + p1.gender)


  }


}