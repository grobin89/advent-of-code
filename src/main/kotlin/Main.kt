package org.example

fun main(args: Array<String>) {
    // 2025 01 1 test
    val (year, day, part, mode) = args
    val solution = Register().solution("S$year$day")
    val answer = when(mode) {
        "solve" -> solution.solve(part)
        "test" -> solution.test(part)
        else -> solution.debug()
    }
    println(answer)
}