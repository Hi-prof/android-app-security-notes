package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class LruMemoryCache implements com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware {
    private final java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new java.util.LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public final android.graphics.Bitmap get(java.lang.String str) {
        android.graphics.Bitmap bitmap;
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.map.get(str);
        }
        return bitmap;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public final boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += sizeOf(str, bitmap);
            android.graphics.Bitmap bitmapPut = this.map.put(str, bitmap);
            if (bitmapPut != null) {
                this.size -= sizeOf(str, bitmapPut);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size > i && !this.map.isEmpty()) {
                    java.util.Map.Entry<java.lang.String, android.graphics.Bitmap> next = this.map.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    java.lang.String key = next.getKey();
                    android.graphics.Bitmap value = next.getValue();
                    this.map.remove(key);
                    this.size -= sizeOf(key, value);
                }
                return;
            }
        }
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public final android.graphics.Bitmap remove(java.lang.String str) {
        android.graphics.Bitmap bitmapRemove;
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            bitmapRemove = this.map.remove(str);
            if (bitmapRemove != null) {
                this.size -= sizeOf(str, bitmapRemove);
            }
        }
        return bitmapRemove;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public java.util.Collection<java.lang.String> keys() {
        java.util.HashSet hashSet;
        synchronized (this) {
            hashSet = new java.util.HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        trimToSize(-1);
    }

    private int sizeOf(java.lang.String str, android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized java.lang.String toString() {
        return java.lang.String.format("LruCache[maxSize=%d]", java.lang.Integer.valueOf(this.maxSize));
    }
}
