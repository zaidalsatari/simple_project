package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHELPER(context: Context):SQLiteOpenHelper(context,"userdata",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
      p0?.execSQL("create table userdata (username TEXT primary key,password TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists userdata")
    }
    fun insertdta(username: String,password: String ): Boolean {
        val p0 = this.writableDatabase
        val cv = contentValuesOf()

        cv.put("username", username)
        cv.put("password", password)

        var result = p0.insert("userdata", null, cv)

        if (result == -1.toLong()) {
            return false
        }
        return true
    }
        fun checkuserconfirm(username: String,password: String): Boolean {
            val p0 = this.writableDatabase
            val query = "select * from userdata where username= '$username', and password= '$password'"
            val cursor = p0.rawQuery(query,null)

            if (cursor.count <= 0){
                cursor.close()
                return false
            }
            cursor.close()
            return true
        }



}