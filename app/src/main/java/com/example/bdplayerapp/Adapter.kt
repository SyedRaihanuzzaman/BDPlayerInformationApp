package com.example.bdplayerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(private val teamlist:ArrayList<Model>): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private lateinit var mlisener:onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:onItemClickListener){
        mlisener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.player_item,parent,false)
        return MyViewHolder(itemview,mlisener)
    }

    override fun getItemCount(): Int {
        return teamlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = teamlist[position]
        holder.img.setImageResource(currentItem.playerimage)
        holder.tittle.text = currentItem.playertittle
        holder.pposition.text = currentItem.playerposition

    }

    class MyViewHolder(itemview:View,listener:onItemClickListener) : RecyclerView.ViewHolder(itemview){

       val img = itemview.findViewById<CircleImageView>(R.id.playerImg)
        val tittle = itemview.findViewById<TextView>(R.id.playerTitle)
        val pposition = itemview.findViewById<TextView>(R.id.playerposition)

        init {
               itemview.setOnClickListener {
                   listener.onItemClick(adapterPosition)
               }
        }

    }


}