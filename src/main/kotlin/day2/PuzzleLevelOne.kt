package day2

import java.io.File

class PuzzleLevelOne {

    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val parsedFileLines: List<ParsedInputLine> = readInputFile(file).map { parseInputLine(it) }
        return parsedFileLines.filter { isValid(it) }.size
    }

    fun isValid(input: ParsedInputLine): Boolean {
        val numberOfOccurrences = numberOfOccurrences(input.password, input)
        return input.frequency.contains(numberOfOccurrences)
    }

    private fun numberOfOccurrences(password: CharArray, input: ParsedInputLine): Int {
        return password.filter { it == input.letter }.size
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}