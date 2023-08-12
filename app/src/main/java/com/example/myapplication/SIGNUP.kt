package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SIGNUP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val usname:EditText = findViewById(R.id.editTextTextPassword2)
        val pswrd:EditText = findViewById(R.id.editTextTextPassword3)
        val cpswrd:EditText = findViewById(R.id.editTextTextPassword4)
        val DBASE:DBHELPER = DBHELPER(this)
        val btnsign:Button = findViewById(R.id.SIGNUPBTN)


        btnsign.setOnClickListener {
            val unametxt = usname.text.toString()
            val pswrdtxt = pswrd.text.toString()
            val cpswrdtxt = cpswrd.text.toString()
            val insdata = DBASE.insertdta(unametxt, pswrdtxt)

            if (TextUtils.isEmpty(unametxt) || TextUtils.isEmpty(pswrdtxt) || TextUtils.isEmpty(cpswrdtxt)) {
                Toast.makeText(
                    this,
                    "Add username, password & confirm password",
                    Toast.LENGTH_SHORT
                ).show()
            }
                else{
                    if (pswrdtxt.equals(cpswrdtxt)) {
                        if (insdata == true){
                            Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT)
                                .show()
                        val intent = Intent(applicationContext, LOGIN::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "user exit", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this, "user exit", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}