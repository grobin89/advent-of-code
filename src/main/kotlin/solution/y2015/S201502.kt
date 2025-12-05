package org.example.solution.y2015

import org.example.core.UnifiedSolution

class S201502 : UnifiedSolution<List<List<Long>>> {
    override fun name() = "S201502"

    override fun data(input: List<String>): List<List<Long>> = input
        .map { it.split("x").map { it.toLong() } }

    override fun solve1(data: List<List<Long>>) = data
        .map { listOf(it[0] * it[1], it[1] * it[2], it[0] * it[2]) }
        .sumOf { it.sumOf { sf -> sf * 2 } + it.min() }.toString()

    override fun solve2(data: List<List<Long>>) = data
        .map { it.sorted() }
        .sumOf { it.take(2).sumOf { m -> m * 2 } + it[0]*it[1]*it[2] }
        .toString()
}