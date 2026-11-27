package com.nostra13.dcloudimageloader.cache.disc.impl;

/* JADX INFO: loaded from: classes.dex */
public class FileCountLimitedDiscCache extends com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache {
    @Override // com.nostra13.dcloudimageloader.cache.disc.LimitedDiscCache
    protected int getSize(java.io.File file) {
        return 1;
    }

    public FileCountLimitedDiscCache(java.io.File file, int i) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public FileCountLimitedDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator, i);
    }
}
