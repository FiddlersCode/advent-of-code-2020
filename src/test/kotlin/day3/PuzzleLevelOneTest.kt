package day3

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleLevelOneTest {
    private val levelOneMove = Move(3, 1)
    private val levelTwoMove = Move(indicesToMove = 1, linesToMove = 2)
    private val genericGridMap = GridMap(
        mapLines = listOf(
            ".##.....#....#....#..#.#...#.##",
            ".###........#.##....#......#..#",
            "#..#..#.....#...#....#.#.......",
            ".........#.................#..."
        )
    )
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
    fun nextPositionTest1() {
        val currentPosition = Position(
            indexInLine = 0,
            lineNumber = 0
        )
        val move = Move(1, 2)
        val actual = puzzleLevelOne.nextPosition(currentPosition, move)
        val expected = Position(
            indexInLine = 1,
            lineNumber = 2
        )
        assertEquals(expected, actual)
    }

    @Test
    fun nextPositionTest2() {
        val currentPosition = Position(
            lineNumber = 0,
            indexInLine = 0
        )

        val actual = puzzleLevelOne.nextPosition(currentPosition, levelOneMove)
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
        val actual = puzzleLevelOne.getRoute(
            genericGridMap,
            startingPosition,
            3,
            levelOneMove
        )
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
    fun getRouteTest2() {
        val startingPosition = Position(
            lineNumber = 0,
            indexInLine = 0
        )

        val move = Move(
            indicesToMove = 1,
            linesToMove = 2
        )
        val actual = puzzleLevelOne.getRoute(
            genericGridMap,
            startingPosition,
            2,
            move
        )
        val expected = Route(
            listOf(
                startingPosition,
                Position(
                    indexInLine = 1,
                    lineNumber = 2
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
                ), Position(
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
        val actual = puzzleLevelOne.solve(input, levelOneMove)
        val expected = 223
        assertEquals(expected, actual)
    }

    @Test
    fun solveTest2() {
        val input = "day3/input.log"
        val move = Move(1, 1)
        val actual = puzzleLevelOne.solveLevelTwo(input, listOf(move))
        val expected = 223
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel2Test() {
        val input = "day3/input.log"
        val moves = listOf(
//            Move(1, 1),
            Move(3, 1),
            Move(5, 1),
            Move(7, 1),
            Move(1, 2)
        )
        val actual = puzzleLevelOne.solveLevelTwo(input, moves)
        val expected = 223
        assertEquals(expected, actual)
    }
}
