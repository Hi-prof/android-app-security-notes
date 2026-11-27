package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class NoOpCacheEventListener implements com.facebook.cache.common.CacheEventListener {

    @javax.annotation.Nullable
    private static com.facebook.cache.common.NoOpCacheEventListener sInstance;

    @Override // com.facebook.cache.common.CacheEventListener
    public void onCleared() {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteSuccess(com.facebook.cache.common.CacheEvent cacheEvent) {
    }

    private NoOpCacheEventListener() {
    }

    public static synchronized com.facebook.cache.common.NoOpCacheEventListener getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.cache.common.NoOpCacheEventListener();
        }
        return sInstance;
    }
}
