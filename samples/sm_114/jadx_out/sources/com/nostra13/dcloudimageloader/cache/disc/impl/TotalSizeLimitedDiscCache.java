package com.nostra13.dcloudimageloader.cache.disc.impl;

/* JADX INFO: loaded from: classes.dex */
public class TotalSizeLimitedDiscCache extends com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache {
    private static final int MIN_NORMAL_CACHE_SIZE = 2097152;
    private static final int MIN_NORMAL_CACHE_SIZE_IN_MB = 2;

    public TotalSizeLimitedDiscCache(java.io.File file, int i) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public TotalSizeLimitedDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator, i);
        if (i < 2097152) {
            com.nostra13.dcloudimageloader.utils.L.w("You set too small disc cache size (less than %1$d Mb)", 2);
        }
    }

    @Override // com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache
    protected int getSize(java.io.File file) {
        return (int) file.length();
    }
}
