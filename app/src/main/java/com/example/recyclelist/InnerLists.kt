package com.example.recyclelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

public class InnerLists : AppCompatActivity(), View.OnClickListener {

    private lateinit var inRecyclerView: RecyclerView


    val innerList = InnerModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inner_lists)

        inRecyclerView =
            findViewById<RecyclerView>(R.id.inner_recycler_view)
        inRecyclerView.layoutManager = LinearLayoutManager(this)

         val inadapter: INAdapter  = INAdapter(this, innerList)

        inRecyclerView.adapter = inadapter
        // i.d of button = button
        val innerAddButton: Button = findViewById(R.id.inAddButton)

        
        innerAddButton.setOnClickListener(this)


        setTitle(intent.getStringExtra("listTitle"))



    }
    override fun onClick(p0: View?) {

    }




    }
