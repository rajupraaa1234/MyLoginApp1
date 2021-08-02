package com.example.myloginapp

import android.annotation.SuppressLint
import android.content.AsyncQueryHandler
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myloginapp.MyServices.MyServicesActivity
import com.example.myloginapp.ui.AsyncTaskActivity
import com.example.myloginapp.ui.WebServicesActivity

class MainActivity : AppCompatActivity() {
//this is a new change
    lateinit var etname : EditText;   // declaration
    lateinit var textView: TextView
    lateinit var focus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var country = arrayOf("India","Pakistan","USA")


        //PopUp Menu
        var popup = findViewById(R.id.popup) as Button
        var rec = findViewById<Button>(R.id.rec)

        rec.setOnClickListener(View.OnClickListener {
            var RecIntent : Intent
            RecIntent =Intent(this,RecyclerViewActivity::class.java)
            startActivity(RecIntent)
        })
        popup.setOnClickListener(View.OnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,popup)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.one ->
                        Toast.makeText(this@MainActivity, "You Clicked one : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.two ->
                        Toast.makeText(this@MainActivity, "You Clicked two: " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.three ->
                        Toast.makeText(this@MainActivity, "You Clicked three: " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        })


        var  check = findViewById(R.id.check) as Button
          focus = findViewById(R.id.focus)

        var spinner = findViewById<Spinner>(R.id.spinner) as Spinner
        check.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Hay This is onActivityResult "  ,Toast.LENGTH_SHORT).show()
        })
        var home_btn = findViewById(R.id.home) as Button
        etname = findViewById(R.id.name);

        textView = findViewById(R.id.mytxt)

        //Set Adapter
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,country)
        spinner.adapter = adapter



        //Add Focus
        focus.setOnClickListener(View.OnClickListener {
            focus.setBackgroundResource(R.drawable.green_back);
        })


        focus.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                changecolor()
            else {
                changeDefaultColor()
            }
        }

//        focus.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
//
//            focus.setBackgroundResource(R.drawable.yellow);
//        }
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

    private fun changeDefaultColor() {
        focus.setBackgroundResource(R.drawable.btn_back);
    }

    @SuppressLint("ResourceAsColor")
    private fun changecolor() {
        Toast.makeText(this,"On Focus"  ,Toast.LENGTH_SHORT).show()
        //focus.setBackgroundResource(R.drawable.yellow);
        focus.setBackgroundColor(R.drawable.yellow)
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
            R.id.service->{openServiceActivity()}
            R.id.alarm ->{setAlarm()}
            R.id.web->{openWebServicesActivity()}
        }
    }

    private fun openWebServicesActivity() {
        var HomeIntent : Intent
        HomeIntent =Intent(this, WebServicesActivity::class.java)
        startActivity(HomeIntent)
    }

    private fun setAlarm() {
        var HomeIntent : Intent
        HomeIntent =Intent(this,MyAlarmActivity::class.java)
        startActivity(HomeIntent)
    }

    private fun openServiceActivity() {
        var HomeIntent : Intent
        HomeIntent =Intent(this,MyServicesActivity::class.java)
        startActivity(HomeIntent)
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
        HomeIntent =Intent(this,AsyncTaskActivity::class.java)
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