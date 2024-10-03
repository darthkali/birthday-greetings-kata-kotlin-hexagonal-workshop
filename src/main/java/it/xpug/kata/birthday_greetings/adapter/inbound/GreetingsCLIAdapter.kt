package it.xpug.kata.birthday_greetings.adapter.inbound

import it.xpug.kata.birthday_greetings.domain.service.BirthdayService
import it.xpug.kata.birthday_greetings.domain.model.XDate

class GreetingsCLIAdapter(private val birthdayService: BirthdayService) {
    fun sendGreetings(args: Array<String>){
        val date = args.get(0)
        birthdayService.sendGreetings(XDate(date))
    }
}