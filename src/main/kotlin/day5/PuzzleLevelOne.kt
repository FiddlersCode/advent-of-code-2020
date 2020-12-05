package day5

import java.io.File

class PuzzleLevelOne {
    private val numberOfRowChars = 7
    private val numberOfColumnChars = 3
    private val lowerRow = "F".single()
    private val lowerColumn = "L".single()
    val highestRowIndex: Int = 127
    private val highestColumnIndex: Int = 7

    fun solve(inputFileName: String, level: Int): Int {
        val lines = readFileLines(inputFileName)
        val parsedLogLines = parseLogLines(lines)
        val rowsAndColumns = computeRowsAndColumns(parsedLogLines)
        val seatIDs = computeSeatIDs(rowsAndColumns).sorted()
        return if (level == 1) { seatIDs.max()!! } else {
            seatIDs.forEachIndexed { index: Int, seatID: Int ->
                if (seatID + 1 != seatIDs[index + 1]) return seatID + 1
            }
            throw Exception("Cannot find seat ID.")
        }
    }

    fun parseLogLine(logline: String): ParsedLogLine {
        return ParsedLogLine(
            row = logline.substring(IntRange(0, 6)),
            column = logline.substring(IntRange(7, 9))
        )
    }

    fun upperHalf(range: IntRange): IntRange {
        val diff = range.last - range.first + 1
        val lower = (diff / 2) + range.first
        return IntRange(lower, range.last)
    }

    fun lowerHalf(range: IntRange): IntRange {
        val diff = (range.last - range.first) / 2
        val upper = range.first + diff
        return IntRange(range.first, upper)
    }

    fun computeRowsAndColumns(parsedLogLines: List<ParsedLogLine>): List<BinarySearchResult> {
        return parsedLogLines.map { computeRowAndColumn(it) }
    }

    fun computeRowAndColumn(parsedLogLine: ParsedLogLine): BinarySearchResult {
        return BinarySearchResult(
            row = computeRow(parsedLogLine.row),
            column = computeColumn(parsedLogLine.column)
        )
    }

    fun computeColumn(column: String): Int {
        if (column.length != numberOfColumnChars) throw Exception("Incorrect number of chars in column: $column.")
        return binarySearch(column, lowerColumn, highestColumnIndex)
    }

    fun computeRow(row: String): Int {
        if (row.length != numberOfRowChars) throw Exception("Incorrect number of chars in row: $row.")
        return binarySearch(row, lowerRow, highestRowIndex)
    }

    fun computeSeatIDs(binarySearchResults: List<BinarySearchResult>): List<Int> {
        return binarySearchResults.map { computeSeatID(it) }
    }

    fun computeSeatID(binarySearchResult: BinarySearchResult): Int {
        return (binarySearchResult.row * 8) + binarySearchResult.column
    }

    fun parseLogLines(logLines: List<String>): List<ParsedLogLine> {
        return logLines.map { parseLogLine(it) }
    }

    private fun binarySearch(input: String, lowerBound: Char, totalNumberOfIndices: Int): Int {
        var currentRange = IntRange(0, totalNumberOfIndices)
        for (c in input) {
            currentRange = if (c == lowerBound) {
                lowerHalf(currentRange)
            } else {
                upperHalf(currentRange)
            }
        }
        return if (currentRange.first == currentRange.last) {
            currentRange.first
        } else throw Exception("Cannot complete binary search with $input.")
    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()

    private fun readFileLines(inputFileName: String): List<String> {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        return readInputFile(file)
    }
}
