package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import java.io.IOException
import java.util.jar.Manifest


class NumberActivity : AppCompatActivity() {
    lateinit var cameraView: SurfaceView
    lateinit var txtValue : TextView
    lateinit var cameraSource : CameraSource
    private var audio : MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        cameraView = findViewById(R.id.surfaceView)
        txtValue = findViewById(R.id.text_view)

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
                            this@NumberActivity,
                            android.Manifest.permission.CAMERA
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(this@NumberActivity, arrayOf(android.Manifest.permission.CAMERA), 1)
                        return
                    }
//                    cameraSource!!.start(binding.surfaceView.holder)
                    cameraSource.start(cameraView.holder)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder) {
                cameraSource.stop()
            }

        })

        //TextRecognizer
        textRecognizer.setProcessor(object: Detector.Processor<TextBlock>{
            override fun release() {

            }

            override fun receiveDetections(p0: Detector.Detections<TextBlock>) {
//                Toast.makeText(applicationContext, "Receive Detections", Toast.LENGTH_LONG).show()
                val items : SparseArray<TextBlock> = p0.detectedItems
                if(items.size() != 0){
                    txtValue.post {
                        val strBuilder = StringBuilder()
                        for (i in 0 until items.size()) {
                            val item = items.valueAt(i)
                            strBuilder.append(item.value)
//                            value.append("\n")
//                            if (strBuilder.toString().first() in 'A'..'Z'){
                            /*if (strBuilder.toString() == "A"){
                                txtValue.text = strBuilder.toString()
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_a)
                                audio.start()
                            } else if (strBuilder.toString() == "B"){
                                txtValue.text = strBuilder.toString()
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_b)
                                audio.start()
                            }else if (strBuilder.toString() == "C"){
                                txtValue.text = strBuilder.toString()
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }else{
                                Toast.makeText(this@NumberActivity, "$strBuilder", Toast.LENGTH_SHORT).show()
                            }*/
                        }

                        txtValue.text = strBuilder.toString()
                        when (txtValue.text) {
                            "A" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_a)
                                audio.start()
                            }
                            "B" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_b)
                                audio.start()
                            }
                            "C" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "D" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "E" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "F" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "G" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "H" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "I" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            "J" -> {
                                audio = MediaPlayer.create(this@NumberActivity,R.raw.letter_c)
                                audio.start()
                            }
                            else -> {
                                Toast.makeText(this@NumberActivity, "$strBuilder", Toast.LENGTH_SHORT).show()
                            }
                        }

                    }
                }
            }
        })

    }
}