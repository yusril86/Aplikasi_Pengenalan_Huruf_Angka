package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailHurufBinding

class DetailHurufActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailHurufBinding
    private var audio : MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHurufBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val huruf = intent.getStringExtra("huruf")

        binding.tvHuruf.text = huruf
        binding.btnSuara.setOnClickListener {
            audio = MediaPlayer.create(this,R.raw.letter_a)
            audio.start()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this@DetailHurufActivity, NumberActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}