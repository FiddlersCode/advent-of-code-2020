package day6

import java.io.File

class PuzzleLevelOne {

    fun solve(inputFileName: String, level: Int): Int {
        val lines = readFileLines(inputFileName)
        val parsedLogLines = parseLogLines(lines)
        return when (level) {
            1 -> {
                val numberOfGroupAnswers = parsedLogLines.map { GroupAnswersLevel1(it).numberOfAnswers }
                countNumberOfGroupAnswers(numberOfGroupAnswers)
            }
            else -> {
                val singleGroupAnswers: List<SingleGroupAnswers> = extractGroups(lines)
                val allGroupAnswers = singleGroupAnswers.flatMap { it.questionsAnsweredByAll }
                val answer = allGroupAnswers.reduce { acc, s -> acc + s }
                return answer.length
            }
        }

    }

    fun extractGroups(logLines: List<String>): List<SingleGroupAnswers> {
        val singleGroupAnswers = mutableListOf(
            SingleGroupAnswers(mutableListOf())
        )

        logLines.forEachIndexed { index: Int, logLine: String ->
            when {
                !isGroupDelimiter(logLines, index) && singleGroupAnswers.isNotEmpty() -> {
                    val personAnswers = PersonAnswers(logLine.map { PersonAnswer(it.toString()) })
                    singleGroupAnswers.last().personAnswers.add(personAnswers)
                }
                isGroupDelimiter(logLines, index) -> {
                    val newSingleGroup = SingleGroupAnswers(mutableListOf())
                    singleGroupAnswers.add(newSingleGroup)
                }
            }
        }

        singleGroupAnswers.mapIndexed { index: Int, singleGroupAnswer: SingleGroupAnswers
            -> singleGroupAnswer.findAllPersonsAnswered(singleGroupAnswers[index].personAnswers)
        }
        return singleGroupAnswers.filter { it.personAnswers.isNotEmpty() }
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
