package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class MultiCacheKey implements com.facebook.cache.common.CacheKey {
    final java.util.List<com.facebook.cache.common.CacheKey> mCacheKeys;

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public MultiCacheKey(java.util.List<com.facebook.cache.common.CacheKey> list) {
        this.mCacheKeys = (java.util.List) com.facebook.common.internal.Preconditions.checkNotNull(list);
    }

    public java.util.List<com.facebook.cache.common.CacheKey> getCacheKeys() {
        return this.mCacheKeys;
    }

    @Override // com.facebook.cache.common.CacheKey
    public java.lang.String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.facebook.cache.common.MultiCacheKey) {
            return this.mCacheKeys.equals(((com.facebook.cache.common.MultiCacheKey) obj).mCacheKeys);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(android.net.Uri uri) {
        for (int i = 0; i < this.mCacheKeys.size(); i++) {
            if (this.mCacheKeys.get(i).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public java.lang.String getUriString() {
        return this.mCacheKeys.get(0).getUriString();
    }
}
