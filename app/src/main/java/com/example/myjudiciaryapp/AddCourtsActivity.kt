package com.example.myjudiciaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class AddCourtsActivity : AppCompatActivity() {
    var editCourtName: EditText? =null
    var editCourtLocation: EditText? =null
    var editRoomNumber: EditText? =null
    var editDate: EditText? =null
    var editTime: EditText? = null
    var mBtnRegi: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcourts)
        editCourtName=findViewById(R.id. editCourtName)
        editCourtLocation=findViewById(R.id. editCourtLocation)
        editRoomNumber=findViewById(R.id. editRoomNumber)
        editDate=findViewById(R.id.editDate)
        editTime=findViewById(R.id. editTime)
        mBtnRegi=findViewById(R.id.mBtnRegi)



        mBtnRegi!!.setOnClickListener {
//            Log.e("message","Button clicked")
            var name=editCourtName!!.text.toString().trim()
            var location=editCourtLocation!!.text.toString().trim()
            var room=editRoomNumber!!.text.toString().trim()
            var date=editDate!!.text.toString().trim()
            var time=editTime!!.text.toString().trim()

            if (name.isEmpty()){
                editCourtName!!.setError("Please fill this input")
                editCourtName!!.requestFocus()
            }else if (location.isEmpty()){
                editCourtLocation!!.setError("Pleae fill this input")
                editCourtLocation!!.requestFocus()
            }else if (room.isEmpty()){
                editRoomNumber!!.setError("Please fill this input")
                editRoomNumber!!.requestFocus()
            }else if (date.isEmpty()){
                editDate!!.setError("Please fill this input")
                editDate!!.requestFocus()
            }else if (time.isEmpty()){
                editTime!!.setError("Please fill this input")
                editTime!!.requestFocus()
            }

            else{
                var time=System.currentTimeMillis().toString()
                var userData=Court(name,location,room,date,time)
                var ref = FirebaseDatabase.getInstance().getReference().child("Court/$time")
                ref.setValue(userData).addOnCompleteListener {
                        task->
                    if(task.isSuccessful){
                        Log.e("message","Saved")
                        Toast.makeText(applicationContext,"User save successfully",
                            Toast.LENGTH_LONG).show()
                    }
                    else{ Toast.makeText(applicationContext,"Saving user failed",
                        Toast.LENGTH_LONG).show()
                    }
                }

            }
        }




    }
}

