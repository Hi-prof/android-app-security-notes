package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public interface CacheEvent {
    @javax.annotation.Nullable
    com.facebook.cache.common.CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    @javax.annotation.Nullable
    com.facebook.cache.common.CacheEventListener.EvictionReason getEvictionReason();

    @javax.annotation.Nullable
    java.io.IOException getException();

    long getItemSize();

    @javax.annotation.Nullable
    java.lang.String getResourceId();
}
