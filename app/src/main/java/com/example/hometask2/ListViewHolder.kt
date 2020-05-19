package com.example.hometask2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.iteam.view.*

class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val Description : TextView = itemView.Description_id
    val Title : TextView = itemView.Title_id


    fun populateModul(user:User,activity:MainActivity,position:Int){
        Description.text = user.Description
        Title.text = user.Title

//
//        itemView.setOnClickListener {
//
//            activity.Addelement(user)
//
//        }

        itemView.btn_option.setOnClickListener {
            activity.ButtonOption(itemView.btn_option,position)
        }
    }
}