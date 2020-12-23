package com.example.it_gate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class DeleteActivity : AppCompatActivity() {
    lateinit var userId : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        userId = findViewById(R.id.userId)
    }

    fun deleteAll(view: View) {
        try {
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "userDB")
                .allowMainThreadQueries().build()
            db.userDao().deleteAllTableData()
            Toast.makeText(this, "All DB Deleted", Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteUserById(view: View) {
        try {
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "userDB")
                .allowMainThreadQueries().build()
            db.userDao().deleteUserById(userId.text.toString().toInt())
            Toast.makeText(this, "User Deleted", Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}