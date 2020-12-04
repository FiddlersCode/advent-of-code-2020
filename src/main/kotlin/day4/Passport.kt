package day4

data class Passport(
    val byr: Int,
    val iyr: Int,
    val eyr: Int,
    val hgt: String,
    val hcl: String,
    val ecl: String,
    val pid: Int,
    val cid: Int?
)

enum class PassportField{
    BYR, IYR, EYR, HGT, HCL, ECL, PID, CID
}