package com.example.hometask2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess

class DialogListAdapter : RecyclerView.Adapter<DialogIteamViewHolder>() {

    var selectedIteamPosition : Int = -1
        set(value) {
            if(field != -1){
                notifyItemChanged(field)
            }
            field = value
            notifyItemChanged(value)
        }


    var models : List<MyModel> = listOf()

        set(value) {
        field = value
        notifyDataSetChanged()
    }


    fun AddElement(activity: MainActivity){
        activity.adapter.AddUser(activity.models.size,"${models[selectedIteamPosition].number}",(selectedIteamPosition + 1).toString())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogIteamViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dialog,parent,false)
        return DialogIteamViewHolder(itemView,this)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: DialogIteamViewHolder, position: Int) {
        holder.populateModel(models[position],position)
    }
}