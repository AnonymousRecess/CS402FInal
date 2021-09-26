package com.example.recyclelist


import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


    public class KAdapter(context: Context, var coffee: ArrayList<String>)
        : RecyclerView.Adapter<KAdapter.KoffeeHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : KAdapter.KoffeeHolder {
            val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false)

            return KoffeeHolder(view, parent, coffee)

        }



        override fun getItemCount() = coffee.size

        override fun onBindViewHolder(holder: KoffeeHolder, position: Int) {
            val acoffee = coffee[position]
            holder.apply {
                titleTextView.text = acoffee
            }

        }
        class KoffeeHolder(v: View, parent: ViewGroup, coffee: ArrayList<String>) : RecyclerView.ViewHolder(v), View.OnClickListener {
            val titleTextView: TextView = v.findViewById(R.id.coffee_name)
            val alertDialog = AlertDialog.Builder(parent.context)
            val coffee2 = coffee
            init {
                v.setOnClickListener(this)


            }
            override fun onClick(v: View?) {
                alertDialog.setTitle("Remove")
                alertDialog.setMessage("Do you want to remove this item?")
                alertDialog.setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                       onRemove(titleTextView.text.toString())
                        Log.d("RecycleList",coffee2.toString())
                    })
                alertDialog.show()

            }

            fun onRemove(name: String) {
                coffee2.remove(name)
                this.bindingAdapter?.notifyDataSetChanged()

            }

        }


    }
