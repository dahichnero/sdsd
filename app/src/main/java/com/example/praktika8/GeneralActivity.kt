package com.example.praktika8


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase

class GeneralActivity : AppCompatActivity() {
    lateinit var newRecyclerView: RecyclerView
    lateinit var newArrayList:List<Tasks>
    lateinit var database: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database-name"
        ).build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)
        val taskDao = db.taskDao()
        newArrayList=taskDao.getAll()
        newRecyclerView=findViewById(R.id.task_recycler_view)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        var adapter=MyAdapter(newArrayList as ArrayList<Tasks>)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent= Intent(this@GeneralActivity,EditTask::class.java)
                intent.putExtra("titlik",newArrayList[position].title)
                intent.putExtra("datelik",newArrayList[position].date)
                intent.putExtra("timelik",newArrayList[position].time)
                intent.putExtra("desclik",newArrayList[position].description)
                startActivity(intent)
            }

        })


    }
    fun adds(view: android.view.View){
        val intent= Intent(this,EditTask::class.java)
        startActivity(intent)
    }
    fun sighup(view: android.view.View){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}