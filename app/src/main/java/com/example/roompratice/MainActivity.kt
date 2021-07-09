package com.example.roompratice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roompratice.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var list = mutableListOf<Todo>()
    private lateinit var db : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )
        db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "tb-table"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val savedContacts = db.todoDao().getAll()
        if(savedContacts.isNotEmpty()){
            list.addAll(savedContacts)
        }
        if(list.size == 0){
            binding.alarmTv.visibility = View.VISIBLE
        }
        else{
            binding.alarmTv.visibility = View.INVISIBLE
        }

        val adapter = DataAdapter(list)
        binding.recycle.adapter = adapter





        binding.flbtn.setOnClickListener {
            startActivityForResult(Intent(this, MainActivity2::class.java), 100)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val rd = Random()
        val num = rd.nextInt(100)
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = (cal.get(Calendar.MONTH) + 1).toString()
        val day = cal.get(Calendar.DATE).toString()
        val today = "$year-$month-$day"
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                db.todoDao().insert(Todo(num, data!!.getStringExtra("data").toString()))
                println(db)
                list.add(Todo(num, data!!.getStringExtra("data").toString()))
                val adapter = DataAdapter(list)
                binding.recycle.adapter!!.notifyDataSetChanged()
                Log.d("asdf", "onActivityResult: " + data.getStringExtra("data"))
                if(list.size == 0){
                    binding.alarmTv.visibility = View.VISIBLE
                }
            }
        }
    }




}