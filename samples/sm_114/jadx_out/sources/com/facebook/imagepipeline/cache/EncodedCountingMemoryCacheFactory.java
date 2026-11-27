package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class EncodedCountingMemoryCacheFactory {
    public static com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> get(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> supplier, com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy cacheTrimStrategy) {
        com.facebook.imagepipeline.cache.LruCountingMemoryCache lruCountingMemoryCache = new com.facebook.imagepipeline.cache.LruCountingMemoryCache(new com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.common.memory.PooledByteBuffer>() { // from class: com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(com.facebook.common.memory.PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, cacheTrimStrategy, supplier, null, false, false);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
