package com.nostra13.dcloudimageloader.cache.disc.impl;

/* JADX INFO: loaded from: classes.dex */
public class LimitedAgeDiscCache extends com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache {
    private final java.util.Map<java.io.File, java.lang.Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiscCache(java.io.File file, long j) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator(), j);
    }

    public LimitedAgeDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator, long j) {
        super(file, fileNameGenerator);
        this.loadingDates = java.util.Collections.synchronizedMap(new java.util.HashMap());
        this.maxFileAge = j * 1000;
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public void put(java.lang.String str, java.io.File file) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        file.setLastModified(jCurrentTimeMillis);
        this.loadingDates.put(file, java.lang.Long.valueOf(jCurrentTimeMillis));
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache, com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public java.io.File get(java.lang.String str) {
        boolean z;
        java.io.File file = super.get(str);
        if (file.exists()) {
            java.lang.Long lValueOf = this.loadingDates.get(file);
            if (lValueOf == null) {
                lValueOf = java.lang.Long.valueOf(file.lastModified());
                z = false;
            } else {
                z = true;
            }
            if (java.lang.System.currentTimeMillis() - lValueOf.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
                return file;
            }
            if (!z) {
                this.loadingDates.put(file, lValueOf);
            }
        }
        return file;
    }
}
