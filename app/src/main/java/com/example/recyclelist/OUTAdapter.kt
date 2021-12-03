package com.example.recyclelist

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OUTAdapter(context: Context, var outerArray: OuterModel)
    : RecyclerView.Adapter<OUTAdapter.OuterHolder>() {

    class OuterHolder(v: View, parent: ViewGroup, outItem: ArrayList<innerListElements>) : RecyclerView.ViewHolder(v), View.OnClickListener{
        val titleTextView: TextView = v.findViewById(R.id.coffee_name) //TODO: Rename this to title
        


        val outHold = outItem

        init {

            v.setOnClickListener(this)

        }
        override fun onClick(v: View?) {
           

        }


        fun onRemove(name: String) {
           

        }

       


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: OuterHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}