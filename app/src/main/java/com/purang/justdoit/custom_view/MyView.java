package com.purang.justdoit.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {
    private static final String TAG = "MyView";

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    //计时器，计时点击时长
    Timer timer;
    TimerTask timerTask;

    boolean isCick = true;//判断是否进行点击
    private static final int LONGPRESSTIME = 300;//长按超过0.3秒，触发长按事件

    //记录上次点击的位置，用来进行移动的模糊处理
    int lastX = 0;
    int lastY = 0;

    //此处可以视为将View划分为10行10列的方格，在方格内移动看作没有移动。
    private static final int MOHUFANWEI = 10;
    public static final int MIN_CLICK_DELAY_TIME = 300;
    private long lastClickTime = 0, currentTime = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyView onTouchEvent: ");

        //实现获取点击位置
        float X = event.getX();
        float Y = event.getY();


        //手指移动的模糊范围，手指移动超出该范围则取消事件处理
        int length = getWidth() / MOHUFANWEI;
        final int indexX = (int) (Y / length);
        final int indexY = (int) (X / length);

        if (event.getAction() == MotionEvent.ACTION_DOWN
                && event.getPointerCount() == 1) {
            lastClickTime = Calendar.getInstance().getTimeInMillis();

            //长按计时器
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    //长按逻辑触发，isClick置为false，手指移开后，不触发点击事件
                    isCick = false;

                    doLongPress(indexX, indexY);
                }
            };
            isCick = true;
            timer.schedule(timerTask, LONGPRESSTIME, 1000 * 60 * 60 * 24);
        }

        if (event.getAction() == MotionEvent.ACTION_UP
                && event.getPointerCount() == 1) {
            //没有触发长按逻辑，进行点击事件
            if (isCick == true) {
                doClick(indexX, indexY);
            }
            //取消计时
            timerTask.cancel();
            timer.cancel();
        }

        //出现移动，取消点击和长按事件
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //如果在一定范围内移动，不处理移动事件
            if (lastX == indexX && lastY == indexY) {
                return true;
            }
            isCick = false;
            timerTask.cancel();
            timer.cancel();
        }


        if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && !isCick) {
            currentTime = Calendar.getInstance().getTimeInMillis();
            long diff = currentTime - lastClickTime;
            if (diff > MIN_CLICK_DELAY_TIME) {
                Log.d(TAG, "超过300ms ， 开始长按 ，diff: " + diff);
                if (!isCick)
                    Toast.makeText(getContext(), "开始长按", Toast.LENGTH_SHORT).show();
            } else {
                Log.d(TAG, "小于300ms ， 取消长按 ，diff: " + diff);
                if (!isCick)
                    Toast.makeText(getContext(), "取消长按", Toast.LENGTH_SHORT).show();
            }
        }
        //一旦触发事件，即改变上次触发事件的坐标
        lastY = indexY;
        lastX = indexX;
        return true;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // 一般情况下，我们不该在普通View内重写dispatchTouchEvent方法，因为它并不执行分发逻辑。
        // 当Touch事件到达View时，我们该做的就是是否在onTouchEvent事件中处理它。
        Log.d(TAG, "MyView dispatchTouchEvent: ");
        return super.dispatchTouchEvent(event);
    }

    private void doLongPress(int x, int y) {
        Log.e("CAM", "长按了" + x + "   " + y);
    }

    private void doClick(int x, int y) {
        Log.e("CAM", "点击了" + x + "   " + y);
    }
}
