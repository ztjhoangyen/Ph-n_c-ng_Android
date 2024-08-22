package com.example.foregroundservice_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.foregroundservice_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityMainBinding.inflate(layoutInflater)

//        binding.setOnClickListener(View.OnClickListener { clickStartService() })
//
//        btnStopService.setOnClickListener(View.OnClickListener { clickStopService() })
        binding.btnStopService.setOnClickListener {
            clickStopService()
        }
        binding.btnStartService.setOnClickListener {
            clickStartService()
        }
        setContentView(binding.root)
    }

    private fun clickStopService() {
        val intent = Intent(this, MyService::class.java)
        //        khoi chay bang cau lenh
// Khi công việc hoàn thành bạn nên stop bằng cách gọi stopService() từ một thành phần khác, hoặc cho chính Service gọi stopSelf().
//     hàm nào được gọi trong main khi nào với cái loại service nào(loại service là cái hàm ovirride bên service đó)
        stopService(intent)
    }

    private fun clickStartService() {
//        Song song = new Song("city", "kk", R.drawable.ic_launcher_foreground, R.raw.sommai);

        val intent = Intent(this, MyService::class.java)
        //        Bundle bundle = new Bundle();
//        bundle.putSerializable("object_song", song);
//        intent.putExtras(bundle) ;
// truyền dữ liệu lên service thì xử lý dữ liệu ở hàm onStartComand bên service
        intent.putExtra("data_intent", binding.edtDataIntent.text.toString().trim())
        //        khoi chay bang cau lenh
//        Gọi startService thì nó chạy vào startCommand bên Myservice
//        Tương tự mấy hàm gọi khác
        startService(intent)
    }

}