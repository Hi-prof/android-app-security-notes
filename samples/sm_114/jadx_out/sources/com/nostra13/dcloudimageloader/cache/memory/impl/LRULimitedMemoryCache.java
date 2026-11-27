package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class LRULimitedMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache {
    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 1.1f;
    private final java.util.Map<java.lang.String, android.graphics.Bitmap> lruCache;

    public LRULimitedMemoryCache(int i) {
        super(i);
        this.lruCache = java.util.Collections.synchronizedMap(new java.util.LinkedHashMap(10, LOAD_FACTOR, true));
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.lruCache.put(str, bitmap);
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap get(java.lang.String str) {
        this.lruCache.get(str);
        return super.get(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        this.lruCache.remove(str);
        return super.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.lruCache.clear();
        super.clear();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected int getSize(android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected android.graphics.Bitmap removeNext() {
        android.graphics.Bitmap value;
        synchronized (this.lruCache) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, android.graphics.Bitmap>> it = this.lruCache.entrySet().iterator();
            if (it.hasNext()) {
                value = it.next().getValue();
                it.remove();
            } else {
                value = null;
            }
        }
        return value;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache
    protected java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
        return new java.lang.ref.WeakReference(bitmap);
    }
}
