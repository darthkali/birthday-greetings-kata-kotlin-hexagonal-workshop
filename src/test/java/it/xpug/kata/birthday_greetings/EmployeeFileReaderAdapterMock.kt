package it.xpug.kata.birthday_greetings

import it.xpug.kata.birthday_greetings.domain.port.outbound.ForLoadingEmployees

class EmployeeFileReaderAdapterMock(private val employeeList: List<Employee>):ForLoadingEmployees {
    override fun loadEmployees(): List<Employee> = employeeList
}