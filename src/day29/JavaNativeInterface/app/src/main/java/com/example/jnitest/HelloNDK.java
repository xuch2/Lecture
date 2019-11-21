package com.example.jnitest;

public class HelloNDK {
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
