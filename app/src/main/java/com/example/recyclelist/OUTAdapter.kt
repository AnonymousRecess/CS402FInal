package com.example.recyclelist

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class OUTAdapter(context: Context, var outerArray: OuterModel)
    : RecyclerView.Adapter<OUTAdapter.OuterHolder>() {

    class OuterHolder(v: View, parent: ViewGroup, outItem: OuterModel) : RecyclerView.ViewHolder(v), View.OnClickListener{
        val titleTextView: TextView = v.findViewById(R.id.listTitle) //TODO: Rename this to title
        


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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lists_view, parent, false)
        return OuterHolder(view, parent, outerArray)
    }

    override fun onBindViewHolder(holder: OuterHolder, position: Int) {
        holder.setIsRecyclable(false)
        val outerListItem = outerArray[position]
        holder.apply {
            titleTextView.text = outerListItem.name
        }
    }

    override fun getItemCount() = outerArray.size
}