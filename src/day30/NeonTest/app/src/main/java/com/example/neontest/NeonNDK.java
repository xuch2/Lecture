package com.example.neontest;

import android.graphics.Bitmap;

public class NeonNDK {
    static {
        System.loadLibrary("FadeInOut");
    }

    public native void runNeon(Bitmap bmpIn, Bitmap bmpOut, Bitmap bitmapResult, int width, int height, int nRate);

    public native void runC(Bitmap bmpIn, Bitmap bmpOut, Bitmap bitmapResult, int width, int height, int nRate);
}
