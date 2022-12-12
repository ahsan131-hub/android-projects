package com.example.httpcon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread(Runnable{

            val url_string="https://tutorialspoint.com/json/data.json"
            val url= URL(url_string)

//            val connection :HttpURLConnection =url.openConnection() as HttpURLConnection
//            connection.connect()
//
//            val reader:BufferedReader= BufferedReader(InputStreamReader(connection.inputStream))
//
//            var line :String =reader.readLne()

        })
        val queue=Volley.newRequestQueue(this)
        val strReq=StringRequest(
            Request.Method.GET,
            "https://tutorialspoint.com/json/data.json",
            Response.Listener {
                findViewById<TextView>(R.id.lblString).text=it
            },
            Response.ErrorListener {
                findViewById<TextView>(R.id.lblString).text=it.message
            }
        )

        queue.add(strReq)

    }
}