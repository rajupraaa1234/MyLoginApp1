package com.example.myloginapp.MyServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myloginapp.R

class MyServicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_services)
    }

    fun servicesClickHandler(view : View){
        when(view.id){
            R.id.stopservice ->{
                var serviceIntent = Intent(this,MyService::class.java)
                startService(serviceIntent)
            }
            R.id.startservice->{
                var serviceIntent = Intent(this,MyService::class.java)
                stopService(serviceIntent)
            }
        }
    }

}