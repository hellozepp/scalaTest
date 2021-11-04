package myscala.jettyTest.JettyServerAnClient

import org.eclipse.jetty.server.Server

object JettyServerDemo {
  def main(args: Array[String]):Unit = {
    val server = new Server(12345)
    server.setHandler(new JettyReceive)
    server.start()
    server.join()
    println("xxxxxxxxxxxxxx")
  }
}