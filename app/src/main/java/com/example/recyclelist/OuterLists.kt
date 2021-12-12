package com.example.recyclelist

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.Scope

import com.google.android.gms.tasks.OnCompleteListener
import com.google.api.client.json.gson.GsonFactory

import com.google.api.client.extensions.android.http.AndroidHttp

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.services.drive.Drive
import com.google.android.gms.tasks.OnFailureListener

import com.google.gson.Gson

import com.google.android.gms.tasks.OnSuccessListener





public class OuterLists : AppCompatActivity(), View.OnClickListener {
    private lateinit var outRecyclerView: RecyclerView
    private lateinit var alertDialog: AlertDialog
    lateinit var mGoogleSignInClient: GoogleSignInClient
    companion object {
        lateinit var mDriveServiceHelper: DriveServiceHelper
    }
    val outerList = OuterModel() //TODO Create OuterModel class
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.outer_lists)

        val imageView = findViewById<ImageView>(R.id.profileView)
        val acctName = findViewById<TextView>(R.id.googleName)
        val signOutOf = findViewById<ImageButton>(R.id.signOut)
        val uploadingButton = findViewById<ImageButton>(R.id.uploadButton)

        signOutOf.setOnClickListener( object: View.OnClickListener{
            override fun onClick(p0: View?) {
                when(p0?.id) {
                    R.id.signOut -> signOut()
                    else -> null
                }
            }
        })

        uploadingButton.setOnClickListener( object: View.OnClickListener{
            override fun onClick(p0: View?) {
                mDriveServiceHelper.createFolder("My Folder", null)
                    .addOnSuccessListener(OnSuccessListener<GoogleDriveFileHolder?> { googleDriveFileHolder ->
                        val gson = Gson()
                        Log.i("TAG",
                            "onSuccess of Folder creation: " + gson.toJson(googleDriveFileHolder))
                    })
                    .addOnFailureListener(OnFailureListener { e ->
                        Log.i("TAG",
                            "onFailure of Folder creation: " + e.message)
                    })

            }

        })

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {

            var ACCESS_DRIVE_SCOPE: Scope = Scope(Scopes.DRIVE_FILE)
            var SCOPE_EMAIL: Scope = Scope(Scopes.EMAIL)
            if (!GoogleSignIn.hasPermissions(
                    GoogleSignIn.getLastSignedInAccount(getApplicationContext()),
                    ACCESS_DRIVE_SCOPE,
                    SCOPE_EMAIL)) {
                GoogleSignIn.requestPermissions(
                    this,
                    1,
                    GoogleSignIn.getLastSignedInAccount(getApplicationContext()),
                    ACCESS_DRIVE_SCOPE,
                    SCOPE_EMAIL);
            } else {
                Toast.makeText(this, "Permission to access Drive and Email has been granted", Toast.LENGTH_SHORT).show();
                driveSetUp();

            }
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
    private fun driveSetUp() {
        val mAccount = GoogleSignIn.getLastSignedInAccount(this)
        val credential = GoogleAccountCredential.usingOAuth2(
            applicationContext, Collections.singleton(Scopes.DRIVE_FILE))
        credential.selectedAccount = mAccount!!.account
      val  googleDriveService = Drive.Builder(
            AndroidHttp.newCompatibleTransport(),
            GsonFactory(),
            credential)
            .setApplicationName("GoogleDriveIntegration 3")
            .build()
       mDriveServiceHelper = DriveServiceHelper(googleDriveService)
    }

  
    
}