package com.example.videomedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {
    lateinit var playerView: PlayerView
    lateinit var player: ExoPlayer

    @UnstableApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        playerView = findViewById(R.id.player_view)

        val player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val mediaItem = MediaItem.Builder()
            .setUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .build()

        val mediaSource = ProgressiveMediaSource.Factory(
            DefaultDataSource.Factory(this)
        )
            .createMediaSource(mediaItem)
            player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

    }
}