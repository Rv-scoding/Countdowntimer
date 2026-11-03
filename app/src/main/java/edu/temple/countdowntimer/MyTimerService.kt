package edu.temple.countdowntimer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.Lifecycle.Event.Companion.downTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MyTimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        startTimer()

        return super.onStartCommand(intent, flags, startId)
    }

    fun startTimer() {

        val scope = CoroutineScope(Dispatchers.Default)

        scope.launch {

            for (i in 50  downTo  0){
                Log.d ("Countdown", i.toString())
                delay(100.milliseconds)
            }



        }




    }



}