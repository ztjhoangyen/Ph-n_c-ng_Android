package com.example.videoexo

import android.app.LoaderManager
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

//TRÌNH PHÁT EXO ĐỂ PHÁT CÁC TẬP TIN VIDEO TRONG BỘ LƯU TRỮ ĐIỆN THOẠI VÀ PHÁT TẤT CẢ CÁC TẬP TIN ĐA PHƯƠNG TIỆN

class MainActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var exoPlayer: ExoPlayer

    private val READ_EXTENAL_STORAGE_PERMISSION_REQUEST = 1
    private val mediaFiles : MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        playerView = findViewById(R.id.player_view)
        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        if(ContextCompat.checkSelfPermission(
            this,
           Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
            ){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_EXTENAL_STORAGE_PERMISSION_REQUEST
            )
        }else{
            loaderManager()
            playMediaFiles()

        }

    }
}

    private  fun loaderManager() {
    
    }

    private  fun playMediaFiles() {

    }


