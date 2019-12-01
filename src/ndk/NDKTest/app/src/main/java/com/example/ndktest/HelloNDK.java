package com.example.ndktest;

public class HelloNDK {
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
