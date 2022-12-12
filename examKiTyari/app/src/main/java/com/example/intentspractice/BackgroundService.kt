package com.example.intentspractice

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class BackgroundService : AppCompatActivity() {
    var CHANNEL_DEFAULT_IMPORTANCE:Int=11
    var ONGOING_NOTIFICATION_ID:Int=22
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_service)
        var context: Context = applicationContext
        var myIntent:Intent=Intent("tel:5551234") // Build the intent for the service
//        context.startForegroundService(intent);
        var pendingIntent: PendingIntent =PendingIntent.getActivity(this,0,myIntent,0)

        var notification: Notification =Notification.Builder(this,
            CHANNEL_DEFAULT_IMPORTANCE.toString()
        ).setContentTitle("Ahsan").setContentText("hello world").setSmallIcon(R.drawable.edhi).build()
//        ONGOING_NOTIFICATION_ID, notification);
        startProgressBar()
    }

    private fun startProgressBar() {
        var bar=findViewById<ProgressBar>(R.id.progress)
        var thread: Unit =Thread( Runnable {

            var i:Int=bar.progress

            while (i<100){
                i++;
//                    bar.progress=i
                bar.post(Runnable {

                    bar.progress=i


                })
                try {
                    // Sleep for 100 milliseconds to show the progress slowly.
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }

        }).start()




    }


}