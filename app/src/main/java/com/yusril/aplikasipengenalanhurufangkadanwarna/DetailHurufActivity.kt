package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusril.aplikasipengenalanhurufangkadanwarna.adapter.LetterImageAdapter
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityDetailHurufBinding

class DetailHurufActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailHurufBinding
    private var audio : MediaPlayer = MediaPlayer()
    private var letterImageAdapter: LetterImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHurufBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val huruf = intent.getStringExtra("letter")

        binding.tvHuruf.text = huruf
        binding.btnSuara.setOnClickListener {
            when(huruf) {
                "A", "a" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_a)
                    audio.start()
                }
                "B", "b" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_b)
                    audio.start()
                }
                "C", "c" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_c)
                    audio.start()
                }
                "D", "d" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_d)
                    audio.start()
                }
                "E", "e" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_e)
                    audio.start()
                }
                "F", "f" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_f)
                    audio.start()
                }
                "G", "g" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_g)
                    audio.start()
                }
                "H", "h" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_h)
                    audio.start()
                }
                "I", "i" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_i)
                    audio.start()
                }
                "J", "j" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_j)
                    audio.start()
                }
                "K", "k" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_k)
                    audio.start()
                }
                "L", "l" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_l)
                    audio.start()
                }
                "M", "m" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_m)
                    audio.start()
                }
                "N", "n" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_n)
                    audio.start()
                }
                "O", "o" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_o)
                    audio.start()
                }
                "P", "p" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_p)
                    audio.start()
                }
                "Q", "q" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_q)
                    audio.start()
                }
                "R", "r" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_r)
                    audio.start()
                }
                "S", "s" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_s)
                    audio.start()
                }
                "T", "t" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_t)
                    audio.start()
                }
                "U", "u" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_u)
                    audio.start()
                }
                "V", "v" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_v)
                    audio.start()
                }
                "W", "w" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_w)
                    audio.start()
                }
                "X", "x" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_x)
                    audio.start()
                }
                "Y", "y" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_y)
                    audio.start()
                }
                "Z", "z" -> {
                    audio = MediaPlayer.create(this, R.raw.letter_z)
                    audio.start()
                }
            }
        }

        letterImageAdapter = LetterImageAdapter()
        binding.rvExampleImage.apply {
            layoutManager = GridLayoutManager(
                context, 2,
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = letterImageAdapter
        }

        val listA = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listB = listOf(R.drawable.image_b, R.drawable.image_b1, R.drawable.image_b2)
        val listC = listOf(R.drawable.image_c, R.drawable.image_c1, R.drawable.image_c2)
        val listD = listOf(R.drawable.image_d, R.drawable.image_d1, R.drawable.image_d2)
        val listE = listOf(R.drawable.image_e, R.drawable.image_e1, R.drawable.image_e2)
        val listF = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listG = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listH = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listI = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listJ = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listK = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listL = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listM = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listN = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listO = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listP = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listQ = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listR = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listS = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listT = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listU = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listV = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listW = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listX = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listY = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)
        val listZ = listOf(R.drawable.image_a, R.drawable.image_a1, R.drawable.image_a2)

        var listImage = listOf<Int>()

        when(huruf) {
            "A", "a" -> {
                listImage = listA
            }
            "B", "b" -> {
                listImage = listB
            }
            "C", "c" -> {
                listImage = listC
            }
            "D", "d" -> {
                listImage = listD
            }
            "E", "e" -> {
                listImage = listE
            }
            "F", "f" -> {
                listImage = listF
            }
            "G", "g" -> {
                listImage = listG
            }
            "H", "h" -> {
                listImage = listH
            }
            "I", "i" -> {
                listImage = listI
            }
            "J", "j" -> {
                listImage = listJ
            }
            "K", "k" -> {
                listImage = listK
            }
            "L", "l" -> {
                listImage = listL
            }
            "M", "m" -> {
                listImage = listM
            }
            "N", "n" -> {
                listImage = listN
            }
            "O", "o" -> {
                listImage = listO
            }
            "P", "p" -> {
                listImage = listP
            }
            "Q", "q" -> {
                listImage = listQ
            }
            "R", "r" -> {
                listImage = listR
            }
            "S", "s" -> {
                listImage = listS
            }
            "T", "t" -> {
                listImage = listT
            }
            "U", "u" -> {
                listImage = listU
            }
            "V", "v" -> {
                listImage = listV
            }
            "W", "w" -> {
                listImage = listW
            }
            "X", "x" -> {
                listImage = listX
            }
            "Y", "y" -> {
                listImage = listY
            }
            "Z", "z" -> {
                listImage = listZ
            }
        }

        letterImageAdapter?.updateAdapter(listImage)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this@DetailHurufActivity, LetterDetectionActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}