package it.xpug.kata.birthday_greetings.adapter.outbound

import it.xpug.kata.birthday_greetings.domain.port.outbound.ForSendingEmail
import java.util.Properties
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class SmtpAdapter(
    private val smtpHost: String,
    private val smtpPort: Int
): ForSendingEmail {
    override fun sendEmail(recipient: String, subject: String, body: String) {
        // Create a mail session
        val props = Properties()
        props["mail.smtp.host"] = smtpHost
        props["mail.smtp.port"] = "" + smtpPort
        val session = Session.getInstance(props, null)
        // Construct the message
        val msg: Message = MimeMessage(session)
        msg.setFrom(InternetAddress("sender@here.com"))
        msg.setRecipient(Message.RecipientType.TO, InternetAddress(recipient))
        msg.subject = subject
        msg.setText(body)
        // Send the message
        Thread.sleep(2000L) // simulate slow dependency
        Transport.send(msg)
    }
}