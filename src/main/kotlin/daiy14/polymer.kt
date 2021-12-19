package daiy14

class Production(
	val input: String,
	val output: Char,
	val left: String = input[0].toString() + output,
	val right: String = output + input[1].toString()
)

fun polymer(lines: List<String>): Long {
	require(lines.isNotEmpty()) { "lines must not be empty" }
	val template = lines.first()
	val rules =
		lines.drop(2).map { rule -> Production(input = rule.take(2), output = rule.takeLast(1).toCharArray()[0]) }
	val charCount = mutableMapOf<Char, Long>()
	var lastRoundPairs = mutableMapOf<String, Long>()

	template.forEach { char ->
		charCount.compute(char) { _, count -> (count ?: 0) + 1 }
	}

	template.windowed(2).forEach { pair ->
		lastRoundPairs.compute(pair) { _, count -> (count ?: 0) + 1 }
	}

	(1..10).forEach { _ ->
		val roundPairs = mutableMapOf<String, Long>()
		rules.forEach { rule ->
			if (lastRoundPairs.containsKey(rule.input)) {
				val nrOfProductions = lastRoundPairs[rule.input]!!
				roundPairs.compute(rule.left) { _, count -> (count ?: 0) + nrOfProductions }
				roundPairs.compute(rule.right) { _, count -> (count ?: 0) + nrOfProductions }
				charCount.compute(rule.output) { _, count -> (count ?: 0) + nrOfProductions }
			}
		}
		lastRoundPairs = roundPairs
	}

	val sorted = charCount.values.sorted()
	return sorted.last() - sorted.first()
}

