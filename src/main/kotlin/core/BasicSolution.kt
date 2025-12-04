package org.example.core

interface BasicSolution : Solution<List<String>, List<String>> {
    override fun data1(input: List<String>): List<String> = getInput("1")
    override fun data2(input: List<String>): List<String> = getInput("2")
    override fun testData1(input: List<String>): List<String> = getInput("1", true)
    override fun testData2(input: List<String>): List<String> = getInput("2", true)
}