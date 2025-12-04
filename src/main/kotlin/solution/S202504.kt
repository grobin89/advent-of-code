package org.example.solution

import org.example.core.BasicSolution

class S202501 : BasicSolution {
    override fun name() = "S202501"

    override fun solve1(data: List<String>): String {
        val data = getInput("04_1").map { it.toList() }
        var rolls = 0

        data.forEachIndexed rowloop@ { rowIndex, row ->
            row.forEachIndexed colloop@ { colIndex, cell ->
                if (cell != '@') return@colloop
                var surroundingRolls = 0
                (-1..1).forEach { rowOffset ->
                    (-1..1).forEach { colOffset ->
                        if (rowIndex + rowOffset in data.indices && colIndex + colOffset in row.indices) {
                            surroundingRolls += if (data[rowIndex + rowOffset][colIndex + colOffset] == '@') 1 else 0
                        }
                    }
                }
                if (surroundingRolls - 1 < 4) rolls++
            }
        }
        return rolls.toString()
    }

    override fun solve2(data: List<String>): String {
    }
}