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
    val dirs: Set<Int> = pipeDirections[pipe]!!
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
        }.associateBy { it.x to it.y }

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

    private fun findNext(curr: Cell, posToCell: Map<Pair<Int, Int>, Cell>, path: Set<Cell>, start: Cell): Cell {
        val topCell = posToCell[curr.x to curr.y - 1] ?: nullCell
        val rightCell = posToCell[curr.x + 1 to curr.y] ?: nullCell
        val bottomCell = posToCell[curr.x to curr.y + 1] ?: nullCell
        val leftCell = posToCell[curr.x - 1 to curr.y] ?: nullCell

        return if (bottom in topCell.dirs && top in curr.dirs && newOrEnd(path, topCell, start)) {
            topCell
        } else if (left in rightCell.dirs && right in curr.dirs && newOrEnd(path, rightCell, start)) {
            rightCell
        } else if (right in leftCell.dirs && left in curr.dirs && newOrEnd(path, leftCell, start)) {
            leftCell
        } else if (top in bottomCell.dirs && bottom in curr.dirs && newOrEnd(path, bottomCell, start)) {
            bottomCell
        } else {
            throw IllegalStateException("no connection for $curr, left: $left, right: $right, bottom: $bottom, top: $top\n$path")
        }
    }

    private fun newOrEnd(path: Set<Cell>, cell: Cell, start: Cell): Boolean =
        !path.contains(cell) || (cell == start && path.size > 2)
}
