package com.example.recyclelist
import kotlin.collections.ArrayList
public data class outerListElements(var name:String)
class OuterModel: ArrayList<outerListElements>() {
    init {
        add(outerListElements("Grocery List"))
        add(outerListElements("To-Do List"))
        add(outerListElements("PC Parts"))
    }
}