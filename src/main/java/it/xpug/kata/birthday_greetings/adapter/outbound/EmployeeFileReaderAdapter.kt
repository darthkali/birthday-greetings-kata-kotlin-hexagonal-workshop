package it.xpug.kata.birthday_greetings.adapter.outbound

import it.xpug.kata.birthday_greetings.Employee
import it.xpug.kata.birthday_greetings.domain.port.outbound.ForLoadingEmployees
import java.io.BufferedReader
import java.io.FileReader

class EmployeeFileReaderAdapter(private val fileName: String):ForLoadingEmployees {
    override fun loadEmployees(): List<Employee> {
        val employeeList = mutableListOf<Employee>()

        BufferedReader(FileReader(fileName)).use { reader ->
            reader.readLine() // skip header
            var str: String

            while ((reader.readLine().also { str = it }) != null) {
                val employeeData = str.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                employeeList.add(Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]))
            }
        }
        return employeeList
    }
}