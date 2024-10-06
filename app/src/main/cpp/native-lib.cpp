#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_handsonjni_NativeCode_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) { // I can't do that because the function is static
    std::string hello = "Hello from G++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_handsonjni_NativeCode_add(JNIEnv* env, jdouble a, jdouble b) {
    jmethodID method = env->GetStaticMethodID(env->FindClass("com/example/handsonjni/NativeCode"), "printSomething", "(Ljava/lang/String;)V");
    env->CallStaticVoidMethod(env->FindClass("com/example/handsonjni/NativeCode"), method, env->NewStringUTF("laborta"));
    return a + b;
}
