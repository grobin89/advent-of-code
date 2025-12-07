package org.example.solution.y2025

import org.example.core.BasicSolution
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
        val firstParse = input.dropLast(1).map { it.split(Regex("\\w")).map { it.toInt() } }
        TODO("Not yet implemented")
    }

}