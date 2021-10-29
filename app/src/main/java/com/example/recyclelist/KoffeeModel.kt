package com.example.recyclelist

import android.util.Log
import org.json.JSONObject
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

public data class KoffeeCup(var name: String, var selection: Boolean)
public class KoffeeModel: ArrayList<KoffeeCup>() {
    init {
       val nst = Executors.newSingleThreadExecutor()
       nst.execute{
            val json = URL("http://mec402.boisestate.edu/cgi-bin/cs402/lenjson")
            val jslength= json.readText()
//           add(KoffeeCup(jstext, true))
//           add(KoffeeCup("Test", false))

                val jsObject: JSONObject = JSONObject(jslength)
             val length = jsObject.getInt("length")
       //    val length = 9;

           val blockSize = length/5;
           val parts = length/blockSize;
           var curr = 0;
           var objLeft = length;
           var end = 0;
           var start = 0;
           Log.d("RecycleList", length.toString())

           for  (i in 0..length-1)
           {
               add(KoffeeCup("placeholder", false))
           }




               for (i in curr until parts) {

                   Log.d("RecycleList", i.toString() + " hello")
                   if (end + blockSize > length) {
                       end = length;
                   } else {
                       end += blockSize;
                   }
                   val json2 =
                       URL("http://mec402.boisestate.edu/cgi-bin/cs402/pagejson?start=" + curr + "&stop=" + end);
                   val block1 = json2.readText()
                   val js2Object: JSONObject = JSONObject(block1)
                   Log.d("RecycleList", blockSize.toString())
                   start = 0;


                   for (i in curr until end) {

                       val jArray2 = js2Object.getJSONArray("data")
                       val item2 = jArray2.getJSONObject(start)

                       Log.d("RecycleList", i.toString() + " variables" + " " + end.toString())
                       Log.d("RecycleList",
                           i.toString() + " goodbye" + item2.getString("name") + start.toString())
                       add(i, KoffeeCup(item2.getString("name"), item2.getBoolean("selected")))

                       curr++;
                       start++;
                   }

                   Thread.sleep(10000);

               }


//           val jarray = jsObject.getJSONArray("coffee")
//            for (i in 0 until jarray.length()) {
//                val item = jarray.getJSONObject(i)
//                add(KoffeeCup(item.getString("name"), item.getBoolean("selected")))
//            }

        }


    }
}