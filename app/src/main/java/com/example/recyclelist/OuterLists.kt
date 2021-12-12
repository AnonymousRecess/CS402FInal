package com.example.recyclelist

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.inflate
import android.view.Window
import android.widget.*

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import java.util.zip.Inflater
import com.google.android.gms.auth.api.signin.GoogleSignIn

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import androidx.annotation.NonNull
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import com.google.android.gms.tasks.OnCompleteListener







public class OuterLists : AppCompatActivity(), View.OnClickListener {
    private lateinit var outRecyclerView: RecyclerView
    private lateinit var alertDialog: AlertDialog
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val outerList = OuterModel() //TODO Create OuterModel class
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.outer_lists)

        val imageView = findViewById<ImageView>(R.id.profileView)
        val acctName = findViewById<TextView>(R.id.googleName)
        val signOutOf = findViewById<ImageButton>(R.id.signOut)

        signOutOf.setOnClickListener( object: View.OnClickListener{
            override fun onClick(p0: View?) {
                when(p0?.id) {
                    R.id.signOut -> signOut()
                    else -> null
                }
            }
        })

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {

            mGoogleSignInClient = login.mGoogleSignInClient
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri? = acct.photoUrl
            Glide.with(this).load(personPhoto).into(imageView)
            acctName.setText(personName)

        }
        outRecyclerView =
            findViewById<RecyclerView>(R.id.outer_recycler_view)
        outRecyclerView.layoutManager = LinearLayoutManager(this)

        val outadapter: OUTAdapter  = OUTAdapter(this, outerList)

        outRecyclerView.adapter = outadapter
        // i.d of button = button
        val outerAddButton: Button = findViewById(R.id.outAddButton) // TODO Add out add button
        

        outerAddButton.setOnClickListener(this)

        setTitle("Lists++")
    }
        override fun onClick(p0: View?) {
            //TODO("Not yet implemented")

            showDialog("Create a new List")

        }
        private fun showDialog(title: String){
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage(title).setView(layoutInflater.inflate(R.layout.fragment_list, null))
            .setPositiveButton("Confirm", DialogInterface.OnClickListener{ dialog, id-> addList(
                dialog as Dialog)})
            .setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog, id -> dialog.cancel()})

            alertDialog = dialogBuilder.create()
            alertDialog.show()
        }

        fun addList(dialog: Dialog){

            val textBox = alertDialog.findViewById<EditText>(R.id.listDialogTitle)

            outerList.add(outerListElements(textBox?.getText().toString()))
            outRecyclerView.adapter?.notifyDataSetChanged()

            dialog.dismiss()
        }
    private fun signOut() {

        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this, OnCompleteListener<Void?> {
                Toast.makeText(this,"Signed out", Toast.LENGTH_SHORT).show()
                val signOutIntent: Intent = Intent(this, login::class.java)
                startActivity(signOutIntent)
            })
    }

  
    
}