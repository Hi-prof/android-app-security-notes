package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class UsingFreqLimitedMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache {
    private final java.util.Map<android.graphics.Bitmap, java.lang.Integer> usingCounts;

    public UsingFreqLimitedMemoryCache(int i) {
        super(i);
        this.usingCounts = java.util.Collections.synchronizedMap(new java.util.HashMap());
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.usingCounts.put(bitmap, 0);
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap get(java.lang.String str) {
        java.lang.Integer num;
        android.graphics.Bitmap bitmap = super.get(str);
        if (bitmap != null && (num = this.usingCounts.get(bitmap)) != null) {
            this.usingCounts.put(bitmap, java.lang.Integer.valueOf(num.intValue() + 1));
        }
        return bitmap;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        android.graphics.Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.usingCounts.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.usingCounts.clear();
        super.clear();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected int getSize(android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected android.graphics.Bitmap removeNext() {
        android.graphics.Bitmap key;
        java.util.Set<java.util.Map.Entry<android.graphics.Bitmap, java.lang.Integer>> setEntrySet = this.usingCounts.entrySet();
        synchronized (this.usingCounts) {
            key = null;
            java.lang.Integer value = null;
            for (java.util.Map.Entry<android.graphics.Bitmap, java.lang.Integer> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    java.lang.Integer value2 = entry.getValue();
                    if (value2.intValue() < value.intValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        this.usingCounts.remove(key);
        return key;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache
    protected java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
        return new java.lang.ref.WeakReference(bitmap);
    }
}
