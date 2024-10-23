package com.example.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var timeDisplayer: TextView
    private lateinit var playbutton: ImageButton
    private lateinit var pausebutton: ImageButton
    private lateinit var resetbutton: ImageButton
    var time = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeDisplayer =




        val handler: Handler = Handler(Looper.getMainLooper())
        var runnable: Runnable = Runnable { }
        runnable = Runnable {
            time++;
            displayTime(time)
            handler.postDelayed(runnable,10)

        }
        handler.postDelayed(runnable,10)


    }
}

fun displayTime(timeNow: Int){
    var hours = (timeNow/360000).toInt()
    var minutes = (timeNow - (timeNow % 6000))/6000
    var deciseconds = timeNow % 100;


}