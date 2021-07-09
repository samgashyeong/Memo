package com.example.roompratice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.roompratice.databinding.FragmentOnBoarding2Binding

class OnBoarding2Fragment : Fragment() {
    lateinit var binding : FragmentOnBoarding2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_boarding2, container, false)

        binding.btn.setOnClickListener {
            startActivity(Intent(it.context, MainActivity::class.java))
        }
        return binding.root
    }

}