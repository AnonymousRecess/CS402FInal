package com.example.recyclelist

public data class innerListElements(var name: String, var selection: Boolean)
public class InnerModel: ArrayList<innerListElements>() {

    init {

           for  (i in 0..4)
           {
               add(innerListElements("placeholder", false))
           }

    }
}