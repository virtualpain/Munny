package me.virtualpain.munny.activities.anko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import me.virtualpain.munny.R
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class AnkoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_anko_list)

        verticalLayout {
            val oooo = recyclerView {
                backgroundColor = ContextCompat.getColor(this@AnkoListActivity, R.color.colorPrimary)
            }
        }
    }
}
