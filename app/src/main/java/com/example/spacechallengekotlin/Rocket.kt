package com.example.spacechallengekotlin

open class Rocket (val cost: Int,
                   var rocketWeight: Int,
                   val maxWeight: Int) : Spaceship {

    override fun launch(): Boolean = true

    override fun land(): Boolean = true

    override fun canCarry(item: Item): Boolean = rocketWeight + item.weight <= maxWeight

    override fun carry(item: Item) {
            rocketWeight += item.weight
    }
}