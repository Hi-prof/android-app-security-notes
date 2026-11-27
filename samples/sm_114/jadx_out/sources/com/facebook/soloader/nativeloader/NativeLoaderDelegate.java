package com.facebook.soloader.nativeloader;

/* JADX INFO: loaded from: classes.dex */
public interface NativeLoaderDelegate {
    public static final int SKIP_MERGED_JNI_ONLOAD = 1;

    java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException;

    int getSoSourcesVersion();

    boolean loadLibrary(java.lang.String str, int i);
}
