package day2

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleTest {
    private lateinit var puzzle: Puzzle

    @BeforeTest
    fun setUp() {
        puzzle = Puzzle()
    }

    @Test
    fun parseFileTest1() {
        val input = "16-18 h: hhhhhhhhhhhhhhhhhh"
        val actual = puzzle.parseInputLine(input)
        val expected: Map<String, String> = mapOf(
            "frequency" to "16-18",
            "letter" to "h",
            "password" to "hhhhhhhhhhhhhhhhhh"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseFileTest2() {
        val input = "17-18 d: ddddddddddddddddzn"
        val actual = puzzle.parseInputLine(input)
        val expected: Map<String, String> = mapOf(
            "frequency" to "17-18",
            "letter" to "d",
            "password" to "ddddddddddddddddzn"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseFileTest3() {
        val input = "8-14 v: pvxlknfvplgktv"
        val actual = puzzle.parseInputLine(input)
        val expected: Map<String, String> = mapOf(
            "frequency" to "8-14",
            "letter" to "v",
            "password" to "pvxlknfvplgktv"
        )
        assertEquals(expected, actual)
    }
}
