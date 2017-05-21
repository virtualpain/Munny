package me.virtualpain.munny.activities.countdown

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_countdown.*
import me.virtualpain.munny.R
import me.virtualpain.munny.helpers.loggerTag
import me.virtualpain.munny.helpers.toast
import java.util.*

class CountdownActivity : AppCompatActivity() {

    val default_counter_start = 99
    val default_increment = 1

    var counter = 0
    var counter_start = default_counter_start
    var counter_counting_down: Boolean = true
    var increment = default_increment

    var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countdown)

        counter_start = intent.getIntExtra("counter_start", default_counter_start)
        Log.d(loggerTag(), "Counter Start = ".plus(counter_start.toString()))
        counter_counting_down = intent.getBooleanExtra("counter_counting_down", true)
        increment = intent.getIntExtra("increment", 1)

        counter = counter_start
        Log.d(loggerTag(), "Counter = ".plus(counter.toString()))

        assignViews()
        updateUi()
    }

    override fun onPause() {
        super.onPause()

        stopTimer()
    }

    fun assignViews()
    {
        start_countdown_button.setOnClickListener {
            startTimer()
        }

        stop_countdown_button.setOnClickListener {
            stopTimer()
        }

        reset_countdown_button.setOnClickListener {
            counter = counter_start
            toast("Timer reset!")
            updateUi()
        }

        set_counter_button.visibility = View.GONE
    }

    fun startTimer()
    {
        if (timer == null)
        {
            Log.d(loggerTag(), "Timer started!")
            timer = Timer()
            timer?.scheduleAtFixedRate(
                    object: TimerTask(){
                        override fun run() {
                            Handler(Looper.getMainLooper()).post({
                                incrementNumber()
                            })
                        }
                    },
                    0L,
                    1000L
            )
        }
    }

    fun stopTimer() {
        timer?.cancel()
        timer?.purge()
        timer = null
    }

    fun incrementNumber() {
        if (counter > 0)
        {
            Log.d(loggerTag(), "Incrementing number")
            if (counter_counting_down)
            {
                counter -= increment
            }
            else {
                counter += increment
            }

            updateUi()
        }
        else {
            Log.d(loggerTag(), "Counter reached zero, stop the timer")
            stopTimer()
        }
    }

    fun updateUi() {
        countdown_number_text.text = counter.toString()
    }
}
