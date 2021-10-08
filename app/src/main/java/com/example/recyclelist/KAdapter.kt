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
import android.widget.*
import androidx.recyclerview.widget.RecyclerView




var combindedList = arrayListOf<String>()
    class KAdapter(context: Context, var coffee: ArrayList<String>)
        : RecyclerView.Adapter<KAdapter.KoffeeHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : KAdapter.KoffeeHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

            return KoffeeHolder(view, parent, coffee)


        }

        fun getJoined(): ArrayList<String> = combindedList

        override fun getItemCount() = coffee.size

        override fun onBindViewHolder(holder: KoffeeHolder, position: Int) {
            holder.setIsRecyclable(false)
            val acoffee = coffee[position]
            holder.apply {
                titleTextView.text = acoffee
                selected.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener() { buttonView, isChecked ->
                    if(isChecked) {
                        combindedList.add(coffee[position])

                        Log.d("RecycleList",combindedList.toString())
                    } else {

                        combindedList.remove(coffee[position])
                        holder.selected.setChecked(false)
                        Log.d("RecycleList",combindedList.toString())
                    }
                })
            }

        }
        class KoffeeHolder(v: View, parent: ViewGroup, coffee: ArrayList<String>) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener{
            val titleTextView: TextView = v.findViewById(R.id.coffee_name)
            val alertDialog = AlertDialog.Builder(parent.context)
            val selected: CheckBox =  v.findViewById(R.id.cbSelect)
            val coffeeHold = coffee

            init {

                v.setOnClickListener(this)
                v.setOnLongClickListener(this)

            }
            override fun onClick(v: View?) {
                alertDialog.setTitle("Removal of Item")
                alertDialog.setMessage("Remove the Item?")
                alertDialog.setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                       onRemove(titleTextView.text.toString())
                        Log.d("RecycleList",coffeeHold.toString())
                        //super.getBindingAdapter()
                        //v?.invalidate()
                    })
                alertDialog.show()

            }


            fun onRemove(name: String) {
                coffeeHold.remove(name)
                this.bindingAdapter?.notifyDataSetChanged()
                //this@KoffeeHolder.getBindingAdapter()
                //super.getBindingAdapter()
            }

            override fun onLongClick(p0: View?): Boolean {

                val first : String = titleTextView.text.toString().substring(0,titleTextView.text.toString().length/2)
                val second : String = titleTextView.text.toString().substring(titleTextView.text.toString().length/2 ,titleTextView.text.toString().length)
                Log.d("RecycleList", first)
                Log.d("RecycleList", second)

                coffeeHold.add(first)
                coffeeHold.add(second)

                onRemove(titleTextView.text.toString())


                return true
            }


        }


    }
