package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class SettableCacheEvent implements com.facebook.cache.common.CacheEvent {
    private static final int MAX_RECYCLED = 5;
    private static final java.lang.Object RECYCLER_LOCK = new java.lang.Object();

    @javax.annotation.Nullable
    private static com.facebook.cache.disk.SettableCacheEvent sFirstRecycledEvent;
    private static int sRecycledCount;

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheKey mCacheKey;
    private long mCacheLimit;
    private long mCacheSize;

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheEventListener.EvictionReason mEvictionReason;

    @javax.annotation.Nullable
    private java.io.IOException mException;
    private long mItemSize;

    @javax.annotation.Nullable
    private com.facebook.cache.disk.SettableCacheEvent mNextRecycledEvent;

    @javax.annotation.Nullable
    private java.lang.String mResourceId;

    public static com.facebook.cache.disk.SettableCacheEvent obtain() {
        synchronized (RECYCLER_LOCK) {
            com.facebook.cache.disk.SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
            if (settableCacheEvent != null) {
                sFirstRecycledEvent = settableCacheEvent.mNextRecycledEvent;
                settableCacheEvent.mNextRecycledEvent = null;
                sRecycledCount--;
                return settableCacheEvent;
            }
            return new com.facebook.cache.disk.SettableCacheEvent();
        }
    }

    private SettableCacheEvent() {
    }

    @Override // com.facebook.cache.common.CacheEvent
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    public com.facebook.cache.disk.SettableCacheEvent setCacheKey(com.facebook.cache.common.CacheKey cacheKey) {
        this.mCacheKey = cacheKey;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @javax.annotation.Nullable
    public java.lang.String getResourceId() {
        return this.mResourceId;
    }

    public com.facebook.cache.disk.SettableCacheEvent setResourceId(java.lang.String str) {
        this.mResourceId = str;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getItemSize() {
        return this.mItemSize;
    }

    public com.facebook.cache.disk.SettableCacheEvent setItemSize(long j) {
        this.mItemSize = j;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheSize() {
        return this.mCacheSize;
    }

    public com.facebook.cache.disk.SettableCacheEvent setCacheSize(long j) {
        this.mCacheSize = j;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    public long getCacheLimit() {
        return this.mCacheLimit;
    }

    public com.facebook.cache.disk.SettableCacheEvent setCacheLimit(long j) {
        this.mCacheLimit = j;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @javax.annotation.Nullable
    public java.io.IOException getException() {
        return this.mException;
    }

    public com.facebook.cache.disk.SettableCacheEvent setException(java.io.IOException iOException) {
        this.mException = iOException;
        return this;
    }

    @Override // com.facebook.cache.common.CacheEvent
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheEventListener.EvictionReason getEvictionReason() {
        return this.mEvictionReason;
    }

    public com.facebook.cache.disk.SettableCacheEvent setEvictionReason(com.facebook.cache.common.CacheEventListener.EvictionReason evictionReason) {
        this.mEvictionReason = evictionReason;
        return this;
    }

    public void recycle() {
        synchronized (RECYCLER_LOCK) {
            if (sRecycledCount < 5) {
                reset();
                sRecycledCount++;
                com.facebook.cache.disk.SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
                if (settableCacheEvent != null) {
                    this.mNextRecycledEvent = settableCacheEvent;
                }
                sFirstRecycledEvent = this;
            }
        }
    }

    private void reset() {
        this.mCacheKey = null;
        this.mResourceId = null;
        this.mItemSize = 0L;
        this.mCacheLimit = 0L;
        this.mCacheSize = 0L;
        this.mException = null;
        this.mEvictionReason = null;
    }
}
