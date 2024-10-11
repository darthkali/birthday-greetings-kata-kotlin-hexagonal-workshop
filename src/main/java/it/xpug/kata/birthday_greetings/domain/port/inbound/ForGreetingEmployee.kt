package it.xpug.kata.birthday_greetings.domain.port.inbound

import it.xpug.kata.birthday_greetings.domain.model.XDate

interface ForGreetingEmployee {
    fun sendGreetings(xDate: XDate)
}