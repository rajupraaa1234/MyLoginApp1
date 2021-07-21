package com.example.myloginapp

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myloginapp.interfacePackage.OnClickListner

class RecAdapter(context : RecyclerViewActivity,data:Array<String>) :RecyclerView.Adapter<RecAdapter.ViewHolder>() {

    var context : Context = context
    var arr : Array<String> = data
    var onclickItem : OnClickListner = context

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
       var textview : TextView = itemView.findViewById(R.id.txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textview.text = arr[position]
        holder.textview.setOnClickListener(View.OnClickListener {
            onclickItem.onItemClick(position)
        })
    }

    override fun getItemCount(): Int {
       return arr.size
    }

}