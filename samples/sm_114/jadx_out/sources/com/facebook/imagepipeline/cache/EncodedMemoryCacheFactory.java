package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class EncodedMemoryCacheFactory {
    public static com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> get(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache, final com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerEncodedMemoryCache(memoryCache);
        return new com.facebook.imagepipeline.cache.InstrumentedMemoryCache<>(memoryCache, new com.facebook.imagepipeline.cache.MemoryCacheTracker<com.facebook.cache.common.CacheKey>() { // from class: com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheHit(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheMiss(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCacheMiss(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCachePut(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onMemoryCachePut(cacheKey);
            }
        });
    }
}
