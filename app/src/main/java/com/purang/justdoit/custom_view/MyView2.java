package com.purang.justdoit.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

public class MyView2 extends View {
    private static final String TAG = MyView2.class.getSimpleName();

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyView2 dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
//        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyView2 onTouchEvent");
        return super.onTouchEvent(event);
    }
}
