package com.example.recyclelist

import org.json.JSONObject
import java.net.URL
import java.util.concurrent.Executors

public data class KoffeeCup(var name: String)
public class KoffeeModel: ArrayList<KoffeeCup>() {
    init {
       val nst = Executors.newSingleThreadExecutor()
       nst.execute{
            val json = URL("http://mec402.boisestate.edu/onejson")
            val jstext = json.readText()
                val jsObject: JSONObject = JSONObject(jstext)
           val jarray = jsObject.getJSONArray("coffee")
            for (i in 0 until jarray.length()) {
                val item = jarray.getJSONObject(i)
                add(KoffeeCup(item.getString("name")))
            }
        }

    }
}