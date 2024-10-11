package it.xpug.kata.birthday_greetings.domain.service

import it.xpug.kata.birthday_greetings.domain.model.XDate
import it.xpug.kata.birthday_greetings.domain.port.inbound.ForGreetingEmployee
import it.xpug.kata.birthday_greetings.domain.port.outbound.ForLoadingEmployees
import java.util.*
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class BirthdayService(private val forLoadingEmployees: ForLoadingEmployees): ForGreetingEmployee {
   override fun sendGreetings(xDate: XDate, smtpHost: String, smtpPort: Int) {
        val employeeList = forLoadingEmployees.loadEmployees()

        employeeList.forEach { employee ->
            if (employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.firstName!!)
                val subject = "Happy Birthday!"
                // Create a mail session
                val props = Properties()
                props["mail.smtp.host"] = smtpHost
                props["mail.smtp.port"] = "" + smtpPort
                val session = Session.getInstance(props, null)
                // Construct the message
                val msg: Message = MimeMessage(session)
                msg.setFrom(InternetAddress("sender@here.com"))
                msg.setRecipient(Message.RecipientType.TO, InternetAddress(recipient!!))
                msg.subject = subject
                msg.setText(body)
                // Send the message
                Thread.sleep(2000L) // simulate slow dependency
                Transport.send(msg)
            }
        }
    }
}
