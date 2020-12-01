package day1

import java.io.File
import java.lang.Exception

class Puzzle(private val targetYear: Int = 2020) {

    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val numbers = readInputFile(file).map { it.toInt() }
        return solve(numbers)
    }

    fun solve(input: List<Int>): Int {
        var result: Int? = null
        input.mapIndexed { index: Int, _: Int ->
            val list = input.slice(IntRange(index, input.size - 1))
            val newList = list.filter { isMatch(it, list) }
            if (newList.isNotEmpty()) {
                result = newList[0] * newList[1]
            }
        }
        if (result != null) {
            return result as Int
        } else
            throw Exception("Your input did not contain any pairs which added up to 2020! The horror!")
    }

    private fun isMatch(number: Int, input: List<Int>): Boolean {
        return input.any { it + number == targetYear }
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}