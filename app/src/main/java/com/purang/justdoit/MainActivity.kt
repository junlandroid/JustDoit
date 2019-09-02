package com.purang.justdoit

import android.app.ActivityManager
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.purang.justdoit.custom_view.CustomViewActivity
import com.purang.justdoit.java.Friut
import com.purang.justdoit.recycleview.SimpleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleAdapter = SimpleAdapter()
        simpleAdapter.notifyDataSetChanged()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = simpleAdapter

    }

    fun skip2CustomView(view: View) {
        startActivity(Intent(this@MainActivity, CustomViewActivity::class.java))
    }
}
