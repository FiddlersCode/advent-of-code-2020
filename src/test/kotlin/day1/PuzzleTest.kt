package day1

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
    fun solveTest1() {
        val input: List<Int> = listOf(
            1, 5, 3, 28, 1992, 33
        )
        val actual: Int = puzzle.solve(input)
        val expected = 55776
        assertEquals(expected, actual)
    }
}
