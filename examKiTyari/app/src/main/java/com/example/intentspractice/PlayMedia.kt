package com.example.intentspractice

import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlayMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_media)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.player,menu);

        return super.onCreateOptionsMenu(menu)
    }


    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this,"play",Toast.LENGTH_SHORT).show()
        var mediaPlayer = MediaPlayer.create(this
            , R.raw.songs)
        mediaPlayer.start()
        return super.onOptionsItemSelected(item)
    }

}