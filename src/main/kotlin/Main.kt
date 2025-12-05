package org.example

/**
 * Arguments: year(DDDD) day(DD) part(D) mode(solve, test, debug)
 */
fun main(args: Array<String>) {
    val (year, day, part, mode) = args
    val solution = Register().solution("S$year$day")
    val answer = when(mode) {
        "solve" -> solution.solve(part)
        "test" -> solution.test(part)
        "debug" -> solution.debug()
        else -> throw IllegalArgumentException("Invalid mode: $mode")
    }
    println(answer)
}