package day3

data class Position(
    val indexInLine: Int,
    val lineNumber: Int
)

data class Move(
    val indicesToMove: Int,
    val linesToMove: Int
)

data class GridMap(
    val mapLines: List<String>
)

data class Route(
    val positions: List<Position>
)
