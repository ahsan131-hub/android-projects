package com.example.patatoman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toggleBodyParts(view:View){
        var chkBox:CheckBox= view as CheckBox
        var img: ImageView? =null;
        when(view.id) {
            R.id.eye -> {img= findViewById(R.id.earImg)}
            R.id.eyebrows -> {img= findViewById(R.id.eyeBrow)}
            R.id.hands->{img= findViewById(R.id.handsImage)}
            R.id.ears->{img= findViewById(R.id.earImg)}
        }
        if(img?.visibility?.equals(ImageView.VISIBLE) == true){
            img?.visibility=ImageView.INVISIBLE
        }else{
            img?.visibility=ImageView.VISIBLE
        }

    }
}