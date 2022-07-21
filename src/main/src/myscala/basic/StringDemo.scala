package myscala.basic

/**
  * 08/11/2021 hellozepp(lisheng.zhanglin@163.com)
  */
class StringDemo {

}

object StringDemo {
  def main(args: Array[String]): Unit = {
    var a = "mysql  "

    a.trim()
    //    res14: String = mysql

    a.stripSuffix("l")
    //    res15: String = "mysql  "

    a.stripSuffix("l ")
    //    res16: String = "mysql  "

    a.stripSuffix("l  ")
    //    res17: String = mysq

    a.stripPrefix("my")
    //    res18: String = "sql  "
  }
}

