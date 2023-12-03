package aoc2023.day2

fun Regex.firstGroupInt(str: String): Sequence<Int> = this.findAll(str).map { it.groupValues[1].toInt() }

class CubeConundrum {

    fun validGamesSum(games: List<String>, red: Int, green: Int, blue: Int): Int {
        return games
            .mapIndexedNotNull { index, game ->
                val blues = Regex("(\\d+) blue").firstGroupInt(game)
                val reds = Regex("(\\d+) red").firstGroupInt(game)
                val greens = Regex("(\\d+) green").firstGroupInt(game)

                if (blues.all { it <= blue } && reds.all { it <= red } && greens.all { it <= green })
                    index
                else
                    null
            }
            .sumOf { it + 1 }
    }

    fun validGamesPowerSum(games: List<String>): Int {
        return games.sumOf { game ->
            val blues = Regex("(\\d+) blue").firstGroupInt(game)
            val reds = Regex("(\\d+) red").firstGroupInt(game)
            val greens = Regex("(\\d+) green").firstGroupInt(game)

            blues.max() * reds.max() * greens.max()
        }
    }
}
