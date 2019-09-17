package com.purang.justdoit.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class Utils {


    public static void setImage(Context context, @Nullable ImageView iv) {
        try {
            InputStream is = context.getResources().getAssets().open("aini.png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] getChatFileUnit(String chatBody) {
        String[] split = chatBody.split("]");
        if (TextUtils.isEmpty(chatBody) || split.length < 1) return new String[]{};
        String[] temp = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            if (TextUtils.isEmpty(split[i])) {
                temp[i] = "";
            } else {
                temp[i] = split[i].substring(1);
            }
        }
        return temp;
    }
}
