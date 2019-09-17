package com.purang.justdoit.image_load;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.purang.justdoit.R;
import com.purang.justdoit.utils.DensityUtils;
import com.purang.justdoit.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class PresetImageWHActivity extends AppCompatActivity {

    private static final String TAG = "PresetImageWHActivity";
    String url = "[http://10.10.64.108/group1/M00/00/69/CgpAbF2AlD-ACNMUAFMUUYawEvk533.jpg][P90830-094927.jpg][5.19MB][{\"width\":\"3984\",\"height\":\"5312\"}]";
    private int mOldWidth = 300, mOldHeight = 300;
    private int mNewWidth = 300, mNewHeight = 300;
    private int mSWidth, mSHeight;
    private float mRatio = 0.3f;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset_image_wh);

        imageView = findViewById(R.id.image);

        final String[] unit = Utils.getChatFileUnit(url);
        for (int i = 0; i < unit.length; i++) {
//            System.out.println(unit[i]);
            if (!TextUtils.isEmpty(unit[3])) {
                try {
                    JSONObject jsonObject = new JSONObject(unit[3]);
                    mOldWidth = Integer.valueOf(jsonObject.getString("width"));
                    mOldHeight = Integer.valueOf(jsonObject.getString("height"));
                    System.out.println("mOldWidth:" + mOldWidth + ",mOldHeight:" + mOldHeight);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        mSWidth = DensityUtils.getDeviceInfo(this)[0];
        mSHeight = DensityUtils.getDeviceInfo(this)[1];

        if (mOldWidth > mSWidth * mRatio || mOldHeight > mSHeight * mRatio) {
            // 开始缩放
            if (mOldWidth > mOldHeight) {
                mNewWidth = (int) (mSWidth * mRatio);
                mNewHeight = mNewWidth * mOldHeight / mOldWidth;
                Log.d(TAG, "onCreate: mNewWidth," + mNewWidth + ",mNewHeight," + mNewHeight);
            } else if (mOldWidth < mOldHeight) {
                mNewHeight = (int) (mSHeight * mRatio);
                mNewWidth = mNewHeight * mOldWidth / mOldHeight;
                Log.d(TAG, "onCreate: mNewWidth," + mNewWidth + ",mNewHeight," + mNewHeight);
            } else {
                mNewWidth = mNewHeight = (int) (mSWidth * mRatio);
                Log.d(TAG, "onCreate: mNewWidth," + mNewWidth + ",mNewHeight," + mNewHeight);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = mNewWidth;
        layoutParams.height = mNewHeight;
        imageView.setLayoutParams(layoutParams);

        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//                imageView.setImageBitmap(bitmap);
                Glide.with(PresetImageWHActivity.this)
                        .load(unit[0])
                        .into(imageView);
            }
        }, 2000l);
    }
}
