package myscala.basic.scalaType

/**
  * 复合类型
  * 22/07/2022 hellozepp(lisheng.zhanglin@163.com)
  */
object CloneAndReset {

  //出现一个问题，参数 obj 的类型是什么。如果类型是 Cloneable 那么参数对象可以被克隆 clone，但不能重置 reset;
  // 如果类型是 Resetable 我们可以重置 reset 它，但却没有克隆 clone 操作。为了避免在这种情况下进行类型转换，我
  // 们可以将 obj 的类型同时指定为 Cloneable 和 Resetable。这种复合类型在 Scala 中写成：Cloneable with Resetable。
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }
}

trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}

trait Resetable {
  def reset: Unit
}