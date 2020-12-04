package day4

import java.io.File

class PuzzleLevelOne(private val requiredFields: List<PassportField> = listOf(
    PassportField.BYR,
    PassportField.ECL,
    PassportField.EYR,
    PassportField.HCL,
    PassportField.HGT,
    PassportField.IYR,
    PassportField.PID
)) {
    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val lines = readInputFile(file)
        val parsedLines = parseLogLines(lines)
        return parsedLines.filter { isValid(it) }.size
    }

    fun solve2(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val lines = readInputFile(file)
        val parsedLines = parseLogLines(lines)
        val validLines =  parsedLines.filter { isValid2(it) }
        return validLines.size
    }

    fun isValid(logEntry: Map<PassportField, String>): Boolean {
        return logEntry.keys.containsAll(requiredFields)
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
        logLines.forEachIndexed { index: Int, line: String ->
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

    private fun getKey(input: String, colonIndex: Int): String{
        return input.substring(IntRange(0, colonIndex))
    }

    private fun getValue(input: String, range: IntRange): String {
        return input.substring(range)
    }

    private fun isValid2(logEntry: Map<PassportField, String>): Boolean {
        val birthYear = logEntry[PassportField.BYR] ?: return false
        if (!isValid(logEntry)) return false
        return logEntry[PassportField.BYR] != null && isValidBirthYear(birthYear)
            && logEntry[PassportField.IYR]?.toInt()?.let { isValidIssueYear(it) } ?: false
            && logEntry[PassportField.EYR]?.toInt()?.let { isValidExpirationYear(it) } ?: false
            && logEntry[PassportField.HGT]?.let { isValidHeight(it) } ?: false
            && logEntry[PassportField.HCL]?.let { isValidHairColor(it) } ?: false
            && logEntry[PassportField.ECL]?.let { isValidEyeColor(it) } ?: false
            && logEntry[PassportField.PID] != null && isValidPID(logEntry[PassportField.PID].toString())
    }

    fun isValidBirthYear(input: String): Boolean {
        return input.toInt() in 1920..2002
    }

    fun isValidHeight(input: String): Boolean {
        val regex = Regex("([0-9])+")
        val number: String = regex.find(input)?.value ?: throw Exception("Cannot find match $input")
        val indexOfLastDigit = input.indexOf(number) + number.length
        val measurement = input.subSequence(indexOfLastDigit, input.lastIndex + 1)
        return when {
            measurement == "cm" && number.toInt() >= 150 && number.toInt() <= 193 -> true
            measurement == "in" && number.toInt() >= 59 && number.toInt() <= 76 -> true
            else -> false
        }
    }

    private fun isValidIssueYear(input: Int): Boolean {
        return input in 2010..2020
    }

    private fun isValidExpirationYear(input: Int): Boolean {
        return input in 2020..2030
    }

    private fun isValidEyeColor(input: String): Boolean {
        return when (input) {
            "amb" -> true
            "blu" -> true
            "brn" -> true
            "gry" -> true
            "grn" -> true
            "hzl" -> true
            "oth" -> true
            else -> false
        }
    }

    fun isValidPID(input: String): Boolean {
        return input.length == 9 && isEachCharDigit(input)
    }

    private fun isEachCharDigit(input: String): Boolean {
        return input.all { it.isDigit() }
    }

    fun isValidHairColor(input: String): Boolean {
        val substring = input.substring(IntRange(1, input.lastIndex))
        val regex = Regex("^[0-9a-f]+$")
        return input[0] == "#".single() && substring.matches(regex)
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
