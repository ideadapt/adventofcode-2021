package aoc2023.day5

class Map(private val sourceStart: Long, private val destStart: Long, private val length: Long) {
    operator fun contains(value: Long) = value in sourceStart..(sourceStart + length)

    fun toDest(value: Long) = destStart + (value - sourceStart)
}

class SeedFertilizer {
    fun minLocation(lines: List<String>): Long {
        val seeds = Regex("\\d+").findAll(lines.first()).map { it.value.toLong() }.toList()
        val seedToSoil = emptySet<Map>().toMutableSet()
        val soilToFert = emptySet<Map>().toMutableSet()
        val fertToWater = emptySet<Map>().toMutableSet()
        val waterToLight = emptySet<Map>().toMutableSet()
        val lightToTemp = emptySet<Map>().toMutableSet()
        val tempToHum = emptySet<Map>().toMutableSet()
        val humToLoc = emptySet<Map>().toMutableSet()
        var parsing = seedToSoil

        lines.drop(2).filter { it.isNotEmpty() }.forEach { line ->
            when (line) {
                "seed-to-soil map:" -> parsing = seedToSoil
                "soil-to-fertilizer map:" -> parsing = soilToFert
                "fertilizer-to-water map:" -> parsing = fertToWater
                "water-to-light map:" -> parsing = waterToLight
                "light-to-temperature map:" -> parsing = lightToTemp
                "temperature-to-humidity map:" -> parsing = tempToHum
                "humidity-to-location map:" -> parsing = humToLoc
                else -> {
                    val (destStart, sourceStart, length) = Regex("\\d+").findAll(line).map { it.value.toLong() }
                        .toList()
                    parsing += Map(sourceStart, destStart, length)
                }
            }
        }

        return seeds.map { seed ->
            val soil = seedToSoil.find { seed in it }?.toDest(seed) ?: seed
            val fert = soilToFert.find { soil in it }?.toDest(soil) ?: soil
            val water = fertToWater.find { fert in it }?.toDest(fert) ?: fert
            val light = waterToLight.find { water in it }?.toDest(water) ?: water
            val temp = lightToTemp.find { light in it }?.toDest(light) ?: light
            val hum = tempToHum.find { temp in it }?.toDest(temp) ?: temp
            val loc = humToLoc.find { hum in it }?.toDest(hum) ?: hum
            loc
        }.minBy { it }
    }
}
