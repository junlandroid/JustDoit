package com.purang.emojitest.utils

import android.content.Context
import android.text.TextUtils
import com.purang.emojitest.adapter.EmoticonPacksAdapter
import com.purang.emojitest.data.DefXhsEmoticons
import com.purang.emojitest.data.Emotion
import com.purang.emojitest.data.EmotionPack
import com.purang.emojitest.help.GridPageFactory
import com.purang.emojitest.interfaces.OnEmoticonClickListener

object AdapterUtils {

    fun getCommonAdapter(context: Context, listener: OnEmoticonClickListener<Emotion>?): EmoticonPacksAdapter {
        val packs = mutableListOf<EmotionPack<out Emotion>>()
        packs.add(getXhsPageSetEntity())

        val adapter = EmoticonPacksAdapter(packs)
        adapter.clickListener = listener
        return adapter
    }

    private fun getXhsPageSetEntity(): EmotionPack<Emotion> {
        val pack = EmotionPack<Emotion>()
        pack.emotions = parseXhsData(DefXhsEmoticons.xhsEmoticonArray)
        val factory = GridPageFactory<Emotion>()
        factory.line = 3
        factory.row = 7
        pack.pageFactory = factory

        return pack
    }

    private fun parseXhsData(array: Array<String>): MutableList<Emotion> {
        val emojis = mutableListOf<Emotion>()

        array.forEach {
            if (!TextUtils.isEmpty(it)) {
                val temp = it.trim { it <= ' ' }

                val text = temp.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                if (text.size == 2) {
                    val emoticon = Emotion()

                    emoticon.uri = "file:///android_asset/${text[0]}"
                    emoticon.code = text[1]

                    emojis.add(emoticon)
                }
            }
        }
        return emojis
    }
}