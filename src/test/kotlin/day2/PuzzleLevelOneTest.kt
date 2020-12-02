package day2

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleLevelOneTest {
    private lateinit var puzzleLevelOne: PuzzleLevelOne

    @BeforeTest
    fun setUp() {
        puzzleLevelOne = PuzzleLevelOne()
    }

    @Test
    fun isValidTest1() {
        val input = ParsedInputLine(
            frequency = IntRange(8, 14),
            letter = "v".single(),
            password = "pvxlknfvplgktv".toCharArray()
        )
        val actual = puzzleLevelOne.isValid(input)
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
        val actual = puzzleLevelOne.isValid(input)
        val expected = true
        assertEquals(expected, actual)
    }


    @Test
    fun solveTest() {
        val input = "day2/input.log"
        val actual = puzzleLevelOne.solve(input)
        val expected = 465
        assertEquals(expected, actual)
    }
}
