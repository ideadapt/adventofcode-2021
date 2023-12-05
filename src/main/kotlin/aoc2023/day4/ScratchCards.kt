package aoc2023.day4

import kotlin.math.pow

class ScratchCards {
    fun totalPoints(cards: List<String>): Double {
        return cards.sumOf { card ->
            val (winning, mine) = card
                .substringAfter(": ")
                .split(" | ")
                .map { part ->
                    Regex("\\d+").findAll(part).map { it.value.toInt() }
                }
            val same = winning.toSet().intersect(mine.toSet())
            if (same.isEmpty()) 0.0 else 2.0.pow(same.size.toDouble() - 1)
        }
    }
}
