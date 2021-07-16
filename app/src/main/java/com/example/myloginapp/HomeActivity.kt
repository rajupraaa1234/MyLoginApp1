package com.example.myloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var msg = intent.getStringExtra("MyKey")
        Toast.makeText(this," Hii "+msg, Toast.LENGTH_SHORT).show();
    }

    fun onClickHome(view: View){
        when(view.id){
            R.id.send->{sendData()}
        }
    }

    private fun sendData() {
        var msg = findViewById<EditText>(R.id.mytxt)
        var dataIntent= Intent()
        dataIntent.putExtra("msg",msg.text.toString())
        setResult(RESULT_OK,dataIntent)
        finish()
    }
}