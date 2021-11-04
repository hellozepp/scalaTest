package myscala.jettyTest.webServletDemo

import org.spark_project.jetty.server.Server
import org.spark_project.jetty.servlet.ServletContextHandler
import org.spark_project.jetty.servlet.ServletHolder

object ServletServer {
  @throws[Exception]
  def main(args: Array[String]) = {
    val server = new Server(12345)
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
    context.setContextPath("/")
    server.setHandler(context)
    context.addServlet(new ServletHolder(new HelloServelt), "/api_v1/writelog")
    server.start()
    server.join()
  }
}