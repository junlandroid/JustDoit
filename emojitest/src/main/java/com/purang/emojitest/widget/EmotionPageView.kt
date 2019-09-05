package com.purang.emojitest.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.GridView
import android.widget.RelativeLayout
import com.purang.emojitest.R

class EmotionPageView(context: Context, attr: AttributeSet?) : RelativeLayout(context, attr) {
    fun setNumColumns(row: Int) {
        mGvEmotion.numColumns = row
    }

    lateinit var mGvEmotion: GridView

    constructor(context: Context) : this(context, null)

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_emoticonpage, this)

        mGvEmotion = view.findViewById<GridView>(R.id.gv_emotion)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            mGvEmotion.isMotionEventSplittingEnabled = false
        }
        mGvEmotion.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        mGvEmotion.cacheColorHint = 0
        mGvEmotion.selector = ColorDrawable(Color.TRANSPARENT)
        mGvEmotion.isVerticalScrollBarEnabled = false
    }

}