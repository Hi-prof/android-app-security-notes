package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public class DynamicDefaultDiskStorageFactory implements com.facebook.imagepipeline.core.DiskStorageFactory {
    @Override // com.facebook.imagepipeline.core.DiskStorageFactory
    public com.facebook.cache.disk.DiskStorage get(com.facebook.cache.disk.DiskCacheConfig diskCacheConfig) {
        return new com.facebook.cache.disk.DynamicDefaultDiskStorage(diskCacheConfig.getVersion(), diskCacheConfig.getBaseDirectoryPathSupplier(), diskCacheConfig.getBaseDirectoryName(), diskCacheConfig.getCacheErrorLogger());
    }
}
