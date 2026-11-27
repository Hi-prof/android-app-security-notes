package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentedMemoryCache<K, V> implements com.facebook.imagepipeline.cache.MemoryCache<K, V> {
    private final com.facebook.imagepipeline.cache.MemoryCache<K, V> mDelegate;
    private final com.facebook.imagepipeline.cache.MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(com.facebook.imagepipeline.cache.MemoryCache<K, V> memoryCache, com.facebook.imagepipeline.cache.MemoryCacheTracker memoryCacheTracker) {
        this.mDelegate = memoryCache;
        this.mTracker = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> get(K k) {
        com.facebook.common.references.CloseableReference<V> closeableReference = this.mDelegate.get(k);
        if (closeableReference == null) {
            this.mTracker.onCacheMiss(k);
            return closeableReference;
        }
        this.mTracker.onCacheHit(k);
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public V inspect(K k) {
        return this.mDelegate.inspect(k);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        this.mDelegate.probe(k);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference) {
        this.mTracker.onCachePut(k);
        return this.mDelegate.cache(k, closeableReference);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(com.facebook.common.internal.Predicate<K> predicate) {
        return this.mDelegate.removeAll(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(com.facebook.common.internal.Predicate<K> predicate) {
        return this.mDelegate.contains((com.facebook.common.internal.Predicate) predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean contains(K k) {
        return this.mDelegate.contains(k);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getCount() {
        return this.mDelegate.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int getSizeInBytes() {
        return this.mDelegate.getSizeInBytes();
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        this.mDelegate.trim(memoryTrimType);
    }

    @Override // com.facebook.cache.common.HasDebugData
    @javax.annotation.Nullable
    public java.lang.String getDebugData() {
        return this.mDelegate.getDebugData();
    }
}
