package org.example.solution.y2025

import org.example.core.UnifiedSolution

class S202505 : UnifiedSolution<Pair<List<LongRange>, List<Long>>> {
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
        val ranges = data.first.sortedBy { it.first }
        val mergedRanges = mutableListOf(ranges.first())

        ranges.drop(1).forEach { comparator ->
            val principal = mergedRanges.last()
            if (principal.isOverlapping(comparator)) {
                val mergedRange = principal.mergeWith(comparator)
                mergedRanges.swapLast(mergedRange)
            } else {
                mergedRanges.add(comparator)
            }
        }
        println(mergedRanges)

        return mergedRanges.sumOf { it.last + 1 - it.first }.toString()
    }

    override fun data(input: List<String>): Pair<List<LongRange>,List<Long>> {
        val (rawRanges, rawIds) = input.partition { it.contains('-') }
        return Pair(
            rawRanges.map { range ->
                val (start,end) = range.split("-").map {
                    val l = it.toLong()
                    l
                }
                LongRange(start,end)
            },
            rawIds.map { it.toLong() }
        )
    }

    private fun LongRange.isOverlapping(comparator: LongRange): Boolean {
        if (this.first in comparator) return true
        if (this.last in comparator) return true
        if (comparator.first in this) return true
        if (comparator.last in this) return true
        return false
    }

    private fun LongRange.mergeWith(range: LongRange): LongRange {
        val lowestFirst = if (this.first < range.first) this.first else range.first
        val highestLast = if (this.last > range.last) this.last else range.last
        return LongRange(lowestFirst, highestLast)
    }

    private fun <R>MutableList<R>.swapLast(item: R) {
        this.removeLast()
        this.add(item)
    }
}