package org.example.core

import java.io.File

interface Solution<D1, D2> {
    fun name(): String

    fun data1(input: List<String> = getInput("1")): D1
    fun solve1(data: D1 = data1()): String
    fun testData1(input: List<String> = getInput("1", true)): D1
    fun test1(): String = solve1(testData1())

    fun data2(input: List<String> = getInput("2")): D2
    fun solve2(data: D2 = data2()): String
    fun testData2(input: List<String> = getInput("2", true)): D2
    fun test2(): String = solve2(testData2())

    fun solve(part: String): String {
        return when(part) {
            "1" -> solve1()
            "2" -> solve2()
            else -> throw IllegalArgumentException("No part $part")
        }
    }

    fun test(part: String): String {
        return when(part) {
            "1" -> test1()
            "2" -> test2()
            else -> throw IllegalArgumentException("No part $part")
        }
    }

    fun getInput(part: String, test: Boolean = false): List<String> {
        val testSuffix = if (test) "_test" else ""
        val fileName = "${name().substring(5)}_$part$testSuffix"
        val pathName = "/${name().substring(1,5)}/$fileName"
        val path = javaClass.getResource(pathName)?.path ?: throw IllegalArgumentException("File not found: $fileName")
        return File(path).readLines()
    }

    fun stats(): Unit {
        TODO()
    }
}