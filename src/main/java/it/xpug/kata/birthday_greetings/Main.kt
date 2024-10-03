package it.xpug.kata.birthday_greetings

import it.xpug.kata.birthday_greetings.adapter.outbound.EmployeeFileReaderAdapter

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val service = BirthdayService(EmployeeFileReaderAdapter("employee_data.txt"))
        val date = args.get(0)
        service.sendGreetings(XDate(date), "localhost", 25)
    }
}
