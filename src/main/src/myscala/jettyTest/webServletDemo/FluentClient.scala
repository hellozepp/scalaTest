package myscala.jettyTest.webServletDemo

import org.apache.http.client.fluent.{Form, Request}
import org.apache.http.entity.ContentType

object FluentClient {
  def main(args: Array[String]): Unit = {
    val data = "{\"sendLog\":{\"token=\":\"token\",\"logLine=\":\"xxx\"}}"
    val length = data.length.toString
    Request.Post("http://127.0.0.1:12345/api_v1/writelog")
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
//      .addHeader("Content-Type", "application/json")
      .addHeader("msg_size", length)
      .bodyForm(Form.form().add(data, null).build())

//      .bodyString(value, ContentType.APPLICATION_FORM_URLENCODED.withCharset("utf8"))

//      .bodyString(data, ContentType.APPLICATION_JSON.withCharset("utf8"))
      .execute()
  }
}
