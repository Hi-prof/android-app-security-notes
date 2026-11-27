package com.nostra13.dcloudimageloader.cache.disc.impl;

/* JADX INFO: loaded from: classes.dex */
public class UnlimitedDiscCache extends com.nostra13.dcloudimageloader.cache.disc.BaseDiscCache {
    @Override // com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware
    public void put(java.lang.String str, java.io.File file) {
    }

    public UnlimitedDiscCache(java.io.File file) {
        this(file, com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator());
    }

    public UnlimitedDiscCache(java.io.File file, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator) {
        super(file, fileNameGenerator);
    }
}
