package com.example.spacechallengekotlin

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simulation = Simulation(this)

        val phase1 = simulation.loadItems(phase1Path)
        val phase2 = simulation.loadItems(phase2Path)

        val u1Phase1: ArrayList<U1> = simulation.loadU1(phase1)
        val u1Phase2: ArrayList<U1> = simulation.loadU1(phase2)
        val u2Phase1: ArrayList<U2> = simulation.loadU2(phase1)
        val u2Phase2: ArrayList<U2> = simulation.loadU2(phase2)

        val result = findViewById<TextView>(R.id.txtResult)
        val u1Phase1Budget = "U1 budget = "
        val u1Phase2Budget = "\nU2 budget = "

        val u1Budget = simulation.runSimulation(u1Phase1) +
                simulation.runSimulation(u1Phase2)
        val u2Budget = simulation.runSimulation(u2Phase1) +
                simulation.runSimulation(u2Phase2)

        result.text = u1Phase1Budget.plus(u1Budget)
            .plus(u1Phase2Budget).plus(u2Budget)
    }

    companion object {
        const val phase1Path = "phase1.txt"
        const val phase2Path = "phase2.txt"
    }
}