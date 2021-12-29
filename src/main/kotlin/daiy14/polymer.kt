package daiy14

data class Tuple(val left: String, val right: String, val pair: Pair<String, String> = Pair(left, right))
data class TupleCount(val tuple: Tuple, val count: Long)

fun mapReduce(
	mapper: (input: TupleCount) -> List<TupleCount>,
	reducer: (key: Tuple, values: List<Long>) -> TupleCount,
	list: List<TupleCount>
): List<TupleCount> {
	val mapped = list.map(mapper).flatten()
	val shuffled = mapped.groupBy(keySelector = { it.tuple }, valueTransform = { it.count })
	return shuffled.mapValues { (key, values) -> reducer(key, values) }.values.toList()
}

fun polymerMRObj(lines: List<String>, depth: Int): Long {
	require(lines.isNotEmpty()) { "lines must not be empty" }
	val rules = lines.drop(2).associate { rule ->
		Pair(Pair(rule.take(1), rule.drop(1).take(1)), rule.takeLast(1))
	}
	val template = lines.first()

	var tupleCounts = template.windowed(2).map {
		TupleCount(Tuple(left = it.take(1), right = it.takeLast(1)), 1)
	}

	(1..depth).forEach { _ ->
		tupleCounts = mapReduce(
			mapper = { tupleCount ->
				val new = rules[tupleCount.tuple.pair]!!
				val left = TupleCount(Tuple(tupleCount.tuple.left, new), tupleCount.count)
				val right = TupleCount(Tuple(new, tupleCount.tuple.right), tupleCount.count)
				listOf(left, right)
			},
			reducer = { tuple, values ->
				TupleCount(tuple, values.sum())
			},
			list = tupleCounts
		)
	}

	val charCount = tupleCounts
		.groupBy(keySelector = { it.tuple.left }, valueTransform = { it.count })
		.mapValues { (_, values) -> values.sum() }
		.toMutableMap()

	charCount[template.takeLast(1)] = charCount[template.takeLast(1)]!! + 1

	val sorted = charCount.values.sorted()
	return sorted.last() - sorted.first()
}

fun polymerMRFun(lines: List<String>, depth: Int): Long {
	require(lines.isNotEmpty()) { "lines must not be empty" }
	val rules = lines.drop(2).associate { rule ->
		Pair(Pair(rule.take(1), rule.drop(1).take(1)), rule.takeLast(1))
	}
	val template = lines.first()

	var tupleCounts = template.windowed(2).map {
		TupleCount(Tuple(left = it.take(1), right = it.takeLast(1)), 1)
	}

	(1..depth).forEach { _ ->
		tupleCounts = tupleCounts.map { (tuple, count): TupleCount ->
			val new = rules[tuple.pair]!!
			val left = TupleCount(Tuple(tuple.left, new), count)
			val right = TupleCount(Tuple(new, tuple.right), count)
			listOf(left, right)
		}.flatten()
			.groupBy(keySelector = { it.tuple }, valueTransform = { it.count }) // shuffle
			.mapValues { (key, values) -> TupleCount(key, values.sum()) }.values.toList() // reduce
	}

	val charCount = tupleCounts
		.groupBy(keySelector = { it.tuple.left }, valueTransform = { it.count })
		.mapValues { (_, values) -> values.sum() }
		.toMutableMap()

	charCount.compute(template.takeLast(1)) { _, count -> (count ?: 0) + 1 }

	val sorted = charCount.values.sorted()
	return sorted.last() - sorted.first()
}

