package com.purang.justdoit.recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.purang.justdoit.R

class GridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val manager = GridLayoutManager(this,8)
        recyclerView.layoutManager = manager
        val simpleAdapter = SimpleAdapter(getData())
        recyclerView.adapter = simpleAdapter
        recyclerView.addItemDecoration(MyItemDecoration())
    }

    private fun getData(): List<String> {
        val list = mutableListOf<String>()
        for (i in 0 until 100) {
            list.add("中$i")
        }
        return list
    }

}