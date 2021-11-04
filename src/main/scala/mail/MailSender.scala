package mail

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException
import sun.jvm.hotspot.debugger.AddressException
import java.io.IOException
import java.util.Properties
import javax.mail._
import javax.mail.internet._

/**
  * 02/11/2021 hellozepp(lisheng.zhanglin@163.com)
  */
object MailSender {
  def main(args: Array[String]): Unit = {
    new MailSender().systemSender(
      "lisheng_zhanglin@163.com",
      "subject",
      "text"
    )
  }
}

class MailSender {
  // throws AddressException, MessagingException
  def setMessageRecipients(message: Message, recipient: String, recipientType: Message.RecipientType): Unit = {
    // had to do the asInstanceOf[...] call here to make scala happy
    val addressArray = buildInternetAddressArray(recipient).asInstanceOf[Array[Address]]
    if ((addressArray != null) && (addressArray.length > 0)) {
      message.setRecipients(recipientType, addressArray)
    }
  }

  @throws[javax.mail.internet.AddressException]
  def buildInternetAddressArray(address: String): Array[InternetAddress] = { // could test for a null or blank String but I'm letting parse just throw an exception
    InternetAddress.parse(address)
  }

  @throws[IOException]
  @throws[AddressException]
  @throws[MessagingException]
  @throws[javax.mail.MessagingException]
  private[mail] def systemSender(recipient: String, subject: String, body: String): Unit = {
    val properties = new Properties
    val session = Session.getDefaultInstance(properties, null)
    val msg = new MimeMessage(session)
    msg.setFrom(new InternetAddress("137297351@qq.com", "137297351"))

    msg.addRecipient(Message.RecipientType.TO, InternetAddress.parse(recipient)(0)) // 收件人
    msg.setSubject(subject)
    msg.setText(body)
    Transport.send(msg)
    System.out.println("Email sent successfully...")
  }
}