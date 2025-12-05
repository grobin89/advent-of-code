package org.example.solution

import org.example.core.UnifiedSolution

class S202504 : UnifiedSolution<List<MutableList<Char>>> {
    override fun name() = "S202504"

    override fun data(input: List<String>) = input.map { it.toMutableList() }

    override fun solve1(data: List<MutableList<Char>>): String {
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

    override fun solve2(data: List<MutableList<Char>>): String {
        var rolls = 0

        do {
            var rollsRemoved = 0
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
                    if (surroundingRolls - 1 < 4) {
                        rollsRemoved++
                        data[rowIndex][colIndex] = 'X'
                    }
                }
            }
            rolls += rollsRemoved
        } while (rollsRemoved > 0)

        return rolls.toString()
    }
}