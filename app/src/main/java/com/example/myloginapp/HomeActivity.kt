package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var msg = intent.getStringExtra("MyKey")
        Toast.makeText(this," Hii "+msg, Toast.LENGTH_SHORT).show();
    }
}