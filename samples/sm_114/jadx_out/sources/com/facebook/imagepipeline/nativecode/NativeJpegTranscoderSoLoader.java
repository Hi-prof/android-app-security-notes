package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class NativeJpegTranscoderSoLoader {
    private static boolean sInitialized;

    public static synchronized void ensure() {
        if (!sInitialized) {
            com.facebook.soloader.nativeloader.NativeLoader.loadLibrary("native-imagetranscoder");
            sInitialized = true;
        }
    }
}
