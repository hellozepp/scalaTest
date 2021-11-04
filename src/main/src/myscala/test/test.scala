package myscala.test

class test() {

}
object test{
   def main(args: Array[String]): Unit = {
     var b = 1
     def a=(b:Int,c:Int)=>(c+b)

    println(a(1,2))
  }
}
