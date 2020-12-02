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
        val actual = puzzle.parseInputLine(input)
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
        val actual = puzzle.parseInputLine(input)
        val expected = ParsedInputLine(
            frequency = IntRange(8, 14),
            letter = "v".single(),
            password = "pvxlknfvplgktv".toCharArray()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun isValidTest1() {
        val input = ParsedInputLine(
            frequency = IntRange(8, 14),
            letter = "v".single(),
            password = "pvxlknfvplgktv".toCharArray()
        )
        val actual = puzzle.isValid(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidTest2() {
        val input = ParsedInputLine(
            frequency = IntRange(3, 7),
            letter = "q".single(),
            password = "sffnxxqvdfsnqlhqpq".toCharArray()
        )
        val actual = puzzle.isValid(input)
        val expected = true
        assertEquals(expected, actual)
    }


    @Test
    fun solveTest() {
        val input = "day2/input.log"
        val actual = puzzle.solve(input)
        val expected = 465
        assertEquals(expected, actual)
    }
}
