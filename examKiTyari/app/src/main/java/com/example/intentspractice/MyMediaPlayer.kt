package com.example.intentspractice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View

class MyMediaPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)



    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//       var inflater:MenuInflater = menuInflater;
//        inflater.inflate(R.menu.player,menu);
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    fun playAudio(view:View){
//        var mediaPlayer = MediaPlayer.create(this, R.raw.songs)
//        mediaPlayer.start()
//    }
}