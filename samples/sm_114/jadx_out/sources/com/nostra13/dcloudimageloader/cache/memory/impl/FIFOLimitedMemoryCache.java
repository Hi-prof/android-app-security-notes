package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class FIFOLimitedMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache {
    private final java.util.List<android.graphics.Bitmap> queue;

    public FIFOLimitedMemoryCache(int i) {
        super(i);
        this.queue = java.util.Collections.synchronizedList(new java.util.LinkedList());
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.queue.add(bitmap);
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        android.graphics.Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.queue.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.queue.clear();
        super.clear();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected int getSize(android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected android.graphics.Bitmap removeNext() {
        return this.queue.remove(0);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache
    protected java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
        return new java.lang.ref.WeakReference(bitmap);
    }
}
