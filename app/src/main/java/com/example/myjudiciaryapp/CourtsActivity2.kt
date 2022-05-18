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

class CourtsActivity2 : AppCompatActivity() {
    var courtList: ListView? =null
    var users:ArrayList<Court> ?=null
    var adapter:CourtAdapter ?=null
    //Adding mBtnlogin and editSearch
//NB THIS CODES ARE THE SAME WITH CODES OF COURTS ACTIVITY ,CLERKS ACTIVITY AND JUDGE ACTIVITY.AND THIS CODE HELP YOU TO VIEW WHAT HAVE BEEN POSTED IN DATABASE.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courts2)
        courtList=findViewById(R.id.courtList)
        // Adding the two button.

        users= ArrayList()
        adapter=CourtAdapter(this,users !!)
        var ref= FirebaseDatabase.getInstance().getReference().child("Court")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
                for (snap in snapshot.children){
                    var user=snap.getValue(Court::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Ask admin to open DB",
                    Toast.LENGTH_LONG).show()
            }
        })
        courtList!!.adapter = adapter!!
        courtList!!.setOnItemClickListener { adapterView, view, i, l ->
            var id=users!!.get(i).Time.toString()
            var alertDialog= AlertDialog.Builder( this)
            alertDialog.setMessage("Are you user your want to delete" + users!!.get(i).CourtName)
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
// This is Judge View page and JudgeList as Id to run the code smart,and this code of view judges is the same code of view cases,clerks and court.
