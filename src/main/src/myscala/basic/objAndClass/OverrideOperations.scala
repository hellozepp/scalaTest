package myscala.basic.objAndClass

class OverrideOperations

class Person2(val name: String, var age: Int) {
  println("The primary constructor of Person")

  val school = "BJU"

  def sleep = "8 hours"

  override def toString = "I am a Person1!"
}

class Worker(name: String, age: Int, val salary: Long) extends Person2(name, age) {
  println("This is the subClass of Person, Primary constructor of Worker")
  override val school = "Spark"

  override def toString: String = "I am a Worker!" + super.sleep


}

object OverrideOperations {
  def main(args: Array[String]): Unit = {
    val w = new Worker("Spark", 5, 100000)
    println("School :" + w.school)
    println("Salary :" + w.salary)
    println(w.toString())
  }
}