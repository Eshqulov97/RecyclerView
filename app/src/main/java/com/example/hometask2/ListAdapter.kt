package com.example.hometask2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val activity: MainActivity):RecyclerView.Adapter<ListViewHolder>() {

    var models : MutableList<User> = mutableListOf()

    fun AddUser(position:Int, description: String, title:String){
        models.add(position,User(description,title))
        notifyItemChanged(position)
        notifyItemRangeChanged(position,models.size)


    }

    fun setData(data:List<User>){
        models = data.toMutableList()
        notifyDataSetChanged()
    }



    fun removeUser(position: Int){
        models.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.iteam,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModul(models[position],activity,position)
    }
}