package myscala.basic


/**
  * @Author: zhanglin
  * @Date: 2019/5/15
  * @Time: 10:49 PM
  */
class DsfClient {

}

object SingletonDemo {
  def main(args: Array[String]): Unit = {
    Console print SingletonDemo.getInstence + "\n"
    Console print SingletonDemo.getInstence + "\n"
    Console print SingletonDemo.getInstence + "\n"
  }

  var instance: DsfClient = _

  def getInstence: DsfClient = {
    if (instance == null) {
      instance = new DsfClient
      instance
    } else {
      instance
    }
  }

}
