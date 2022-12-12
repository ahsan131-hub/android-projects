package com.example.contentproviderapi

import android.content.ContentResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var listView=findViewById<ListView>(R.id.nameList)
        val arrayList:ArrayList<String> = ArrayList();
        val cursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(ContactsContract.CommonDataKinds.Phone.CONTACT_ID),null,null,null
        )
        cursor!!.moveToFirst()
        do {
            arrayList.add(cursor.getString(0))
        }while (cursor.moveToNext())

        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList)
        listView.adapter=adapter

    }



}