package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonstartrbtn:Button = findViewById(R.id.STARTbtn)

        buttonstartrbtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity1::class.java)
            startActivity(intent)
        }


    }
}