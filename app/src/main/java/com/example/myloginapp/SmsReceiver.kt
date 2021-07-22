package com.example.myloginapp

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi


class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("MyReciever","onRecieved")
        if (intent!!.action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            Log.i("MyReciever","Recieved")
            val bundle = intent!!.extras //---get the SMS message passed in---
            var msgs: Array<SmsMessage?>? = null
            var msg_from: String
            if (bundle != null) {
                //---retrieve the SMS message received---
                try {
                    val pdus = bundle["pdus"] as Array<Any>?
                    msgs = arrayOfNulls<SmsMessage>(pdus!!.size)
                    for (i in msgs.indices) {
                        msgs!![i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
                        msg_from = msgs[i]?.getOriginatingAddress().toString()
                        val msgBody: String = msgs[i]?.getMessageBody().toString()
                        Toast.makeText(context, msgBody, Toast.LENGTH_SHORT).show()

                    }
                } catch (e: Exception) {
                    //                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }
}