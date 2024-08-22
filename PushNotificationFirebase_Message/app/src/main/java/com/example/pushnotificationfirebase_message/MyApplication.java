package com.example.pushnotificationfirebase_message;

import android.app.Application;
import android.os.Build;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createChannelNotification();
    }
//đăng ký channel id cho notification
//    tiếp theo xử lý logic làm sao có thể nhận push notification cho firebase
    private void createChannelNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){

        }
    }
}
