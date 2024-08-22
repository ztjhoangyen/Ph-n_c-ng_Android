package com.example.foregroundservice_kotlin

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


//thuc hanh foreground service
//viết code xử lý bên trong này
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //        khởi tạo channel id
        createChannelNotification()
    }

    private fun createChannelNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, "Channel Service Example",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager?.createNotificationChannel(channel)
        }
    }

    companion object {
        //    khởi tạo 1 hằng số
        const val CHANNEL_ID: String = "channel_service_example"
    }
}
