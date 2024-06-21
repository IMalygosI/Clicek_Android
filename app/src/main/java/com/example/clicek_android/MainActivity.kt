package com.example.clicek_android

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var currentState = 1
    var mainTextView: TextView? = null
    var mainBtn: Button? = null
    var mainBtnMin: Button? = null
    var mainBtnObnl: Button? = null
    var score = 0
    var ds = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTextView = findViewById<View>(R.id.mainTxt) as TextView
        mainBtn = findViewById<View>(R.id.Plus_btn) as Button
        mainBtn!!.setOnClickListener(clickListener)
        mainBtnMin = findViewById<View>(R.id.mainBtnMin) as Button
        mainBtnMin!!.setOnClickListener(clickListener)
        mainBtnObnl = findViewById<View>(R.id.mainBtnObnl) as Button
        mainBtnObnl!!.setOnClickListener(clickListener)
    }

    var clickListener: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View) {
            if (view.id == R.id.Plus_btn) {
                score += 1
                val sco = score % 10
                if (2 == sco || 4 == sco || 3 == sco) {
                    val s = "Кнопка нажата: $score Раза"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtn!!.setOnClickListener(this)
                } else {
                    val s = "Кнопка нажата: $score Раз"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtn!!.setOnClickListener(this)
                }
                if (score == 12 || score == 13 || score == 14) {
                    val s = "Кнопка нажата: $score Раз"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtn!!.setOnClickListener(this)
                }
            }
            if (view.id == R.id.mainBtnMin) {
                score -= 1
                val sco = score % 10
                if (2 == sco || 4 == sco || 3 == sco) {
                    val s = "Кнопка нажата: $score Раза"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtnMin!!.setOnClickListener(this)
                } else {
                    val s = "Кнопка нажата: $score Раз"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtnMin!!.setOnClickListener(this)
                }
                if (score == 12 || score == 13 || score == 14) {
                    val s = "Кнопка нажата: $score Раз"
                    mainTextView!!.setText(s.toCharArray(), 0, s.length)
                    mainBtnMin!!.setOnClickListener(this)
                }
            }
            if (view.id == R.id.mainBtnObnl) {
                score = 0
                ds = 0
                val s = "Кнопка нажата: $score Раз"
                mainTextView!!.setText(s.toCharArray(), 0, s.length)
                val imageView = findViewById<ImageView>(R.id.IImage)
                imageView.visibility = View.VISIBLE
                findViewById<ImageView>(R.id.IImage).setImageResource(R.drawable.obnul)
                mainBtnObnl!!.setOnClickListener(this)
            }
            if (view.id == R.id.Plus_btn || view.id == R.id.mainBtnMin) {
                currentState = if (currentState == 1) 2 else 1
                val imageResource = when (currentState) {

                    1 -> R.drawable.cat
                    2 -> R.drawable.cat2
                    else -> R.drawable.cat
                }
                val imageView = findViewById<ImageView>(R.id.IImage)
                imageView.visibility = View.GONE
                findViewById<ImageView>(R.id.catImage).setImageResource(imageResource)

                ds++
                if (ds == 10) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.ads)
                }
                if (ds == 20) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img)
                }
                if (ds == 30) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_7)
                }
                if (ds == 40 || ds == 41|| ds == 42|| ds == 43|| ds == 44) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_3)
                    findViewById<ImageView>(R.id.catImage).setImageResource(R.drawable.img_2)
                }
                if (ds == 50) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_4)
                }
                if (ds == 60 ) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_1)
                }
                if (ds == 61) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.mudrec)
                }
                if (ds % 70 == 0) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_5)
                }
                if (ds % 80 == 0 ) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_6)
                }
                if (ds % 75 == 0 ) {
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_8)
                }
                if (score == 200 ) {
                    imageView.visibility = View.VISIBLE
                    findViewById<ImageView>(R.id.IImage).setImageResource(R.drawable.obnul)
                    findViewById<ImageView>(R.id.IImage).setImageResource(R.drawable.img_9)
                }
                if (score == 201 ) {
                    val imageView = findViewById<ImageView>(R.id.IImage)
                    imageView.visibility = View.GONE
                    findViewById<ImageView>(R.id.Image).setImageResource(R.drawable.img_8)
                }
            }
        }
    }
}
