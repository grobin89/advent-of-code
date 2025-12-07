package org.example

import org.example.core.Solution
import org.example.solution.y2015.S201501
import org.example.solution.y2015.S201502
import org.example.solution.y2025.*

class Register {
    private val solutions: Map<String, Solution<*,*>>
        get() = mapOf(
            "S201501" to S201501(),
            "S201502" to S201502(),
            "S202501" to S202501(),
            "S202502" to S202502(),
            "S202503" to S202503(),
            "S202504" to S202504(),
            "S202505" to S202505(),
            "S202506" to S202506(),
        )

    fun solution(name: String) = solutions[name] ?: throw IllegalArgumentException("No solution $name")
}