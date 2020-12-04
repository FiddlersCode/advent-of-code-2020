package day4

import kotlin.math.exp
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PuzzleLevelOneTest {
    private lateinit var puzzleLevelOne: PuzzleLevelOne

    @BeforeTest
    fun setUp() {
        puzzleLevelOne = PuzzleLevelOne()
    }

    @Test
    fun isValidTest1() {
        val logEntry: Map<PassportField, String> = mapOf(
            PassportField.BYR to "1937",
            PassportField.CID to "157",
            PassportField.ECL to "gry",
            PassportField.EYR to "2020",
            PassportField.HCL to "#fffffd",
            PassportField.HGT to "183cm",
            PassportField.IYR to "2017",
            PassportField.PID to "860033327"
        )
        val actual = puzzleLevelOne.isValid(logEntry)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLineTest1() {
        val logLine = "hgt:171cm iyr:2013 pid:214368857 hcl:#cfa07d byr:1986 eyr:2028 ecl:grn"
        val actual: Map<PassportField, String> = puzzleLevelOne.parseLogLine(logLine).toSortedMap()
        val expected: Map<PassportField, String> =
            mapOf(
                PassportField.BYR to "1986",
                PassportField.ECL to "grn",
                PassportField.EYR to "2028",
                PassportField.HCL to "#cfa07d",
                PassportField.HGT to "171cm",
                PassportField.IYR to "2013",
                PassportField.PID to "214368857"
            )
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLinesTest1() {
        val logLines = listOf(
            "hgt:171cm",
            "iyr:2013 pid:214368857 hcl:#cfa07d byr:1986 eyr:2028 ecl:gry",
            "",
            "hgt:167cm cid:210 ecl:brn pid:429131951 hcl:#cfa07d eyr:2029 iyr:2010",
            "byr:1945",
            ""
        )
        val actual = puzzleLevelOne.parseLogLines(logLines)
        val expected: List<Map<PassportField, String>> = listOf(
            mapOf(
                PassportField.BYR to "1986",
                PassportField.ECL to "gry",
                PassportField.EYR to "2028",
                PassportField.HCL to "#cfa07d",
                PassportField.HGT to "171cm",
                PassportField.IYR to "2013",
                PassportField.PID to "214368857"
            ),
            mapOf(
                PassportField.BYR to "1945",
                PassportField.CID to "210",
                PassportField.ECL to "brn",
                PassportField.EYR to "2029",
                PassportField.HCL to "#cfa07d",
                PassportField.HGT to "167cm",
                PassportField.IYR to "2010",
                PassportField.PID to "429131951"
            )
        )
        expected.forEachIndexed { index: Int, expectedField: Map<PassportField, String> ->
            assertEquals(expectedField.toSortedMap(), actual[index].toSortedMap())
        }
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest(){
        val input = "#888785"
        val actual = puzzleLevelOne.isValidHairColor(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest2(){
        val input = "#888X85"
        val actual = puzzleLevelOne.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest3(){
        val input = "3888885"
        val actual = puzzleLevelOne.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest4(){
        val input = "#88A8F5"
        val actual = puzzleLevelOne.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest5(){
        val input = "#888af5"
        val actual = puzzleLevelOne.isValidHairColor(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest1(){
        val input = "149cm"
        val actual = puzzleLevelOne.isValidHeight(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest2(){
        val input = "150cm"
        val actual = puzzleLevelOne.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest3(){
        val input = "193cm"
        val actual = puzzleLevelOne.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest4(){
        val input = "194cm"
        val actual = puzzleLevelOne.isValidHeight(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidPidTest1() {
        val input = "88fsdfsad"
        val actual = puzzleLevelOne.isValidPID(input)
        val expected = false
        assertEquals(expected, actual)
    }


    @Test
    fun isValidPidTest2() {
        val input = "000000000"
        val actual = puzzleLevelOne.isValidPID(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidPidTest3() {
        val input = "0000000b0"
        val actual = puzzleLevelOne.isValidPID(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest5(){
        val input = "59in"
        val actual = puzzleLevelOne.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear1(){
        val input = "1919"
        val actual = puzzleLevelOne.isValidBirthYear(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear2(){
        val input = "1920"
        val actual = puzzleLevelOne.isValidBirthYear(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear3(){
        val input = "2002"
        val actual = puzzleLevelOne.isValidBirthYear(input)
        val expected = true
        assertEquals(expected, actual)
    }
    @Test
    fun isValidBirthYear4(){
        val input = "2003"
        val actual = puzzleLevelOne.isValidBirthYear(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun solveTest() {
        val input = "day4/input.log"
        val actual = puzzleLevelOne.solve(input)
        val expected = 256
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel2Test() {
        val input = "day4/input.log"
        val actual = puzzleLevelOne.solve2(input)
        val expected = 223
        assertEquals(expected, actual)
    }
}
