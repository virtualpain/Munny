package me.virtualpain.munny

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_menu_list.view.*

class MainMenuAdapter(val mainMenus: ArrayList<MainMenuModel>, val listener: OnclickListener) : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>() {
    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) = holder.bind(
            mainMenus[position], listener
    )

    override fun onCreateViewHolder(parent: ViewGroup?, p1: Int): MainMenuViewHolder = MainMenuViewHolder(
            LayoutInflater.from(parent?.context).inflate(R.layout.main_menu_list, parent, false)
    )

    override fun getItemCount(): Int = mainMenus.size

    class MainMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mainMenu: MainMenuModel, listener: OnclickListener) = with(itemView)
        {
            main_menu_name.text = mainMenu.name
            main_menu_description.text = if (mainMenu.description.isEmpty()) "No description" else mainMenu.description

            setOnClickListener {
                listener.click(mainMenu)
            }
        }
    }

    interface OnclickListener
    {
        fun click(mainMenu: MainMenuModel)
    }
}