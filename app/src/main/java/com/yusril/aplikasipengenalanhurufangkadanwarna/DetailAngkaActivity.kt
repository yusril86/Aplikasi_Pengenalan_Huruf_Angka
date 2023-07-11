package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailAngkaBinding

class DetailAngkaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailAngkaBinding
    private var audio : MediaPlayer = MediaPlayer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAngkaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val angka  = intent.getStringExtra("number")

        binding.tvAngka.text = angka

        binding.btnSuara.setOnClickListener {
            when(angka){
                "1" ->{
                    audio = MediaPlayer.create(this, R.raw.suara1)
                    audio.start()
                }
                "2" ->{
                    audio = MediaPlayer.create(this, R.raw.suara2)
                    audio.start()
                }
                "3" ->{
                    audio = MediaPlayer.create(this, R.raw.suara3)
                    audio.start()
                }
                "4" ->{
                    audio = MediaPlayer.create(this, R.raw.suara4)
                    audio.start()
                }
                "5" ->{
                    audio = MediaPlayer.create(this, R.raw.suara5)
                    audio.start()
                }
                "6" ->{
                    audio = MediaPlayer.create(this, R.raw.suara6)
                    audio.start()
                }
                "7"->{
                    audio = MediaPlayer.create(this, R.raw.suara7)
                    audio.start()
                }
                "8" ->{
                    audio = MediaPlayer.create(this, R.raw.suara8)
                    audio.start()
                }
                "9" ->{
                    audio = MediaPlayer.create(this, R.raw.suara9)
                    audio.start()
                }
                "0"->{
                    audio = MediaPlayer.create(this, R.raw.suara0)
                    audio.start()
                }
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this@DetailAngkaActivity, NumberDetectionActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}
