package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//this is a new change
    lateinit var etname : EditText;   // declaration
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_new_activity = findViewById(R.id.login) as Button
        etname = findViewById(R.id.name);
        textView = findViewById(R.id.mytxt)
        btn_new_activity.setOnClickListener {
            var name = etname.text.toString()
            textView.setText(name)
            var sum = add(10,20)
            Toast.makeText(this," Hii " + name+ sum,Toast.LENGTH_SHORT).show();
        }
    }

    fun add(a : Int,b : Int) : Int{
        return a+b
    }

}