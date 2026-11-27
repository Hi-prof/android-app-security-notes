package com.sample.breakpad;

/* JADX INFO: loaded from: classes.dex */
public class BreakpadInit {
    private static native void initBreakpadNative(java.lang.String str);

    static {
        java.lang.System.loadLibrary("breakpad-core");
    }

    public static void initBreakpad(java.lang.String str) {
        initBreakpadNative(str);
    }
}
