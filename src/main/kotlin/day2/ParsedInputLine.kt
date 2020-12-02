package day2

fun convertToIntRange(input: String): IntRange {
    val split = input.split("-")
    return IntRange(split[0].toInt(), split[1].toInt())
}

fun parseInputLine(input: String): ParsedInputLine {
    val parts = input.split(" ", ":", " ")
    return ParsedInputLine(
        frequency = convertToIntRange(parts[0]),
        letter = parts[1].single(),
        password = parts[3].toCharArray()
    )
}

fun parseInputLineWithZeroIndexConversion(input: String): ParsedInputLine {
    val parts = input.split(" ", ":", " ")
    return ParsedInputLine(
        frequency = convertToZeroIndex(convertToIntRange(parts[0])),
        letter = parts[1].single(),
        password = parts[3].toCharArray()
    )
}

fun convertToZeroIndex(intRange: IntRange): IntRange {
    return IntRange(intRange.first - 1, intRange.last - 1)
}

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