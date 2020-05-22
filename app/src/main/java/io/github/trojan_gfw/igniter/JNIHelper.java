package io.github.trojan_gfw.igniter;
/*
java原生接口辅助类(调用C)
* */
public class JNIHelper {
    static {
        System.loadLibrary("jni-helper");
    }

    public static native void trojan(String config);

    public static native void stop();
}
