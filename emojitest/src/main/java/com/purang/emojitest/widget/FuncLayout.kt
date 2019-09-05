package com.purang.emojitest.widget

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class FuncLayout(context: Context, attr: AttributeSet?) : LinearLayout(context, attr) {

    private var mFuncViewArrayMap = SparseArray<View>()

    constructor(context: Context) : this(context, null)

    init {
        orientation = VERTICAL
    }

    fun addFuncView(key: Int, view: View) {
        if (mFuncViewArrayMap.get(key) != null) return

        mFuncViewArrayMap.put(key, view)

        var params =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        addView(view, params)
    }
}