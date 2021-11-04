package myscala.basic.objAndClass

class AbstractClassOps {
  var id: Int = _
}

abstract class SuperTeacher(val name: String) {
  var id: Int
  //  var age = 35 //设置var会报错子类不能覆盖
  val age = 35

  //  def teach = _
  def teach
}

class TeacherForMaths(name: String) extends SuperTeacher(name) {

  override var id = name.hashCode()
  override val age: Int = 29

  override def teach {
    println("Teaching!!!")
  }
}


object AbstractClassOps {
  def main(args: Array[String]): Unit = {
    val teacher = new TeacherForMaths("Spark")
    teacher.teach

    println("teacher.id" + ":" + teacher.id)
    println(teacher.name + ":" + teacher.age)

  }
}