package com.nostra13.dcloudimageloader.cache.disc;

/* JADX INFO: loaded from: classes.dex */
public abstract class LimitedDiscCache extends com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache {
    private static final int INVALID_SIZE = -1;
    private final java.util.concurrent.atomic.AtomicInteger cacheSize;
    private final java.util.Map<java.io.File, java.lang.Long> lastUsageDates;
    private final int sizeLimit;

    protected abstract int getSize(java.io.File file);

    public LimitedDiscCache(java.io.File file, int i) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public LimitedDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator);
        this.lastUsageDates = java.util.Collections.synchronizedMap(new java.util.HashMap());
        this.sizeLimit = i;
        this.cacheSize = new java.util.concurrent.atomic.AtomicInteger();
        calculateCacheSizeAndFillUsageMap();
    }

    private void calculateCacheSizeAndFillUsageMap() {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache.1
            @Override // java.lang.Runnable
            public void run() {
                java.io.File[] fileArrListFiles = com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache.this.cacheDir.listFiles();
                if (fileArrListFiles != null) {
                    int size = 0;
                    for (java.io.File file : fileArrListFiles) {
                        size += com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache.this.getSize(file);
                        com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache.this.lastUsageDates.put(file, java.lang.Long.valueOf(file.lastModified()));
                    }
                    com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache.this.cacheSize.set(size);
                }
            }
        }).start();
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public void put(java.lang.String str, java.io.File file) {
        int iRemoveNext;
        int size = getSize(file);
        int iAddAndGet = this.cacheSize.get();
        while (iAddAndGet + size > this.sizeLimit && (iRemoveNext = removeNext()) != -1) {
            iAddAndGet = this.cacheSize.addAndGet(-iRemoveNext);
        }
        this.cacheSize.addAndGet(size);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.Long lValueOf = java.lang.Long.valueOf(jCurrentTimeMillis);
        lValueOf.getClass();
        file.setLastModified(jCurrentTimeMillis);
        this.lastUsageDates.put(file, lValueOf);
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache, com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public java.io.File get(java.lang.String str) {
        java.io.File file = super.get(str);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.Long lValueOf = java.lang.Long.valueOf(jCurrentTimeMillis);
        lValueOf.getClass();
        file.setLastModified(jCurrentTimeMillis);
        this.lastUsageDates.put(file, lValueOf);
        return file;
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache, com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public void clear() {
        this.lastUsageDates.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    private int removeNext() {
        java.io.File key;
        if (this.lastUsageDates.isEmpty()) {
            return -1;
        }
        java.util.Set<java.util.Map.Entry<java.io.File, java.lang.Long>> setEntrySet = this.lastUsageDates.entrySet();
        synchronized (this.lastUsageDates) {
            key = null;
            java.lang.Long value = null;
            for (java.util.Map.Entry<java.io.File, java.lang.Long> entry : setEntrySet) {
                if (key == null) {
                    key = entry.getKey();
                    value = entry.getValue();
                } else {
                    java.lang.Long value2 = entry.getValue();
                    if (value2.longValue() < value.longValue()) {
                        key = entry.getKey();
                        value = value2;
                    }
                }
            }
        }
        if (key != null) {
            if (key.exists()) {
                int size = getSize(key);
                if (key.delete()) {
                    this.lastUsageDates.remove(key);
                }
                return size;
            }
            this.lastUsageDates.remove(key);
        }
        return 0;
    }
}
