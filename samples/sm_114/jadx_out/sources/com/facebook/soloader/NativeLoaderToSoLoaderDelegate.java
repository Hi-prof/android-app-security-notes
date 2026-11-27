package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class NativeLoaderToSoLoaderDelegate implements com.facebook.soloader.nativeloader.NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(java.lang.String str, int i) {
        return com.facebook.soloader.SoLoader.loadLibrary(str, (i & 1) != 0 ? 16 : 0);
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        return com.facebook.soloader.SoLoader.getLibraryPath(str);
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public int getSoSourcesVersion() {
        return com.facebook.soloader.SoLoader.getSoSourcesVersion();
    }
}
