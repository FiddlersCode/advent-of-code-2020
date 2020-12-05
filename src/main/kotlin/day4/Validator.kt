package day4

class Validator(
    private val requiredFields: List<PassportField> =
        listOf(
            PassportField.BYR,
            PassportField.ECL,
            PassportField.EYR,
            PassportField.HCL,
            PassportField.HGT,
            PassportField.IYR,
            PassportField.PID
        ),
    private val validRanges: ValidRanges = ValidRanges()
) {

    fun isValidLevel1(logEntry: Map<PassportField, String>): Boolean {
        return logEntry.keys.containsAll(requiredFields)
    }

    fun isValidLevel2(logEntry: Map<PassportField, String>): Boolean {
        if (!isValidLevel1(logEntry)) { return false }

        val invalidFields = requiredFields.filterNot {
            passportField ->
            val currentField = logEntry[passportField] ?: throw Exception("Cannot find required field $passportField")
            isValidField(passportField, currentField)
        }

        return invalidFields.isEmpty()
    }

    private fun isValidField(requiredField: PassportField, input: String): Boolean {
        return when (requiredField) {
            PassportField.BYR -> isValidBirthYear(input)
            PassportField.ECL -> isValidEyeColor(input)
            PassportField.EYR -> isValidExpirationYear(input.toInt())
            PassportField.IYR -> isValidIssueYear(input.toInt())
            PassportField.HCL -> isValidHairColor(input)
            PassportField.HGT -> isValidHeight(input)
            PassportField.PID -> isValidPID(input)
            else -> false
        }
    }

    fun isValidBirthYear(input: String): Boolean {
        return input.toInt() in validRanges.birthYears.first..validRanges.birthYears.last
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
        return input in validRanges.issueYears.first..validRanges.issueYears.last
    }

    private fun isValidExpirationYear(input: Int): Boolean {
        return input in validRanges.expirationYears.first..validRanges.expirationYears.last
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
}
