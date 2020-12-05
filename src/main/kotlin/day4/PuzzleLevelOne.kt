package day4

import java.io.File

class PuzzleLevelOne(private val validator: Validator = Validator()) {
    fun solve(inputFileName: String, level: Int): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val lines = readInputFile(file)
        val parsedLines = parseLogLines(lines)
        return if (level == 1) {
            parsedLines.filter { validator.isValidLevel1(it) }.size
        } else {
            parsedLines.filter { validator.isValidLevel2(it) }.size
        }
    }

    fun parseLogLine(logline: String): Map<PassportField, String> {
        val split = logline.split(" ").filter { it.isNotBlank() }
        val parsedLogLine: MutableMap<PassportField, String> = mutableMapOf()
        split.map {
            val colonIndex = it.indexOf(":")
            val key = getKey(it, colonIndex - 1)
            val value = getValue(it, IntRange(colonIndex + 1, it.lastIndex))
            val mappedKey = mapStringToPassportField(key)
            parsedLogLine.put(mappedKey, value)
        }
        return parsedLogLine
    }

    fun parseLogLines(logLines: List<String>): List<Map<PassportField, String>> {
        val logList: MutableList<String> = mutableListOf(logLines[0])
        logLines.forEach { line: String ->
            if (line.isBlank()) {
                logList.add(line)
            } else {
                logList[logList.size - 1] = logList.last() + " " + line
            }
        }
        if (logList.last().isBlank()) {
            logList.removeAt(logList.size - 1)
        }

        val passportFields: MutableList<Map<PassportField, String>> = mutableListOf()
        logList.map { passportFields.add(parseLogLine(it)) }

        return passportFields
    }

    private fun getKey(input: String, colonIndex: Int): String {
        return input.substring(IntRange(0, colonIndex))
    }

    private fun getValue(input: String, range: IntRange): String {
        return input.substring(range)
    }

    private fun mapStringToPassportField(input: String): PassportField {
        return when (input) {
            "byr" -> PassportField.BYR
            "cid" -> PassportField.CID
            "ecl" -> PassportField.ECL
            "eyr" -> PassportField.EYR
            "hcl" -> PassportField.HCL
            "hgt" -> PassportField.HGT
            "iyr" -> PassportField.IYR
            "pid" -> PassportField.PID
            else -> throw Exception("Unknown input: $input")
        }
    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()
}
