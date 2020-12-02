package day2

import kotlin.test.Test
import kotlin.test.assertEquals

class ParsedInputLineTest {

    @Test
    fun parseFileTest1() {
        val input = "16-18 h: hhhhhhhhhhhhhhhhhh"
        val actual = parseInputLine(input)
        val expected = ParsedInputLine(
            frequency = IntRange(16, 18),
            letter = "h".single(),
            password = "hhhhhhhhhhhhhhhhhh".toCharArray()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseFileTest2() {
        val input = "17-18 d: ddddddddddddddddzn"
        val actual = parseInputLine(input)
        val expected = ParsedInputLine(
            frequency = IntRange(17, 18),
            letter = "d".single(),
            password = "ddddddddddddddddzn".toCharArray()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseFileTest3() {
        val input = "8-14 v: pvxlknfvplgktv"
        val actual = parseInputLine(input)
        val expected = ParsedInputLine(
            frequency = IntRange(8, 14),
            letter = "v".single(),
            password = "pvxlknfvplgktv".toCharArray()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseFileTestWithZeroIndexConversion() {
        val input = "16-18 h: hhhhhhhhhhhhhhhhhh"
        val actual = parseInputLineWithZeroIndexConversion(input)
        val expected = ParsedInputLine(
            frequency = IntRange(15, 17),
            letter = "h".single(),
            password = "hhhhhhhhhhhhhhhhhh".toCharArray()
        )
        assertEquals(expected, actual)
    }
}
