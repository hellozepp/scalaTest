package myscala.basic

/**
  * @author liuqiang
  * @since 2020/4/28 13:16
  */
object String01 {

  def main(args: Array[String]): Unit = {
    var s = "jbsxt"
    val s1 = "BJSXT"

    println(s.equals(s1))
    println(s.equalsIgnoreCase(s1))
    println(s.indexOf(98)) // ascii码
    println(s.charAt(2))

    s = "xsqlsqlextsql"
    println(s.replaceFirst("sql", ""))
    var _fullName = "SQLxxxExt"
    if (_fullName.endsWith("Ext")) {
      _fullName = _fullName.substring(0, _fullName.length - 3)
    } else if (_fullName.endsWith("InPlace")) {
      _fullName = _fullName.substring(0, _fullName.length - 7)
    }
    println("_fullName:" + _fullName)
    if (s.startsWith("sql")) {
      println("xx")
    }
    println("xxx".substring(0, "xxx".length))

    println(List(1, 2).filterNot(_ == 1))
  }


}
