package com.example.myloginapp.MyServices

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import com.example.myloginapp.R

class MyServicesActivity : AppCompatActivity() {

    private lateinit var mService: MyBoundServices
    private var mBound: Boolean = false

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
            R.id.boundservice->{
                if (mBound) {
                    // Call a method from the LocalService.
                    // However, if this call were something that might hang, then this request should
                    // occur in a separate thread to avoid slowing down the activity performance.
                    val num: Int = mService.randomNumber
                    Toast.makeText(this, "number: $num", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    /** Defines callbacks for service binding, passed to bindService()  */
    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as MyBoundServices.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        // Bind to LocalService
        Intent(this, MyBoundServices::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }


}