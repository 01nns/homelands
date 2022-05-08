#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_nnss_dev_homelands_App_baseUrl(JNIEnv *env, jobject thiz) {
    std::string url = "Null";
    url = "https://restcountries.com/v3.1/";
    return env->NewStringUTF(url.c_str());
}