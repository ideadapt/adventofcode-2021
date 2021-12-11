package row

fun chr2Int(c: Char): Int {
	return c.toString().toInt()
}

fun risk(lines: Array<String>): Int {
	require(lines.isNotEmpty())

	val width = lines[0].length
	val tbWall = List(width + 2) { 9 }
	val lrWall = listOf(9)

	return lines.mapIndexed { lineIdx, line ->
		val prev = if (lineIdx > 0) {
			lrWall + List(width) { c -> lines[lineIdx - 1][c] }.map(::chr2Int) + lrWall
		} else tbWall

		val curr = lrWall + List(width) { c -> line[c] }.map(::chr2Int) + lrWall

		val next = if (lineIdx != lines.size - 1) {
			lrWall + List(width) { c -> lines[lineIdx + 1][c] }.map(::chr2Int) + lrWall
		} else tbWall

		val lineMins = curr.filterIndexed { colIdx, num ->
			val isWall = colIdx == 0 || colIdx > line.length
			if (isWall) false else {
				curr[colIdx + 1] > num && curr[colIdx - 1] > num && prev[colIdx] > num && next[colIdx] > num
			}
		}

		lineMins.sumOf { it + 1 }
	}.sum()
}
