package day3

import java.io.File

class PuzzleLevelOne {

    fun solveLevelTwo(inputFileName: String, moves: List<Move>): Int {
        val treeCounts = moves.map {
            solve(inputFileName, it)
        }
        return treeCounts.reduce { a, c -> a * c}
    }

    fun solve(inputFileName: String, move: Move): Int {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val gridMap = GridMap(readInputFile(file))
        val route: Route = getRoute(Position(0, 0), gridMap.mapLines.size - 1, move)
        return if (move.linesToMove == 2) {
            val newPositions = route.positions.toMutableList()
            newPositions.removeAt(newPositions.size - 1)
            val newRoute = Route(newPositions.toList())
            countTrees(gridMap, newRoute)
        } else {
            countTrees(gridMap, route)
        }
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

    fun getRoute(startingPosition: Position, numberOfMoves: Int, move: Move): Route {
        val positions = mutableListOf(startingPosition)
        for (i in 1..numberOfMoves) {
            val newPosition = move(positions[i - 1], move)
            positions.add(newPosition)
        }
        return Route(positions)
    }

    fun isTree(input: Char) = input == "#".single()

    fun move(currentPosition: Position, move: Move): Position {
        return Position(
            currentPosition.lineNumber + move.linesToMove,
            currentPosition.indexInLine + move.indicesToMove
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
