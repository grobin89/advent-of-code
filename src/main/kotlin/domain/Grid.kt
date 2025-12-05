package org.example.domain

abstract class Grid<D> {
    private val grid = mutableMapOf<Pair<Int,Int>,D>(Pair(0,0) to instantiate()).withDefault { instantiate() }
    private val trail = mutableListOf<Pair<Int, Int>>()
    private var position = grid.keys.first()

    fun left() = position.copy(first = position.first - 1)
    fun right() = position.copy(first = position.first + 1)
    fun up() = position.copy(second = position.second - 1)
    fun down() = position.copy(second = position.second + 1)
    fun topLeft() = position.copy(first = position.first - 1, second = position.second - 1)
    fun topRight() = position.copy(first = position.first + 1, second = position.second - 1)
    fun bottomLeft() = position.copy(first = position.first - 1, second = position.second + 1)
    fun bottomRight() = position.copy(first = position.first + 1, second = position.second + 1)

    fun move(position: Pair<Int, Int>): D {
        this.position = position
        trail.add(position)
        if (!grid.containsKey(position)) grid[position] = instantiate()
        return grid[position]!!
    }

    fun peek(position: Pair<Int,Int>): D? = grid.getOrDefault(position, null)

    fun toMap() = grid.toMap()
    fun getTrail() = trail.toList()

    abstract fun instantiate(input: D? = null): D
}