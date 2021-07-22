package com.example.myloginapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SmsReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context,"Hi Raju u recived msg",Toast.LENGTH_SHORT).show()
    }
}