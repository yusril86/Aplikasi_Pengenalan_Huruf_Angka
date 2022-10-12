package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.text.TextBlock
import com.google.android.gms.vision.text.TextRecognizer
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityLetterDetectionBinding

class NumberDetectionActivity : AppCompatActivity(), SurfaceHolder.Callback,
    Detector.Processor<TextBlock> {

    private  lateinit var binding : ActivityLetterDetectionBinding
    private var cameraSource: CameraSource? = null
    private var cameraView: SurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLetterDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        cameraView = findViewById(R.id.surfaceView)
        val txtRecognizer : TextRecognizer = TextRecognizer.Builder(applicationContext).build()

        if (!txtRecognizer.isOperational) {
            Log.e("Main Activity", "Detector dependencies are not yet available")
        } else {
            cameraSource = CameraSource.Builder(applicationContext, txtRecognizer)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1280, 1024)
                .setRequestedFps(2.0f)
                .setAutoFocusEnabled(true)
                .build()
            binding.surfaceView.holder.addCallback(this)
            txtRecognizer.setProcessor(this)
            /*txtRecognizer.setProcessor(object: Detector.Processor<TextBlock>{
                override fun release() {

                }

                override fun receiveDetections(p0: Detector.Detections<TextBlock>) {

                }

            })*/
        }
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        try {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
                return
            }
            cameraSource!!.start(binding.surfaceView.holder)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        cameraSource?.stop()
    }

    override fun release() {

    }

    override fun receiveDetections(p0: Detector.Detections<TextBlock?>) {
        val items: SparseArray<TextBlock?> = p0.detectedItems
        val strBuilder = StringBuilder()

        for (i in 1..items.size()){
            val item = items.valueAt(i) as TextBlock
            strBuilder.append(item.value)


            binding.textView.post {
                if (strBuilder.toString().first() in 'A'..'Z'){
                    binding.textView.text = strBuilder.toString()
                } else {
                    Toast.makeText(this, "$strBuilder", Toast.LENGTH_SHORT).show()
                }
            }

        }
        
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    try {
                        cameraSource!!.start(cameraView!!.holder)
                    } catch (e: java.lang.Exception) {
                    }
                }
            }
        }
    }
}


