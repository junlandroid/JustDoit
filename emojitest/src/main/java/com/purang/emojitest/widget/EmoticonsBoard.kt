package com.purang.emojitest.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.purang.emojitest.R
import com.purang.emojitest.adapter.EmoticonPacksAdapter
import java.util.zip.Inflater

open class EmoticonsBoard(context: Context, attr: AttributeSet?) : RelativeLayout(context) {

    protected var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    protected lateinit var funcLayout:FuncLayout

    constructor(context: Context) : this(context, null)

    init {
        inflaterKeyBoardBar()
        initFuncView()
    }

    private fun inflaterKeyBoardBar() {
        inflater.inflate(R.layout.view_keyboard_xhs,this)
        funcLayout = findViewById(R.id.ly_kvml)

    }


    private fun initFuncView() {
        var keyboard = inflaterFunc()
        funcLayout.addFuncView(FUNC_TYPE_EMOTION, keyboard)

    }

    private fun inflaterFunc(): View {
        // 填充键盘表情区域
        return inflater.inflate(R.layout.view_func_emtion,this)
    }

    fun setAdapter(adapter: EmoticonPacksAdapter) {

    }

    companion object{
        const val FUNC_TYPE_EMOTION = -1
    }

}