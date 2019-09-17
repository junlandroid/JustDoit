package com.purang.justdoit.recycleview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.purang.justdoit.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    List<String> mData;
    Context mContext;

    public GridViewAdapter(Context context , List<String> mData) {
        this.mData = mData;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private int clickTemp = -1;
    //标识选择的Item
    public void setSeclection(int position) {
        clickTemp = position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mData.get(position));
//        if (clickTemp == position) {
//            holder.textView.setBackgroundColor(Color.RED);
//        } else {
//            holder.textView.setBackgroundColor(Color.TRANSPARENT);
//        }

        return convertView;
    }

    class ViewHolder{

        TextView textView;


        public ViewHolder(View convertView) {
            textView = convertView.findViewById(R.id.tv);
        }
    }
}
