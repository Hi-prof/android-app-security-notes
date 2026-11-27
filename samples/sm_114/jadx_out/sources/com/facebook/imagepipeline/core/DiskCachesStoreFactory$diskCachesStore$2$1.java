package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: DiskCachesStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001b\u0010\u0002\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005R\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000bR'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"com/facebook/imagepipeline/core/DiskCachesStoreFactory$diskCachesStore$2$1", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "mainFileCache", "Lcom/facebook/cache/disk/FileCache;", "getMainFileCache", "()Lcom/facebook/cache/disk/FileCache;", "mainFileCache$delegate", "Lkotlin/Lazy;", "mainBufferedDiskCache", "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "getMainBufferedDiskCache", "()Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "mainBufferedDiskCache$delegate", "smallImageFileCache", "getSmallImageFileCache", "smallImageFileCache$delegate", "smallImageBufferedDiskCache", "getSmallImageBufferedDiskCache", "smallImageBufferedDiskCache$delegate", "dynamicFileCaches", "", "", "getDynamicFileCaches", "()Ljava/util/Map;", "dynamicFileCaches$delegate", "dynamicBufferedDiskCaches", "Lcom/facebook/common/internal/ImmutableMap;", "getDynamicBufferedDiskCaches", "()Lcom/facebook/common/internal/ImmutableMap;", "dynamicBufferedDiskCaches$delegate", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DiskCachesStoreFactory$diskCachesStore$2$1 implements com.facebook.imagepipeline.core.DiskCachesStore {

    /* JADX INFO: renamed from: dynamicBufferedDiskCaches$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy dynamicBufferedDiskCaches;

    /* JADX INFO: renamed from: dynamicFileCaches$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy dynamicFileCaches;

    /* JADX INFO: renamed from: mainBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy mainBufferedDiskCache;

    /* JADX INFO: renamed from: mainFileCache$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy mainFileCache;

    /* JADX INFO: renamed from: smallImageBufferedDiskCache$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy smallImageBufferedDiskCache;

    /* JADX INFO: renamed from: smallImageFileCache$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy smallImageFileCache;

    DiskCachesStoreFactory$diskCachesStore$2$1(final com.facebook.imagepipeline.core.DiskCachesStoreFactory diskCachesStoreFactory) {
        this.mainFileCache = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.mainFileCache_delegate$lambda$0(diskCachesStoreFactory);
            }
        });
        this.mainBufferedDiskCache = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.mainBufferedDiskCache_delegate$lambda$1(this.f$0, diskCachesStoreFactory);
            }
        });
        this.smallImageFileCache = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.smallImageFileCache_delegate$lambda$2(diskCachesStoreFactory);
            }
        });
        this.smallImageBufferedDiskCache = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.smallImageBufferedDiskCache_delegate$lambda$3(this.f$0, diskCachesStoreFactory);
            }
        });
        this.dynamicFileCaches = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.dynamicFileCaches_delegate$lambda$7(diskCachesStoreFactory, this);
            }
        });
        this.dynamicBufferedDiskCaches = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1.dynamicBufferedDiskCaches_delegate$lambda$9(this.f$0, diskCachesStoreFactory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.cache.disk.FileCache mainFileCache_delegate$lambda$0(com.facebook.imagepipeline.core.DiskCachesStoreFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.mainDiskCacheConfig);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public com.facebook.cache.disk.FileCache getMainFileCache() {
        return (com.facebook.cache.disk.FileCache) this.mainFileCache.getValue();
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public com.facebook.imagepipeline.cache.BufferedDiskCache getMainBufferedDiskCache() {
        return (com.facebook.imagepipeline.cache.BufferedDiskCache) this.mainBufferedDiskCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache_delegate$lambda$1(com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1 this$0, com.facebook.imagepipeline.core.DiskCachesStoreFactory this$1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$1, "this$1");
        com.facebook.cache.disk.FileCache mainFileCache = this$0.getMainFileCache();
        com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        com.facebook.common.memory.PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        java.util.concurrent.Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
        java.util.concurrent.Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new com.facebook.imagepipeline.cache.BufferedDiskCache(mainFileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public com.facebook.cache.disk.FileCache getSmallImageFileCache() {
        return (com.facebook.cache.disk.FileCache) this.smallImageFileCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.cache.disk.FileCache smallImageFileCache_delegate$lambda$2(com.facebook.imagepipeline.core.DiskCachesStoreFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.smallImageDiskCacheConfig);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public com.facebook.imagepipeline.cache.BufferedDiskCache getSmallImageBufferedDiskCache() {
        return (com.facebook.imagepipeline.cache.BufferedDiskCache) this.smallImageBufferedDiskCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.cache.BufferedDiskCache smallImageBufferedDiskCache_delegate$lambda$3(com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1 this$0, com.facebook.imagepipeline.core.DiskCachesStoreFactory this$1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$1, "this$1");
        com.facebook.cache.disk.FileCache smallImageFileCache = this$0.getSmallImageFileCache();
        com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        com.facebook.common.memory.PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        java.util.concurrent.Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
        java.util.concurrent.Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new com.facebook.imagepipeline.cache.BufferedDiskCache(smallImageFileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public java.util.Map<java.lang.String, com.facebook.cache.disk.FileCache> getDynamicFileCaches() {
        return (java.util.Map) this.dynamicFileCaches.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map dynamicFileCaches_delegate$lambda$7(com.facebook.imagepipeline.core.DiskCachesStoreFactory this$0, com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1 this$1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$1, "this$1");
        java.util.Map map = this$0.dynamicDiskCacheConfigMap;
        if (map == null) {
            return kotlin.collections.MapsKt.emptyMap();
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(map.size()));
        for (java.util.Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), this$0.fileCacheFactory.get((com.facebook.cache.disk.DiskCacheConfig) entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public com.facebook.common.internal.ImmutableMap<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache> getDynamicBufferedDiskCaches() {
        java.lang.Object value = this.dynamicBufferedDiskCaches.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.common.internal.ImmutableMap) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.common.internal.ImmutableMap dynamicBufferedDiskCaches_delegate$lambda$9(com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1 this$0, com.facebook.imagepipeline.core.DiskCachesStoreFactory this$1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$1, "this$1");
        java.util.Map<java.lang.String, com.facebook.cache.disk.FileCache> dynamicFileCaches = this$0.getDynamicFileCaches();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(dynamicFileCaches.size()));
        java.util.Iterator<T> it = dynamicFileCaches.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            java.lang.Object key = entry.getKey();
            com.facebook.cache.disk.FileCache fileCache = (com.facebook.cache.disk.FileCache) entry.getValue();
            com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
            com.facebook.common.memory.PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
            java.util.concurrent.Executor ioBoundExecutor = this$1.executorSupplier.getIoBoundExecutor();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ioBoundExecutor, "forLocalStorageRead(...)");
            java.util.concurrent.Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
            linkedHashMap.put(key, new com.facebook.imagepipeline.cache.BufferedDiskCache(fileCache, pooledByteBufferFactory, pooledByteStreams, ioBoundExecutor, executorForLocalStorageWrite, this$1.imageCacheStatsTracker));
        }
        return com.facebook.common.internal.ImmutableMap.copyOf((java.util.Map) linkedHashMap);
    }
}
