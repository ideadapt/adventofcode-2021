package aoc2023.day1

class Calibration {
    fun calibrationValuesSum(lines: List<String>): Int =
        lines.sumOf { line ->
            "${line.first { it.isDigit() }}${line.last { it.isDigit() }}".toInt()
        }
}
