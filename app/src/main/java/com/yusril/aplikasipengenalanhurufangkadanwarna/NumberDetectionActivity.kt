package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityLetterDetectionBinding

class NumberDetectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLetterDetectionBinding
    lateinit var cameraSource: CameraSource
    lateinit var cameraView: SurfaceView
    lateinit var txtValue : TextView

    private var resultDetection = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLetterDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cameraView = findViewById(R.id.surfaceView)
        txtValue = findViewById(R.id.text_view)

        val txtRecognizer: TextRecognizer = TextRecognizer.Builder(applicationContext).build()

        if (!txtRecognizer.isOperational) {
            Log.e("Main Activity", "Detector dependencies are not yet available")
        } else {
            cameraSource = CameraSource.Builder(applicationContext, txtRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build()
            val listNumber = (0..9).toMutableList()

            cameraView.holder.addCallback(object : SurfaceHolder.Callback {
                override fun surfaceCreated(p0: SurfaceHolder) {
                    try {
                        if (ActivityCompat.checkSelfPermission(
                                this@NumberDetectionActivity,
                                android.Manifest.permission.CAMERA
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(this@NumberDetectionActivity, arrayOf(android.Manifest.permission.CAMERA), 1)
                            return
                        }
                        cameraSource.start(cameraView.holder)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                @SuppressLint("MissingPermission")
                override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
                    cameraSource.start(cameraView.holder)
                }

                override fun surfaceDestroyed(p0: SurfaceHolder) {
                    cameraSource.stop()
                }
            })

            txtRecognizer.setProcessor(object : Detector.Processor<TextBlock> {
                override fun release() {
                    listNumber.forEachIndexed { index, _ ->
                        if (resultDetection == listNumber[index].toString()) {
                            val intent = Intent(
                                this@NumberDetectionActivity,
                                DetailAngkaActivity::class.java
                            )
                            intent.putExtra("number", listNumber[index].toString())
                            startActivity(intent)
                        }
                    }
                }

                override fun receiveDetections(p0: Detector.Detections<TextBlock>) {
                    val items : SparseArray<TextBlock> = p0.detectedItems
                    if (items.size() > 0) {
                        txtValue.post {
                            val strBuilder = StringBuilder()
                            for (i in 0 until items.size()) {
                                val item = items.valueAt(i)
                                strBuilder.append(item.value)
                                listNumber.forEachIndexed { index, _ ->
                                    if (strBuilder.toString() == listNumber[index].toString() || strBuilder.toString() == listNumber[index].toString()
                                            .lowercase()
                                    ) {
                                        resultDetection = listNumber[index].toString()
                                        cameraSource.release()
                                    }
                                }
                            }
                        }
                    }
                }

            })
        }
    }




}


