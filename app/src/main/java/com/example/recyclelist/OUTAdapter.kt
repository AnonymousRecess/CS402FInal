package com.example.recyclelist

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class OUTAdapter(context: Context, var outerArray: OuterModel)
    : RecyclerView.Adapter<OUTAdapter.OuterHolder>() {

    inner class OuterHolder(v: View, parent: ViewGroup, outItem: OuterModel) : RecyclerView.ViewHolder(v), View.OnClickListener, View
    .OnLongClickListener{
        val titleTextView: TextView = v.findViewById(R.id.listTitle) //TODO: Rename this to title
        private lateinit var removeOutDialog: androidx.appcompat.app.AlertDialog


        val outHold = outItem

        init {

            v.setOnClickListener(this)
            v.setOnLongClickListener(this)

        }
        override fun onClick(v: View) {
            val name = outHold[bindingAdapterPosition].name
            val switchActivityIntent  = Intent(v.getContext(), InnerLists::class.java).apply {
                putExtra("listTitle", name)

           }
            v.getContext().startActivity(switchActivityIntent)
        }


        fun onRemove(name: String) {
           

        }

        override fun onLongClick(p0: View?): Boolean {
            showRemoveOuterDialog("Remove List?", p0, bindingAdapterPosition)
                    return true
        }
        private fun showRemoveOuterDialog(title: String, p0: View?, position: Int) {
            val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(p0!!.getContext())
                .setMessage(title)
                .setPositiveButton("Confirm", DialogInterface.OnClickListener{ dialog, id-> removeList(position)})
                .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, id -> dialog.cancel()})

            removeOutDialog = dialogBuilder.create()
            removeOutDialog.show()
        }
        private fun removeList(bindingPos: Int){
            outerArray.removeAt(bindingPos)
            notifyDataSetChanged()
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