package com.purang.justdoit.recycleview

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.purang.justdoit.R

class GridActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        val gridView = findViewById<GridView>(R.id.gridView)
//        val manager = GridLayoutManager(this,8)
//        recyclerView.layoutManager = manager
//        val simpleAdapter = SimpleAdapter(getData())
//        recyclerView.adapter = simpleAdapter
//        recyclerView.addItemDecoration(MyItemDecoration())
        val adapter = GridViewAdapter(this, getData())

        gridView.adapter = adapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            parent.getChildAt(position).background = ContextCompat.getDrawable(this,R.drawable.im_flow_item_selector_radius)}

    }

    private fun getData(): List<String> {
        val list = mutableListOf<String>()
        for (i in 0 until 100) {
            list.add("中$i")
        }
        return list
    }




}