package myscala.bigData.implicit隐式转换

import java.io.File

object MyRef {
  //在这里声明
  implicit def richFile(f: File): 隐式转换3 = new 隐式转换3(f)

  implicit def todo(f: File): String = "隐式转换3.."
}

class aa(f: File) {
  def todo(): String = {
    "sdfasddfasdfa"
  }
}

object Rev {
  //相当于装饰器 接收被装饰类, 直接关系到装饰哪个对象
  implicit def RichFile(f: File): aa = new aa(f) //开始装饰
}