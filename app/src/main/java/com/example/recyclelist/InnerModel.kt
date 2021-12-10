package com.example.recyclelist

import java.text.SimpleDateFormat
import java.util.Date
import kotlin.collections.ArrayList

public data class innerListElements(var itemTitle : String, var imageUrl : String, var description : String, var tag : String, var date : Date)
public class InnerModel: ArrayList<innerListElements>(){

    init {

           val df = SimpleDateFormat("mm/dd/yyyy")
           for  (i in 0..4)
           {
               add(innerListElements("Title","https://sanctionedforums.com/data/avatars/l/5/5704.jpg?1624828277","description","tag",df.parse("11/9/2001")!!))
           }
           add(innerListElements("Title","https://static.wikia.nocookie.net/leagueoflegends/images/c/c8/04MT005-full.png/revision/latest/scale-to-width-down/1200?cb=20210427042138","temp","tag",df.parse("12/9/2001")!!))

    }
}