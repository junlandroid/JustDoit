package com.purang.emojitest.data

import android.content.Context
import android.view.View
import com.purang.emojitest.help.GridPageFactory
import com.purang.emojitest.help.PageFactory
import com.purang.emojitest.interfaces.OnEmoticonClickListener

class EmotionPack<T : Emotion> {

    var name: String? = null
    var iconUrl: String? = null
    lateinit var emotions: MutableList<Emotion>
    var pageFactory:PageFactory<Emotion> = GridPageFactory<Emotion>()

    var isDataChanged = false
    var tag: Any? = null

    val pageCount: Int
        get() {
            if (emotions == null || pageFactory == null) {
                throw RuntimeException("must set emotions and pageFactory first")
            }

            var count = emotions.size / pageFactory.emoticonsCapacity()

            if (emotions.size % pageFactory.emoticonsCapacity() > 0) {
                count++
            }

            return count
        }


    fun getView(context: Context, pageIndex: Int, listener: OnEmoticonClickListener<Emotion>?): View {
        // 创建viewPager
        return pageFactory.create(context, getEmotions(pageIndex), listener)
    }

    private fun getEmotions(pageIndex: Int): MutableList<Emotion> {
        val fromIndex = pageIndex * pageFactory.emoticonsCapacity()
        var toIndex = Math.min((pageIndex + 1) * pageFactory.emoticonsCapacity(), emotions.size)

        return emotions.subList(fromIndex, toIndex)
    }

}