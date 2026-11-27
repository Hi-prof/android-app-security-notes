package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: DiskCachesStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/facebook/imagepipeline/core/DiskCachesStoreFactory;", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "fileCacheFactory", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "memoryChunkType", "", "mainDiskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "smallImageDiskCacheConfig", "dynamicDiskCacheConfigMap", "", "", "<init>", "(Lcom/facebook/imagepipeline/core/FileCacheFactory;Lcom/facebook/imagepipeline/memory/PoolFactory;Lcom/facebook/imagepipeline/core/ExecutorSupplier;Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;ILcom/facebook/cache/disk/DiskCacheConfig;Lcom/facebook/cache/disk/DiskCacheConfig;Ljava/util/Map;)V", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG, "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "(Lcom/facebook/imagepipeline/core/FileCacheFactory;Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;)V", "diskCachesStore", "getDiskCachesStore", "()Lcom/facebook/imagepipeline/core/DiskCachesStore;", "diskCachesStore$delegate", "Lkotlin/Lazy;", "get", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DiskCachesStoreFactory implements com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> {

    /* JADX INFO: renamed from: diskCachesStore$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy diskCachesStore;
    private final java.util.Map<java.lang.String, com.facebook.cache.disk.DiskCacheConfig> dynamicDiskCacheConfigMap;
    private final com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier;
    private final com.facebook.imagepipeline.core.FileCacheFactory fileCacheFactory;
    private final com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker;
    private final com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig;
    private final int memoryChunkType;
    private final com.facebook.imagepipeline.memory.PoolFactory poolFactory;
    private final com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public DiskCachesStoreFactory(com.facebook.imagepipeline.core.FileCacheFactory fileCacheFactory, com.facebook.imagepipeline.memory.PoolFactory poolFactory, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker, int i, com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig, com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig, java.util.Map<java.lang.String, ? extends com.facebook.cache.disk.DiskCacheConfig> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mainDiskCacheConfig, "mainDiskCacheConfig");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smallImageDiskCacheConfig, "smallImageDiskCacheConfig");
        this.fileCacheFactory = fileCacheFactory;
        this.poolFactory = poolFactory;
        this.executorSupplier = executorSupplier;
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.memoryChunkType = i;
        this.mainDiskCacheConfig = mainDiskCacheConfig;
        this.smallImageDiskCacheConfig = smallImageDiskCacheConfig;
        this.dynamicDiskCacheConfigMap = map;
        this.diskCachesStore = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.DiskCachesStoreFactory.diskCachesStore_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskCachesStoreFactory(com.facebook.imagepipeline.core.FileCacheFactory fileCacheFactory, com.facebook.imagepipeline.core.ImagePipelineConfigInterface config) {
        this(fileCacheFactory, config.getPoolFactory(), config.getExecutorSupplier(), config.getImageCacheStatsTracker(), config.getMemoryChunkType(), config.getMainDiskCacheConfig(), config.getSmallImageDiskCacheConfig(), config.getDynamicDiskCacheConfigMap());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
    }

    private final com.facebook.imagepipeline.core.DiskCachesStore getDiskCachesStore() {
        return (com.facebook.imagepipeline.core.DiskCachesStore) this.diskCachesStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStore_delegate$lambda$0(com.facebook.imagepipeline.core.DiskCachesStoreFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1(this$0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public com.facebook.imagepipeline.core.DiskCachesStore get() {
        return getDiskCachesStore();
    }
}
