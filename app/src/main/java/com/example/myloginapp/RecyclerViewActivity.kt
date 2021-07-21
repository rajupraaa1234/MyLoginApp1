package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myloginapp.interfacePackage.OnClickListner
import java.text.FieldPosition

class RecyclerViewActivity : AppCompatActivity(), OnClickListner{
    var data = arrayOf("Raju kumar","Rahul kumar gupta","Raja kumar","Ankit kumar","Anmol kumar")

    lateinit var adapter: RecAdapter

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView =  findViewById(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RecAdapter(this,data)

        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Hello ${data[position]}",Toast.LENGTH_SHORT).show()
    }
}