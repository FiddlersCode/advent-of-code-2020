package day2

import java.io.File

class PuzzleLevelTwo {

    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val parsedFileLines: List<ParsedInputLine> = readInputFile(file).map { parseInputLineWithZeroIndexConversion(it) }
        return parsedFileLines.filter { isValid(it) }.size
    }

    fun isValid(input: ParsedInputLine): Boolean {
        val relevantChars = listOf(
            input.password[input.frequency.first],
            input.password[input.frequency.last()]
        )
        return relevantChars.filter{ it == input.letter }.size == 1
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}