package com.example.recyclelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

public class InnerLists : AppCompatActivity(), View.OnClickListener {

    private lateinit var inRecyclerView: RecyclerView


    val innerList = InnerModel()
    var displayList = mutableListOf<String>()

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        var item: MenuItem = menu!!.findItem(R.id.action_search)

        if(item != null) {
            var searchView = item.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                //searchView.setOnQueryTextListener()
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        var search = newText.lowercase(Locale.getDefault())

                        for (list in innerList.listIterator().toString()) {
                            if (list.lowercase(Locale.getDefault()).contains(search)) {
                                displayList.add(list.toString())
                            }
                            inRecyclerView.adapter?.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(innerListElements)
                        inRecyclerView.adapter?.notifyDataSetChanged()

                    }
                    return true
                }


            })
        }
        return super.onCreateOptionsMenu(menu)
}



