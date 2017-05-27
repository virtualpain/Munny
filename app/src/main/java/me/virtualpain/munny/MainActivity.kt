package me.virtualpain.munny

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.virtualpain.munny.activities.anko.AnkoListActivity
import me.virtualpain.munny.activities.anko.TryAnkoActivity
import me.virtualpain.munny.activities.countdown.CountdownActivity
import me.virtualpain.munny.activities.counter.CounterActivity
import me.virtualpain.munny.activities.fruits.FruitActivity

class MainActivity : AppCompatActivity(), MainMenuAdapter.OnclickListener {
    override fun click(mainMenu: MainMenuModel) {
        startActivity(Intent(this, mainMenu.className.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menus = ArrayList<MainMenuModel>()
        menus.add(MainMenuModel("Fruit List", FruitActivity::class,  "Basic RecyclerView, contain extension property"))
        menus.add(MainMenuModel("The Number", CounterActivity::class, "Simple counter app, contain extension function: toast"))
        menus.add(MainMenuModel("Countdown", CountdownActivity::class, "Simple counter app, contain timer"))
        menus.add(MainMenuModel("Anko Layout", TryAnkoActivity::class, "Views in this activity made by Anko DSL"))
        menus.add(MainMenuModel("Anko List", AnkoListActivity::class, "Using Anko in Recycler view"))

        val mainMenuAdapter = MainMenuAdapter(menus, this)

        activity_list.layoutManager = LinearLayoutManager(this)
        activity_list.adapter = mainMenuAdapter
    }
}
