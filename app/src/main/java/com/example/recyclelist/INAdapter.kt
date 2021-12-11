package com.example.recyclelist


import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import android.widget.LinearLayout





private lateinit var addDialog: androidx.appcompat.app.AlertDialog
private lateinit var removeDialog: androidx.appcompat.app.AlertDialog
private var isImageFitToScreen: Boolean = false


    class INAdapter(context: Context, var innerDisplayArray: InnerModel, var innerArray: InnerModel)
        : RecyclerView.Adapter<INAdapter.InnerHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : INAdapter.InnerHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
            return InnerHolder(view, parent, innerDisplayArray)


        }



        override fun getItemCount() = innerDisplayArray.size

        override fun onBindViewHolder(holder: InnerHolder, position: Int) {
            holder.setIsRecyclable(false)
            val innerListItem = innerDisplayArray[position]
            //val imageURL = "https://static.wikia.nocookie.net/leagueoflegends/images/c/c8/04MT005-full.png/revision/latest/scale-to-width-down/1200?cb=20210427042138"
            Glide.with(holder.itemView.getContext()).load(innerListItem.imageUrl).into(holder.imageView)
            val df = SimpleDateFormat("MM/dd/yyyy")
            holder.apply {
                titleTextView.text = innerListItem.itemTitle
                dateTextView.text = df.format(innerListItem.date)
                descriptionTextView.text = innerListItem.description
                tagTextView.text = innerListItem.tag
            }

        }
        inner class InnerHolder(v: View, parent: ViewGroup, inItem: ArrayList<innerListElements>) : RecyclerView.ViewHolder(v), View.OnClickListener,
        View.OnLongClickListener{
            val titleTextView: TextView = v.findViewById(R.id.inner_item_title) //TODO: Rename this to title
            val imageView: ImageView = v.findViewById(R.id.imageView)
            //TODO: Add more properties to the item_view.xml    DONE
            //TODO: Add a url property to the KoffeeModel and consume that in the onBindViewAdapter instead of the hard coded url
            val descriptionTextView: TextView = v.findViewById(R.id.itemDescription) //Possibly rename to description??
            val dateTextView: TextView = v.findViewById(R.id.dateTextView)
            val tagTextView: TextView = v.findViewById(R.id.tagView)
            val addDialogBuilder = androidx.appcompat.app.AlertDialog.Builder(parent.context)

            val inHold = inItem
            val view : View = v
            init {
                imageView.setOnClickListener {showImage()}
                v.setOnClickListener(this)
                v.setOnLongClickListener(this)

            }

            fun showImage(){
                if(isImageFitToScreen) {
                    isImageFitToScreen = false;
                    imageView.setLayoutParams(RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT));
                    val params: ViewGroup.MarginLayoutParams = imageView!!.layoutParams as ViewGroup.MarginLayoutParams
                    val factor =  view.context.resources.displayMetrics.density
                    params.topMargin = (20 * factor).toInt()
                    params.width = (129 * factor).toInt()
                    params.height = (120 * factor).toInt()

                    imageView.setAdjustViewBounds(true);

                }
                else{
                    isImageFitToScreen = true
                    imageView.layoutParams =
                        RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT)
                    imageView.scaleType = ImageView.ScaleType.FIT_XY
                }
            }

            override fun onClick(v: View?) {
//                addDialogBuilder.setTitle("Removal of Item")
//                addDialogBuilder.setMessage("Remove the Item?")
//                addDialogBuilder.setPositiveButton("Yes",
//                    DialogInterface.OnClickListener { dialog, id ->
//                       onRemove(titleTextView.text.toString())
//                        Log.d("RecycleList",inHold.toString())
//                    })
//                addDialog = addDialogBuilder.create()
//                addDialog.show()

            }




            override fun onLongClick(p0: View?): Boolean {

                showRemoveInnerDialog("Remove an item from the list?", p0, bindingAdapterPosition)




                //inHold.removeAt()

                return true
            }
            private fun showRemoveInnerDialog(title: String, p0: View?, position: Int){

                val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(p0!!.getContext())
                    .setMessage(title)
                    .setPositiveButton("Confirm", DialogInterface.OnClickListener{ dialog, id-> removeItem(position)})
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, id -> dialog.cancel()})

                removeDialog = dialogBuilder.create()
                removeDialog.show()
            }


            private fun removeItem(bindingPos: Int){
                    innerArray.remove(innerDisplayArray.get(bindingPos))
                    innerDisplayArray.removeAt(bindingPos)

                    notifyDataSetChanged()
            }

        }



    }
