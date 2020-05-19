package com.example.hometask2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_dialog.view.*

class DialogIteamViewHolder(iteamView: View,val adapter:DialogListAdapter): RecyclerView.ViewHolder(iteamView){

    fun populateModel(model:MyModel,pos:Int){
        itemView.tvNumber.text = model.number.toString()

        if(model.isSelected){
            itemView.ivBg.setImageResource(R.drawable.selected_bg)
        }

        itemView.setOnClickListener {

            if(adapter.selectedIteamPosition !=-1){
                adapter.models[adapter.selectedIteamPosition].isSelected = false
            }

            model.isSelected = true
            adapter.selectedIteamPosition = pos

        }

    }

}