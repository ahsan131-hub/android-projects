package com.example.practices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class Login : Fragment() {
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        var loginBtn=view.findViewById<Button>(R.id.loginBtn)
         loginBtn.setOnClickListener(){

//        loginBtn.isClickable=false

             var scan: Scanner = Scanner(resources.openRawResource(R.raw.credentials))
             // read entire file
             // read entire file
             var allText =  mutableListOf<String>();
             while (scan.hasNextLine()) {
                 val line = scan.nextLine()
                 allText.add(line.split("=")[1])
             }
             scan.close()
//        if(!(
//            findViewById<EditText>(R.id.username).text.toString().trim()==allText[0].trim()
//            &&
//            findViewById<EditText>(R.id.password).text.toString().trim()==allText[1].trim())){
//            Toast.makeText(this ,"Incorrect Credentials ", Toast.LENGTH_SHORT).show()
//        }
//        got to next fragement

             var bundle:Bundle=Bundle()
                bundle.putString("username",view.findViewById<EditText>(R.id.username).text.toString().trim())
                var homeFr:Fragment=Home()
             homeFr.arguments=bundle

             activity?.supportFragmentManager?.beginTransaction()?.apply {
                 replace(R.id.frameLayout,homeFr)
                 addToBackStack(null)
                 commit()
             }
             Toast.makeText(activity ,"Login ", Toast.LENGTH_SHORT).show()


         }

         return view;
    }

}