package day6

import java.io.File

class PuzzleLevelOne {

    fun solve(inputFileName: String, level: Int): Int {
        val lines = readFileLines(inputFileName)
        val parsedLogLines = parseLogLines(lines)
        val groupAnswers = parsedLogLines.map { GroupAnswers(it) }
        val numberOfGroupAnswers = parsedLogLines.map { GroupAnswers(it).numberOfAnswers }
        return countNumberOfGroupAnswers(numberOfGroupAnswers)
    }

    fun parseLogLines(logLines: List<String>): List<String> {
        val parsedLogLines = mutableListOf<String>()
        logLines.forEachIndexed { index: Int, logLine: String ->
            when {
                !isGroupDelimiter(logLines, index) && parsedLogLines.isEmpty() -> {
                    parsedLogLines.add(logLine)
                }
                !isGroupDelimiter(logLines, index) && parsedLogLines.isNotEmpty() -> {
                    val newString = parsedLogLines.last().plus(logLine)
                    parsedLogLines.removeAt(parsedLogLines.lastIndex)
                    parsedLogLines.add(newString)
                }
                isGroupDelimiter(logLines, index) -> {
                    parsedLogLines.add(logLine)
                }
            }
        }
        if (parsedLogLines.last().isBlank()) {
            parsedLogLines.removeAt(parsedLogLines.size - 1)
        }
        return parsedLogLines
    }

    fun countNumberOfGroupAnswers(input: List<Int>): Int {
        return input.reduce { acc, i -> acc + i }
    }

    fun isGroupDelimiter(input: List<String>, indexOfChar: Int): Boolean {
        return input[indexOfChar].isBlank()
    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()

    private fun readFileLines(inputFileName: String): List<String> {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        return readInputFile(file)
    }
}
