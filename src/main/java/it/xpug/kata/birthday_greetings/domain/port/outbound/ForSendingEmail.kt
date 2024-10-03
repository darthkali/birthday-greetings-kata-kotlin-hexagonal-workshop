package it.xpug.kata.birthday_greetings.domain.port.outbound

interface ForSendingEmail {
    fun sendEmail(recipient: String, subject: String, body: String)
}