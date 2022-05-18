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

class SearchActivity : AppCompatActivity() {
    var searchList: ListView? =null
    var users:ArrayList<Search> ?=null
    var adapter:SearchAdapter ?=null
    //Adding mBtnlogin and editSearch
//NB THIS CODES ARE THE SAME WITH CODES OF COURTS ACTIVITY ,CLERKS ACTIVITY AND JUDGE ACTIVITY.AND THIS CODE HELP YOU TO VIEW WHAT HAVE BEEN POSTED IN DATABASE.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_layout)
        searchList=findViewById(R.id.searchList)
        // Adding the two button.

        users= ArrayList()
        adapter= SearchAdapter(this,users !!)
        var ref= FirebaseDatabase.getInstance().getReference().child("Judges")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
                for (snap in snapshot.children){
                    var user=snap.getValue(Search::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Ask admin to open DB",
                    Toast.LENGTH_LONG).show()
            }
        })
        searchList!!.adapter = adapter!!
        searchList!!.setOnItemClickListener { adapterView, view, i, l ->
//            var id=users!!.get(i).id.toString()
            var alertDialog= AlertDialog.Builder( this)
            alertDialog.setMessage("Are you user your want to delete" + users!!.get(i).search)
            alertDialog.setNegativeButton( "NO", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alertDialog.setPositiveButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->
                var ref= FirebaseDatabase.getInstance().getReference().
                child("Users")
                ref.removeValue()
            })
            alertDialog.create().show()
        }

    }
}
// This is search View page and JudgeList as Id to run the code smart,and this code of view judges is the same code of view cases,clerks and court.
