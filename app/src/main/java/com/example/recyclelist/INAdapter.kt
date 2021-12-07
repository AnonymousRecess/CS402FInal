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
import java.text.SimpleDateFormat


var combindedList = arrayListOf<innerListElements>()


    class INAdapter(context: Context, var innerArray: InnerModel)
        : RecyclerView.Adapter<INAdapter.InnerHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : INAdapter.InnerHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
            return InnerHolder(view, parent, innerArray)


        }



        override fun getItemCount() = innerArray.size

        override fun onBindViewHolder(holder: InnerHolder, position: Int) {
            holder.setIsRecyclable(false)
            val innerListItem = innerArray[position]
            //val imageURL = "https://static.wikia.nocookie.net/leagueoflegends/images/c/c8/04MT005-full.png/revision/latest/scale-to-width-down/1200?cb=20210427042138"
            Glide.with(holder.itemView.getContext()).load(innerListItem.imageUrl).into(holder.imageView)
            val df = SimpleDateFormat("mm/dd/yyyy")
            holder.apply {
                titleTextView.text = innerListItem.itemTitle
                dateTextView.text = df.format(innerListItem.date)
                descriptionTextView.text = innerListItem.description
                tagTextView.text = innerListItem.tag
            }

        }
        class InnerHolder(v: View, parent: ViewGroup, inItem: ArrayList<innerListElements>) : RecyclerView.ViewHolder(v), View.OnClickListener{
            val titleTextView: TextView = v.findViewById(R.id.inner_item_title) //TODO: Rename this to title
            val imageView: ImageView = v.findViewById(R.id.imageView)
            //TODO: Add more properties to the item_view.xml    DONE
            //TODO: Add a url property to the KoffeeModel and consume that in the onBindViewAdapter instead of the hard coded url
            val descriptionTextView: TextView = v.findViewById(R.id.itemDescription) //Possibly rename to description??
            val dateTextView: TextView = v.findViewById(R.id.dateTextView)
            val tagTextView: TextView = v.findViewById(R.id.tagView)
            val alertDialog = AlertDialog.Builder(parent.context)


            val inHold = inItem

            init {

                v.setOnClickListener(this)
//                v.setOnLongClickListener(this)

            }
            override fun onClick(v: View?) {
                alertDialog.setTitle("Removal of Item")
                alertDialog.setMessage("Remove the Item?")
                alertDialog.setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                       onRemove(titleTextView.text.toString())
                        Log.d("RecycleList",inHold.toString())
                    })
                alertDialog.show()

            }


            fun onRemove(name: String) {
//                inHold.remove(innerListElements(name, false))

            }

//            override fun onLongClick(p0: View?): Boolean {
//
//                val first : String = titleTextView.text.toString().substring(0,titleTextView.text.toString().length/2)
//                val second : String = titleTextView.text.toString().substring(titleTextView.text.toString().length/2 ,titleTextView.text.toString().length)
//                Log.d("RecycleList", first)
//                Log.d("RecycleList", second)
//
//                inHold.add(innerListElements(first, false))
//                inHold.add(innerListElements(second, false))
//
//                onRemove(titleTextView.text.toString())
//
//
//                return true
//            }


        }


    }
