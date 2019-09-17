package com.purang.justdoit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.purang.justdoit.image_load.PresetImageWHActivity
import com.purang.justdoit.recycleview.GridActivity
import com.purang.justdoit.utils.Utils

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val iv = findViewById<ImageView>(R.id.iv)

//        val ipus = resources
//        .assets.open("aini.png")
//        val bitmap = BitmapFactory.decodeStream(ipus)
//        iv.setImageBitmap(bitmap)

        Utils.setImage(this@MainActivity,iv)

    }

    fun skip2CustomView(view: View) {
//        startActivity(Intent(this@MainActivity, CustomViewActivity::class.java))
//        startActivity(Intent(this@MainActivity, GridActivity::class.java))
        startActivity(Intent(this@MainActivity, PresetImageWHActivity::class.java))
    }

//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        Log.d(TAG, "MainActivity dispatchTouchEvent,event:")
//        return super.dispatchTouchEvent(ev)
//    }
//
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Log.d(TAG, "MainActivity  MainActivity处理了Touch事件,event:")
//        return super.onTouchEvent(event)
//    }

    companion object{
        private const val TAG = "MainActivity"

    }

}
