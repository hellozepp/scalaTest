package myscala.jettyTest.JettyServerAnClient

import org.apache.http.HttpEntity
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

object HttpClient {
  def main(args: Array[String]): Unit = HttpClient.
    report("http://127.0.0.1:12345/api_v1/writelog", "Hello Jetty,this request from HttpSender")

  /**
    *
    * @param url  汇报地址
    * @param data 汇报内容
    * @return true表示汇报成功，false代表失败
    */
  def report(url: String, data: String): Boolean = {
    var httpClient: CloseableHttpClient = null
    var response: CloseableHttpResponse = null
    try {
      // 创建发送端
      httpClient = HttpClients.createDefault
      // 设置request的超时时间
      val requestConfig = RequestConfig
        .custom.setConnectionRequestTimeout(5000)
        .setConnectionRequestTimeout(5000)
        .setSocketTimeout(5000).build
      // 创建post请求
      val httpPost = new HttpPost(url)
      httpPost.setConfig(requestConfig)
      // 设置数据体
      httpPost.setEntity(new StringEntity(data))
      // 发送请求
      response = httpClient.execute(httpPost)
      if (response.getStatusLine.getStatusCode != 200) return false
      val entity = response.getEntity
      if (entity != null) if (EntityUtils.toString(entity, "UTF-8") == "ok") return true
    } catch {
      case e: Exception =>
        e.printStackTrace()
    } finally {
      try if (response != null) response.close()
      catch {
        case e2: Exception =>
          e2.printStackTrace()
      }
      try if (httpClient != null) httpClient.close()
      catch {
        case e2: Exception =>
          e2.printStackTrace()
      }
    }
    false
  }
}