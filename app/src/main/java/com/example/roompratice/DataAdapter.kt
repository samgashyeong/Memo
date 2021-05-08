package com.example.roompratice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  DataAdapter(val DataList: List<Todo>): RecyclerView.Adapter<DataAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //ex)val 변수명 = itemView.findViewById<xml이름>(아이디네임)
        val numTv = itemView.findViewById<TextView>(R.id.numTv)
        val workTv = itemView.findViewById<TextView>(R.id.workTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_row_data_recycle, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //ex)holder.(홀더클래스변수).text = DataList[position].name
        holder.numTv.text = DataList[position].id.toString()
        holder.workTv.text = DataList[position].title.toString()
    }
    override fun getItemCount() = DataList.size

}