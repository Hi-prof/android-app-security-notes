package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class NoOpCacheErrorLogger implements com.facebook.cache.common.CacheErrorLogger {

    @javax.annotation.Nullable
    private static com.facebook.cache.common.NoOpCacheErrorLogger sInstance;

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory cacheErrorCategory, java.lang.Class<?> cls, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
    }

    private NoOpCacheErrorLogger() {
    }

    public static synchronized com.facebook.cache.common.NoOpCacheErrorLogger getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.cache.common.NoOpCacheErrorLogger();
        }
        return sInstance;
    }
}
