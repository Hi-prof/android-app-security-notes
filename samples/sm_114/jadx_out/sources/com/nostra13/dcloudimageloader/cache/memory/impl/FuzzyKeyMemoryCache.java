package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class FuzzyKeyMemoryCache implements com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware {
    private final com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware cache;
    private final java.util.Comparator<java.lang.String> keyComparator;

    public FuzzyKeyMemoryCache(com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware, java.util.Comparator<java.lang.String> comparator) {
        this.cache = memoryCacheAware;
        this.keyComparator = comparator;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        java.lang.String next;
        synchronized (this.cache) {
            java.util.Iterator<java.lang.String> it = this.cache.keys().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (this.keyComparator.compare(str, next) != 0);
            if (next != null) {
                this.cache.remove(next);
            }
        }
        return this.cache.put(str, bitmap);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap get(java.lang.String str) {
        return this.cache.get(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        return this.cache.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.cache.clear();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public java.util.Collection<java.lang.String> keys() {
        return this.cache.keys();
    }
}
