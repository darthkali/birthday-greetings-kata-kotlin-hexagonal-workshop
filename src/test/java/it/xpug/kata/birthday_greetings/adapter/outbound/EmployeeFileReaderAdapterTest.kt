package it.xpug.kata.birthday_greetings.adapter.outbound

import it.xpug.kata.birthday_greetings.Employee
import junit.framework.TestCase

class EmployeeFileReaderAdapterTest : TestCase() {

    fun testLoadEmployees() {
        val adapter = EmployeeFileReaderAdapter("employee_data.txt")

        val employeeList = adapter.loadEmployees()

        assertEquals(2, employeeList.size)

        val expectedEmployees = listOf(
            Employee("John", "Doe", "1982/10/08", "john.doe@foobar.com"),
            Employee("Mary", "Ann", "1975/03/11", "mary.ann@foobar.com")
        )

        employeeList.forEachIndexed { index, employee ->
            val expected = expectedEmployees[index]
            assertEquals(expected.firstName, employee.firstName)
            assertEquals(expected.lastName, employee.lastName)
            assertEquals(expected.birthDate, employee.birthDate)
            assertEquals(expected.email, employee.email)
        }
    }
}