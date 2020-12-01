package day1

import java.io.File
import java.lang.Exception

class Puzzle {

    fun solve(inputFile: String): Int {
        val numbers = readInputFile(inputFile).map { it.toInt() }
        return solve(numbers)
    }

    fun solve(input: List<Int>): Int {
        var result: Int? = null
        input.mapIndexed { index: Int, number: Int ->
            if (index + 1 < input.size && number + input[index + 1] == 2020)
                result = number * input[index + 1]

        }
        if (result != null) {
            return result as Int
        } else
            throw Exception("Your input did not contain any pairs which added up to 2020! The horror!")
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}