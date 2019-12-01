LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE    := FadeInOut
LOCAL_SRC_FILES := FadeInOut.c
LOCAL_SRC_FILES += neon_imageview.c
LOCAL_LDLIBS        += -llog

include $(BUILD_SHARED_LIBRARY)