package com.purang.emojitest.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.purang.emojitest.data.Emotion
import com.purang.emojitest.data.EmotionPack
import com.purang.emojitest.interfaces.OnEmoticonClickListener

open class EmoticonPacksAdapter(val packList: List<EmotionPack<out Emotion>>): PagerAdapter() {

    var clickListener: OnEmoticonClickListener<Emotion>? = null
    var adapterListener: EmotionPacksAdapterListener? = null
    private var oldCount = -1
    private var isUpdateAll = false

    fun getEmotionPackPosition(pack: EmotionPack<out Emotion>): Int {
        var startPosition = 0

        for (it in packList) {
            if (it != pack) {
                startPosition += it.pageCount
            } else {
                break
            }
        }

        return startPosition
    }

    override fun getCount(): Int {
        var count = 0

        packList.forEach {
            count += it.pageCount
        }

        if (oldCount != -1) {
            isUpdateAll = count < oldCount
        }

        oldCount = count

        return count
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any? {
        var pageNumber = position
        var pack: EmotionPack<*>? = null

        for (emoticonPack in packList) {
            if (emoticonPack.pageCount > pageNumber) {
                pack = emoticonPack
                break
            } else {
                pageNumber -= emoticonPack.pageCount
            }
        }

        // 返回viewPager展示的页面
        val view = pack?.getView(container.context, pageNumber, clickListener)
        view?.tag = position
        container.addView(view)

        pack?.isDataChanged = false

        isUpdateAll = false

        return view
    }

    private fun getEmotionPack(position: Int) : EmotionPack<*>? {
        var pageNumber = position

        for (emoticonPack in packList) {
            if (emoticonPack.pageCount > pageNumber) {
                return emoticonPack
            } else {
                pageNumber -= emoticonPack.pageCount
            }
        }

        return null
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }


    override fun getItemPosition(obj: Any?): Int {

        if (isUpdateAll) {
            return POSITION_NONE
        }

        if (packList.isEmpty()) {
            return POSITION_NONE
        }

        if (obj is View) {
            val pack = getEmotionPack(obj.tag as Int)

            if (pack != null && pack.isDataChanged) {
                return POSITION_NONE
            }
        }

        return POSITION_UNCHANGED
    }

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()

        adapterListener?.onDataSetChanged()
    }

    interface EmotionPacksAdapterListener {
        fun onDataSetChanged()
    }
}