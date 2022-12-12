package com.example.intentspractice

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val USERNAME_ACTIVITY=11
    lateinit var pref:SharedPreferences;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref=getSharedPreferences("prefs", MODE_PRIVATE)
        if(pref.getBoolean("isLogin",false)){
            startApp(findViewById(R.id.startBtn))
        }


    }

    fun startApp(view: View){
        var intent:Intent=Intent(this,Home::class.java);
        intent.putExtra("name","Chutiya")
        startActivityForResult(intent,USERNAME_ACTIVITY);

        val editor:SharedPreferences.Editor=pref.edit()

        editor.putBoolean("isLogin",true)
        editor.commit()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==USERNAME_ACTIVITY&& resultCode== RESULT_OK){
            Toast.makeText(this,data?.getStringExtra("name").toString(),Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this,"fuck",Toast.LENGTH_SHORT).show();
        }

    }


}