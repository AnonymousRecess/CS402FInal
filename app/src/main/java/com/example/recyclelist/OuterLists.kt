package com.example.recyclelist

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

public class OuterLists : AppCompatActivity(), View.OnClickListener {
    private lateinit var outRecyclerView: RecyclerView
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
        val innerAddButton: Button = findViewById(R.id.outAddButton) // TODO Add out add button
        

        innerAddButton.setOnClickListener(this)
    }
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
           
        }
    
}