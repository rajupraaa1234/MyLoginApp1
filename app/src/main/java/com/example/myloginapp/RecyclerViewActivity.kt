package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myloginapp.Dialog.ExampleDialog
import com.example.myloginapp.interfacePackage.OnClickListner
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewActivity : AppCompatActivity(), OnClickListner,ExampleDialog.ExampleDialogListener{
    var data : ArrayList<String> = ArrayList<String>()




    //var data = arrayOf("Raju kumar","Rahul kumar gupta","Raja kumar","Ankit kumar","Anmol kumar")

    lateinit var adapter: RecAdapter

    lateinit var recyclerView: RecyclerView
    lateinit var send : Button
    lateinit var msg : EditText
    lateinit var myflotingbtn : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView =  findViewById(R.id.recycle)
        send = findViewById(R.id.add)
        msg = findViewById(R.id.addtxt)
        myflotingbtn = findViewById(R.id.floatingbtn)

        data.add("Raju kumar")
        data.add("Rahul kumar gupta")
        data.add("Sonu kumar")
        data.add("Rakesh kumar")

        //Add Floating task
        myflotingbtn.setOnClickListener(View.OnClickListener {
            var exampleDialog : ExampleDialog  = ExampleDialog();
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecAdapter(this,data)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Hello ${data[position]}",Toast.LENGTH_SHORT).show()
    }

    override fun applyTexts(username: String?) {
        if (username != null) {
            data.add(username)
        }
            adapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(data.size)
    }
}