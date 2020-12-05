package day5

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
    fun upperHalfTest1() {
        val input = IntRange(0, puzzleLevelOne.highestRowIndex)
        val actual = puzzleLevelOne.upperHalf(input)
        val expected = IntRange(64, 127)
        assertEquals(expected, actual)
    }

    @Test
    fun upperHalfTest2() {
        val input = IntRange(0, 63)
        val actual = puzzleLevelOne.upperHalf(input)
        val expected = IntRange(32, 63)
        assertEquals(expected, actual)
    }

    @Test
    fun upperHalfTest3() {
        val input = IntRange(32, 47)
        val actual = puzzleLevelOne.upperHalf(input)
        val expected = IntRange(40, 47)
        assertEquals(expected, actual)
    }

    @Test
    fun upperHalfTest4() {
        val input = IntRange(40, 47)
        val actual = puzzleLevelOne.upperHalf(input)
        val expected = IntRange(44, 47)
        assertEquals(expected, actual)
    }


    @Test
    fun upperHalfTest5() {
        val input = IntRange(44, 45)
        val actual = puzzleLevelOne.upperHalf(input)
        val expected = IntRange(45, 45)
        assertEquals(expected, actual)
    }

    @Test
    fun lowerHalfTest1() {
        val input = IntRange(0, puzzleLevelOne.highestRowIndex)
        val actual = puzzleLevelOne.lowerHalf(input)
        val expected = IntRange(0, 63)
        assertEquals(expected, actual)
    }

    @Test
    fun lowerHalfTest2() {
        val input = IntRange(32, 63)
        val actual = puzzleLevelOne.lowerHalf(input)
        val expected = IntRange(32, 47)
        assertEquals(expected, actual)
    }

    @Test
    fun lowerHalfTest3() {
        val input = IntRange(44, 47)
        val actual = puzzleLevelOne.lowerHalf(input)
        val expected = IntRange(44, 45)
        assertEquals(expected, actual)
    }

    @Test
    fun lowerHalfTest4() {
        val input = IntRange(44, 45)
        val actual = puzzleLevelOne.lowerHalf(input)
        val expected = IntRange(44, 44)
        assertEquals(expected, actual)
    }

    @Test
    fun computeRowTest1() {
        val input = "FBFBBFF"
        val actual = puzzleLevelOne.computeRow(input)
        val expected = 44
        assertEquals(expected, actual)
    }

    @Test
    fun computeColumnTest1() {
        val input = "RLR"
        val actual = puzzleLevelOne.computeColumn(input)
        val expected = 5
        assertEquals(expected, actual)
    }

    @Test
    fun computeRowAndColumnTest1() {
        val parsedLogLine = ParsedLogLine(
            row = "FBFBBFF",
            column = "RLR"
        )

        val actual = puzzleLevelOne.computeRowAndColumn(parsedLogLine)
        val expected = BinarySearchResult(row = 44, column = 5)
        assertEquals(expected, actual)
    }

    @Test
    fun computeRowsAndColumnsTest1() {
        val parsedLogLines = listOf(
            ParsedLogLine(
                row = "FBFBBFF",
                column = "RLR"
            ),
            ParsedLogLine(
                row = "FBFBBFB",
                column = "RLR"
            )
        )

        val actual = puzzleLevelOne.computeRowsAndColumns(parsedLogLines)
        val expected = listOf(
            BinarySearchResult(row = 44, column = 5),
            BinarySearchResult(row = 45, column = 5)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun computeSeatIDTest1() {
        val input = BinarySearchResult(row = 44, column = 5)
        val actual = puzzleLevelOne.computeSeatID(input)
        val expected = 357
        assertEquals(expected, actual)
    }

    @Test
    fun computeSeatIDsTest1() {
        val input = listOf(
            BinarySearchResult(row = 44, column = 5),
            BinarySearchResult(row = 45, column = 5)
        )
        val actual = puzzleLevelOne.computeSeatIDs(input)
        val expected = listOf(357, 365)
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLineTest1() {
        val input = "FBBBBBBRRL"
        val input2 = "BBFFFBBLRL"
        val actual = puzzleLevelOne.parseLogLine(input)
        val expected = ParsedLogLine(
            row = "FBBBBBB",
            column = "RRL"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLinesTest1() {
        val input = listOf(
            "FBBBBBBRRL",
            "BBFFFBBLRL"
        )
        val actual = puzzleLevelOne.parseLogLines(input)
        val expected = listOf(
            ParsedLogLine(
                row = "FBBBBBB",
                column = "RRL"
            ),
            ParsedLogLine(
                row = "BBFFFBB",
                column = "LRL"
            )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun solveTest() {
        val input = "day5/input.log"
        val actual = puzzleLevelOne.solve(input)
        val expected = 256
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel2Test() {
//        val input = "day5/input.log"
//        val actual = puzzleLevelOne.solve(input, 2)
//        val expected = 198
//        assertEquals(expected, actual)
    }
}
