package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class NoOpImageCacheStatsTracker implements com.facebook.imagepipeline.cache.ImageCacheStatsTracker {

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker sInstance;

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheHit(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheMiss(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCachePut(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheGetFail(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheHit(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheMiss(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCachePut(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheHit(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheMiss(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCachePut(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaHit(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaMiss(com.facebook.cache.common.CacheKey cacheKey) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerBitmapMemoryCache(com.facebook.imagepipeline.cache.MemoryCache<?, ?> memoryCache) {
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerEncodedMemoryCache(com.facebook.imagepipeline.cache.MemoryCache<?, ?> memoryCache) {
    }

    private NoOpImageCacheStatsTracker() {
    }

    public static synchronized com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker();
        }
        return sInstance;
    }
}
