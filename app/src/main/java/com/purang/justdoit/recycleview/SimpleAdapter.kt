package com.purang.justdoit.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.purang.justdoit.R
import java.util.zip.Inflater

class SimpleAdapter(var mData: List<String>) : RecyclerView.Adapter<SimpleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return SimpleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.tv.text = mData[position]
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(true)
    }
}

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var tv:TextView = itemView.findViewById(R.id.tv)
}