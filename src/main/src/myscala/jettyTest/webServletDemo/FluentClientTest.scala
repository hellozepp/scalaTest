package myscala.jettyTest.webServletDemo

import org.apache.http.client.fluent.{Form, Request}
import org.apache.http.entity.ContentType
import org.apache.http.util.EntityUtils

object FluentClientTest {
  def main(args: Array[String]): Unit = {
    val data = " {\"grant_type\": \"refresh_token\",   \"client_id\": \"DseWcRVfx5GgIqrAQFrOiVrAbUfOnv5D\",   \"client_secret\": \"F74owU1uuSOwNOn4uM4bW_ioe3Wt9EYFYCIyWxpFjNEQT_rYo1fQGFibUUzpOqL2\",   \"refresh_token\": \"CIt8_ATPY_SY2kycsGa6KR5MUGYmWFR5CFI0KeQO2C4D5\" }"
    val length = data.length.toString
    val response = Request.Post("http://docker:52478/v2/writelog")
      .addHeader("Content-Type", "application/json")
      .addHeader("Content-Type", "application/json")
      //      .addHeader("msg_size", length)
      //      .bodyForm(Form.form().add(data, null).build())

      //      .bodyString(value, ContentType.APPLICATION_FORM_URLENCODED.withCharset("utf8"))

      .bodyString(data, ContentType.APPLICATION_JSON.withCharset("utf8"))
      .execute()
    val httpResponse = response.returnResponse()
    val status = httpResponse.getStatusLine.getStatusCode
    println(status)
    println(new String(EntityUtils.toByteArray(httpResponse.getEntity)))
  }
}
