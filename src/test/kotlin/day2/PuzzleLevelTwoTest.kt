package day2

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleLevelTwoTest {
    private lateinit var puzzleLevelTwo: PuzzleLevelTwo

    @BeforeTest
    fun setUp() {
        puzzleLevelTwo = PuzzleLevelTwo()
    }

    @Test
    fun isValidTest1() {
        val input = ParsedInputLine(
            frequency = IntRange(0, 2),
            letter = "a".single(),
            password = "abcde".toCharArray()
        )
        val actual = puzzleLevelTwo.isValid(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isValidTest2() {
        val input = ParsedInputLine(
            frequency = IntRange(0, 2),
            letter = "b".single(),
            password = "cdefg".toCharArray()
        )
        val actual = puzzleLevelTwo.isValid(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isValidTest3() {
        val input = ParsedInputLine(
            frequency = IntRange(1, 8),
            letter = "c".single(),
            password = "ccccccccc".toCharArray()
        )
        val actual = puzzleLevelTwo.isValid(input)
        val expected = false
        assertEquals(expected, actual)
    }


    @Test
    fun solveTest() {
        val input = "day2/input.log"
        val actual = puzzleLevelTwo.solve(input)
        val expected = 294
        assertEquals(expected, actual)
    }
}
