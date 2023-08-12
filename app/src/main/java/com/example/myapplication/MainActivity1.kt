package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val buttonsignup1:Button=findViewById(R.id.button)
        val buttonlogin1:Button=findViewById(R.id.button2)

        buttonsignup1.setOnClickListener{
            val intent = Intent(this,SIGNUP::class.java)
            startActivity(intent)
        }

        buttonlogin1.setOnClickListener{
            val intent = Intent(this,LOGIN::class.java)
            startActivity(intent)
        }

    }
}