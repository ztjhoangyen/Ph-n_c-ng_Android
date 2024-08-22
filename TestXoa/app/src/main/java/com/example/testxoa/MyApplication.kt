package com.example.testxoa

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        createChannelNotification()
    }

    private fun createChannelNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, "Channel Service Exmple",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val manager = getSystemService(
                NotificationManager::class.java
            )

            manager?.createNotificationChannel((channel))
        }
    }

    companion object{
        const val CHANNEL_ID : String = "channel_service_example"
    }
}