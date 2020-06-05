package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

class MainActivity : AppCompatActivity() {
    var a = 0
    var c =0
    var curr = true
    var play1 = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a1 = work.text.toString().toInt()*100+1
        var a2 = relax.text.toString().toInt()*100+1

        current.text = "работа"
        reset.setOnClickListener {
            play1 = false
            a = 0
            c = 0
            curr = true
            current.text = "работа"
        }
        play.setOnClickListener {
            play1 = !play1
        }
        val timer1 = Timer("schedule", true);
        timer1.scheduleAtFixedRate(100, 100) {
            if(play1) {
                a += 1
                c += 1
                try {
                    a1 = work.text.toString().toInt()*100+2
                    a2 = relax.text.toString().toInt()*100+2
                } catch (e: Exception){
                    a1 = 102
                    a2 = 102
                }

                if(a1 == null){
                    a1 = 1*100+2;
                }
                if(a2 == null){
                    a2 = 1*100+2;
                }
            }
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                timer.text =  (a / 100).toString() + ":" +(a % 100).toString()
            })
            if(c == a1 && curr){
                c = 0
                current.text = "отдых"

                curr = !curr
            }
            if(c == a2 && !curr){
                c = 0
                current.text = "работа"
                curr = !curr
            }
        }
    }


}
