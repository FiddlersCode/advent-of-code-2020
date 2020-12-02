package day2

import java.io.File
import java.lang.Exception

class Puzzle(private val targetYear: Int = 2020) {


    fun parseInputLine(input: String): Map<String, String> {
        val parts = input.split(" ", ":", " ")
        return mapOf(
            "frequency" to parts[0],
            "letter" to parts[1],
            "password" to parts[3]
        )
    }
    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}