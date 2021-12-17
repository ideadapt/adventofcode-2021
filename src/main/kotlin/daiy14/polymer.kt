package daiy14

fun polymer(lines: List<String>): Int {
	require(lines.isNotEmpty()) { "lines must not be empty" }
	var polymer = lines.first()
	val rules = lines.drop(2).associate { rule -> Pair(rule.take(2), rule.takeLast(1)) }
	val occ = mutableMapOf<Char, Int>()

	(1..10).forEach { _ ->
		polymer = polymer.windowed(2).joinToString("", "", polymer.takeLast(1)) { pair ->
			pair.first() + rules[pair]!!
		}
	}

	polymer.forEach { c ->
		occ[c] = occ.getOrDefault(c, 0) + 1
	}

	val sorted = occ.values.sorted()
	return sorted.last() - sorted.first()
}
