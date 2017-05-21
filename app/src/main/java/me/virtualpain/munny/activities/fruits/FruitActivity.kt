package me.virtualpain.munny.activities.fruits

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import me.virtualpain.munny.R
import me.virtualpain.munny.activities.fruits.adapter.FruitAdapter
import me.virtualpain.munny.activities.fruits.model.Fruit
import java.math.BigDecimal

class FruitActivity : AppCompatActivity(), FruitAdapter.OnClickListener {
    override fun click(fruit: Fruit) {
        toast("You love ${fruit.name} so much?")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        val fruits = ArrayList<Fruit>()
        fruits.add(Fruit("Anggur", 100.bd))
        fruits.add(Fruit("Pepaya", 25.bd))
        fruits.add(Fruit("Jeruk", 15.bd))
        fruits.add(Fruit("Nanas", 25.bd))
        fruits.add(Fruit("Pisang", 10.bd))
        fruits.add(Fruit("Apel", 5.bd))
        fruits.add(Fruit("Stroberi", 75.bd))
        fruits.add(Fruit("Mangga", 10.bd))
        fruits.add(Fruit("Belimbing", 10.bd))

        val list = findViewById(R.id.fruit_list) as RecyclerView
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = FruitAdapter(fruits, this)
    }

    fun toast(message: String, len: Int = Toast.LENGTH_SHORT)
    {
        Toast.makeText(this, message, len).show()
    }

}

private val Int.bd: BigDecimal
    get() {
        return BigDecimal(this)
    }
