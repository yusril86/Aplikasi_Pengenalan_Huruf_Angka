package com.yusril.aplikasipengenalanhurufangkadanwarna

import android.app.Activity
import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.internal.ContextUtils.getActivity
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ActivityColorBinding
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.LayoutColorBinding


class ColorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColorBinding

     var color1:ImageButton? = null

//     val colorCyan = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.cyan))

//     val colorMagenta = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.magenta))


//     val colorYellow = ColorStateList.valueOf(this@ColorActivity.resources.getColor(R.color.yellow))
//     val colorYellow = resources.getColor(R.color.yellow)

//     val colorBlack = ColorStateList.valueOf(applicationContext.resources.getColor(R.color.black))
//     val colorBlack = resources.getColor(R.color.black)
        private var firstColor = 4
        private var secondColor = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        var audio = MediaPlayer()


        binding.apply {
            btnColorPick1.setOnClickListener {
                showDialogColorPick1()
            }
            btnColorPick2.setOnClickListener {
                showDialogColorPick2()
//                combineColor(firstColor,secondColor)
            }
        }


    }

    private fun showDialogColorPick1(){
        val dialogColor = Dialog(this@ColorActivity, androidx.appcompat.R.style.Theme_AppCompat_Dialog)
        dialogColor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogColor.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialogColor.setContentView(R.layout.layout_color)
        dialogColor.setCancelable(false)
        /*val dialogBinding: LayoutColorBinding = LayoutColorBinding.inflate(layoutInflater)
        setContentView(dialogBinding.root)*/

        val color1 = dialogColor.findViewById(R.id.color1) as ImageButton
        val color2 = dialogColor.findViewById(R.id.color2) as ImageButton
        val color3 = dialogColor.findViewById(R.id.color3) as ImageButton
        val color4 = dialogColor.findViewById(R.id.color4) as ImageButton



        color1.setOnClickListener {
            binding.btnColorPick1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.cyan))
            dialogColor.dismiss()
            firstColor = 1
            combineColor(firstColor,secondColor)
        }
        color2.setOnClickListener {
            binding.btnColorPick1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.magenta))
            dialogColor.dismiss()
            firstColor = 2
            combineColor(firstColor,secondColor)
        }

        color3.setOnClickListener {
            binding.btnColorPick1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
            dialogColor.dismiss()
            firstColor = 3
            combineColor(firstColor,secondColor)
        }

        color4.setOnClickListener {
            binding.btnColorPick1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
            dialogColor.dismiss()
            firstColor = 4
            combineColor(firstColor,secondColor)
        }

        dialogColor.show()
    }



    private fun showDialogColorPick2(){
        val dialogColor = Dialog(this@ColorActivity, androidx.appcompat.R.style.Theme_AppCompat_Dialog)
        dialogColor.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogColor.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialogColor.setContentView(R.layout.layout_color)
        dialogColor.setCancelable(false)
//        val dialogBinding: LayoutColorBinding = LayoutColorBinding.inflate(layoutInflater)
//        setContentView(dialogBinding.root)

        val color1 = dialogColor.findViewById(R.id.color1) as ImageButton
        val color2 = dialogColor.findViewById(R.id.color2) as ImageButton
        val color3 = dialogColor.findViewById(R.id.color3) as ImageButton
        val color4 = dialogColor.findViewById(R.id.color4) as ImageButton



        color1.setOnClickListener {
            binding.btnColorPick2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.cyan))
            dialogColor.dismiss()
            secondColor = 1
            combineColor(firstColor,secondColor)
        }
        color2.setOnClickListener {
            binding.btnColorPick2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.magenta))
            dialogColor.dismiss()
            secondColor = 2
            combineColor(firstColor,secondColor)
        }

        color3.setOnClickListener {
            binding.btnColorPick2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
            dialogColor.dismiss()
            secondColor = 3
            combineColor(firstColor,secondColor)
        }

        color4.setOnClickListener {
            binding.btnColorPick2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
            dialogColor.dismiss()
            secondColor = 4
            combineColor(firstColor,secondColor)
        }

        dialogColor.show()
    }


    private fun combineColor(firstColor:Int, secondColor:Int){
       /* cyan = 1
        magenta = 2
        yellow = 3
        black = 4
        blue = 5
        green = 6
        red = 7*/


        if (firstColor == 1 && secondColor == 1){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.cyan))
            binding.tvNameColor.text = "Cyan"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.cyan))
        }else if (firstColor == 1 && secondColor ==2){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.blue))
            binding.tvNameColor.text = "Blue"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.blue))
        }else if (firstColor == 1 && secondColor == 3){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green))
            binding.tvNameColor.text = "Green"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.green))
        }else if (firstColor == 2 && secondColor == 1){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.blue))
            binding.tvNameColor.text = "Blue"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.blue))
        }else if (firstColor == 2  && secondColor == 2){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.magenta))
            binding.tvNameColor.text = "Magenta"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.magenta))
        }else if (firstColor == 2 && secondColor == 3){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.red))
            binding.tvNameColor.text = "Red"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.red))
        }else if (firstColor == 3 && secondColor ==1 ){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green))
            binding.tvNameColor.text = "Green"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.green))
        }else if (firstColor == 3 && secondColor == 2){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.red))
            binding.tvNameColor.text = "Red"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.red))
        }else if (firstColor == 3 && secondColor == 3){
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.yellow))
            binding.tvNameColor.text = "Yellow"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.yellow))
        }else{
            binding.ivCombineColor.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.black))
            binding.tvNameColor.text = "Black"
            binding.tvNameColor.setTextColor(resources.getColor(R.color.black))
        }
    }
}