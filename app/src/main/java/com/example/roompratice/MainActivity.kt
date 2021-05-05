package com.example.roompratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roompratice.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )


        val layoutManager = LinearLayoutManager(this)
        binding.recycle.setLayoutManager(layoutManager)

        loadData()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
        binding.button.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                db.todoDao().insert(Todo(1, binding.editText.text.toString()))
            }
            loadData()
        }

    }

    fun loadData(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
        GlobalScope.launch(Dispatchers.IO){
            val list : List<Todo> = db.todoDao().getAll()

            withContext(Dispatchers.Main){
                val adapter = DataAdapter(list)
                binding.recycle.adapter = adapter
            }
        }
    }
}