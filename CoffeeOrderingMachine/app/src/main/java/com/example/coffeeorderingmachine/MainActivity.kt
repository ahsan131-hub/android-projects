package com.example.coffeeorderingmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var quantity:Float= 0.0F;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increment(view: View){
        quantity++;
        findViewById<TextView>(R.id.QuantityTxt).text=quantity.toString();
    }

    fun decrement(view: View){
        quantity--;
        findViewById<TextView>(R.id.QuantityTxt).text=quantity.toString();
    }

    fun order(view: View){
        var orderSummary="";
        orderSummary+="Added whipped cream? "

        if(findViewById<CheckBox>(R.id.cream).isChecked) orderSummary+="yes"
        if(!findViewById<CheckBox>(R.id.cream).isChecked) orderSummary+="no"

        orderSummary+="\nAdd Chocolate? "

        if(findViewById<CheckBox>(R.id.chocolate).isChecked) orderSummary+="yes"
        if(!findViewById<CheckBox>(R.id.chocolate).isChecked) orderSummary+="no"

        orderSummary+="\n\nPrice: $"+ quantity*4.5
        orderSummary+="\nThank You"

        findViewById<TextView>(R.id.summary).text=orderSummary

//        reset values
        quantity=0.0F
        findViewById<CheckBox>(R.id.cream).isChecked=false
        findViewById<CheckBox>(R.id.chocolate).isChecked=false
    }


}