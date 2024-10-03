package it.xpug.kata.birthday_greetings

import it.xpug.kata.birthday_greetings.domain.model.XDate
import it.xpug.kata.birthday_greetings.domain.service.BirthdayService

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val birthdayService = BirthdayService()
        val date = args.get(0)
        birthdayService.sendGreetings("employee_data.txt", XDate(date), "localhost", 25)
    }
}
