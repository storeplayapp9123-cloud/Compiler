
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_aalam_compiler_MainActivity_nativeGetStatus(
    JNIEnv* env,
    jobject
) {
    const std::string status =
        "Aalam Compiler C++ engine initialized";

    return env->NewStringUTF(status.c_str());
}
