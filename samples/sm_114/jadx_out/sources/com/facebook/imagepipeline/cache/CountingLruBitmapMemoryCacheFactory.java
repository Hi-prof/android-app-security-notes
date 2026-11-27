package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class CountingLruBitmapMemoryCacheFactory implements com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory {
    @Override // com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory
    public com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> create(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> supplier, com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy cacheTrimStrategy, boolean z, boolean z2, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> entryStateObserver) {
        com.facebook.imagepipeline.cache.LruCountingMemoryCache lruCountingMemoryCache = new com.facebook.imagepipeline.cache.LruCountingMemoryCache(new com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.imagepipeline.image.CloseableImage>() { // from class: com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
                return closeableImage.getSizeInBytes();
            }
        }, cacheTrimStrategy, supplier, entryStateObserver, z, z2);
        memoryTrimmableRegistry.registerMemoryTrimmable(lruCountingMemoryCache);
        return lruCountingMemoryCache;
    }
}
