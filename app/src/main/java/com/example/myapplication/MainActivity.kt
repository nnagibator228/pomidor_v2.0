package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class MainActivity : AppCompatActivity() {
    var a = 0
    var play1 = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play.setOnClickListener {
            play1 = true
        }
        reset.setOnClickListener {
            play1 = false
            a = 0
            timer.text = "00:00"
        }

        val timer1 = Timer("schedule", true);
        timer1.scheduleAtFixedRate(100, 100) {
            if(play1) {
                a += 1
            }
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                timer.text = (a % 100).toString() + ":" + (a / 100).toString()
            })
            

        }
    }


}
