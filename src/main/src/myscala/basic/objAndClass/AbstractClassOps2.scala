package myscala.basic.objAndClass

class AbstractClassOps2 {
  var id: Int = _
}

abstract class SuperTeacher1(val clazz: Class[_]) {
  val a: String = getClassName + teach

  def getClassName: String = clazz.getName

  def teach: String
}

object TeacherForMaths1 extends SuperTeacher1(classOf[TeacherForMaths1]) {
  override def teach = "Teaching"
}

class TeacherForMaths1 {}

object AbstractClassOps2 {
  def main(args: Array[String]): Unit = {
    println(TeacherForMaths1.a)
  }
}