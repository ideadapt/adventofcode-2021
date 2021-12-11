package basin

typealias Loc = Pair<Int, Int>
typealias Grid = HashMap<Loc, Int>
typealias Level = Int
typealias Basin = HashSet<Loc>

fun neighbours(grid: Grid, loc: Loc): List<Loc> {
	val left = Pair(loc.first - 1, loc.second)
	val right = Pair(loc.first + 1, loc.second)
	val top = Pair(loc.first, loc.second - 1)
	val bottom = Pair(loc.first, loc.second + 1)

	return listOf(left, right, top, bottom).filter { neighbourLoc -> grid.containsKey(neighbourLoc) }
}

fun collectGreaterNeighbours(basin: Basin, grid: Grid, loc: Loc): Basin {
	basin.add(loc)

	neighbours(grid, loc).filter { nb ->
		val notMax = grid[nb]!! < 9
		val isGreaterNeighbour = grid[nb]!! > grid[loc]!!
		notMax && isGreaterNeighbour
	}.forEach { nb -> collectGreaterNeighbours(basin, grid, nb) }

	return basin
}

fun gridBasin(lines: Array<String>): Int {
	require(lines.isNotEmpty())

	val size = lines[0].length
	val grid = Grid(size * size)

	lines.forEachIndexed { y, line ->
		line.forEachIndexed { x, value ->
			grid[Pair(x, y)] = value.toString().toInt()
		}
	}

	val basins = grid
		.filter { (loc, num) -> neighbours(grid, loc).all { neighbour -> grid[neighbour]!! > num } }
		.map { (loc, _) ->
			collectGreaterNeighbours(Basin(10), grid, loc).size
		}

	return basins.sortedDescending().take(3).reduce { prod, basinSize -> basinSize * prod }
}
