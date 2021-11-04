package myscala.jettyTest.JettyServerAnClient

import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object JettyReceive {
  /**
    * 获取request的客户端IP地址
    *
    * @param request
    * @return
    */
  def getIpAdrress(request: HttpServletRequest) = { //表示 HTTP 请求端真实 IP
    var ip = request.getHeader("X-Forwarded-For")
    if (ip == null || ip.isEmpty || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("Proxy-Client-IP")
    if (ip == null || ip.isEmpty || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("WL-Proxy-Client-IP")
    if (ip == null || ip.isEmpty || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_CLIENT_IP")
    if (ip == null || ip.isEmpty || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_X_FORWARDED_FOR")
    if (ip == null || ip.isEmpty || "unknown".equalsIgnoreCase(ip)) ip = request.getRemoteAddr
    ip
  }
}

class JettyReceive extends AbstractHandler {
  @throws[IOException]
  @throws[ServletException]
  override def handle(url: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse): Unit = {
    println("---------handle------------")
    println(url)
    println(JettyReceive.getIpAdrress(request))
    println(request.getHeader("msg_size"))
    //    println(getBodyDate(request))

    val mapByRequest = request.getParameterMap
    System.out.println("map count:" + mapByRequest.size)

    if (mapByRequest != null && mapByRequest.size > 0) {
      import scala.collection.JavaConversions.asScalaSet
      println("--------------------------------map[0]:" + mapByRequest.keySet.toSeq.head)
    }

    println(request.getParameter("value"))
  }

  // 从请求中获取数据
  def getBodyDate(request: HttpServletRequest): String = {
    var bodyStr: java.lang.String = null
    var br: BufferedReader = null
    try { // 设置编码
      request.setCharacterEncoding("UTF-8")
      // 创建输入流
      br = new BufferedReader(new InputStreamReader(request.getInputStream))
      // 获取body内容
      var line: java.lang.String = null
      val buf = new StringBuilder
      line = br.readLine
      while (line != null) {
        buf.append(line)
        line = br.readLine
      }
      bodyStr = buf.toString
    } catch {
      case e: Exception =>
        e.printStackTrace()
    } finally if (br != null) try br.close()
    catch {
      case e: IOException =>
        e.printStackTrace()
    }
    bodyStr
  }
}