package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public interface CacheEventListener {

    public enum EvictionReason {
        CACHE_FULL,
        CONTENT_STALE,
        USER_FORCED,
        CACHE_MANAGER_TRIMMED,
        TRIM_EXPIRED
    }

    void onCleared();

    void onEviction(com.facebook.cache.common.CacheEvent cacheEvent);

    void onHit(com.facebook.cache.common.CacheEvent cacheEvent);

    void onMiss(com.facebook.cache.common.CacheEvent cacheEvent);

    void onReadException(com.facebook.cache.common.CacheEvent cacheEvent);

    void onWriteAttempt(com.facebook.cache.common.CacheEvent cacheEvent);

    void onWriteException(com.facebook.cache.common.CacheEvent cacheEvent);

    void onWriteSuccess(com.facebook.cache.common.CacheEvent cacheEvent);
}
