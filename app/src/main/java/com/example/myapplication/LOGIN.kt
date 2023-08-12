package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LOGIN : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val lognbtn:Button = findViewById(R.id.LOGINBTN)
        val unameg:EditText = findViewById(R.id.editTextTextEmailAddress)
        val pswrdg:EditText = findViewById(R.id.editTextTextPassword)
        val dBASE2:DBHELPER = DBHELPER(this)

        lognbtn.setOnClickListener{
            val unamedgtxt = unameg.text.toString()
            val pswrdgtxt = pswrdg.text.toString()

            if (TextUtils.isEmpty(unamedgtxt) || TextUtils.isEmpty(pswrdgtxt) ){
                Toast.makeText(this, "Add username & password", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                val checkuser = dBASE2.checkuserconfirm(unamedgtxt,pswrdgtxt)
                if (checkuser){
                    Toast.makeText(this, "logged in successfully", Toast.LENGTH_SHORT).show()
                         val intent = Intent(applicationContext, MainActivity::class.java)
                          startActivity(intent)
                }
                else{
                    Toast.makeText(this, "wrong username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}