package com.example.hometask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom_add.*

class MainActivity : AppCompatActivity() {

    val adapter : ListAdapter = ListAdapter(this)
    val models : MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecycleView.adapter = adapter
        RecycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val model : User = User()
        model.Title = "Title"
        model.Description = "Description"

        models.add(model)
        adapter.setData(models)
        
    }
//
//    fun Addelement(user:User){
//
//        val temp = models.size
//
//        for(i in 1..user.Numberr.toInt()){
//
//            val obekt : User = User()
//            obekt.Title = "Title"
//            obekt.Description = "Description"
//            obekt.Numberr = "${temp + i}"
//            models.add(obekt)
//        }
//
//
//        adapter.setData(models)
//
//    }


    fun ButtonOption(view: View,position: Int){

        val Optionmenu = PopupMenu(this,view)
        val menuInflater = Optionmenu.menuInflater
        menuInflater.inflate(R.menu.menu_option,Optionmenu.menu)

        Optionmenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.Id_add ->{
                    val obekt = CustomDialog(this,this)
                    obekt.show()
                }
                R.id.Id_delete ->{


                    val alert = AlertDialog.Builder(this)
                    alert.setTitle("Choose title")
                    alert.setMessage("O'chirishni xoxlaysizmi ?")
                    alert.setCancelable(false)

                    alert.setPositiveButton("YES"){_,_->


                        adapter.removeUser(position)

                    }
                    alert.setNegativeButton("NO"){_,_->

                    }

                    val alertD = alert.create()
                    alert.show()

                }
            }
            true
        }
        Optionmenu.show()

    }
}
