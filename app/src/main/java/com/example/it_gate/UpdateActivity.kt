package com.example.it_gate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class UpdateActivity : AppCompatActivity() {


    lateinit var nameEditText : EditText
    lateinit var addressEditText : EditText
    lateinit var idEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        nameEditText = findViewById(R.id.nameId)
        addressEditText = findViewById(R.id.addressId)
        idEditText = findViewById(R.id.idId)
    }

    fun Update(view: View) {
        try {
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "userDB")
                .allowMainThreadQueries().build()
            db.userDao().updateUser(idEditText.text.toString().toInt(),nameEditText.text.toString(),addressEditText.text.toString())
            Toast.makeText(this, "Updated Success", Toast.LENGTH_SHORT).show()
        }catch (e:Exception){
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}