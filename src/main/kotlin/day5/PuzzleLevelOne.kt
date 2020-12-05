package day5

import java.io.File

class PuzzleLevelOne(private val validator: Validator = Validator()) {
    fun solve(inputFileName: String, level: Int): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val lines = readInputFile(file)

    }

    fun parseLogLine(logline: String): Map<PassportField, String> {

    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()
}
