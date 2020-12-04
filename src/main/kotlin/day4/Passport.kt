package day4

enum class PassportField{
    BYR, IYR, EYR, HGT, HCL, ECL, PID, CID
}

data class ValidRanges(
    val birthYears: IntRange = IntRange(1920, 2002),
    val expirationYears: IntRange = IntRange(2020, 2030),
    val issueYears: IntRange = IntRange(2010, 2020),
    val centimetres: IntRange = IntRange(150, 193)
    )