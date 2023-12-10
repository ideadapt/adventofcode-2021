package aoc2023.day10

val left = intArrayOf(-1, 0)
val right = intArrayOf(1, 0)
val top = intArrayOf(0, -1)
val bottom = intArrayOf(0, 1)

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
    var inPath: Boolean = false,
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
            line.trim().mapIndexed { x, char -> Cell(x, y, char, inPath = char == 'S') }
        }.associateBy { "${it.x}-${it.y}" }

        val start = posToCell.values.first { it.pipe == 'S' }

        val path = mutableListOf(start)

        val topNeighbour = posToCell["${start.x}-${start.y - 1}"] ?: nullCell
        val rightNeighbour = posToCell["${start.x + 1}-${start.y}"] ?: nullCell
        val bottomNeighbour = posToCell["${start.x}-${start.y + 1}"] ?: nullCell
        val leftNeighbour = posToCell["${start.x - 1}-${start.y}"] ?: nullCell

        var curr = if (pipeDirections[topNeighbour.pipe]!!.contains(bottom)) {
            topNeighbour
        } else if (pipeDirections[rightNeighbour.pipe]!!.contains(left)) {
            rightNeighbour
        } else if (pipeDirections[leftNeighbour.pipe]!!.contains(right)) {
            leftNeighbour
        } else if (pipeDirections[bottomNeighbour.pipe]!!.contains(top)) {
            bottomNeighbour
        } else {
            throw IllegalStateException("start $start has no connectable neighbour")
        }
        curr.inPath = true
        path += curr

        var i = 1e6 // safety first
        while (--i > 0) {
            val next = findNext(curr, posToCell, path, start)
            if (next == start) break
            path += next
            next.inPath = true
            curr = next
        }

        println(i)
        println(path.take(200))

        return path.size / 2
    }

    private fun findNext(curr: Cell, posToCell: Map<String, Cell>, path: MutableList<Cell>, start: Cell): Cell {
        val topNeighbour = posToCell["${curr.x}-${curr.y - 1}"] ?: nullCell
        val rightNeighbour = posToCell["${curr.x + 1}-${curr.y}"] ?: nullCell
        val bottomNeighbour = posToCell["${curr.x}-${curr.y + 1}"] ?: nullCell
        val leftNeighbour = posToCell["${curr.x - 1}-${curr.y}"] ?: nullCell

        val currDirections = pipeDirections[curr.pipe]!!
        return if (pipeDirections[topNeighbour.pipe]!!.contains(bottom) && currDirections.contains(top) && (!topNeighbour.inPath || (topNeighbour == start && path.size > 2))) {
            topNeighbour
        } else if (pipeDirections[rightNeighbour.pipe]!!.contains(left) && currDirections.contains(right) && (!rightNeighbour.inPath || (rightNeighbour == start && path.size > 2))) {
            rightNeighbour
        } else if (pipeDirections[leftNeighbour.pipe]!!.contains(right) && currDirections.contains(left) && (!leftNeighbour.inPath || (leftNeighbour == start && path.size > 2))) {
            leftNeighbour
        } else if (pipeDirections[bottomNeighbour.pipe]!!.contains(top) && currDirections.contains(bottom) && (!bottomNeighbour.inPath || (bottomNeighbour == start && path.size > 2))) {
            bottomNeighbour
        } else {
            throw IllegalStateException("no connection for $curr, left: $left, right: $right, bottom: $bottom, top: $top\n$path")
        }
    }
}
