package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public interface FileCache extends com.facebook.common.disk.DiskTrimmable {
    void clearAll();

    long clearOldEntries(long j);

    long getCount();

    com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.io.IOException;

    @javax.annotation.Nullable
    com.facebook.binaryresource.BinaryResource getResource(com.facebook.cache.common.CacheKey cacheKey);

    long getSize();

    boolean hasKey(com.facebook.cache.common.CacheKey cacheKey);

    boolean hasKeySync(com.facebook.cache.common.CacheKey cacheKey);

    @javax.annotation.Nullable
    com.facebook.binaryresource.BinaryResource insert(com.facebook.cache.common.CacheKey cacheKey, com.facebook.cache.common.WriterCallback writerCallback) throws java.io.IOException;

    boolean isEnabled();

    boolean probe(com.facebook.cache.common.CacheKey cacheKey);

    void remove(com.facebook.cache.common.CacheKey cacheKey);
}
