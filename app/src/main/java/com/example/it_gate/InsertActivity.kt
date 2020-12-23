package com.example.it_gate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class InsertActivity : AppCompatActivity() {
    lateinit var nameEditText : EditText
    lateinit var addressEditText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        nameEditText = findViewById(R.id.nameId)
        addressEditText = findViewById(R.id.addressId)
    }

    fun insertToDB(view: View) {
        try{
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "userDB").allowMainThreadQueries().build()
            val newUser = User(nameEditText.text.toString(),addressEditText.text.toString())
            db.userDao().insertNewUser(newUser)
            Toast.makeText(this,"User Added Success", Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            Toast.makeText(this,"Exception ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}