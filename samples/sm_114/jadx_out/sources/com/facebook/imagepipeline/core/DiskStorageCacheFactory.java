package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public class DiskStorageCacheFactory implements com.facebook.imagepipeline.core.FileCacheFactory {
    private com.facebook.imagepipeline.core.DiskStorageFactory mDiskStorageFactory;

    public DiskStorageCacheFactory(com.facebook.imagepipeline.core.DiskStorageFactory diskStorageFactory) {
        this.mDiskStorageFactory = diskStorageFactory;
    }

    private static com.facebook.cache.disk.DiskStorageCache buildDiskStorageCache(com.facebook.cache.disk.DiskCacheConfig diskCacheConfig, com.facebook.cache.disk.DiskStorage diskStorage) {
        return buildDiskStorageCache(diskCacheConfig, diskStorage, java.util.concurrent.Executors.newSingleThreadExecutor());
    }

    private static com.facebook.cache.disk.DiskStorageCache buildDiskStorageCache(com.facebook.cache.disk.DiskCacheConfig diskCacheConfig, com.facebook.cache.disk.DiskStorage diskStorage, java.util.concurrent.Executor executor) {
        return new com.facebook.cache.disk.DiskStorageCache(diskStorage, diskCacheConfig.getEntryEvictionComparatorSupplier(), new com.facebook.cache.disk.DiskStorageCache.Params(diskCacheConfig.getMinimumSizeLimit(), diskCacheConfig.getLowDiskSpaceSizeLimit(), diskCacheConfig.getDefaultSizeLimit()), diskCacheConfig.getCacheEventListener(), diskCacheConfig.getCacheErrorLogger(), diskCacheConfig.getDiskTrimmableRegistry(), executor, diskCacheConfig.getIndexPopulateAtStartupEnabled());
    }

    @Override // com.facebook.imagepipeline.core.FileCacheFactory
    public com.facebook.cache.disk.FileCache get(com.facebook.cache.disk.DiskCacheConfig diskCacheConfig) {
        return buildDiskStorageCache(diskCacheConfig, this.mDiskStorageFactory.get(diskCacheConfig));
    }
}
