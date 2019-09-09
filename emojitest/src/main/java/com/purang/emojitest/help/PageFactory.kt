package com.purang.emojitest.help

import android.content.Context
import android.view.View
import com.purang.emojitest.data.Emotion
import com.purang.emojitest.interfaces.OnEmoticonClickListener

interface PageFactory<T : Emotion> {
    /**
     * 每页能显示的表情数
     */
    fun emoticonsCapacity(): Int

    /**
     * 创建用于显示表情的View
     */
    fun create(context: Context, emoticons: List<T>, clickListener: OnEmoticonClickListener<Emotion>?): View
}