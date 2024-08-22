package com.example.foregroundservice_kotlin

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.foregroundservice_kotlin.MyApplication.Companion.CHANNEL_ID

//Để tạo một Service, bạn phải tạo một lớp con
class MyService : Service() {
    // khi nào cần sử dụng hàm nào qui vào bạn sử dụng loại service nào
    override fun onCreate() {
        super.onCreate()
        //        khi nó chạy vào đây chứng tỏ nó đã được khởi tạo
        Log.e("Tincoder", "Myservice onCreate()")
    }

    //hàm này là sử dụng khi thuộc loại bounded service và ngược lại
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    //Hệ thống gọi phương thức này khi một thành phần khác (Activity chẳng hạn) gọi đến Service bằng câu lệnh startService()
    //    chay trong background vô thời hạn
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//       nhận dữ liệu bên activity từ Intent
        val strDateIntent = intent.getStringExtra("data_intent")
        //        Bundle bundle = intent.getExtras();
//        if(bundle != null){
//            Song song = (Song) bundle.getSerializable("object_song");
//        }
        sendNotification(strDateIntent)
        //Yêu cầu hệ thống không cần khởi động lại dịch vụ, ngay cả khi có đủ bộ nhớ.
        return START_NOT_STICKY
    }

    //gửi notification
    private fun sendNotification(strDateIntent: String?) {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Title notification service example")
            .setContentText(strDateIntent)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()
        //Xử lý những phần code liên quan đến foreground
        startForeground(1, notification)
    }

    // khi service muốn hủy bỏ thì chạy hàm này
    override fun onDestroy() {
        super.onDestroy()
    }
}
