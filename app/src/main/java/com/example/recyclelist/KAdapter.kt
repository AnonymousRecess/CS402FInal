package com.example.recyclelist


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    public class KAdapter(context: Context, var coffee: ArrayList<String>)
        : RecyclerView.Adapter<KAdapter.KoffeeHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : KAdapter.KoffeeHolder {
            val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false)
            return KoffeeHolder(view)
        }



        override fun getItemCount() = coffee.size

        override fun onBindViewHolder(holder: KoffeeHolder, position: Int) {
            val acoffee = coffee[position]
            holder.apply {
                titleTextView.text = acoffee
            }
        }
        class KoffeeHolder(view: View) : RecyclerView.ViewHolder(view) {

            val titleTextView: TextView = view.findViewById(R.id.coffee_name)

        }


    }
