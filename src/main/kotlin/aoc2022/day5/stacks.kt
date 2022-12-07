package aoc2022.day5

val stacks = mutableMapOf<Int, ArrayDeque<Char>>()

fun fillStacks(input: String): MutableMap<Int, ArrayDeque<Char>> {
    repeat(9) { idx -> stacks[idx + 1] = ArrayDeque() }

    input.trimIndent().lines().forEach { line ->
        if (line.contains('[')) {
            stacks.keys.forEach { pos ->
                val element = line[(pos - 1) * 4 + 1]
                if (element != ' ') stacks[pos]!!.addLast(element)
            }
        }
    }
    return stacks
}

fun move(input: String): List<Char> {
    input.trimIndent().lines().forEach { line ->
        if (line.startsWith("move ")) {
            val (count, from, to) = Regex("move (\\d+) from (\\d+) to (\\d+)").find(line)!!.destructured.toList()
                .map { it.toInt() }
            repeat(count) {
                stacks[to]!!.addFirst(stacks[from]!!.removeFirst())
            }
        }
    }

    return stacks.map { if (it.value.size > 0) it.value.first() else ' ' }
}

fun moveStacked(input: String): List<Char> {
    input.trimIndent().lines().forEach { line ->
        if (line.startsWith("move ")) {
            val (count, from, to) = Regex("move (\\d+) from (\\d+) to (\\d+)").find(line)!!.destructured.toList()
                .map { it.toInt() }
            stacks[to]!!.addAll(0, stacks[from]!!.take(count))
        }
    }

    return stacks.map { if (it.value.size > 0) it.value.first() else ' ' }
}