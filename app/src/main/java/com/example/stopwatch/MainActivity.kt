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
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    private lateinit var timeDisplayer: TextView
    private lateinit var playbutton: ImageButton
    private lateinit var pausebutton: ImageButton
    private lateinit var resetbutton: ImageButton
    var time = 0;
    var clockRunning = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeDisplayer = findViewById(R.id.showTime)
        playbutton = findViewById(R.id.startbutton)
        pausebutton = findViewById(R.id.pausebutton)
        resetbutton = findViewById(R.id.resetbutton)

        val handler: Handler = Handler(Looper.getMainLooper())
        var runnable: Runnable = Runnable { }
        runnable = Runnable {

            if (clockRunning){
                time++;
                displayTime()
            }
            handler.postDelayed(runnable,10)

        }
        handler.postDelayed(runnable,10)


        playbutton.setOnClickListener{
            clockRunning = true;
        }
        pausebutton.setOnClickListener{
            clockRunning = false;
        }
        resetbutton.setOnClickListener{
            //clockRunning = false
            time = 0;
            displayTime()
        }
    }

    fun displayTime(){
        var minutes = "0" + (time/6000).toString()

        var seconds = if (((time/100)%60) > 10) ((time/100)%60).toString() else  "0" + ((time/100)%60).toString()

        var deciseconds = if ((time % 100) > 10) (time % 100).toString() else  "0" + (time % 100).toString()
        timeDisplayer.text = "$minutes : $seconds : $deciseconds"

    }


}

