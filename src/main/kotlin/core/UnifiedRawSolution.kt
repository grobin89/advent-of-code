package org.example.core

interface UnifiedRawSolution<D> : Solution<D, D> {
    fun data(input: String): D
    override fun data1() = data(getRawInput("1"))
    override fun data2() = data(getRawInput("2"))
    override fun testData1() = data(getRawInput("1", true))
    override fun testData2() = data(getRawInput("2", true))
}