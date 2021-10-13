package com.example.spacechallengekotlin

class Item constructor(
    var name: String? = null,
    var weight: Int = 0) : Comparable<Item> {

    override fun compareTo(other: Item): Int = other.weight.compareTo(weight)
}