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
        val dataA1 = LetterModel(
            R.drawable.image_a,
            R.raw.a_ayam
        )
        val dataA2 = LetterModel(
            R.drawable.image_a1,
            R.raw.a_apel
        )
        val dataA3 = LetterModel(
            R.drawable.image_a2,
            R.raw.a_angsa
        )
        val listA = listOf(dataA1,dataA2,dataA3)


        val dataB1 = LetterModel(
            R.drawable.image_b,
            R.raw.b_burung
        )
        val dataB2 = LetterModel(
            R.drawable.image_b1,
            R.raw.b_bola
        )
        val dataB3 = LetterModel(
            R.drawable.image_b2,
            R.raw.b_buku
        )
        val listB = listOf(dataB1,dataB2,dataB3)


        val dataC1 = LetterModel(
            R.drawable.image_c,
            R.raw.c_cermin
        )
        val dataC2 = LetterModel(
            R.drawable.image_c1,
            R.raw.c_cabai
        )
        val dataC3 = LetterModel(
            R.drawable.image_c2,
            R.raw.c_capung
        )
        val listC = listOf(dataC1, dataC2, dataC3)

        val dataD1 = LetterModel(
            R.drawable.image_d,
            R.raw.d_durian
        )
        val dataD2 = LetterModel(
            R.drawable.image_d1,
            R.raw.d_drum
        )
        val dataD3 = LetterModel(
            R.drawable.image_d2,
            R.raw.d_domba
        )
        val listD = listOf(dataD1, dataD2, dataD3)

        val dataE1 = LetterModel(
            R.drawable.image_e,
            R.raw.e_emberr
        )
        val dataE2 = LetterModel(
            R.drawable.image_e1,
            R.raw.e_es_krim
        )
        val dataE3 = LetterModel(
            R.drawable.image_e2,
            R.raw.a_apel
        )
        val listE = listOf(dataE1, dataE2, dataE3)

        val dataF1 = LetterModel(
            R.drawable.image_f1,
            R.raw.f_flamingo
        )
        val dataF2 = LetterModel(
            R.drawable.image_f2,
            R.raw.f_foto
        )
        val dataF3 = LetterModel(
            R.drawable.image_f3,
            R.raw.f_ferii
        )
        val listF = listOf(dataF1, dataF2, dataF3)

        val dataG1 = LetterModel(
            R.drawable.image_g1,
            R.raw.g_gajah
        )
        val dataG2 = LetterModel(
            R.drawable.image_g2,
            R.raw.g_gelass
        )
        val dataG3 = LetterModel(
            R.drawable.image_g3,
            R.raw.g_gunung
        )
        val listG = listOf(dataG1, dataG2, dataG3)

        val dataH1 = LetterModel(
            R.drawable.image_h1,
            R.raw.h_hantu
        )
        val dataH2 = LetterModel(
            R.drawable.image_h2,
            R.raw.h_hidung
        )
        val dataH3 = LetterModel(
            R.drawable.image_h3,
            R.raw.h_hujan
        )
        val listH = listOf(dataH1, dataH2, dataH3)

        val dataI1 = LetterModel(
            R.drawable.image_i1,
            R.raw.i_ikan
        )
        val dataI2 = LetterModel(
            R.drawable.image_i2,
            R.raw.i_iguana
        )
        val listI = listOf(dataI1, dataI2)

        val dataJ1 = LetterModel(
            R.drawable.image_j1,
            R.raw.j_jagung
        )
        val dataJ2 = LetterModel(
            R.drawable.image_j2,
            R.raw.j_jerapah
        )
        val dataJ3 = LetterModel(
            R.drawable.image_j3,
            R.raw.j_jam
        )
        val listJ = listOf(dataJ1, dataJ2, dataJ3)

        val dataK1 = LetterModel(
            R.drawable.image_k1,
            R.raw.k_katak
        )
        val dataK2 = LetterModel(
            R.drawable.image_k2,
            R.raw.k_kentang
        )
        val dataK3 = LetterModel(
            R.drawable.image_k3,
            R.raw.k_kaki
        )
        val listK = listOf(dataK1, dataK2, dataK3)

        val dataL1 = LetterModel(
            R.drawable.image_l1,
            R.raw.l_lalat
        )
        val dataL2 = LetterModel(
            R.drawable.image_l2,
            R.raw.l_labalaba
        )
        val dataL3 = LetterModel(
            R.drawable.image_l3,
            R.raw.l_labu
        )
        val dataL4 = LetterModel(
            R.drawable.image_l4,
            R.raw.l_leci
        )
        val listL = listOf(dataL1, dataL2, dataL3, dataL4)

        val dataM1 = LetterModel(
            R.drawable.image_m1,
            R.raw.m_macan
        )
        val dataM2 = LetterModel(
            R.drawable.image_m2,
            R.raw.m_mangga
        )
        val dataM3 = LetterModel(
            R.drawable.image_m3,
            R.raw.m_mobil
        )
        val listM = listOf(dataM1, dataM2, dataM3)

        val dataN1 = LetterModel(
            R.drawable.image_n1,
            R.raw.n_nanas
        )
        val dataN2 = LetterModel(
            R.drawable.image_n2,
            R.raw.n_naga
        )
        val dataN3 = LetterModel(
            R.drawable.image_n3,
            R.raw.n_nenek
        )
        val listN = listOf(dataN1, dataN2, dataN3)

        val dataO1 = LetterModel(
            R.drawable.image_o1,
            R.raw.o_orang_hutan
        )
        val dataO2 = LetterModel(
            R.drawable.image_o2,
            R.raw.o_oborrr
        )
        val dataO3 = LetterModel(
            R.drawable.image_o3,
            R.raw.o_odol
        )
        val dataO4 = LetterModel(
            R.drawable.image_o4,
            R.raw.o_oven
        )
        val listO = listOf(dataO1, dataO2, dataO3, dataO4)

        val dataP1 = LetterModel(
            R.drawable.image_p1,
            R.raw.p_pinguin
        )
        val dataP2 = LetterModel(
            R.drawable.image_p2,
            R.raw.p_pisangg
        )
        val dataP3 = LetterModel(
            R.drawable.image_p3,
            R.raw.p_pisau
        )
        val dataP4 = LetterModel(
            R.drawable.image_p4,
            R.raw.p_pandaa
        )
        val listP = listOf(dataP1, dataP2, dataP3, dataP4)

        val dataQ1 = LetterModel(
            R.drawable.image_q1,
            R.raw.q_quraan
        )
        val dataQ2 = LetterModel(
            R.drawable.image_q2,
            R.raw.q_quokka
        )
        val dataQ3 = LetterModel(
            R.drawable.image_q3,
            R.raw.q_quince
        )
        val listQ = listOf(dataQ1, dataQ2, dataQ3)

        val dataR1 = LetterModel(
            R.drawable.image_r1,
            R.raw.r_roti
        )
        val dataR2 = LetterModel(
            R.drawable.image_r2,
            R.raw.r_rumahh
        )
        val dataR3 = LetterModel(
            R.drawable.image_r3,
            R.raw.r_radio
        )
        val dataR4 = LetterModel(
            R.drawable.image_r4,
            R.raw.r_raket
        )
        val dataR5 = LetterModel(
            R.drawable.image_r5,
            R.raw.r_roket
        )
        val listR = listOf(dataR1, dataR2, dataR3, dataR4, dataR5)

        val dataS1 = LetterModel(
            R.drawable.image_s1,
            R.raw.s_semangka
        )
        val dataS2 = LetterModel(
            R.drawable.image_s2,
            R.raw.s_sisir
        )
        val dataS3 = LetterModel(
            R.drawable.image_s3,
            R.raw.s_sabun
        )

        val listS = listOf(dataS1, dataS2, dataS3)

        val dataT1 = LetterModel(
            R.drawable.image_t1,
            R.raw.t_teh
        )
        val dataT2 = LetterModel(
            R.drawable.image_t2,
            R.raw.t_tangga
        )
        val dataT3 = LetterModel(
            R.drawable.image_t3,
            R.raw.t_tali
        )

        val listT = listOf(dataT1, dataT2, dataT3)

        val dataU1 = LetterModel(
            R.drawable.image_u1,
            R.raw.u_uang
        )
        val dataU2 = LetterModel(
            R.drawable.image_u2,
            R.raw.u_ubi
        )
        val dataU3 = LetterModel(
            R.drawable.image_u3,
            R.raw.u_udang
        )
        val dataU4 = LetterModel(
            R.drawable.image_u4,
            R.raw.u_ularr
        )
        val dataU5 = LetterModel(
            R.drawable.image_u5,
            R.raw.u_unta
        )
        val listU = listOf(dataU1, dataU2, dataU3, dataU4, dataU5)

        val dataV1 = LetterModel(
            R.drawable.image_v1,
            R.raw.v_vas
        )
        val dataV2 = LetterModel(
            R.drawable.image_v2,
            R.raw.v_vespa
        )
        val dataV3 = LetterModel(
            R.drawable.image_v3,
            R.raw.v_volly
        )
        val listV = listOf(dataV1, dataV2, dataV3)

        val dataW1 = LetterModel(
            R.drawable.image_w1,
            R.raw.w_wafer
        )
        val dataW2 = LetterModel(
            R.drawable.image_w2,
            R.raw.w_wajan
        )
        val dataW3 = LetterModel(
            R.drawable.image_w3,
            R.raw.w_wortel
        )
        val listW = listOf(dataW1, dataW2, dataW3)


        val dataX1 = LetterModel(
            R.drawable.image_x1,
            R.raw.x_xilofon
        )
        val dataX2 = LetterModel(
            R.drawable.image_x2,
            R.raw.x_x_man
        )
        val dataX3 = LetterModel(
            R.drawable.image_x3,
            R.raw.x_x_ray
        )
        val listX = listOf(dataX1, dataX2, dataX3)

        val dataY1 = LetterModel(
            R.drawable.image_y1,
            R.raw.y_yoyo
        )
        val dataY2 = LetterModel(
            R.drawable.image_y2,
            R.raw.y_yogourt
        )
        val dataY3 = LetterModel(
            R.drawable.image_y3,
            R.raw.y_yak
        )
        val listY = listOf(dataY1, dataY2, dataY3)

        val dataZ1 = LetterModel(
            R.drawable.image_z1,
            R.raw.z_zaitun
        )
        val dataZ2 = LetterModel(
            R.drawable.image_z2,
            R.raw.z_zebra_cross
        )
        val dataZ3 = LetterModel(
            R.drawable.image_z3,
            R.raw.z_zebra
        )
        val listZ = listOf(dataZ1, dataZ2, dataZ3)

        var listImage = listOf<LetterModel>()

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
data class LetterModel(
    val drawableId : Int,
    val soundId : Int
)