package com.example.testxoa

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.testxoa.MyApplication.Companion.CHANNEL_ID

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
//        khi chay vao day chung to no da duoc khoi tao
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

//        yeu cau he thong khong can phai khoi dong lai dich vu, ngay ca khi he thong du bo nho
        return START_NOT_STICKY
    }

    private fun sendNotication(strDateIntent: String?){
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)

        val notification : Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Oko")
            .setContentText(strDateIntent)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)
    }

//    khi nao muon huy bo thi chay ham nay
    override fun onDestroy() {
        super.onDestroy()
    }
}