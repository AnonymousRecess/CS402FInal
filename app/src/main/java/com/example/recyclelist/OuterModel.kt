package com.example.recyclelist
import kotlin.collections.ArrayList
public data class outerListElements(var name:String)
class OuterModel: ArrayList<outerListElements>() {
    init {
        add(outerListElements("Title1"))
        add(outerListElements("Title2"))
        add(outerListElements("Title3"))
    }
}