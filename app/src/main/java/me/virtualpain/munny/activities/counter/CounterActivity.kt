package me.virtualpain.munny.activities.counter

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_counter.*
import me.virtualpain.munny.R
import me.virtualpain.munny.activities.countdown.CountdownActivity
import me.virtualpain.munny.helpers.loggerTag
import me.virtualpain.munny.helpers.randomNumber
import me.virtualpain.munny.helpers.toast
import java.security.SecureRandom

class CounterActivity : AppCompatActivity() {

    val MAX_NUMBER = 9999999

    var number = 0
    var customAddition = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        the_number.text = number.toString()
        updateUi()

        plus_button.setOnClickListener {
            number++
            updateUi()
        }
        minus_button.setOnClickListener {
            number--
            updateUi()
        }

        custom_plus_button.setOnClickListener {
            number += customAddition
            updateUi()
        }

        custom_minus_button.setOnClickListener {
            number -= customAddition
            updateUi()
        }

        zero_button.setOnClickListener {
            number = 0
            updateUi()
        }

        pi_button.setOnClickListener {
            number = 3
            toast("Comma not supported :(")
        }

        random_button.setOnClickListener {
            val random = SecureRandom()

            val random_number = random.nextInt(MAX_NUMBER)

            number = random_number

            updateUi()
        }

        change_custom_number_button.setOnClickListener {
            if (!custom_number_input.text.toString().isEmpty())
            {
                customAddition = custom_number_input.text.toString().toInt()
            }
            else {
                customAddition = 0
            }

            updateUi()
        }

        open_countdown_app_button.setOnClickListener {
            val countdownIntent = Intent(this, CountdownActivity::class.java)
            countdownIntent.putExtra("counter_start", number)
            Log.d(loggerTag(), "Start activity with counter start = ".plus(number.toString()))
            startActivity(countdownIntent)
        }

        // JJ Abrams fans unite!!
        lost_number_button.setOnClickListener {
            val lostNumbers = listOf(4, 8, 15, 16, 23, 42)
            number = lostNumbers[randomNumber(0, lostNumbers.size - 1)]

            updateUi()
        }

    }

    fun updateUi()
    {
        the_number.text = number.toString()
        custom_plus_button.text = "+$customAddition"
        custom_minus_button.text = "-$customAddition"
    }
}
