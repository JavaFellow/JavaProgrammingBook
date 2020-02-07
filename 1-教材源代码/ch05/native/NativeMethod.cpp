#include "stdafx.h"
#include "jni.h" 
#include "NativeMethod.h" 
#include <math.h>

JNIEXPORT void JNICALL Java_NativeMethod_sayHello(JNIEnv *env, jobject thisObj)
{
    printf("Hello from a c++ native method.\n");
    return;
}

JNIEXPORT jlong JNICALL Java_NativeMethod_doCalc(JNIEnv *env, jobject thisObj, jint n)
{
    return pow(n, 2); // º∆À„n^2
}
