package day1

import java.io.File
import java.lang.Exception

class Puzzle(private val targetYear: Int = 2020) {

    fun solve(inputFileName: String, level: Int): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val numbers = readInputFile(file).map { it.toInt() }
        return solve(numbers, level)
    }

    fun solve(input: List<Int>, level: Int): Int {
        var result: Int? = null
        input.mapIndexed { index: Int, number: Int ->
            val numbersAfterCurrentNumber = input.slice(IntRange(index, input.size - 1))
            var newList: List<Int> = listOf()
            when (level) {
                1 -> newList = levelTwoMatch(numbersAfterCurrentNumber)
                2 -> newList = levelThreeMatch(number, numbersAfterCurrentNumber)
            }
            if (newList.isNotEmpty()) {
                result = newList.reduce { a, b -> a * b }
            }
        }
        return result ?: throw Exception("Your input did not contain any pairs which added up to 2020! The horror!")
    }

    private fun levelTwoMatch(numbersAfterCurrentNumber: List<Int>) =
        numbersAfterCurrentNumber.filter {
            subNumber: Int -> containsTwoNumbersWhichAddToTargetYear(subNumber, numbersAfterCurrentNumber) }

    private fun containsTwoNumbersWhichAddToTargetYear(number: Int, numbersAfterCurrentNumber: List<Int>): Boolean {
        return numbersAfterCurrentNumber.any { it + number == targetYear }
    }

    fun levelThreeMatch(number0: Int, input: List<Int>, targetYear: Int = this.targetYear): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        for (i in 0..input.size - 3) {
            val number1 = input[i + 1]
            for (j in 0..input.size - 3) {
                val number2 = input[j + 2]
                val addition = number0 + number1 + number2
                if (input.any { addition == targetYear }) {
                    result.addAll(listOf(number0, number1, number2))
                }
            }

        }
        return if (result.size > 2) result.slice(IntRange(0, 2)) else result
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}