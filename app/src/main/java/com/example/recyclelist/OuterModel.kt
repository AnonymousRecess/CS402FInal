package com.example.recyclelist
import kotlin.collections.ArrayList
public data class innerLists(var name:String)
class OuterModel: ArrayList<innerLists>() {
    init {
        add(innerLists("Title"))
    }
}