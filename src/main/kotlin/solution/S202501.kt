package org.example.solution

import org.example.core.BasicSolution

class S202501 : BasicSolution {
    override fun name() = "S202501"

    override fun solve1(data: List<String>): String {
        val numbersOnDial = 100
        var dial = 50
        var zeroes = 0
        data.forEach {
            val direction = it.first()
            var rotation = it.substring(1).toInt()

            dial = when(direction) {
                'R' -> (dial + rotation) % numbersOnDial
                'L' -> (dial - rotation) % numbersOnDial
                else -> throw IllegalArgumentException("Invalid direction: $direction")
            }

            if (dial == 0) zeroes++
        }
        return zeroes.toString()
    }

    override fun solve2(data: List<String>): String {
        val numbersOnDial = 100
        var dial = 50
        var zeroes = 0
        data.forEach {
            val direction = it.first()
            var rotation = it.substring(1).toInt()

            while (rotation != 0) {
                dial = when(direction) {
                    'R' -> (dial + 1) % numbersOnDial
                    'L' -> (dial - 1) % numbersOnDial
                    else -> throw IllegalArgumentException("Invalid direction: $direction")
                }
                rotation--
                if (dial == 0) zeroes++
            }
        }
        return zeroes.toString()
    }
}