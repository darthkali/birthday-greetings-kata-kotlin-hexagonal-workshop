package it.xpug.kata.birthday_greetings

import it.xpug.kata.birthday_greetings.adapter.inbound.GreetingsCLIAdapter
import it.xpug.kata.birthday_greetings.adapter.outbound.EmployeeFileReaderAdapter

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val employeeFileReaderAdapter = EmployeeFileReaderAdapter("employee_data.txt")
        val birthdayService = BirthdayService(employeeFileReaderAdapter)
        val greetingsCLIAdapter = GreetingsCLIAdapter(birthdayService)
        greetingsCLIAdapter.sendGreetings(args, "localhost", 25)
    }
}
