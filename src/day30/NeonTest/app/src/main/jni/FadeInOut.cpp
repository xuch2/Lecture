//
// Created by user on 2019-11-22.
//

#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <cpu-features.h>
#include <android/bitmap.h>

#include "com_example_neontest_MainActivity.h"
#include "neon_imageview.h"

JNIEXPORT void JNICALL Java_com_example_neontest_MainActivity_runNeon( JNIEnv* env,  jobject thiz, jobject bitmapIn, jobject bitmapOut, jobject bitmapResult, jint width, jint height, jint nRate)
{
	uint64_t features;
    void*	bmpin;
    void*   bmpout;
    void*   bmpresult;

	features = android_getCpuFeatures();

    AndroidBitmap_lockPixels(env, bitmapIn, &bmpin);
    AndroidBitmap_lockPixels(env, bitmapOut, &bmpout);
    AndroidBitmap_lockPixels(env, bitmapResult, &bmpresult);
	if (( android_getCpuFamily()==ANDROID_CPU_FAMILY_ARM  &&(features & ANDROID_CPU_ARM_FEATURE_NEON) != 0) ){
	    	ImageProcessNeon((unsigned char *)bmpin, (unsigned char*)bmpout, (unsigned char*) bmpresult, width, height, nRate);
	}
	else{
    	ImageProcessC((unsigned char *)bmpin, (unsigned char*)bmpout, (unsigned char*) bmpresult, width, height, nRate);
	}
    AndroidBitmap_unlockPixels(env, bitmapIn);
    AndroidBitmap_unlockPixels(env, bitmapOut);
    AndroidBitmap_unlockPixels(env, bitmapResult);

 }

JNIEXPORT void JNICALL Java_com_example_neontest_MainActivity_runC( JNIEnv* env,  jobject thiz, jobject bitmapIn, jobject bitmapOut, jobject bitmapResult, jint width, jint height, jint nRate)
{
    void*	bmpin;
    void*   bmpout;
    void*   bmpresult;

    AndroidBitmap_lockPixels(env, bitmapIn, &bmpin);
    AndroidBitmap_lockPixels(env, bitmapOut, &bmpout);
    AndroidBitmap_lockPixels(env, bitmapResult, &bmpresult);
   	ImageProcessC((unsigned char *)bmpin, (unsigned char*)bmpout, (unsigned char*)bmpresult, width, height, nRate);
    AndroidBitmap_unlockPixels(env, bitmapIn);
    AndroidBitmap_unlockPixels(env, bitmapOut);
    AndroidBitmap_unlockPixels(env, bitmapResult);

}