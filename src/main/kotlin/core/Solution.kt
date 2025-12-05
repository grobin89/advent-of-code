package org.example.core

import java.io.File

interface Solution<D1, D2> {
    fun name(): String
    fun year(): String = name().substring(1, 5)
    fun day(): String = name().takeLast(2)

    fun data1(): D1
    fun solve1(data: D1 = data1()): String
    fun testData1(): D1
    fun test1(): String = solve1(testData1())

    fun data2(): D2
    fun solve2(data: D2 = data2()): String
    fun testData2(): D2
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
        return getFile(part, test).readLines()
    }

    fun getRawInput(part: String, test: Boolean = false): String {
        return getFile(part, test).readText()
    }

    fun getFile(part: String, test: Boolean = false): File = File(
        "src/${if (test) "test" else "main"}/resources/${year()}/${day()}_$part"
    )

    fun debug(): String {
        return """
            name:  ${name()}
            year:  ${year()}
            day:   ${day()}
            file1: ${fileStats("1")}
            file2: ${fileStats("2")}
            test1: ${fileStats("1", true)}
            test2: ${fileStats("2", true)}
        """.trimIndent()
    }

    private fun fileStats(part: String, test: Boolean = false): String {
        val branch = if (test) "test" else "main"
        val fileName = "${day()}_1"
        val pathName = "src/$branch/resources/${year()}/$fileName"
        val file = File(pathName)
        if (!file.exists()) return "missing"
        return "size=${file.length()}"
    }
}