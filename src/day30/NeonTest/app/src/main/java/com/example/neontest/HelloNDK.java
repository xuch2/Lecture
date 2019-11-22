package com.example.neontest;

public class HelloNDK {
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}