package com.example.recyclelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var kRecyclerView: RecyclerView
    val koffeeList = arrayListOf<String>("Arabic", "Robusta","Sumatra","Kona")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kRecyclerView =
            findViewById(R.id.coffee_recycler_view) as RecyclerView
        kRecyclerView.layoutManager = LinearLayoutManager(this)

        val kadapter: KAdapter  = KAdapter(this, koffeeList)

        kRecyclerView.setAdapter(kadapter)

    }
}