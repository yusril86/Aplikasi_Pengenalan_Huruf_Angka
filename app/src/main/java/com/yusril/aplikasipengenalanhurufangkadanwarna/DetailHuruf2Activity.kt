package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailHuruf2Binding
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailHurufBinding

class DetailHuruf2Activity : AppCompatActivity() {
    lateinit var binding : ActivityDetailHuruf2Binding
    private var audio : MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHuruf2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val huruf = intent.getStringExtra("huruf")

        binding.tvHuruf.text = huruf
        binding.btnSuara.setOnClickListener {
            audio = MediaPlayer.create(this,R.raw.letter_b)
            audio.start()
        }

    }
}