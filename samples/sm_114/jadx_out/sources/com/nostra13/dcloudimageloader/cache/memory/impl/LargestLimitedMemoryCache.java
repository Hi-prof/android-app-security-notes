package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class LargestLimitedMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache {
    private final java.util.Map<android.graphics.Bitmap, java.lang.Integer> valueSizes;

    public LargestLimitedMemoryCache(int i) {
        super(i);
        this.valueSizes = java.util.Collections.synchronizedMap(new java.util.HashMap());
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.valueSizes.put(bitmap, java.lang.Integer.valueOf(getSize(bitmap)));
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        android.graphics.Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.valueSizes.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache, com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.valueSizes.clear();
        super.clear();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected int getSize(android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.LimitedMemoryCache
    protected android.graphics.Bitmap removeNext() {
        android.graphics.Bitmap key;
        java.util.Set<java.util.Map.Entry<android.graphics.Bitmap, java.lang.Integer>> setEntrySet = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            key = null;
            java.lang.Integer value = null;
            for (java.util.Map.Entry<android.graphics.Bitmap, java.lang.Integer> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    java.lang.Integer value2 = entry.getValue();
                    if (value2.intValue() > value.intValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        this.valueSizes.remove(key);
        return key;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache
    protected java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
        return new java.lang.ref.WeakReference(bitmap);
    }
}
