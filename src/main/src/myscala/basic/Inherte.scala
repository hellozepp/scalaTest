package myscala.basic

/**
  * Created by docker on 2017/5/21.
  */
class Outer {


  class Inner {
    //对于final类型的变量在继承关系的时候不可以被子类重写，而val类型的变量在继承的时候可以被子类重写，尽管其不可以被重新赋值
    final val xx1: String = "x1"
    val xx2: String = "x2"
    private val xx3: String = "x3"

    private def f() {
      println("f")
    }

    protected def f1() {
      println("f1")
    }

    def f2() {
      println("f2")
    }

    private[this] def d(): Unit = {
      println("d")
    }

    private[myscala] def d1() {
      println("d1")
    }

    private[Inner] def d2() {}

    private[myscala] def d3() {
      println("d3")
    }

    //默认
    //    这里的x指代某个所属的包、类或单例对象。
    //内部类访问
    class InnerMost {
      f()
      d()
      d1()
      d2()

      def apply: InnerMost = new InnerMost() //伴生
    }

  }


  //  (new Inner).f() //错误
  //   (new Inner).f1()//只有子类和半生能访问
  //  (new Inner).d() //只有该类有效
  (new Inner).d1() //可访问同包中的指定私有
  //  (new Inner).d2()
  (new Inner).f2()


  class Inner1 extends Inner {
    //  override  val xx1 :String = "x1" // X
    override val xx2: String = "Inner1 x2"
    val xx3: String = "x3"
    //    super.f() //私有只能自己 访问
    super.f1()

    override private[myscala] def d1(): Unit = {
      println("d1方法被子类覆盖")
    }

    override def f2() {
      println("f2")
    }

    //    f()
    //    d()
    d1()
    //    d2()
  }

}

object Inherte {
  def main(args: Array[String]): Unit = {
    val outer = new Outer()
    val inner = new outer.Inner()
    // 插值字符串
    println(s"inner[xx1=${inner.xx1},xx2=${inner.xx2}]")
    val inner1 = new outer.Inner1()
    // 插值字符串
    println(s"inner1[xx1=${inner1.xx1},xx2=${inner1.xx2}]")
//    inner1.f1() //X protected拿不到
    inner1.f2()
    inner1.d3()
  }
}
