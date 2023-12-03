package aoc2023.day2

class CubeConundrum {

    fun validGamesSum(games: List<String>, red: Int, green: Int, blue: Int): Int {
        return games
            .mapIndexedNotNull { index, game ->
                val blues = Regex("(\\d+) blue").findAll(game).map { it.groupValues[1].toInt() }
                val reds = Regex("(\\d+) red").findAll(game).map { it.groupValues[1].toInt() }
                val greens = Regex("(\\d+) green").findAll(game).map { it.groupValues[1].toInt() }

                if (blues.all { it <= blue } && reds.all { it <= red } && greens.all { it <= green })
                    index
                else
                    null
            }
            .sumOf { it + 1 }
    }

    fun validGamesPowerSum(games: List<String>): Int {
        return games.sumOf { game ->
            val blues = Regex("(\\d+) blue").findAll(game).map { it.groupValues[1].toInt() }
            val reds = Regex("(\\d+) red").findAll(game).map { it.groupValues[1].toInt() }
            val greens = Regex("(\\d+) green").findAll(game).map { it.groupValues[1].toInt() }

            blues.max() * reds.max() * greens.max()
        }
    }
}
