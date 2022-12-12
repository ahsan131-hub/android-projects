package com.example.workmanager

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.WorkSource
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWorker(context: Context,workerParams: WorkerParameters): Worker(context,workerParams) {

    override fun doWork(): Result {
        val handler = Handler(Looper.getMainLooper())
        handler.post{Toast.makeText(applicationContext,"hello fucking world..",Toast.LENGTH_LONG).show()}
        return Result.success()
    }

}