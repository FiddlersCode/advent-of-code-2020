package day3

data class Position(
    val lineNumber: Int,
    val indexInLine: Int
)

data class GridMap(
    val mapLines: List<String>
)

data class Route(
    val positions: List<Position>
)

data class Move(
    val indicesToMove: Int,
    val linesToMove: Int
)