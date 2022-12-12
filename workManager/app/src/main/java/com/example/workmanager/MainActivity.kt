package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.work.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickMe(view : View){
        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val request=OneTimeWorkRequest.Builder(TestWorker::class.java).setConstraints(constraints).build()

        val workerManager=WorkManager.getInstance(this)
        workerManager.enqueueUniqueWork("1",ExistingWorkPolicy.REPLACE,request)

    }

}