package it.xpug.kata.birthday_greetings.adapter.inbound

import it.xpug.kata.birthday_greetings.BirthdayService
import it.xpug.kata.birthday_greetings.XDate

class GreetingsCLIAdapter(private val birthdayService: BirthdayService) {
    fun sendGreetings(args: Array<String>, smtpHost: String, smtpPort: Int){
        val date = args.get(0)
        birthdayService.sendGreetings(XDate(date), smtpHost, smtpPort)
    }
}