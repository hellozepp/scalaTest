package myscala.basic.objAndClass

/**
  * class和object的关系
（1）单例对象不能带参数，类可以

（2）对象和类名一样时，object被称为伴生对象，class被称为伴生类

（3）类和伴生对象可以相互访问其私有属性，但是它们必须在一个源文件中

（4）类只会被编译，不会被执行；要执行，必须在object中
  */
class University{
  val id = University.newStudenNo
  private var number =0
  def aClass(number:Int){this.number += number}
}

object University{
  private var studentNo = 0
  def newStudenNo = {
    studentNo += 1
    studentNo
  }
}


object ObjectOps {

  def main(args: Array[String]): Unit = {
    
    println(University.newStudenNo)
    println(University.newStudenNo)
    
    
  }

}