package com.example.practices

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.practices.R.layout
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        var modeSwitch:Switch=findViewById<Switch>(R.id.darkMode)
        val sharedPreferences = getSharedPreferences(
            "sharedPrefs", MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        val isDarkModeOn = sharedPreferences
            .getBoolean(
                "isDarkModeOn", false
            )

        if (isDarkModeOn) {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_YES);
            modeSwitch.text=("Light Mode");
        }
        else {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_NO);
            modeSwitch.text="Dark Mode";
        }
        modeSwitch.setOnClickListener(){
            if(modeSwitch.isChecked){
                AppCompatDelegate
                    .setDefaultNightMode(
                        AppCompatDelegate
                            .MODE_NIGHT_YES);
                editor.putBoolean(
                    "isDarkModeOn", true);
                editor.apply();

                // change text of Button
                modeSwitch.setText(
                    "Dark Mode");
            }else
            {
                AppCompatDelegate
                    .setDefaultNightMode(
                        AppCompatDelegate
                            .MODE_NIGHT_NO);
                editor.putBoolean(
                    "isDarkModeOn", false);
                editor.apply();
                modeSwitch.setText(
                    "Light Mode");
            }

            }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,Login())
            addToBackStack(null)
            commit()
        }


    }



}