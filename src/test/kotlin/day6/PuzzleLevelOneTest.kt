package day6

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
    fun isNewGroupTest1() {
        val input = listOf(
            "a",
            "b",
            "x",
            "",
            "de",
            "df",
            "abc",
            ""
        )
        val actual = puzzleLevelOne.isGroupDelimiter(input, 0)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isNewGroupTest2() {
        val input = listOf(
            "a",
            "b",
            "x",
            "",
            "de",
            "df",
            "abc",
            ""
        )
        val actual = puzzleLevelOne.isGroupDelimiter(input, input.size - 1)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isNewGroupTest3() {
        val input = listOf(
            "a",
            "b",
            "x",
            "",
            "de",
            "df",
            "abc",
            ""
        )
        val actual = puzzleLevelOne.isGroupDelimiter(input, 2)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun isNewGroupTest4() {
        val input = listOf(
            "a",
            "b",
            "x",
            "",
            "de",
            "df",
            "abc",
            ""
        )
        val actual = puzzleLevelOne.isGroupDelimiter(input, 3)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLinesTest1() {
        val input = listOf(
            "a",
            "b",
            "q",
            "",
            "de",
            "df",
            "",
            "xyz",
            ""
        )

        val actual = puzzleLevelOne.parseLogLines(input)
        val expected = listOf(
            "abq",
            "dedf",
            "xyz"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun countNumberOfGroupAnswersTest1() {
        val input = listOf(9, 8, 3, 1)
        val actual = puzzleLevelOne.countNumberOfGroupAnswers(input)
        val expected = 21
        assertEquals(expected, actual)
    }

    @Test
    fun solveWithSmallInputTest() {
        val input = "day6/inputSmall.log"
        val actual = puzzleLevelOne.solve(input, 1)
        // no 6743
        val expected = 45
        assertEquals(expected, actual)
    }

    @Test
    fun solveTest() {
        val input = "day6/input.log"
        val actual = puzzleLevelOne.solve(input, 1)
        val expected = 6748
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel2Test() {
        val input = "day6/input.log"
        val actual = puzzleLevelOne.solve(input, 2)
        val expected = 603
        assertEquals(expected, actual)
    }
}
