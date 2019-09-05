package com.purang.emojitest

import com.purang.emojitest.data.Emotion
import com.purang.emojitest.interfaces.OnEmoticonClickListener

class TEst {

    private val onEmoticonClickListener = object : OnEmoticonClickListener<Emotion> {
        override fun onEmotionClick(emotion: Emotion) {

        }
    }
}
