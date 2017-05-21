package me.virtualpain.munny.activities.fruits.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.virtualpain.munny.R
import me.virtualpain.munny.activities.fruits.model.Fruit
import kotlinx.android.synthetic.main.fruit_list.view.*

class FruitAdapter(val fruits: ArrayList<Fruit>, val listener: OnClickListener) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>()
{
    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) = holder.bind(
            fruits[position], listener
    )

    override fun getItemCount(): Int = fruits.size

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): FruitViewHolder = FruitViewHolder(
        LayoutInflater.from(parent?.context).inflate(R.layout.fruit_list, parent, false)
    )

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fruit: Fruit, listener: OnClickListener) = with(itemView)
        {
            fruitName.text = fruit.name
            fruitPrice.text = fruit.price.toString()

            setOnClickListener {
                listener.click(fruit)
            }
        }
    }

    interface OnClickListener {
        fun click(fruit: Fruit)
    }

}

