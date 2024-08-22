package com.example.testxoa

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testxoa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.btnStop.setOnClickListener {
            clickStopService()
        }
        binding.start.setOnClickListener {
            clickStartServicr()
        }
        setContentView(binding.root)

    }

    private fun clickStopService(){
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }

    private fun clickStartServicr(){
        val intent = Intent(this, MyService::class.java)
        intent.putExtra("data_intent", binding.edtText.text.toString().trim())

        startService(intent)
    }
}