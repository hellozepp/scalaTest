package myscala.basic

/**
  * 02/11/2021 hellozepp(lisheng.zhanglin@163.com)
  */
object EnumerationDemo {
  def main(args: Array[String]): Unit = {
    println(MailTypeEnum.withName("config").toString)
    println(MailTypeEnum.withName("config"))
    println(MailTypeEnum.values.contains(MailTypeEnum.withName("config")))
  }
}

private[basic] object MailTypeEnum extends Enumeration {
  type MailTypeEnum = Value
  val CONFIG: Value = Value("config")
  val LOCAL_SERVER: Value = Value("local")

  def checkExists(optionValues: String): Boolean = this.values.exists(_.toString == optionValues)

  def checkExistsValue(value: Value): Boolean = this.values.contains(value)
}
