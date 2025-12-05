package org.example.solution.y2025

import org.example.core.UnifiedSolution

class S202502 : UnifiedSolution<List<LongRange>> {
    override fun name() = "S202502"

    override fun data(input: List<String>) = input.first().split(",").map {
        val (start,end) = it.split("-")
        return@map start.toLong()..end.toLong()
    }


    override fun solve1(data: List<LongRange>) = findRepeatingPatterns(data, 2).toString()

    override fun solve2(data: List<LongRange>) = findRepeatingPatterns(data).toString()

    private fun findRepeatingPatterns(data: List<LongRange>, repeat: Int? = null) = data.sumOf { range ->
        val repeaters = range.filter { number ->
            getPrimeFactors(number.toString().length)
                .find { primeFactor -> hasRepeatingSample(primeFactor, number.toString(), repeat) } != null
        }
        repeaters.sum()
    }

    fun getPrimeFactors(n: Int): List<Int> = (1..<n).toList().filter { n % it == 0 }

    fun hasRepeatingSample(sampleSize: Int, number: String, repeat: Int? = null): Boolean {
        val sample = number.take(sampleSize)
        val repeats = number.length / sampleSize
        val match = number.matches("^($sample){$repeats}\$".toRegex())
        if (repeat == null) return match
        if (repeat != repeats) return false
        return match
    }
}