package com.example.myjudiciaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class AddJudgeActivity : AppCompatActivity() {
    var editName: EditText? =null
    var editEmail: EditText? =null
    var editPhone: EditText? =null
    var editId: EditText? =null

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    // var editNumber: EditText? = null
    var mBtnRegi: Button?=null
    var editPassword: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_judge)
        editName=findViewById(R.id.editName)
        editEmail=findViewById(R.id.editEmail)
        editPhone=findViewById(R.id.editPhone)
        editId=findViewById(R.id.editId)
       // editNumber=findViewById(R.id.editNumber)
        mBtnRegi=findViewById(R.id.mBtnRegi)
        editPassword=findViewById(R.id.editPassword)

//        mBtnView!!.setOnClickListener {
//            startActivity(Intent( this,CasesActivity::class.java))
//        }
        mBtnRegi!!.setOnClickListener {
//            Log.e("message","Button clicked")
            var name=editName!!.text.toString().trim()
            var email=editEmail!!.text.toString().trim()
            var idNumber=editId!!.text.toString().trim()
            var phone=editPhone!!.text.toString().trim()
            var password=editPassword!!.text.toString().trim()

            if (name.isEmpty()){
                editName!!.setError("Please fill this input")
                editName!!.requestFocus()
            }else if (email.isEmpty()){
                editEmail!!.setError("pleae fill this input")
                editEmail!!.requestFocus()
            }else if (!email.matches(emailPattern.toRegex())) {
                editEmail!!.setError("pleae enter a valid email")
                editEmail!!.requestFocus()
            }else if (idNumber.isEmpty()){
                editId!!.setError("Please fill this input")
                editId!!.requestFocus()
            }else if (phone.isEmpty()){
                editPhone!!.setError("Please fill this input")
                editPhone!!.requestFocus()
            }else if (password.isEmpty()){
                editPassword!!.setError("Please fill this input")
                editPassword!!.requestFocus()
            }

            else{
                var time=System.currentTimeMillis().toString()
                var userData=Judge (name,email,idNumber,phone,password)
                var ref = FirebaseDatabase.getInstance().getReference().child("Judges/$time")
                ref.setValue(userData).addOnCompleteListener {
                        task->
                    if(task.isSuccessful){
                        Log.e("message","Saved")
                        Toast.makeText(applicationContext,"User save successfully",
                            Toast.LENGTH_LONG).show()
                    }else{ Toast.makeText(applicationContext,"Saving user failed",
                        Toast.LENGTH_LONG).show()
                    }
                }

            }
        }




    }
}

