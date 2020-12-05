package day4

enum class PassportField{
    BYR, CID, ECL, EYR, IYR, HCL, HGT, PID,
}

data class ValidRanges(
    val birthYears: IntRange = IntRange(1920, 2002),
    val expirationYears: IntRange = IntRange(2020, 2030),
    val issueYears: IntRange = IntRange(2010, 2020),
    val centimetres: IntRange = IntRange(150, 193)
    )