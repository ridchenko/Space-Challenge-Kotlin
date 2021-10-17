package com.example.spacechallengekotlin

class Item (val name: String? = null,
            val weight: Int = 0) : Comparable<Item> {

    override fun compareTo(other: Item): Int = other.weight.compareTo(weight)
}