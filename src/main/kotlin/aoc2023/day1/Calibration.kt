package aoc2023.day1

class Calibration {
    fun calibrationValuesSumPart1(lines: List<String>): Int =
        lines.sumOf { line ->
            "${line.first { it.isDigit() }}${line.last { it.isDigit() }}".toInt()
        }

    fun calibrationValuesSumPart2(lines: List<String>): Int {
        val digitWordToInt = mapOf(
            *listOf(
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
            ).mapIndexed { index, word -> word to index + 1 }.toTypedArray()
        )
        val digits = digitWordToInt.values.joinToString("|")
        val words = digitWordToInt.keys.joinToString("|")
        val numberStrings = Regex("^($digits|$words)")

        return lines.sumOf { line ->
            val matches = line.indices.mapNotNull { index ->
                numberStrings.find(line.substring(index))?.value?.let { numberString ->
                    digitWordToInt[numberString] ?: numberString.toInt()
                }
            }
            val first = matches.first()
            val last = matches.last()
//            println("$line $first $last")
            "$first$last".toInt()
        }
    }
}
