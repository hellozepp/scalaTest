package myscala.jettyTest.JettyServerAnClient

import org.apache.http.client.fluent.{Form, Request}
import org.apache.http.entity.ContentType

import java.nio.charset.Charset

object FluentClient {
  def main(args: Array[String]): Unit = {
    val value = "{\"大大说的sendLog\":{\"token=\":\"token\",\"logLine=\":\"大大说的dsfafd\"}}"
    val length = value.length.toString
    Request.Post("http://127.0.0.1:12345/v2/writelog")
      .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("msg_size", length)
//            .bodyForm(Form.form().add("value", value).build())
//      .bodyString(value, ContentType.APPLICATION_FORM_URLENCODED.withCharset("utf8"))
            .bodyString(value, ContentType.APPLICATION_JSON.withCharset("UTF-8"))
      .execute()
  }
}
