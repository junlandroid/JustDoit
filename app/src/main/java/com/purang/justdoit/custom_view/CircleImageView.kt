package com.purang.justdoit.custom_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import com.purang.justdoit.R

class CircleImageView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    ImageView(context, attributeSet, defStyleAttr) {
    private lateinit var bitmap: Bitmap
    private lateinit var paint: Paint
    private lateinit var src: Bitmap

    constructor(context: Context) : this(context, null) {
        initData()
    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0) {
        initData()
    }

    init {
        initData()
    }

    private fun initData() {
        paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.YELLOW

        src = BitmapFactory.decodeResource(resources, R.mipmap.test)
        bitmap = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(bitmap)
        canvas.drawRoundRect(RectF(0f, 0f, src.width.toFloat(), src.height.toFloat()), 80f, 80f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas!!.drawBitmap(src, 0f, 0f, paint)
        
    }

    override fun setOnLongClickListener(l: OnLongClickListener?) {
        super.setOnLongClickListener(l)
        Log.d(TAG, "setOnLongClickListener")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(TAG, "onTouchEvent")
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> Log.d(TAG, "ACTION_DOWN")
            MotionEvent.ACTION_UP -> Log.d(TAG, "ACTION_UP")
            MotionEvent.ACTION_CANCEL -> Log.d(TAG, "ACTION_CANCEL")
        }
        return super.onTouchEvent(event)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        Log.d(TAG, "setOnClickListener")
    }

    companion object {
        private const val TAG: String = "CircleImageView"
    }
}