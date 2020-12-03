package day3

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
    fun isTreeTest1() {
        val input = "#".single()
        val actual = puzzleLevelOne.isTree(input)
        val expected = true
        assertEquals(expected, actual)
    }

    @Test
    fun isTreeTest2() {
        val input = ".".single()
        val actual = puzzleLevelOne.isTree(input)
        val expected = false
        assertEquals(expected, actual)
    }

    @Test
    fun moveTest1() {
        val currentPosition = Position(
            lineNumber = 0,
            indexInLine = 0
        )
        val actual = puzzleLevelOne.move(currentPosition)
        val expected = Position(
            lineNumber = 1,
            indexInLine = 3
        )
        assertEquals(expected, actual)
    }

    @Test
    fun getRouteTest1() {
        val startingPosition = Position(
            lineNumber = 0,
            indexInLine = 0
        )
        val actual = puzzleLevelOne.getRoute(startingPosition, 3)
        val expected = Route(
            listOf(
                startingPosition,
                Position(
                    lineNumber = 1,
                    indexInLine = 3
                ),
                Position(
                    lineNumber = 2,
                    indexInLine = 6
                ),
                Position(
                    lineNumber = 3,
                    indexInLine = 9
                )
            )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun countTreesTest1() {
        val gridMap = GridMap(
            mapLines = listOf(
                ".##.....#....#....#..#.#...#.##",
                ".###........#.##....#......#..#",
                "#..#..#.....#...#....#.#.......",
                ".........#.................#..."
            )
        )
        val route = Route(
            listOf(
                Position(
                    lineNumber = 0,
                    indexInLine = 0
                ),   Position(
                    lineNumber = 1,
                    indexInLine = 3
                ),
                Position(
                    lineNumber = 2,
                    indexInLine = 6
                ),
                Position(
                    lineNumber = 3,
                    indexInLine = 9
                )
            )
        )
        val actual = puzzleLevelOne.countTrees(gridMap, route)
        val expected = 3

        assertEquals(expected, actual)
    }

    @Test
    fun repeatLinePatternTest1() {
        val gridMap = GridMap(
            mapLines = listOf(
                ".##..",
                ".##..",
                ".##..",
                ".##..",
                ".##..",
                ".##.."
            )
        )

        val actual = puzzleLevelOne.repeatLinePattern(gridMap.mapLines[0])
        val expected = ".##...##.."

        assertEquals(expected, actual)
    }

    @Test
    fun solveTest() {
        val input = "day3/input.log"
        val actual = puzzleLevelOne.solve(input)
        val expected = 223
        assertEquals(expected, actual)
    }
}
