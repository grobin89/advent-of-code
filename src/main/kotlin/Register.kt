package org.example

import org.example.core.Solution
import org.example.solution.S202501
import org.example.solution.S202502
import org.example.solution.S202503
import org.example.solution.S202504
import org.example.solution.S202505

class Register {
    private val solutions: Map<String, Solution<*,*>>
        get() = mapOf(
            "S202501" to S202501(),
            "S202502" to S202502(),
            "S202503" to S202503(),
            "S202504" to S202504(),
            "S202505" to S202505(),
        )

    fun solution(name: String) = solutions[name] ?: throw IllegalArgumentException("No solution $name")
}