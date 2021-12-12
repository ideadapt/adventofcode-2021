package grid

typealias Loc = Pair<Int, Int>
typealias Grid = HashMap<Loc, Int>

fun neighbours(grid: Grid, loc: Loc): List<Int> {
	val left = Pair(loc.first - 1, loc.second)
	val right = Pair(loc.first + 1, loc.second)
	val top = Pair(loc.first, loc.second - 1)
	val bottom = Pair(loc.first, loc.second + 1)

	return listOf(left, right, top, bottom).mapNotNull { neighbourLoc -> grid.getOrDefault(neighbourLoc, null) }
}

fun risk(lines: List<String>): Int {
	require(lines.isNotEmpty())

	val size = lines[0].length
	val grid = Grid(size * size)

	lines.forEachIndexed { y, line ->
		line.forEachIndexed { x, value ->
			grid[Pair(x, y)] = value.toString().toInt()
		}
	}

	return grid
		.filter { (loc, num) ->
			neighbours(grid, loc).all { neighbourNum -> neighbourNum > num }
		}
		.map { (_, num) -> num + 1 }
		.sum()
}
