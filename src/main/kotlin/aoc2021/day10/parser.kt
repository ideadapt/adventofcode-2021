package aoc2021.day10

import java.util.*

fun parse(lines: List<String>): Int {
	val pairs = "([{<".zip(")]}>").toMap()
	val scores = mapOf(Pair(')', 3), Pair(']', 57), Pair('}', 1197), Pair('>', 25137))

	return lines.mapNotNull { line ->
		val stack = Stack<Char>()
		line.dropWhile { c ->
			if (pairs.containsKey(c)) {
				stack.push(c)
				true
			} else {
				val expected = pairs[stack.peek()]
				if (expected == c) {
					stack.pop()
					true
				} else {
//					println("expected ${expected} but found ${c} instead")
					false
				}
			}
		}.firstOrNull()
	}.sumOf { invalid -> scores[invalid]!! }
}
