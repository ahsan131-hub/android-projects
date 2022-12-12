package com.example.intentspractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.coroutines.flow.asFlow

class Adaptors : AppCompatActivity() {
    data class User(
        val image: Int,
        val name:String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptors)

        val listView:ListView=findViewById(R.id.listView)
        val array=ArrayList<User>()
        array.add(User(R.drawable.edhi,"EDHI"))
        array.add(User(R.drawable.iqbal,"IQBAL"))
        array.add(User(R.drawable.nas,"NAS"))
        array.add(User(R.drawable.edhi,"EDHI"))
        array.add(User(R.drawable.iqbal,"IQBAL"))
        array.add(User(R.drawable.nas,"NAS"))
        array.add(User(R.drawable.edhi,"EDHI"))
        array.add(User(R.drawable.iqbal,"IQBAL"))
        array.add(User(R.drawable.nas,"NAS"))
        array.add(User(R.drawable.edhi,"EDHI"))
        array.add(User(R.drawable.iqbal,"IQBAL"))
        array.add(User(R.drawable.nas,"NAS"))

        listView.adapter= UserAdapter(this,R.layout.contactrow,array)


    }

    class UserAdapter(context: Context, resource: Int, list: MutableList<Adaptors.User>) :
        ArrayAdapter<User>(context,resource,list) {
        private val cont=context;
        val res=resource
        private val data=list

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            super.getView(position, convertView, parent)

            val view =LayoutInflater.from(cont).inflate(res,parent,true)
//            val dp:ImageView=view.findViewById(R.id.contactImage)
////            val name:TextView=view.findViewById(R.id.contactName)
//            dp.setImageResource(data[position].image)
//            name.text=data[position].name.toString()
            return view;
        }


    }
}