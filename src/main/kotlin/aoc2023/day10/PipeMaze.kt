package aoc2023.day10

const val left = 1
const val right = 2
const val top = 3
const val bottom = 4

val pipeDirections = mapOf(
    '|' to setOf(top, bottom),
    '-' to setOf(left, right),
    'L' to setOf(right, top),
    'J' to setOf(left, top),
    '7' to setOf(left, bottom),
    'F' to setOf(right, bottom),
    '.' to setOf(),
    'S' to setOf(bottom, right, top, left)
)

data class Cell(
    val x: Int,
    val y: Int,
    val pipe: Char,
    val directions: Set<Int> = pipeDirections[pipe]!!
)

val nullCell = Cell(x = -1, y = -1, pipe = '.')

class PipeMaze {
    /**
    ..F7.
    .FJ|.
    SJ.L7
    |F--J
    LJ...

    ..45.
    .236.
    01.78
    14567
    23...

    => 8
     */
    fun maxDistance(lines: List<String>): Int {
        val posToCell = lines.flatMapIndexed { y, line ->
            line.trim().mapIndexed { x, char -> Cell(x, y, char) }
        }.associateBy { "${it.x}-${it.y}" }

        val start = posToCell.values.first { it.pipe == 'S' }

        val path = mutableSetOf(start) // order does not matter, in part1 at least

        var curr = start
        var i = 1e6 // safety first
        while (--i > 0) {
            val next = findNext(curr, posToCell, path, start)
            if (next == start) break
            path += next
            curr = next
        }

        return path.size / 2
    }

    private fun findNext(curr: Cell, posToCell: Map<String, Cell>, path: Set<Cell>, start: Cell): Cell {
        val topNeighbour = posToCell["${curr.x}-${curr.y - 1}"] ?: nullCell
        val rightNeighbour = posToCell["${curr.x + 1}-${curr.y}"] ?: nullCell
        val bottomNeighbour = posToCell["${curr.x}-${curr.y + 1}"] ?: nullCell
        val leftNeighbour = posToCell["${curr.x - 1}-${curr.y}"] ?: nullCell

        val currDirections = pipeDirections[curr.pipe]!!
        return if (topNeighbour.directions.contains(bottom) && currDirections.contains(top) && (!path.contains(
                topNeighbour
            ) || (topNeighbour == start && path.size > 2))
        ) {
            topNeighbour
        } else if (rightNeighbour.directions.contains(left) && currDirections.contains(right) && (!path.contains(
                rightNeighbour
            ) || (rightNeighbour == start && path.size > 2))
        ) {
            rightNeighbour
        } else if (leftNeighbour.directions.contains(right) && currDirections.contains(left) && (!path.contains(
                leftNeighbour
            ) || (leftNeighbour == start && path.size > 2))
        ) {
            leftNeighbour
        } else if (bottomNeighbour.directions.contains(top) && currDirections.contains(bottom) && (!path.contains(
                bottomNeighbour
            ) || (bottomNeighbour == start && path.size > 2))
        ) {
            bottomNeighbour
        } else {
            throw IllegalStateException("no connection for $curr, left: $left, right: $right, bottom: $bottom, top: $top\n$path")
        }
    }
}
