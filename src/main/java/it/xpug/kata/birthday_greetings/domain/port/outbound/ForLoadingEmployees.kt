package it.xpug.kata.birthday_greetings.domain.port.outbound

import it.xpug.kata.birthday_greetings.domain.model.Employee

interface ForLoadingEmployees {
    fun loadEmployees(): List<Employee>
}