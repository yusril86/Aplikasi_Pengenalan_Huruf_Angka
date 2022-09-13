package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
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

class LetterDetectionActivity : AppCompatActivity() {
    lateinit var cameraView: SurfaceView
    lateinit var txtValue : TextView
    lateinit var cameraSource : CameraSource

    private var resultDetection = ""

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this@LetterDetectionActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        cameraView = findViewById(R.id.surfaceView)
        txtValue = findViewById(R.id.text_view)

        resultDetection = ""

        val textRecognizer = TextRecognizer.Builder(applicationContext).build()
        if (!textRecognizer.isOperational) {
            Toast.makeText(this, "Text Recognizer is not functional", Toast.LENGTH_LONG).show()
        }

        cameraSource = CameraSource.Builder(applicationContext, textRecognizer)
            .setFacing(CameraSource.CAMERA_FACING_BACK)
            .setRequestedPreviewSize(1280, 1024)
            .setRequestedFps(2.0.toFloat())
            .setAutoFocusEnabled(true)
            .build()

        //SurfaceHolder
        cameraView.holder.addCallback(object : SurfaceHolder.Callback{
            override fun surfaceCreated(p0: SurfaceHolder) {
                try {
                    if (ActivityCompat.checkSelfPermission(
                            this@LetterDetectionActivity,
                            android.Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(this@LetterDetectionActivity, arrayOf(android.Manifest.permission.CAMERA), 1)
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

        textRecognizer.setProcessor(object: Detector.Processor<TextBlock>{
            override fun release() {
                when(resultDetection) {
                    "A" -> {
                        val intent  = Intent(this@LetterDetectionActivity,DetailHurufActivity::class.java)
                        intent.putExtra("huruf","A")
                        startActivity(intent)
                    }
                    "B" -> {
                        val intent  = Intent(this@LetterDetectionActivity,DetailHuruf2Activity::class.java)
                        intent.putExtra("huruf","B")
                        startActivity(intent)
                    }
                    "C" -> {
                        val intent  = Intent(this@LetterDetectionActivity,DetailHurufActivity::class.java)
                        intent.putExtra("huruf","C")
                        startActivity(intent)
                    }
                }
            }

            override fun receiveDetections(p0: Detector.Detections<TextBlock>) {
                val items : SparseArray<TextBlock> = p0.detectedItems
                if(items.size() > 0){
                    txtValue.post {
                        val strBuilder = StringBuilder()
                        for (i in 0 until items.size()) {
                            val item = items.valueAt(i)
                            strBuilder.append(item.value)
                            when {
                                strBuilder.toString() == "A" -> {
                                    resultDetection = "A"
                                    cameraSource.release()
                                }
                                strBuilder.toString() == "B" -> {
                                    resultDetection = "B"
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