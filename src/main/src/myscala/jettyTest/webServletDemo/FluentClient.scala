package myscala.jettyTest.webServletDemo

import org.apache.http.client.fluent.{Form, Request}
import org.apache.http.entity.ContentType

object FluentClient {
  def main(args: Array[String]): Unit = {
    val data = "{\"sendLog\":{\"token\":\"c013d2e8-74b0-4cac-85c7-cd2dedd07853\",\"logLine\":\"xxx\"}}"
    Request.Post("http://docker:53923/v2/writelog")
      //            .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;aaa=1")
      //      .addHeader("Content-Type", "application/json")
      //      .addHeader("msg_size", length)
      //      .bodyForm(Form.form().add(data, null).build())
            .bodyString(data, ContentType.APPLICATION_JSON.withCharset("utf8"))
      .execute()
  }
}
