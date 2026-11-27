package com.nostra13.dcloudimageloader.cache.memory.impl;

/* JADX INFO: loaded from: classes.dex */
public class LimitedAgeMemoryCache implements com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware {
    private final com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware cache;
    private final java.util.Map<java.lang.String, java.lang.Long> loadingDates = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private final long maxAge;

    public LimitedAgeMemoryCache(com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware, long j) {
        this.cache = memoryCacheAware;
        this.maxAge = j * 1000;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        boolean zPut = this.cache.put(str, bitmap);
        if (zPut) {
            this.loadingDates.put(str, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        }
        return zPut;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap get(java.lang.String str) {
        java.lang.Long l = this.loadingDates.get(str);
        if (l != null && java.lang.System.currentTimeMillis() - l.longValue() > this.maxAge) {
            this.cache.remove(str);
            this.loadingDates.remove(str);
        }
        return this.cache.get(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        this.loadingDates.remove(str);
        return this.cache.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public java.util.Collection<java.lang.String> keys() {
        return this.cache.keys();
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.cache.clear();
        this.loadingDates.clear();
    }
}
