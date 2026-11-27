package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public interface CacheKey {
    boolean containsUri(android.net.Uri uri);

    boolean equals(java.lang.Object obj);

    java.lang.String getUriString();

    int hashCode();

    boolean isResourceIdForDebugging();

    java.lang.String toString();
}
