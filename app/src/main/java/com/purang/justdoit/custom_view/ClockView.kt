package com.purang.justdoit.custom_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.IntegerRes
import org.jetbrains.annotations.NotNull

class ClockView constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) :
    View(context, attr, defStyleAttr) {

    private lateinit var mPathPaint: Paint
    private lateinit var mPath: Path
    private lateinit var mTextPaint2: Paint
    private lateinit var mTextPaint: Paint
    private lateinit var mMinutePointer: Paint
    private lateinit var mHourPointer: Paint
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

        // 时针指针
        mHourPointer = Paint(Paint.ANTI_ALIAS_FLAG)
        mHourPointer.style = Paint.Style.FILL
        mHourPointer.color = Color.BLACK
        mHourPointer.strokeWidth = 20f

        mMinutePointer = Paint(Paint.ANTI_ALIAS_FLAG)
        mMinutePointer.style = Paint.Style.FILL
        mMinutePointer.color = Color.BLACK
        mMinutePointer.strokeWidth = 10f

        mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint.textAlign = Paint.Align.CENTER
        mTextPaint.textSize = 40f
        mTextPaint.color = Color.RED
        // 设置文本字体，可以自定义字体
        var font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC)
        mTextPaint.typeface = font
//        mTextPaint.isUnderlineText = true //下划线
//        mTextPaint.isStrikeThruText = true// 中划线

        mTextPaint2 = Paint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint2.textSize = 40f
        mTextPaint2.color = Color.BLUE
        mTextPaint2.textAlign = Paint.Align.CENTER

        // 绘制线
        mPath = Path()
        mPathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPathPaint.style = Paint.Style.STROKE

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 4).toFloat(), mPaint)
        // 画刻度线

        for (i in 0 until 24) {
            var degree = i.toString()
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                drawKeDuLine(canvas, 50)
                mKeDuPaint.textSize = 35f
                drawKeduText(canvas, degree, 80)
            } else {
                drawKeDuLine(canvas, 25)
                mKeDuPaint.textSize = 25f
                drawKeduText(canvas, degree, 60)
            }

            // 旋转坐标系
            canvas.rotate(15f, (width / 2).toFloat(), (height / 2).toFloat())
        }
        canvas.save() //保存上一个图层 ？？？
        // 画时分针指针
        drawPointer(canvas)
//        canvas.restore()

        // 写字
//        canvas.drawText("天王表", width / 2.toFloat(), (height / 2 - width / 12  ).toFloat(), mTextPaint)
        canvas.drawText("天王表", 0f, -60f, mTextPaint)
        canvas.restore()//恢复坐标系？？？


        canvas.save()
        canvas.translate((width / 2).toFloat(), (height / 2 + width / 4).toFloat() + 100)
        canvas.drawText("hello world", 0f,0f, mTextPaint2)
        canvas.restore()
        canvas.translate((width/2).toFloat(), (height / 2 + width / 4).toFloat() + 200)
        mPath.moveTo(90f, 60f)
        mPath.lineTo(150f, 60f)
        mPath.lineTo(135f, 0f)
        mPath.lineTo(105f, 0f)
        mPath.close()
        canvas.drawPath(mPath,mPathPaint)

        Log.d("TAG", canvas.saveCount.toString())
    }

    private fun drawPointer(canvas: Canvas) {
        // 将坐标系平移到圆点
        canvas.translate((width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawLine(0f, 0f, 100f, 100f, mHourPointer)
        canvas.drawLine(0f, 0f, 0f, 150f, mMinutePointer)
    }

    private fun drawKeduText(canvas: Canvas, degree: String, keDuSize: Int) {
        mKeDuPaint.strokeWidth = 1f
        mKeDuPaint.style = Paint.Style.FILL
        canvas.drawText(
            degree,
            width / 2 - mKeDuPaint.measureText(degree) / 2,
            (height / 2 - width / 4 + keDuSize).toFloat(),
            mKeDuPaint
        )
    }

    private fun drawKeDuLine(canvas: Canvas, keDuSize: Int) {
        mKeDuPaint.strokeWidth = 3f
        mKeDuPaint.style = Paint.Style.FILL
        canvas.drawLine(
            (width / 2).toFloat(),
            (height / 2 - width / 4).toFloat(),
            (width / 2).toFloat(),
            (height / 2 - width / 4).toFloat() + keDuSize,
            mKeDuPaint
        )
    }

}