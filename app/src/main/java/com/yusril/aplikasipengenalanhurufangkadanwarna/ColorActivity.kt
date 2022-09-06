package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        var audio = MediaPlayer()

        binding.apply {
            redColor.setOnClickListener {
                audio = MediaPlayer.create(this@ColorActivity,R.raw.red_color)
                audio.start()
            }
            greenColor.setOnClickListener {
                audio = MediaPlayer.create(this@ColorActivity,R.raw.green_color)
                audio.start()
            }
            blueColor.setOnClickListener {
                audio = MediaPlayer.create(this@ColorActivity,R.raw.blue_color)
                audio.start()
            }
        }
    }
}