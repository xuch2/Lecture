#include <jni.h>
#include <string>

#include "com_example_ndktest_HelloNDK.h"

JNIEXPORT jstring JNICALL Java_com_example_ndktest_HelloNDK_stringFromJNI(
    JNIEnv *env,
    jobject /* this */) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}