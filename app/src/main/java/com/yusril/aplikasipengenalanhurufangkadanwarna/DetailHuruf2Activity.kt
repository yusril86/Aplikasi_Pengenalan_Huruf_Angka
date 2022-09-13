package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailHuruf2Binding

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

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this@DetailHuruf2Activity, LetterDetectionActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}