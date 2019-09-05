package com.purang.emojitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.purang.emojitest.adapter.EmoticonPacksAdapter
import com.purang.emojitest.data.Emotion
import com.purang.emojitest.interfaces.OnEmoticonClickListener
import com.purang.emojitest.utils.AdapterUtils
import com.purang.emojitest.widget.EmoticonsBoard

class MainActivity : AppCompatActivity() {

    private lateinit var ekBar: EmoticonsBoard
    private lateinit var adapter: EmoticonPacksAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ekBar = findViewById<EmoticonsBoard>(R.id.ek_bar)
        adapter = AdapterUtils.getCommonAdapter(this,onEmoticonClickListener)
        ekBar.setAdapter(adapter)
    }

   private val onEmoticonClickListener = object : OnEmoticonClickListener<Emotion>{
       override fun onEmotionClick(t: Emotion) {

       }

   }


//    internal var onEmoticonClickListener: OnEmoticonClickListener<Emoticon> = OnEmoticonClickListener { emoticon ->
}
