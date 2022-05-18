package com.example.myjudiciaryapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CasesActivity : AppCompatActivity() {
    var caseList: ListView? =null
    var users:ArrayList<Case> ?=null
    var adapter:CaseAdapter ?=null
    //Adding mBtnlogin and editSearch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cases)
        caseList=findViewById(R.id.caseList)
        // Adding the two button.

        users= ArrayList()
        adapter=CaseAdapter(this,users !!)
        var ref= FirebaseDatabase.getInstance().getReference().child("Cases")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
                for (snap in snapshot.children){
                    var user=snap.getValue(Case::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Ask admin to open DB",
                    Toast.LENGTH_LONG).show()
            }
        })
        caseList!!.adapter = adapter!!
        caseList!!.setOnItemClickListener { adapterView, view, i, l ->
            var id=users!!.get(i).id.toString()
            var alertDialog= AlertDialog.Builder( this)
            alertDialog.setMessage("Are you user your want to delete" + users!!.get(i).name)
            alertDialog.setNegativeButton( "NO", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alertDialog.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                var ref= FirebaseDatabase.getInstance().getReference().
                child("Users/$id")
                ref.removeValue()
            })
            alertDialog.create().show()
        }

    }
    }
