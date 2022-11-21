package com.example.praktika8


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditTask : AppCompatActivity() {
    lateinit var tileE: EditText
    lateinit var dateE: EditText
    lateinit var timeE: EditText
    lateinit var descE: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        tileE=findViewById(R.id.title_task)
        dateE=findViewById(R.id.date_task)
        timeE=findViewById(R.id.time_task)
        descE=findViewById(R.id.desc_task)
        val bundle: Bundle?=intent.extras
        val titleR=bundle!!.getString("titlik")
        val dateR=bundle!!.getString("datelik")
        val timeR=bundle!!.getString("timelik")
        val descR=bundle!!.getString("desclik")
        tileE.setText(titleR)
        dateE.setText(dateR)
        timeE.setText(timeR)
        descE.setText(descR)
    }
    fun zap(view: android.view.View){

    }
    fun del(view: android.view.View){

    }
    fun backlist(view: android.view.View){
        val intent= Intent(this,GeneralActivity::class.java)
        startActivity(intent)
    }
}