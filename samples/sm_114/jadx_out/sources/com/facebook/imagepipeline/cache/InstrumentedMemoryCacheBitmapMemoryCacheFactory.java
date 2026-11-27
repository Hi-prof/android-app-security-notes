package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentedMemoryCacheBitmapMemoryCacheFactory {
    public static com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> get(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, final com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.registerBitmapMemoryCache(memoryCache);
        return new com.facebook.imagepipeline.cache.InstrumentedMemoryCache<>(memoryCache, new com.facebook.imagepipeline.cache.MemoryCacheTracker<com.facebook.cache.common.CacheKey>() { // from class: com.facebook.imagepipeline.cache.InstrumentedMemoryCacheBitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheHit(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheHit(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCacheMiss(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCacheMiss(cacheKey);
            }

            @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
            public void onCachePut(com.facebook.cache.common.CacheKey cacheKey) {
                imageCacheStatsTracker.onBitmapCachePut(cacheKey);
            }
        });
    }
}
