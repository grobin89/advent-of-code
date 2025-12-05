package org.example.solution.y2025

import org.example.core.UnifiedRawSolution

class S202505 : UnifiedRawSolution<Pair<List<LongRange>, List<Long>>> {
    override fun name() = "S202505"

    override fun solve1(data: Pair<List<LongRange>, List<Long>>): String {
        var freshIds = 0
        data.second.forEach idLoop@ { id ->
            data.first.forEach rangeLoop@ { range ->
                if (id in range) {
                    freshIds++
                    return@idLoop
                }
            }
        }
        return freshIds.toString()
    }

    override fun solve2(data: Pair<List<LongRange>, List<Long>>): String {
        TODO("Not yet implemented")
    }

    override fun data(input: String): Pair<List<LongRange>,List<Long>> {
        val (rawRanges, rawIds) = input.split("\n\n")
        return Pair(
            rawRanges.split("\n").map {
                val (start,end) = it.split("-").map { it.toLong() }
                LongRange(start,end)
            },
            rawIds.split("\n").map { it.toLong() }
        )
    }
}