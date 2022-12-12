package com.example.practices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class Home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var username =arguments?.getString("username")
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<TextView>(R.id.userNameLbl).text=username
        return view

    }
    fun changeData(str:String){
        Toast.makeText(activity,"hello",Toast.LENGTH_SHORT).show()

    }


}