package com.example.myjudiciaryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    var mBtnAdd:Button ?= null
    var mBtnViewCases:Button ?= null
    var mBtnAddClerk:Button?=null
    var mBtnAddJudge:Button?=null
    var mBtnAddCourt:Button?=null
    var mBtnViewClerk:Button?=null
    var mBtnViewJudge:Button?=null
    var mBtnViewCourt:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        //Adding up other buttons for Clerks,Judges,and Courts.



        //This is the button for Courts .
        mBtnAddCourt=findViewById(R.id.mBtnAddCourt)
        mBtnAddCourt!!.setOnClickListener {
            startActivity(Intent(this,AddCourtsActivity::class.java))
        }

        //This is the button for Judges has been added.
        mBtnAddJudge=findViewById(R.id.mBtnAddJudge)
        mBtnAddJudge!!.setOnClickListener {
            startActivity(Intent(this,AddJudgeActivity::class.java))
        }

// This is the button for clerk has been added here.
        mBtnAddClerk = findViewById(R.id.mBtnAddClerk)

        mBtnAddClerk!!.setOnClickListener {
            startActivity(Intent(this,AddClerkActivity::class.java))
        }

        mBtnViewCases = findViewById(R.id.mBtnViewCases)
        mBtnViewCases!!.setOnClickListener {
            startActivity(Intent(this,CasesActivity::class.java))
        }
        //Adding up other buttons for Clerks,Judges,and Courts.

        mBtnAdd = findViewById(R.id.mBtnAdd)
        mBtnAdd!!.setOnClickListener {
            startActivity(Intent(this,AddcaseActivity::class.java))
        }

        mBtnViewClerk = findViewById(R.id.mBtnViewClerk)
        mBtnViewClerk!!.setOnClickListener {
            startActivity(Intent(this,ClerksActivity::class.java))
        }

        mBtnViewJudge = findViewById(R.id.mBtnViewJudge)
        mBtnViewJudge!!.setOnClickListener {
            startActivity(Intent(this,JudgesActivity::class.java))
        }
        mBtnViewCourt = findViewById(R.id.mBtnViewCourt)
        mBtnViewCourt!!.setOnClickListener {
            startActivity(Intent(this,CourtsActivity2::class.java))
        }


    }
}