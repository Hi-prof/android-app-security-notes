package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class StaticWebpNativeLoader {
    private static boolean sInitialized;

    public static synchronized void ensure() {
        if (!sInitialized) {
            com.facebook.soloader.nativeloader.NativeLoader.loadLibrary("static-webp");
            sInitialized = true;
        }
    }
}
