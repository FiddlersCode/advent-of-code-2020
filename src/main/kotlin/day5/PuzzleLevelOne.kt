package day5

import java.io.File

class PuzzleLevelOne {
    private val numberOfRowChars = 7
    private val numberOfColumnChars = 3
    private val lowerRow = "F".single()
    private val lowerColumn = "L".single()
    val highestRowIndex: Int = 127
    private val highestColumnIndex: Int = 7

    fun solve(inputFileName: String): Int {
        val seatIDs = getSeatIDs(inputFileName)
        return seatIDs.max()!!
    }

    private fun getSeatIDs(inputFileName: String): List<Int> {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        val lines = readInputFile(file)
        val parsedLogLines = parseLogLines(lines)
        val rowsAndColumns = computeRowsAndColumns(parsedLogLines)
        val seatIDs = computeSeatIDs(rowsAndColumns).sorted()
        return seatIDs
    }

    fun solve2(inputFileName: String): Int? {
        val seatIDs = getSeatIDs(inputFileName)
        seatIDs.forEachIndexed {index: Int,  seatID: Int ->
            if (seatID + 1 != seatIDs[index + 1]) return seatID + 1
        }
        return null
    }

    fun computeRowsAndColumns(parsedLogLines: List<ParsedLogLine>): List<BinarySearchResult> {
        return parsedLogLines.map { computeRowAndColumn(it)}
    }

    fun computeRowAndColumn(parsedLogLine: ParsedLogLine): BinarySearchResult {
        return BinarySearchResult(
            row = computeRow(parsedLogLine.row),
            column =  computeColumn(parsedLogLine.column)
        )
    }

    fun computeRow(row: String): Int {
        if (row.length != numberOfRowChars) throw Exception("Incorrect number of chars in row: $row.")
        return binarySearch(row, lowerRow, highestRowIndex)
    }


    fun computeColumn(column: String): Int {
        if (column.length != numberOfColumnChars) throw Exception("Incorrect number of chars in column: $column.")
        return binarySearch(column, lowerColumn, highestColumnIndex)
    }

    fun computeSeatID(binarySearchResult: BinarySearchResult): Int {
        return (binarySearchResult.row * 8) + binarySearchResult.column
    }

    fun computeSeatIDs(binarySearchResults: List<BinarySearchResult>): List<Int> {
        return binarySearchResults.map { computeSeatID(it) }
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

    fun parseLogLines(logLines: List<String>): List<ParsedLogLine> {
        return logLines.map { parseLogLine(it) }
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

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()
}
