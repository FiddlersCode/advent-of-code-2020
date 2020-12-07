/*
package day7

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
    fun extractGroupsTest1() {
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

        val actual = puzzleLevelOne.extractGroups(input)
        val expected = listOf(
            SingleGroupAnswers(
                mutableListOf(
                    PersonAnswers(
                        listOf
                        (
                            PersonAnswer("a"),
                            PersonAnswer("b"),
                            PersonAnswer("q")
                        )
                    )
                )
            ),
            SingleGroupAnswers(
                mutableListOf(
                    PersonAnswers(
                        listOf(
                            PersonAnswer("d"),
                            PersonAnswer("e")
                        )
                    ),
                    PersonAnswers(
                        listOf(
                            PersonAnswer("d"),
                            PersonAnswer("f")
                        )
                    )
                )
            ),
            SingleGroupAnswers(
                mutableListOf(
                    PersonAnswers(
                        listOf(
                            PersonAnswer("x"),
                            PersonAnswer("y"),
                            PersonAnswer("z")
                        )
                    )
                )
            )
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
    fun solveLevel1WithSmallInputTest() {
        val input = "day6/inputSmall.log"
        val actual = puzzleLevelOne.solve(input, 1)
        val expected = 45
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel2WithSmallInputTest() {
        val input = "day6/inputSmaller.log"
        val actual = puzzleLevelOne.solve(input, 2)
        val expected = 2
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
        val expected = 3445
        assertEquals(expected, actual)
    }
}
*/
