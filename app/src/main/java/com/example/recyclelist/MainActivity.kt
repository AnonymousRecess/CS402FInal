package com.example.recyclelist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var kRecyclerView: RecyclerView


    val koffeeList = KoffeeModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kRecyclerView =
            findViewById<RecyclerView>(R.id.coffee_recycler_view)
        kRecyclerView.layoutManager = LinearLayoutManager(this)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
            val imageView = ImageView(this)
        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Boise_State_%22B%22_logo.svg/1200px-Boise_State_%22B%22_logo.svg.png").into(imageView)
        linearLayout.addView(imageView)
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
//        if (p0?.id == R.id.button) {
//            var enteredText: String
//            val alertDialog = AlertDialog.Builder(this)
//            alertDialog.setTitle("Add")
//            alertDialog.setMessage("Name of Item to Add?")
//            val input: EditText = EditText(this)
//            input.setHint("Enter Text")
//            input.inputType = InputType.TYPE_CLASS_TEXT
//            alertDialog.setPositiveButton("ok",
//                DialogInterface.OnClickListener { dialog, id ->
//                    enteredText = input.getText().toString()
//                    koffeeList.add(KoffeeCup(enteredText,false))
//                   kRecyclerView.adapter?.notifyDataSetChanged()
//                })
//            alertDialog.setView(input)
//            alertDialog.show()
//        }
//        else {
//            val checked: CheckBox = findViewById(R.id.cbSelect)
//            koffeeList.add(KoffeeCup(combindedList.toString(), false))
//            // Testing here
//
//
//
//            for (i in combindedList) {koffeeList.remove(i) }
//
//            if(checked.isChecked)
//            {
//                checked.isChecked=false
//            }
//
//
//
//            kRecyclerView.adapter?.notifyDataSetChanged()
//
//
//        }
    }




    }
