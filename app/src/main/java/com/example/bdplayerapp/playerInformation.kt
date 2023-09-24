package com.example.bdplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class playerInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_information)
        val tittlename = findViewById<TextView>(R.id.tittlename)
        val mainimg = findViewById<ImageView>(R.id.img)
        val details = findViewById<TextView>(R.id.details)

        val bundle: Bundle?=intent.extras
        val tittle = bundle!!.getString("tittle")
        val image = bundle!!.getInt("img")
        val Details = bundle!!.getString("information")

        tittlename.text = tittle
        details.text = Details
        mainimg.setImageResource(image)

    }
}