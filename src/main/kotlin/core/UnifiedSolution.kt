package org.example.core

interface UnifiedSolution<D> : Solution<D, D> {
    fun data(input: List<String>): D
    override fun data1(input: List<String>) = data(getInput("1"))
    override fun data2(input: List<String>) = data(getInput("2"))
    override fun testData1(input: List<String>) = data(getInput("1", true))
    override fun testData2(input: List<String>) = data(getInput("2", true))
}
