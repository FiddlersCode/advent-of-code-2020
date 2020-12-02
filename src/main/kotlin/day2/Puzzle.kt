package day2

import java.io.File
import java.lang.Exception

data class ParsedInputLine(
    val frequency: IntRange,
    val letter: Char,
    val password: CharArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParsedInputLine

        if (frequency != other.frequency) return false
        if (letter != other.letter) return false
        if (!password.contentEquals(other.password)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = frequency.hashCode()
        result = 31 * result + letter.hashCode()
        result = 31 * result + password.contentHashCode()
        return result
    }
}

class Puzzle {

    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val parsedFileLines: List<ParsedInputLine> = readInputFile(file).map { parseInputLine(it) }
        return parsedFileLines.filter { isValid(it) }.size
    }

    fun isValid(input: ParsedInputLine): Boolean {
        val numberOfOccurrences = numberOfOccurrences(input.password, input)
        return input.frequency.contains(numberOfOccurrences)
    }

    fun parseInputLine(input: String): ParsedInputLine {
        val parts = input.split(" ", ":", " ")
        return ParsedInputLine(
            frequency = convertToIntRange(parts[0]),
            letter = parts[1].single(),
            password = parts[3].toCharArray()
        )
    }

    private fun convertToIntRange(input: String): IntRange {
        val split = input.split("-")
        return IntRange(split[0].toInt(), split[1].toInt())
    }

    private fun numberOfOccurrences(password: CharArray, input: ParsedInputLine): Int {
        return password.filter { it == input.letter }.size
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}