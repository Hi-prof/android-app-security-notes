package com.facebook.soloader.nativeloader;

/* JADX INFO: loaded from: classes.dex */
public class SystemDelegate implements com.facebook.soloader.nativeloader.NativeLoaderDelegate {
    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public java.lang.String getLibraryPath(java.lang.String str) {
        return null;
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public int getSoSourcesVersion() {
        return 0;
    }

    @Override // com.facebook.soloader.nativeloader.NativeLoaderDelegate
    public boolean loadLibrary(java.lang.String str, int i) {
        java.lang.System.loadLibrary(str);
        return true;
    }
}
