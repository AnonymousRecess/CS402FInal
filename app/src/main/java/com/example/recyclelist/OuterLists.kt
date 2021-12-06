package com.example.recyclelist

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

public class OuterLists : AppCompatActivity(), View.OnClickListener {
    private lateinit var outRecyclerView: RecyclerView
    private lateinit var alertDialog: AlertDialog
    val outerList = OuterModel() //TODO Create OuterModel class
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.outer_lists)

        outRecyclerView =
            findViewById<RecyclerView>(R.id.outer_recycler_view)
        outRecyclerView.layoutManager = LinearLayoutManager(this)

        val outadapter: OUTAdapter  = OUTAdapter(this, outerList)

        outRecyclerView.adapter = outadapter
        // i.d of button = button
        val outerAddButton: Button = findViewById(R.id.outAddButton) // TODO Add out add button
        

        outerAddButton.setOnClickListener(this)
    }
        override fun onClick(p0: View?) {
            //TODO("Not yet implemented")

            showDialog("Create a new List")

        }
        private fun showDialog(title: String){
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage(title).setView(layoutInflater.inflate(R.layout.fragment_list, null))
            .setPositiveButton("Confirm", DialogInterface.OnClickListener{ dialog, id-> addList(
                dialog as Dialog)})
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, id -> dialog.cancel()})

            alertDialog = dialogBuilder.create()
            alertDialog.show()
        }

        fun addList(dialog: Dialog){

            val textBox = alertDialog.findViewById<EditText>(R.id.listDialogTitle)

            outerList.add(outerListElements(textBox?.getText().toString()))
            outRecyclerView.adapter?.notifyDataSetChanged()

            dialog.dismiss()
        }
    
}