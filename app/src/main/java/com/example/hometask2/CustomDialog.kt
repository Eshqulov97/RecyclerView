package com.example.hometask2

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_custom_add.*
import kotlinx.android.synthetic.main.item_dialog.*
import kotlin.system.exitProcess

class CustomDialog(context: Context,val activity: MainActivity): Dialog(context) {

    private val adapter = DialogListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_add)

        recycleView.adapter = adapter

        setData()

        //adapter.models[adapter.selectedIteamPosition].number.toString()
        //val temp = adapter.models[adapter.selectedIteamPosition].number.toString()
        tv_ok.setOnClickListener {

            adapter.AddElement(activity)

           // activity.adapter.AddUser(activity.models.size,temp,temp)
        }

        tv_cancle.setOnClickListener {
            exitProcess(1)
        }

    }


    fun setData(){

        val son:MutableList<MyModel> = mutableListOf()

        for(i in 1..100){

            son.add(MyModel(i,false))

        }


        adapter.models = son

    }

}