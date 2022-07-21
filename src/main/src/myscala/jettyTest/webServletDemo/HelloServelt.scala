package myscala.jettyTest.webServletDemo

import myscala.jettyTest.JettyServerAnClient.JettyReceive

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(Array("api_v1/writelog"))
@SerialVersionUID(1L)
class HelloServelt()

  extends HttpServlet {
  @throws[ServletException]
  @throws[IOException]
  override protected def doPost(request: HttpServletRequest, response: HttpServletResponse): Unit = doGet(request, response)

  @throws[ServletException]
  @throws[IOException]
  override protected def doGet(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    println("---------handle------------")
    println(JettyReceive.getIpAdrress(request))
//    println(request.getHeader("msg_size"))
    //    println(getBodyDate(request))
    val mapByRequest = request.getParameterMap
    System.out.println("map count:" + mapByRequest.size)

    if (mapByRequest != null && mapByRequest.size > 0) {
      import scala.collection.JavaConversions.asScalaSet
      println("--------------------------------map[0]:" + mapByRequest.keySet.toSeq.head)
    }

  }
}