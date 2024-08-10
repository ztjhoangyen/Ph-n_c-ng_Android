package com.example.foregroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    private EditText edtDataInt;
    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDataInt = findViewById(R.id.edt_data_intent);
        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);
        
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });

    }

    private void clickStopService() {
        Intent intent = new Intent(this, MyService.class);
        //        khoi chay bang cau lenh
// Khi công việc hoàn thành bạn nên stop bằng cách gọi stopService() từ một thành phần khác, hoặc cho chính Service gọi stopSelf().
//     hàm nào được gọi trong main khi nào với cái loại service nào(loại service là cái hàm ovirride bên service đó)
        stopService(intent);
    }

    private void clickStartService() {
//        Song song = new Song("city", "kk", R.drawable.ic_launcher_foreground, R.raw.sommai);

        Intent intent = new Intent(this, MyService.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("object_song", song);
//        intent.putExtras(bundle) ;
// truyền dữ liệu lên service thì xử lý dữ liệu ở hàm onStartComand bên service
                intent.putExtra("data_intent", edtDataInt.getText().toString().trim());
        //        khoi chay bang cau lenh
        startService(intent);
    }

}