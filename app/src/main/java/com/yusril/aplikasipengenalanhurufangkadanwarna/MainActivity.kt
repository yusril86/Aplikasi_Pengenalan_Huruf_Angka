package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLetter.setOnClickListener {
            val intent = Intent(this,NumberActivity::class.java)
//            intent.putExtra("letter","letter")
            startActivity(intent)
        }

        binding.btnNumber.setOnClickListener {
            val intent = Intent(this,LetterDetectionActivity::class.java)
//            intent.putExtra("number","number")
            startActivity(intent)
        }
    }


}