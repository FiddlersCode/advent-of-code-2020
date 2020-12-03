package day3

import java.io.File

class PuzzleLevelOne {

    fun solve(inputFileName: String): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val gridMap = GridMap(readInputFile(file))
        val route = getRoute(Position(0, 0), gridMap.mapLines.size - 1)
        return countTrees(gridMap, route)
    }

    fun countTrees(gridMap: GridMap, route: Route): Int {
        var trees = 0
        route.positions.forEachIndexed { index, position ->
            if (isTree(currentCharInGrid(gridMap, position))) {
                trees++
            }
        }
        return trees
    }

    fun currentCharInGrid(gridMap: GridMap, position: Position): Char {
        val currentLine = gridMap.mapLines[position.lineNumber]
        return currentCharInLine(currentLine, position)
    }

    private fun currentCharInLine(currentLine: String, position: Position): Char {
        val newLine = repeatLinePattern(currentLine, 200)
        return newLine[position.indexInLine]
    }

    fun repeatLinePattern(mapLine: String, numberOfCopies: Int = 1): String {
        val builder = StringBuilder()
        for (i in 0..numberOfCopies) {
            builder.append(mapLine)
        }
        return builder.toString()
    }

    fun getRoute(startingPosition: Position, numberOfMoves: Int): Route {
        val positions = mutableListOf(startingPosition)
        for (i in 1..numberOfMoves) {
            positions.add(move(positions[i - 1]))
        }
        return Route(positions)
    }

    fun move(currentPosition: Position): Position {
        return Position(currentPosition.lineNumber + 1, currentPosition.indexInLine + 3)
    }

    fun isTree(input: Char): Boolean {
        return input == "#".single()
    }

    private fun readInputFile(filePath: String): List<String> {
        return File(filePath).readLines()
    }
}