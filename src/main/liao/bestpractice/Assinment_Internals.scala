package bestpractice


object Assinment_Internals {

  def main(args: Array[String]) {
    val a@b = 1000
    println("a = " + a + ", b = " + b)
    val (c, d) = (1000, 2000)
    println(c)
    println(d)
    //    val (e,F) = (1000,2000)
    var Array(g, h) = Array(1000, 2000)
    g += 1
    println(g)
    //    val Array(i,J) = Array(1000,2000)
    //    object Test { val 1 = 1 }
    // 未调用不会被编译
    object Test {
      val 1 = 2
      123.1
      println(1)
    }
//    Test
  object Test1 {
    print("This is test1")
  }
    Test1
    val e = Some(2)
    val f@Some(1) = Some(1)
    println(e)
    println(f)

    val bb = 2
    val aa@"IMF" = "IMF"
    println(bb)
    println(aa)

  }

}