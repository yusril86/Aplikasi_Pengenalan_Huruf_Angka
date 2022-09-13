package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLetter.setOnClickListener {
            val intent = Intent(this,LetterDetectionActivity::class.java)
//            intent.putExtra("letter","letter")
            startActivity(intent)
        }

        binding.btnNumber.setOnClickListener {
            val intent = Intent(this,NumberDetectionActivity::class.java)
//            intent.putExtra("number","number")
            startActivity(intent)
        }

        binding.btnColor.setOnClickListener {
            val intent = Intent(this, ColorActivity::class.java)
            startActivity(intent)
        }
    }


}