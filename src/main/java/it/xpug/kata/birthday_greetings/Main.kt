package it.xpug.kata.birthday_greetings

import it.xpug.kata.birthday_greetings.adapter.inbound.GreetingsCLIAdapter
import it.xpug.kata.birthday_greetings.adapter.outbound.EmployeeFileReaderAdapter
import it.xpug.kata.birthday_greetings.adapter.outbound.SmtpAdapter
import it.xpug.kata.birthday_greetings.domain.service.BirthdayService

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val employeeFileReaderAdapter = EmployeeFileReaderAdapter("employee_data.txt")
        val smtpAdapter = SmtpAdapter("localhost", 25)
        val birthdayService = BirthdayService(employeeFileReaderAdapter, smtpAdapter)
        val greetingsCLIAdapter = GreetingsCLIAdapter(birthdayService)
        greetingsCLIAdapter.sendGreetings(args)
    }
}
