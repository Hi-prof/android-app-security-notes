package com.nostra13.dcloudimageloader.cache.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class LimitedMemoryCache extends com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final java.util.List<android.graphics.Bitmap> hardCache = java.util.Collections.synchronizedList(new java.util.LinkedList());
    private final java.util.concurrent.atomic.AtomicInteger cacheSize = new java.util.concurrent.atomic.AtomicInteger();

    protected abstract int getSize(android.graphics.Bitmap bitmap);

    protected abstract android.graphics.Bitmap removeNext();

    public LimitedMemoryCache(int i) {
        this.sizeLimit = i;
        if (i > 16777216) {
            com.nostra13.dcloudimageloader.utils.L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
        boolean z;
        int size = getSize(bitmap);
        int sizeLimit = getSizeLimit();
        int iAddAndGet = this.cacheSize.get();
        if (size < sizeLimit) {
            while (iAddAndGet + size > sizeLimit) {
                android.graphics.Bitmap bitmapRemoveNext = removeNext();
                if (this.hardCache.remove(bitmapRemoveNext)) {
                    iAddAndGet = this.cacheSize.addAndGet(-getSize(bitmapRemoveNext));
                }
            }
            this.hardCache.add(bitmap);
            this.cacheSize.addAndGet(size);
            z = true;
        } else {
            z = false;
        }
        super.put(str, bitmap);
        return z;
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public android.graphics.Bitmap remove(java.lang.String str) {
        android.graphics.Bitmap bitmap = super.get(str);
        if (bitmap != null && this.hardCache.remove(bitmap)) {
            this.cacheSize.addAndGet(-getSize(bitmap));
        }
        return super.remove(str);
    }

    @Override // com.nostra13.dcloudimageloader.cache.memory.BaseMemoryCache, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected int getSizeLimit() {
        return this.sizeLimit;
    }
}
