package com.example.it_gate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun gotoAdd(view: View) {
        val intent = Intent(this,InsertActivity::class.java)
        startActivity(intent)
    }
    fun gotoShow(view: View) {
        val intent = Intent(this,ShowActivity::class.java)
        startActivity(intent)
    }
    fun gotoDelete(view: View) {
        val intent = Intent(this,DeleteActivity::class.java)
        startActivity(intent)
    }
    fun gotoUpdate(view: View) {
        val intent = Intent(this,UpdateActivity::class.java)
        startActivity(intent)
    }
}