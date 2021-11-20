package com.example.recyclelist


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


var combindedList = arrayListOf<KoffeeCup>()


    class KAdapter(context: Context, var coffee: KoffeeModel)
        : RecyclerView.Adapter<KAdapter.KoffeeHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : KAdapter.KoffeeHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

            return KoffeeHolder(view, parent, coffee)


        }



        override fun getItemCount() = coffee.size

        override fun onBindViewHolder(holder: KoffeeHolder, position: Int) {
           holder.setIsRecyclable(false)
            val acoffee = coffee[position]
            val imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Boise_State_%22B%22_logo.svg/1200px-Boise_State_%22B%22_logo.svg.png"
            Glide.with(holder.itemView.getContext()).load(imageURL).into(holder.imageView)
            holder.apply {
                titleTextView.text = acoffee.name

//                var kSelect = acoffee.selection
//                if (kSelect)
//                {
//                    holder.selected.setChecked(true)
//                    combindedList.add(coffee[position])
//
//                }
//                selected.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener() { buttonView, isChecked ->
//                    if(isChecked) {
//                        combindedList.add(coffee[position])
//
//                        Log.d("RecycleList",combindedList.toString())
//                    } else {
//
//                        combindedList.remove(coffee[position])
//                        holder.selected.setChecked(false)
//                        Log.d("RecycleList",combindedList.toString())
//                    }
            }

        }
        class KoffeeHolder(v: View, parent: ViewGroup, coffee: ArrayList<KoffeeCup>) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnLongClickListener{
            val titleTextView: TextView = v.findViewById(R.id.coffee_name) //TODO: Rename this to title
            val imageView: ImageView = v.findViewById(R.id.imageView)
            //TODO: Add more properties to the item_view.xml
            //TODO: Add a url property to the KoffeeModel and consume that in the onBindViewAdapter instead of the hard coded url
            //val descriptionTextView: TextView = v.findViewById(R.id.description) //Possibly rename to description??
            //val tagsTextView: TextView = v.findViewById(R.id.tags)
            //val dateTextView: TextView = v.findViewById(R.id.date)
            val alertDialog = AlertDialog.Builder(parent.context)

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
                coffeeHold.remove(KoffeeCup(name, false))
              //  this.bindingAdapter?.notifyDataSetChanged()
                //this@KoffeeHolder.getBindingAdapter()
                //super.getBindingAdapter()
            }

            override fun onLongClick(p0: View?): Boolean {

                val first : String = titleTextView.text.toString().substring(0,titleTextView.text.toString().length/2)
                val second : String = titleTextView.text.toString().substring(titleTextView.text.toString().length/2 ,titleTextView.text.toString().length)
                Log.d("RecycleList", first)
                Log.d("RecycleList", second)

                coffeeHold.add(KoffeeCup(first, false))
                coffeeHold.add(KoffeeCup(second, false))

                onRemove(titleTextView.text.toString())


                return true
            }


        }


    }
