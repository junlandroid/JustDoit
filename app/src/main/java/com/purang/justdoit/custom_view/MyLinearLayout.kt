package com.purang.justdoit.custom_view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.LinearLayout

class MyLinearLayout(context: Context, attributeSet: AttributeSet?) : ViewGroup(context, attributeSet) {

    companion object {
        private const val TAG = "MyLinearLayout"
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(TAG, "MyLinearLayout dispatchTouchEvent,event:" + ev!!.action)
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(TAG, "MyLinearLayout onTouchEvent")
//        when (event!!.action) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d(TAG, "dispatchTouchEvent,event:Down")
//            }
//            MotionEvent.ACTION_UP -> {
//                Log.d(TAG, "dispatchTouchEvent,event:Up")
//                return true
//            }
//            MotionEvent.ACTION_MOVE -> {
//                Log.d(TAG, "dispatchTouchEvent,event:Move")
//                return true
//            }
//            MotionEvent.ACTION_CANCEL -> {
//                Log.d(TAG, "dispatchTouchEvent,event:Cancel")
//            }
//        }
        return super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d(TAG, "MyLinearLayout onInterceptTouchEvent")
        return super.onInterceptTouchEvent(ev)
    }

}