package com.example.myloginapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        var  check = findViewById(R.id.check) as Button
        check.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Hay This is onActivityResult "  ,Toast.LENGTH_SHORT).show()
        })
        var home_btn = findViewById(R.id.home) as Button
        etname = findViewById(R.id.name);

        textView = findViewById(R.id.mytxt)

//        home_btn.setOnClickListener(View.OnClickListener {
//
//        })
//        home_btn.setOnClickListener {
//            var HomeIntent : Intent
//            HomeIntent =Intent(this,HomeActivity::class.java)
//            HomeIntent.putExtra("MyKey","Hii Raju")
//            startActivity(HomeIntent)
//
//        }
//
//        btn_new_activity.setOnClickListener {
//            var name = etname.text.toString()
//            textView.setText(name)
//            var sum = add(10,20)
//            Toast.makeText(this," Hii " + name+ sum,Toast.LENGTH_SHORT).show();
//        }
    }

    fun add(a : Int,b : Int) : Int{
        return a+b
    }

    fun ClickHandler(view: View){
        when(view.id){
            R.id.login->{loginbtn()}
            R.id.home->{goHome()}
            R.id.google->{openGoogle()}
            R.id.dail->{openDail()}
            R.id.sarf->{openCamera()}
        }
    }

    private fun openCamera() {
          var intent=Intent(this,HomeActivity::class.java)
               startActivityForResult(intent,123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==123 && resultCode==RESULT_OK){
             var msg = data?.getStringExtra("msg")
             Toast.makeText(this,"Hay This is onActivityResult " + msg ,Toast.LENGTH_SHORT).show()
        }
    }

    private fun openDail() {
        var gIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:123456789"))
        startActivity(gIntent)
    }

    private fun openGoogle() {
        var gIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/"))
        startActivity(gIntent)
    }

    private fun goHome() {
        var HomeIntent : Intent
        HomeIntent =Intent(this,HomeActivity::class.java)
        HomeIntent.putExtra("MyKey","Hii Raju")
        startActivity(HomeIntent)
    }

    private fun loginbtn() {
        var name = etname.text.toString()
        textView.setText(name)
        var sum = add(10,20)
        Toast.makeText(this," Hay " + name+ sum,Toast.LENGTH_SHORT).show();
    }

}