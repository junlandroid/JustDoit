package com.purang.justdoit.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class AssetsUtilsTest {


    public static void setImage(Context context, @Nullable ImageView iv) {
        try {
            InputStream is = context.getResources().getAssets().open("aini.png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
