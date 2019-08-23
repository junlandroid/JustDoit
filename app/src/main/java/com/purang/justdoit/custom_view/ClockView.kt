package com.purang.justdoit.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.IntegerRes
import org.jetbrains.annotations.NotNull

class ClockView constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) :
    View(context, attr, defStyleAttr) {

    private lateinit var mPaint: Paint
    private lateinit var mKeDuPaint: Paint

    constructor(context: Context) : this(context, null) {
        // 次构造函数通过this关键字委托给主构造函数
        initData()
    }

    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0) {
        initData()
    }

    init {
        //  init 代码块
        initData()
    }

    private fun initData() {
        //
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f

        // 画刻度线和刻度
        mKeDuPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mKeDuPaint.strokeWidth = 3f
        mKeDuPaint.style = Paint.Style.STROKE


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 4).toFloat(), mPaint)
        // 画刻度线


        for (i in 0 until 24) {
            var degree = i.toString()
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                drawLongKeDu(canvas, 50)
                drawKeduText(canvas, degree , 80)
            } else {
                drawLongKeDu(canvas, 25)
                drawKeduText(canvas, degree , 60)
            }
            canvas.rotate(15f, (width / 2).toFloat(), (height / 2).toFloat())
        }
    }

    private fun drawKeduText(canvas: Canvas, degree: String , keDuSize: Int) {
        canvas.drawText(
            degree,
            width / 2 - mKeDuPaint.measureText(degree) / 2,
            (height / 2 - width / 4 + keDuSize).toFloat(),
            mKeDuPaint
        )
    }

    private fun drawLongKeDu(canvas: Canvas, keDuSize: Int) {
        canvas.drawLine(
            (width / 2).toFloat(),
            (height / 2 - width / 4).toFloat(),
            (width / 2).toFloat(),
            (height / 2 - width / 4).toFloat() + keDuSize,
            mKeDuPaint
        )
    }

}