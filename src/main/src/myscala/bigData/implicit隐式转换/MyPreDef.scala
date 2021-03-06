package myscala.bigData.implicit隐式转换

/**
  * Created by ZX on 2016/4/14.
  */
object MyPreDef {

  /**
    * 先比颜值后比身高
    *
    * @param girl
    * @return
    */
  implicit def girlToOrdered(girl: Girl): Ordered[Girl] = new Ordered[Girl] {
    override def compare(that: Girl): Int = {
      if (girl.faceValue == that.faceValue) {
        girl.size - that.size
      } else {
        girl.faceValue - that.faceValue
      }
    }
  }

  implicit object girlOrdering extends Ordering[Girl] {
    override def compare(x: Girl, y: Girl): Int = {
      if (x.faceValue == y.faceValue) {
        x.size - y.size
      } else {
        x.faceValue - y.faceValue
      }
    }
  }

}
