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
    var list = mutableListOf<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        var db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        val savedContacts = db!!.todoDao().getAll()
        if(savedContacts.isNotEmpty()){
            list.addAll(savedContacts)
        }

        val adapter = DataAdapter(list)
        binding.recycle.adapter = adapter
        binding.button.setOnClickListener {
                db.todoDao().insert(Todo(1, binding.editText.text.toString()))
                println(db)
                list.add(Todo(1, binding.editText.text.toString()))

                    adapter.notifyDataSetChanged()

        }

    }
}