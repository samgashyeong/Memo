package com.example.roompratice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplishAcitivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splish_acitivty)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, OnBoardingActivity::class.java))
        }, 1500)
    }
}