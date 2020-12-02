package day1

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleLevelOneTest {
    private lateinit var puzzle: Puzzle

    @BeforeTest
    fun setUp() {
        puzzle = Puzzle()
    }

    @Test
    fun solveTwoAdjacentNumbers() {
        val input: List<Int> = listOf(
            1, 5, 3, 28, 1992, 33
        )
        val actual: Int = puzzle.solve(input, 1)
        val expected = 55776
        assertEquals(expected, actual)
    }

    @Test
    fun solveTwoNonadjacentNumbers() {
        val input: List<Int> = listOf(
            1, 5, 3, 28, 843, 23, 1992, 33
        )
        val actual: Int = puzzle.solve(input, 1)
        val expected = 55776
        assertEquals(expected, actual)
    }

    @Test
    fun solveRealInputTwoNumbers() {
        val inputFile = "day1/input.log"
        val actual: Int = puzzle.solve(inputFile, 1)
        val expected = 41979
        assertEquals(expected, actual)
    }

    @Test
    fun solveThreeAdjacentNumbers() {
        val input: List<Int> = listOf(
            1, 5, 3, 20, 8, 1992, 33
        )
        val actual: Int = puzzle.solve(input, 2)
        val expected = 318720
        assertEquals(expected, actual)
    }

    @Test
    fun solveThreeNonadjacentNumbers() {
        val input: List<Int> = listOf(
            1, 5, 3, 20, 843, 239, 1992, 33, 8
        )
        val actual: Int = puzzle.solve(input, 2)
        val expected = 318720
        assertEquals(expected, actual)
    }

    @Test
    fun solveRealInputThreeNumbers() {
        val inputFile = "day1/input.log"
        val actual: Int = puzzle.solve(inputFile, 2)
        val expected = 193416912
        assertEquals(expected, actual)
    }
}
