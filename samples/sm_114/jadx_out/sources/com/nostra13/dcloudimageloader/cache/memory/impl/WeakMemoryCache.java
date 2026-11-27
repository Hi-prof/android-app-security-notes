package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class WeakMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache {
    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache
    protected java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
        return new java.lang.ref.WeakReference(bitmap);
    }
}
