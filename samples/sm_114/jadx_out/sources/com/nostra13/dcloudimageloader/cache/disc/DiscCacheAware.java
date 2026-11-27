package com.nostra13.dcloudimageloader.cache.disc;

/* JADX INFO: loaded from: classes.dex */
public interface DiscCacheAware {
    void clear();

    java.io.File get(java.lang.String str);

    void put(java.lang.String str, java.io.File file);
}
