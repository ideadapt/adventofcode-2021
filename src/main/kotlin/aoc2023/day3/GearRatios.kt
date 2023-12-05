package aoc2023.day3

data class Part(val number: Int, val lineIdx: Int, val range: IntRange)
data class Symbol(val symbol: String, val lineIdx: Int, val range: IntRange)

class GearRatios {
    fun partNumbersSum(schematicLines: List<String>): Int {
        val parts = schematicLines.flatMapIndexed { lineIdx, line ->
            Regex("\\d+").findAll(line)
                .map { Part(it.value.toInt(), lineIdx, IntRange(it.range.first - 1, it.range.last + 1)) }
        }.groupBy { it.lineIdx }

        val symbols = schematicLines.flatMapIndexed { lineIdx, line ->
            Regex("[^.0-9]").findAll(line)
                .map { Symbol(it.value, lineIdx, it.range) }
        }.groupBy { it.lineIdx }

        return schematicLines.flatMapIndexed { lineIdx, _ ->
            val contextLines = IntRange(Math.max(0, lineIdx - 1), Math.min(schematicLines.lastIndex, lineIdx + 1))

            parts[lineIdx]?.filter { part ->
                contextLines.any { contextLineIdx ->
                    symbols[contextLineIdx]?.any { symbol ->
                        part.range.contains(symbol.range.first) && part.range.contains(symbol.range.last)
                    } ?: false
                }
            } ?: emptyList()
        }.also {
            println(it.joinToString())
        }.sumOf { it.number }
    }

    fun gearRatioSum(schematicLines: List<String>): Int {
        val parts = schematicLines.flatMapIndexed { lineIdx, line ->
            Regex("\\d+").findAll(line)
                .map { Part(it.value.toInt(), lineIdx, IntRange(it.range.first - 1, it.range.last + 1)) }
        }.groupBy { it.lineIdx }

        val asterisks = schematicLines.flatMapIndexed { lineIdx, line ->
            Regex("\\*").findAll(line)
                .map { Symbol(it.value, lineIdx, it.range) }
        }.groupBy { it.lineIdx }

        return asterisks.keys.sumOf { lineIdx ->
            val contextLines = IntRange(Math.max(0, lineIdx - 1), Math.min(schematicLines.lastIndex, lineIdx + 1))

            asterisks[lineIdx]?.sumOf { asterisk ->
                val asteriskParts = contextLines.flatMap { contextLineIdx ->
                    parts[contextLineIdx]?.mapNotNull { part ->
                        if (part.range.contains(asterisk.range.first) && part.range.contains(asterisk.range.last)) part else null
                    } ?: emptyList()
                }
                if (asteriskParts.size == 2) {
                    asteriskParts[0].number * asteriskParts[1].number
                } else {
                    0
                }
            } ?: 0
        }
    }
}
