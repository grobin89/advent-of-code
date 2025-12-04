package org.example

import jdk.internal.vm.vector.VectorSupport.test
import org.example.core.Solution
import org.example.solution.S202501

fun main(args: Array<String>) {
    // 2025 01 1 test
    val (year, day, part, mode) = args
    val solution = register("S$year$day")
    val answer = when(mode) {
        "solve" -> solution.solve(part)
        "test" -> solution.test(part)
        else -> solution.name()
    }
    println(answer)
}

fun register(solutionName: String): Solution<*,*> {
    return when(solutionName) {
        "S202501" -> S202501()
        else -> throw IllegalArgumentException("Unknown Solution.")
    }
}