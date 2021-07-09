package com.example.roompratice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.roompratice.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        setSupportActionBar(binding.toolbar)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ok -> {
                val et = binding.editText.text.toString()
                Log.d("TAG", "onOptionsItemSelected: $et")
                setResult(RESULT_OK, Intent().putExtra("data", et))
                finish()
            }
            R.id.cancel ->{
                setResult(RESULT_CANCELED, Intent())
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }
}