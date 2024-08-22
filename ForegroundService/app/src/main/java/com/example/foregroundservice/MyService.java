package com.example.foregroundservice;

import static com.example.foregroundservice.MyApplication.CHANNEL_ID;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

//Để tạo một Service, bạn phải tạo một lớp con
public class MyService extends Service {
// khi nào cần sử dụng hàm nào qui vào bạn sử dụng loại service nào

    @Override
    public void onCreate() {
        super.onCreate();
//        khi nó chạy vào đây chứng tỏ nó đã được khởi tạo
        Log.e("Tincoder", "Myservice onCreate()");
    }
//hàm này là sử dụng khi thuộc loại bounded service và ngược lại
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
//Hệ thống gọi phương thức này khi một thành phần khác (Activity chẳng hạn) gọi đến Service bằng câu lệnh startService()
//    chay trong background vô thời hạn
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//       nhận dữ liệu bên activity từ Intent
        String strDateIntent = intent.getStringExtra("data_intent");
//        Bundle bundle = intent.getExtras();
//        if(bundle != null){
//            Song song = (Song) bundle.getSerializable("object_song");
//        }
        sendNotification(strDateIntent);
//Yêu cầu hệ thống không cần khởi động lại dịch vụ, ngay cả khi có đủ bộ nhớ.
        return START_NOT_STICKY;
    }

//gửi notification

    private void sendNotification(String strDateIntent) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE  );

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Title notification service example")
                .setContentText(strDateIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build();
//Xử lý những phần code liên quan đến foreground
        startForeground(1, notification);
    }

// khi service muốn hủy bỏ thì chạy hàm này
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
