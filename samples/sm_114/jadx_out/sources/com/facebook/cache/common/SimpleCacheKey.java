package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class SimpleCacheKey implements com.facebook.cache.common.CacheKey {
    final boolean mIsResourceIdForDebugging;
    final java.lang.String mKey;

    public SimpleCacheKey(java.lang.String str) {
        this(str, false);
    }

    public SimpleCacheKey(java.lang.String str, boolean z) {
        this.mKey = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(str);
        this.mIsResourceIdForDebugging = z;
    }

    @Override // com.facebook.cache.common.CacheKey
    public java.lang.String toString() {
        return this.mKey;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.facebook.cache.common.SimpleCacheKey) {
            return this.mKey.equals(((com.facebook.cache.common.SimpleCacheKey) obj).mKey);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mKey.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(android.net.Uri uri) {
        return this.mKey.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.CacheKey
    public java.lang.String getUriString() {
        return this.mKey;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return this.mIsResourceIdForDebugging;
    }
}
