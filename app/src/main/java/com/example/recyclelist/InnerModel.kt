package com.example.recyclelist

import java.text.SimpleDateFormat
import java.util.Date
import kotlin.collections.ArrayList

public data class innerListElements(var itemTitle : String, var imageUrl : String, var description : String, var tag : String, var date : Date)
public class InnerModel: ArrayList<innerListElements>(){

    init {

           val df = SimpleDateFormat("MM/dd/yyyy")
           for  (i in 0..4)
           {
               add(innerListElements("Title $i","https://sanctionedforums.com/data/avatars/l/5/5704.jpg?1624828277","description","tag",df.parse
               ("11/9/2001")!!))
           }
           add(innerListElements("Title","https://static.wikia.nocookie.net/leagueoflegends/images/c/c8/04MT005-full.png/revision/latest/scale-to-width-down/1200?cb=20210427042138","temp","According to all known laws\n" +
                   "of aviation,\n" +
                   "\n" +
                   "  \n" +
                   "there is no way a bee\n" +
                   "should be able to fly.\n" +
                   "\n" +
                   "  \n" +
                   "Its wings are too small to get\n" +
                   "its fat little body off the ground.\n" +
                   "\n" +
                   "  \n" +
                   "The bee, of course, flies anyway\n" +
                   "\n" +
                   "  \n" +
                   "because bees don't care\n" +
                   "what humans think is impossible.\n" +
                   "\n" +
                   "  \n" +
                   "Yellow, black. Yellow, black.\n" +
                   "Yellow, black. Yellow, black.\n" +
                   "\n" +
                   "  \n" +
                   "Ooh, black and yellow!\n" +
                   "Let's shake it up a little.\n" +
                   "\n" +
                   "  \n" +
                   "Barry! Breakfast is ready!\n" +
                   "\n" +
                   "  \n" +
                   "Ooming!\n" +
                   "\n" +
                   "  \n" +
                   "Hang on a second.\n" +
                   "\n" +
                   "  \n" +
                   "Hello?\n" +
                   "\n" +
                   "  \n" +
                   "- Barry?\n" +
                   "- Adam?\n" +
                   "\n" +
                   "  \n" +
                   "- Oan you believe this is happening?\n" +
                   "- I can't. I'll pick you up.\n" +
                   "\n" +
                   "  \n" +
                   "Looking sharp.\n" +
                   "\n" +
                   "  \n" +
                   "Use the stairs. Your father\n" +
                   "paid good money for those.\n" +
                   "\n" +
                   "  \n" +
                   "Sorry. I'm excited.\n" +
                   "\n" +
                   "  \n" +
                   "Here's the graduate.\n" +
                   "We're very proud of you, son.\n" +
                   "\n" +
                   "  \n" +
                   "A perfect report card, all B's.\n" +
                   "\n" +
                   "  \n" +
                   "Very proud.\n" +
                   "\n" +
                   "  \n" +
                   "Ma! I got a thing going here.\n" +
                   "\n" +
                   "  \n" +
                   "- You got lint on your fuzz.\n" +
                   "- Ow! That's me!\n" +
                   "\n" +
                   "  \n" +
                   "- Wave to us! We'll be in row 118,000.\n" +
                   "- Bye!\n" +
                   "\n" +
                   "  \n" +
                   "Barry, I told you,\n" +
                   "stop flying in the house!",df.parse("12/9/2001")!!))

    }
}