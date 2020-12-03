package day3

import java.io.File

class PuzzleLevelOne {
    private val startingPosition = Position(0, 0)

    fun solveLevelTwo(inputFileName: String, moves: List<Move>): Int {
        val treeCounts = moves.map {
            solve(inputFileName, it)
        }
        return treeCounts.reduce { a, c -> a * c }
    }

    fun solve(inputFileName: String, move: Move): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val gridMap = GridMap(readInputFile(file))
        val numberOfMoves = gridMap.mapLines.size - 1
        val route: Route = getRoute(gridMap, startingPosition, numberOfMoves, move)
        return countTrees(gridMap, route)
    }

    fun countTrees(gridMap: GridMap, route: Route): Int {
        var trees = 0
        route.positions.forEach { position ->
            if (isTree(currentCharInGrid(gridMap, position))) {
                trees++
            }
        }
        return trees
    }

    fun getRoute(gridMap: GridMap, startingPosition: Position, numberOfMoves: Int, move: Move): Route {
        val positions = mutableListOf(startingPosition)
        for (i in 1..numberOfMoves) {
            if (positions.last().lineNumber < gridMap.mapLines.size - move.linesToMove) {
                val newPosition = nextPosition(positions[i - 1], move)
                positions.add(newPosition)
            }
        }
        return Route(positions)

    }

    fun isTree(input: Char) = input == "#".single()

    fun nextPosition(currentPosition: Position, move: Move): Position {
        return Position(
            indexInLine = currentPosition.indexInLine + move.indicesToMove,
            lineNumber = currentPosition.lineNumber + move.linesToMove
        )
    }

    fun repeatLinePattern(mapLine: String, numberOfCopies: Int = 1): String {
        val builder = StringBuilder()
        for (i in 0..numberOfCopies) {
            builder.append(mapLine)
        }
        return builder.toString()
    }

    private fun currentCharInGrid(gridMap: GridMap, position: Position): Char {
        val currentLine = gridMap.mapLines[position.lineNumber]
        return currentCharInLine(currentLine, position)
    }

    private fun currentCharInLine(currentLine: String, position: Position): Char {
        val newLine = repeatLinePattern(currentLine, position.indexInLine)
        return newLine[position.indexInLine]
    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()
}
