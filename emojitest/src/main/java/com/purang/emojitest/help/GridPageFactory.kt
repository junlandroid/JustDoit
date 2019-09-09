package com.purang.emojitest.help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import com.purang.emojitest.R
import com.purang.emojitest.data.Emotion
import com.purang.emojitest.interfaces.OnEmoticonClickListener
import com.purang.emojitest.widget.EmotionPageView
import github.ll.emotionboard.utils.imageloader.ImageLoader

class GridPageFactory<T : Emotion> : PageFactory<T> {


    var line = 3
    var row = 7


    override fun emoticonsCapacity(): Int {
        return line * row
    }

    override fun create(context: Context, emoticons: List<T>, clickListener: OnEmoticonClickListener<Emotion>?): View {
        val pageView = EmotionPageView(context)
        pageView.setNumColumns(row)
        val adapter = createAdapter(context, emoticons, clickListener)
        pageView.mGvEmotion.adapter = adapter
        return pageView
    }

    private fun createAdapter(context: Context, emoticons: List<T>, clickListener: OnEmoticonClickListener<Emotion>?): BaseAdapter {
        val adapter = ImageAdapter(context,emoticons,clickListener)
        adapter.line = line
        return adapter
    }
}

open class ImageAdapter<T:Emotion>(context: Context,emoticons: List<T>,clickListener: OnEmoticonClickListener<Emotion>?)
    :GridAdapter<T,ImageAdapter.ViewHolder>(context,emoticons,clickListener){


    val DEF_HEIGHT_MAX_RATIO = 2.toDouble()

    val defaultItemHeight = context.resources.getDimension(R.dimen.item_emoticon_size_default).toInt()
    var itemHeight = defaultItemHeight
    var itemHeightMax = 0
    var itemHeightMin = 0
    var itemHeightMaxRatio = DEF_HEIGHT_MAX_RATIO
    var line = 0

    override fun createViewHolder(convertView: View): ViewHolder {
        val viewHolder = ViewHolder()
        viewHolder.rootView = convertView
        viewHolder.rootLayout = convertView.findViewById(R.id.ly_root) as LinearLayout
        viewHolder.imageView = convertView.findViewById(R.id.iv_emoticon) as ImageView

        return viewHolder
    }

    override fun createConvertView(inflater: LayoutInflater): View {
        return inflater.inflate(R.layout.item_emoticon, null)
    }

    override fun bindView(item: T, parent: ViewGroup, viewHolder: ViewHolder) {

        viewHolder.rootLayout?.setBackgroundResource(R.drawable.bg_emoticon)

        val uri = item.uri

        val image = viewHolder.imageView

        if (image != null && uri != null) {
            ImageLoader.displayImage(uri, image)
        }

        viewHolder.rootView?.setOnClickListener {
            clickListener?.onEmotionClick(item)
        }
    }

    override fun setViewHolderLayoutParams(viewHolder: ViewHolder, parent: ViewGroup) {
        if (defaultItemHeight != itemHeight) {
            viewHolder.imageView?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, itemHeight)
        }
        itemHeightMax = if (itemHeightMax!= 0) itemHeightMax else (itemHeight * itemHeightMaxRatio).toInt()
        itemHeightMin = if (this.itemHeightMin != 0) this.itemHeightMin else itemHeight

        var realItemHeight = (parent.parent as View).measuredHeight / line
        realItemHeight = Math.min(realItemHeight, itemHeightMax)
        realItemHeight = Math.max(realItemHeight, itemHeightMin)

        viewHolder.rootLayout?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, realItemHeight)
    }

    class ViewHolder {
        var rootView: View? = null
        var rootLayout: LinearLayout? = null
        var imageView: ImageView? = null
    }
}

abstract class GridAdapter<T:Emotion,V>(val context: Context,
                                        val emotions: List<T>,
                                        val clickListener: OnEmoticonClickListener<Emotion>?):BaseAdapter(){
    private val inflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertTempView = convertView

        val viewHolder: V
        if (convertTempView == null) {
            convertTempView = createConvertView(inflater)
            viewHolder = createViewHolder(convertTempView)
            convertTempView.tag = viewHolder
        } else {
            viewHolder = convertTempView.tag as V
        }

        bindView(getItem(position) as T, parent, viewHolder)
        setViewHolderLayoutParams(viewHolder, parent)
        return convertTempView
    }

    abstract fun createViewHolder(convertView: View): V

    abstract fun createConvertView(inflater: LayoutInflater): View

    override fun getItem(position: Int): Any = emotions[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = emotions.size

    abstract fun bindView(item: T, parent: ViewGroup, viewHolder: V)

    abstract fun setViewHolderLayoutParams(viewHolder: V, parent: ViewGroup)

}

