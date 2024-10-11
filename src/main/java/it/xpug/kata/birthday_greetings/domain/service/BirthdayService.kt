package it.xpug.kata.birthday_greetings.domain.service

import it.xpug.kata.birthday_greetings.domain.model.XDate
import it.xpug.kata.birthday_greetings.domain.port.inbound.ForGreetingEmployee
import it.xpug.kata.birthday_greetings.domain.port.outbound.ForLoadingEmployees
import it.xpug.kata.birthday_greetings.domain.port.outbound.ForSendingEmail

class BirthdayService(
    private val forLoadingEmployees: ForLoadingEmployees,
    private val forSendingEmail: ForSendingEmail
): ForGreetingEmployee {
    override fun sendGreetings(xDate: XDate) {
        val employeeList = forLoadingEmployees.loadEmployees()

        employeeList.forEach { employee ->
            if (employee.isBirthday(xDate)) {
                val recipient = employee.email
                val body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.firstName!!)
                val subject = "Happy Birthday!"

                forSendingEmail.sendEmail(
                    recipient = recipient!!,
                    body = body,
                    subject=subject
                )
            }
        }
    }
}
