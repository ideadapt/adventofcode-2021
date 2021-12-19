package daiy14

fun polymer1(lines: List<String>) = sequence {

	suspend fun SequenceScope<String>.produce(pair: String, rules: Map<String, String>, depth: Int) {
		val left = pair.take(1)
		if (depth == 0) {
			yield(left)
		} else {
			val right = pair.takeLast(1)
			val insert = rules[left + right]
			produce(left + insert, rules, depth - 1)
			produce(insert + right, rules, depth - 1)
		}
	}

	val polymer = lines.first()
	val rules = lines.drop(2).associate { rule -> Pair(rule.take(2), rule.takeLast(1)) }
	val occ = mutableMapOf<String, Int>()

	for (pair in polymer.windowed(2)) {
		produce(pair, rules, 30)
	}
	yield(polymer.last().toString())
}
/*
fun polymer(lines: List<String>): Int {
	require(lines.isNotEmpty()) { "lines must not be empty" }
	val polymer = lines.first()
	val rules = lines.drop(2).associate { rule -> Pair(rule.take(2), rule.takeLast(1)) }
	val occ = mutableMapOf<String, Int>()

	val polymers = polymer.windowed(2).asSequence().flatMap { pair ->
		produce(pair, rules, 30)
	} + sequenceOf(polymer.last().toString())

//	println(polymers)

/*
	(1..40).forEach { i ->
		polymers = polymers.foldIndexed(mutableListOf<Char>()) { idx, withInserts, c ->
			if(idx == polymers.size-1) withInserts
			else {
				val insert = rules[c + polymers[idx + 1].toString()]!!
				withInserts.add(c)
				withInserts.add(insert)
				withInserts
			}
		} + polymers.last()
		println(i.toString() + " " + polymers.size) //+ " " + polymers.joinToString(""))
	}
*/
	polymers.forEach { c ->
		occ[c] = occ.getOrDefault(c, 0) + 1
	}
	val sorted = occ.values.sorted()
	return sorted.last() - sorted.first()
//	return 0
}
*/
