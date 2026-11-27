package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class NoopSoSource extends com.facebook.soloader.SoSource {
    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) {
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    public java.io.File unpackLibrary(java.lang.String str) {
        throw new java.lang.UnsupportedOperationException("unpacking not supported in test mode");
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "NoopSoSource";
    }
}
