package org.example.solution.y2015

import org.example.core.UnifiedSolution

class S201501 : UnifiedSolution<List<Char>> {
    override fun name() = "S201501"

    override fun data(input: List<String>) = input.first().toList()

    override fun solve1(data: List<Char>): String {
        var level = 0
        data.forEach { level += if (it == '(') 1 else -1 }
        return level.toString()
    }

    override fun solve2(data: List<Char>): String {
        var level = 0
        data.forEachIndexed { i, floor ->
            level += if (floor == '(') 1 else -1
            if (level == -1) return (i + 1).toString()
        }
        return "none"
    }

}