package com.nostra13.dcloudimageloader.cache.memory;

/* JADX INFO: loaded from: classes.dex */
public interface MemoryCacheAware {
    void clear();

    android.graphics.Bitmap get(java.lang.String str);

    java.util.Collection<java.lang.String> keys();

    boolean put(java.lang.String str, android.graphics.Bitmap bitmap);

    android.graphics.Bitmap remove(java.lang.String str);
}
