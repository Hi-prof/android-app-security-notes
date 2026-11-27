package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class DebuggingCacheKey extends com.facebook.cache.common.SimpleCacheKey {

    @javax.annotation.Nullable
    private final java.lang.Object mCallerContext;
    private final android.net.Uri mSourceUri;

    public DebuggingCacheKey(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj, android.net.Uri uri) {
        super(str);
        this.mCallerContext = obj;
        this.mSourceUri = uri;
    }

    @javax.annotation.Nullable
    public java.lang.Object getCallerContext() {
        return this.mCallerContext;
    }

    public android.net.Uri getSourceUri() {
        return this.mSourceUri;
    }
}
