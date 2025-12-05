package org.example.solution.y2025

import org.example.core.UnifiedSolution

class S202503 : UnifiedSolution<List<List<Int>>> {
    override fun name() = "S202503"

    override fun data(input: List<String>) =  input.map { bank -> bank.toList().map { battery -> battery.toString().toInt() } }

    override fun solve1(data: List<List<Int>>) = getJoltage(data, 2).toString()

    override fun solve2(data: List<List<Int>>) = getJoltage(data, 12).toString()

    private fun getJoltage(data: List<List<Int>>, digits: Int): Long {
        return data.sumOf { bank ->
            val joltage = mutableListOf<Int>()
            var trimIndex = 0

            (1..digits).forEach { digitIndex ->
                val scope = bank.drop(trimIndex).dropLast(digits - digitIndex)
                var maxIndex = 0
                var maxBattery = scope[0]
                scope.forEachIndexed { index, battery ->
                    if (battery > maxBattery) {
                        maxBattery = battery
                        maxIndex = index
                        println(index)
                    }
                }
                joltage.add(maxBattery)
                trimIndex += (maxIndex + 1)
            }

            joltage.joinToString("").toLong()
        }
    }
}