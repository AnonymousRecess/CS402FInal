package com.example.recyclelist

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var kRecyclerView: RecyclerView
    val koffeeList = arrayListOf<String>("Arabic", "Robusta","Sumatra","Kona")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kRecyclerView =
            findViewById<RecyclerView>(R.id.coffee_recycler_view)
        kRecyclerView.layoutManager = LinearLayoutManager(this)

        val kadapter: KAdapter  = KAdapter(this, koffeeList)

        kRecyclerView.adapter = kadapter
        // i.d of button = button
        val clickButton: Button = findViewById(R.id.button)

        clickButton.text = "Add"
        clickButton.setOnClickListener(this)

        val joinButton: Button = findViewById(R.id.button2)

        joinButton.text = "Join"
        joinButton.setOnClickListener(this)



    }


    override fun onClick(p0: View?) {
        if (p0?.id == R.id.button) {
            var enteredText: String
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Add")
            alertDialog.setMessage("Name of Item to Add?")
            val input: EditText = EditText(this)
            input.setHint("Enter Text")
            input.inputType = InputType.TYPE_CLASS_TEXT
            alertDialog.setPositiveButton("ok",
                DialogInterface.OnClickListener { dialog, id ->
                    enteredText = input.getText().toString()
                    koffeeList.add(enteredText)
                })
            alertDialog.setView(input)
            alertDialog.show()
        }
        else {
            val checked: CheckBox = findViewById(R.id.cbSelect)
            koffeeList.add(combindedList.toString())
           for (i in combindedList) {koffeeList.remove(i) }

            if(checked.isChecked)
            {
                checked.isChecked=false
            }



            kRecyclerView.adapter?.notifyDataSetChanged()

            combindedList = arrayListOf<String>()
        }
    }


    }
