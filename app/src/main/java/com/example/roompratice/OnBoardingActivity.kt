package com.example.roompratice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roompratice.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    var curpage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fra, OnBoarding1Fragment())
            .commit()
        binding.backBtn.visibility = View.INVISIBLE

        binding.backBtn.setOnClickListener {
            back()
        }
        binding.prevBtn.setOnClickListener {
            prev()
        }
    }

    fun back(){
        val fr : Fragment = OnBoarding1Fragment()
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fra, fr)
        fragmentTransaction.commit()
        binding.backBtn.visibility = View.INVISIBLE
        binding.prevBtn.visibility = View.VISIBLE
    }

    fun prev(){
        val fr : Fragment = OnBoarding2Fragment()
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.fra, fr)
        fragmentTransaction.commit()
        binding.backBtn.visibility = View.VISIBLE
        binding.prevBtn.visibility = View.INVISIBLE
    }
}