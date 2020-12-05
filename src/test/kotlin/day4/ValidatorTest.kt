package day4

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ValidatorTest {
    private lateinit var validator: Validator

    @BeforeTest
    fun setUp() {
        validator = Validator()
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
        val actual = validator.isValidLevel1(logEntry)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidTest2() {
        val logEntry: Map<PassportField, String> = mapOf(
            PassportField.BYR to "1937",
            PassportField.ECL to "gry",
            PassportField.EYR to "2020",
            PassportField.HCL to "#fffffd",
            PassportField.HGT to "183cm",
            PassportField.IYR to "2017",
            PassportField.PID to "860033327"
        )
        val actual = validator.isValidLevel1(logEntry)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValid2Test1() {
        val logEntry: Map<PassportField, String> = mapOf(
            PassportField.BYR to "1837",
            PassportField.ECL to "gry",
            PassportField.EYR to "2020",
            PassportField.HCL to "#fffffd",
            PassportField.HGT to "183cm",
            PassportField.IYR to "2017",
            PassportField.PID to "860033327"
        )
        val actual = validator.isValidLevel2(logEntry)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest(){
        val input = "#888785"
        val actual = validator.isValidHairColor(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest2(){
        val input = "#888X85"
        val actual = validator.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest3(){
        val input = "3888885"
        val actual = validator.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest4(){
        val input = "#88A8F5"
        val actual = validator.isValidHairColor(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHairColorTest5(){
        val input = "#888af5"
        val actual = validator.isValidHairColor(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest1(){
        val input = "149cm"
        val actual = validator.isValidHeight(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest2(){
        val input = "150cm"
        val actual = validator.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest3(){
        val input = "193cm"
        val actual = validator.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest4(){
        val input = "194cm"
        val actual = validator.isValidHeight(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidPidTest1() {
        val input = "88fsdfsad"
        val actual = validator.isValidPID(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidPidTest2() {
        val input = "000000000"
        val actual = validator.isValidPID(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidPidTest3() {
        val input = "0000000b0"
        val actual = validator.isValidPID(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidHeightTest5(){
        val input = "59in"
        val actual = validator.isValidHeight(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear1(){
        val input = "1919"
        val actual = validator.isValidBirthYear(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear2(){
        val input = "1920"
        val actual = validator.isValidBirthYear(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidBirthYear3(){
        val input = "2002"
        val actual = validator.isValidBirthYear(input)
        val expected = true
        assertEquals(expected, actual)
    }
    @Test
    fun isValidBirthYear4(){
        val input = "2003"
        val actual = validator.isValidBirthYear(input)
        val expected = false
        assertEquals(expected, actual)
    }
}
