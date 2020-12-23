package com.example.it_gate

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class ShowActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var mAdapter :RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        recyclerView = findViewById(R.id.recyclerViewId)
        val db = Room.databaseBuilder(this, AppDatabase::class.java, "userDB").allowMainThreadQueries().build()
        mAdapter = RecyclerViewAdapter(db.userDao().getAll(),this)
        recyclerView.adapter = mAdapter
    }
}
