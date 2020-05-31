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

    var curr = true
    var play1 = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a1 = work.text.toString().toInt()*100+1;
        var a2 = relax.text.toString().toInt()*100+1+a1;
        var c =0
        current.text = "$a:$a1:$a2"
        reset.setOnClickListener {
            play1 = false
            a = 0
        }
        play.setOnClickListener {
            play1 = !play1
        }
        val timer1 = Timer("schedule", true);
        timer1.scheduleAtFixedRate(10, 10) {
            if(play1) {
                a += 1
            }
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                timer.text =  (a / 100).toString() + ":" +(a % 100).toString()
            })
            if(a == a1 && curr){
                c+=1
                a1 = a+a2-c*work.text.toString().toInt()
                current.text = "$a:$a1:$a2"
                curr = !curr
            }
            if(a == a2 && !curr){
                c+=1
                a2 = a+a1-c*relax.text.toString().toInt()
                current.text = "$a:$a1:$a2"
                curr = !curr
            }
        }
    }


}
