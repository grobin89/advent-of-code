package org.example.solution.y2025

import org.example.core.UnifiedSolution

class S202506 : UnifiedSolution<List<Pair<List<Int>,Char>>> {
    override fun name() = "S202506"

    override fun solve2(data: List<Pair<List<Int>, Char>>): String {
        TODO("Not yet implemented")
    }

    override fun solve1(data: List<Pair<List<Int>, Char>>): String {
        TODO("Not yet implemented")
    }

    override fun data(input: List<String>): List<Pair<List<Int>, Char>> {
        val firstParse = input.dropLast(1).map { it.trim().split(Regex("\\s+")) }
        val lastParse = input.takeLast(1).first().trim().split(Regex("\\s+"))
        println(firstParse)
        println(lastParse)
        TODO("Not yet implemented")
    }

}