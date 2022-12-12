package com.example.intentspractice

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream

class Filing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filing)
    }

    val data:String ="some fucking data to be written here, fucking fuck bitch";
    val fileName="SOME_FUCKING_NAME.txt"
    fun readFromFile(view:View){
//    readin gfrom file
        val fs:FileInputStream=openFileInput(fileName)
        var dataBuffer:StringBuffer=StringBuffer();
        var i:Int;
        i=fs.read()
        while (i!=-1){
            dataBuffer.append(i.toChar())
            i= fs.read()
        }
        fs.close()
        findViewById<TextView>(R.id.fileData).text=dataBuffer.toString()
    }

    fun writeOnFile(view :View){
//        writing one file
        val fs:FileOutputStream=openFileOutput(fileName , MODE_PRIVATE)
        fs.write(data.toByteArray())
        fs.close()
    }



}