package com.purang.justdoit

import android.app.ActivityManager
import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.purang.justdoit.custom_view.CustomViewActivity
import com.purang.justdoit.java.Friut
import com.purang.justdoit.recycleview.GridActivity
import com.purang.justdoit.recycleview.SimpleAdapter
import com.purang.justdoit.utils.AssetsUtilsTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        simpleAdapter.notifyDataSetChanged()
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.adapter = simpleAdapter


        val iv = findViewById<ImageView>(R.id.iv)

//        val ipus = resources
//        .assets.open("aini.png")
//        val bitmap = BitmapFactory.decodeStream(ipus)
//        iv.setImageBitmap(bitmap)

        AssetsUtilsTest.setImage(this@MainActivity,iv)

    }

    fun skip2CustomView(view: View) {
//        startActivity(Intent(this@MainActivity, CustomViewActivity::class.java))
        startActivity(Intent(this@MainActivity, GridActivity::class.java))
    }
}
