package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: ImagePipelineConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u009a\u00012\u00020\u0001:\u0006\u0098\u0001\u0099\u0001\u009a\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000eR\u0014\u0010+\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u0004\u0018\u000104X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u0004\u0018\u000108X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000eR\u001e\u0010>\u001a\u0004\u0018\u00010?X\u0096\u0004¢\u0006\u0010\n\u0002\u0010D\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020<0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000eR\u0014\u0010F\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020KX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020?X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010A\u001a\u0004\bP\u0010QR\u0018\u0010R\u001a\u0006\u0012\u0002\b\u00030SX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\u0004\u0018\u00010XX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020`X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020i0dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010gR\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020l0dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010gR\u0014\u0010n\u001a\u00020<X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010IR\u0016\u0010r\u001a\u0004\u0018\u00010sX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020wX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020<X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010oR\u0016\u0010{\u001a\u0004\u0018\u00010|X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0017\u0010\u007f\u001a\u00030\u0080\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u0083\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0085\u0001\u0018\u00010\u0084\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010\u0088\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0084\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u0087\u0001R\u001a\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R'\u0010\u0093\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0004\u0012\u00020G\u0018\u00010\u0094\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "bitmapMemoryCacheParamsSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "getBitmapMemoryCacheParamsSupplier", "()Lcom/facebook/common/internal/Supplier;", "bitmapMemoryCacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "getBitmapMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "encodedMemoryCacheTrimStrategy", "getEncodedMemoryCacheTrimStrategy", "bitmapMemoryCacheEntryStateObserver", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "Lcom/facebook/cache/common/CacheKey;", "getBitmapMemoryCacheEntryStateObserver", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "diskCachesStoreSupplier", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "getDiskCachesStoreSupplier", "encodedMemoryCacheParamsSupplier", "getEncodedMemoryCacheParamsSupplier", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "getImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "getImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "enableEncodedImageColorSpaceUsage", "", "getEnableEncodedImageColorSpaceUsage", "imageTranscoderType", "", "getImageTranscoderType$annotations", "()V", "getImageTranscoderType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isPrefetchEnabledSupplier", "mainDiskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "getMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "memoryChunkType", "getMemoryChunkType$annotations", "getMemoryChunkType", "()I", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "getNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "httpNetworkTimeout", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "getPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "requestListeners", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getRequestListeners", "()Ljava/util/Set;", "requestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "getRequestListener2s", "customProducerSequenceFactories", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "getCustomProducerSequenceFactories", "isResizeAndRotateEnabledForNetwork", "()Z", "smallImageDiskCacheConfig", "getSmallImageDiskCacheConfig", "imageDecoderConfig", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "getImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "experiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "getExperiments", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "isDiskCacheEnabled", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "getCallerContextVerifier", "()Lcom/facebook/callercontext/CallerContextVerifier;", "closeableReferenceLeakTracker", "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "getCloseableReferenceLeakTracker", "()Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "bitmapCacheOverride", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getBitmapCacheOverride", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "encodedMemoryCacheOverride", "Lcom/facebook/common/memory/PooledByteBuffer;", "getEncodedMemoryCacheOverride", "executorServiceForAnimatedImages", "Lcom/facebook/common/executors/SerialExecutorService;", "getExecutorServiceForAnimatedImages", "()Lcom/facebook/common/executors/SerialExecutorService;", "bitmapMemoryCacheFactory", "Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "getBitmapMemoryCacheFactory", "()Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "dynamicDiskCacheConfigMap", "", "", "getDynamicDiskCacheConfigMap", "()Ljava/util/Map;", "DefaultImageRequestConfig", "Builder", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagePipelineConfig implements com.facebook.imagepipeline.core.ImagePipelineConfigInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.core.ImagePipelineConfig.Companion INSTANCE = new com.facebook.imagepipeline.core.ImagePipelineConfig.Companion(null);
    private static com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig defaultImageRequestConfig = new com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig();
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapCacheOverride;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> bitmapMemoryCacheEntryStateObserver;
    private final com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> bitmapMemoryCacheParamsSupplier;
    private final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
    private final com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory;
    private final com.facebook.callercontext.CallerContextVerifier callerContextVerifier;
    private final com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker closeableReferenceLeakTracker;
    private final android.content.Context context;
    private final java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> customProducerSequenceFactories;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier;
    private final com.facebook.imagepipeline.core.DownsampleMode downsampleMode;
    private final java.util.Map<java.lang.String, com.facebook.cache.disk.DiskCacheConfig> dynamicDiskCacheConfigMap;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> enableEncodedImageColorSpaceUsage;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCacheOverride;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> encodedMemoryCacheParamsSupplier;
    private final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
    private final com.facebook.common.executors.SerialExecutorService executorServiceForAnimatedImages;
    private final com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier;
    private final com.facebook.imagepipeline.core.ImagePipelineExperiments experiments;
    private final int httpNetworkTimeout;
    private final com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker;
    private final com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
    private final com.facebook.imagepipeline.decoder.ImageDecoderConfig imageDecoderConfig;
    private final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory;
    private final java.lang.Integer imageTranscoderType;
    private final boolean isDiskCacheEnabled;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier;
    private final boolean isResizeAndRotateEnabledForNetwork;
    private final com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig;
    private final int memoryChunkType;
    private final com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry;
    private final com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory;
    private final com.facebook.imagepipeline.memory.PoolFactory poolFactory;
    private final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig;
    private final java.util.Set<com.facebook.imagepipeline.listener.RequestListener2> requestListener2s;
    private final java.util.Set<com.facebook.imagepipeline.listener.RequestListener> requestListeners;
    private final com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig;

    public /* synthetic */ ImagePipelineConfig(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public static final com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return INSTANCE.getDefaultImageRequestConfig();
    }

    public static /* synthetic */ void getImageTranscoderType$annotations() {
    }

    public static /* synthetic */ void getMemoryChunkType$annotations() {
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder newBuilder(android.content.Context context) {
        return INSTANCE.newBuilder(context);
    }

    @kotlin.jvm.JvmStatic
    public static final void resetDefaultRequestConfig() {
        INSTANCE.resetDefaultRequestConfig();
    }

    private ImagePipelineConfig(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
        com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher networkFetcher;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.experiments = builder.getExperimentsBuilder().build();
        com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier bitmapMemoryCacheParamsSupplier = builder.getBitmapMemoryCacheParamsSupplier();
        if (bitmapMemoryCacheParamsSupplier == null) {
            java.lang.Object systemService = builder.getContext().getSystemService("activity");
            if (systemService != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                bitmapMemoryCacheParamsSupplier = new com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier((android.app.ActivityManager) systemService);
            } else {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
        }
        this.bitmapMemoryCacheParamsSupplier = bitmapMemoryCacheParamsSupplier;
        com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy bitmapMemoryCacheTrimStrategy = builder.getBitmapMemoryCacheTrimStrategy();
        this.bitmapMemoryCacheTrimStrategy = bitmapMemoryCacheTrimStrategy == null ? new com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy() : bitmapMemoryCacheTrimStrategy;
        com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy encodedMemoryCacheTrimStrategy = builder.getEncodedMemoryCacheTrimStrategy();
        this.encodedMemoryCacheTrimStrategy = encodedMemoryCacheTrimStrategy == null ? new com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy() : encodedMemoryCacheTrimStrategy;
        this.bitmapMemoryCacheEntryStateObserver = builder.getBitmapMemoryCacheEntryStateObserver();
        android.graphics.Bitmap.Config bitmapConfig = builder.getBitmapConfig();
        this.bitmapConfig = bitmapConfig == null ? android.graphics.Bitmap.Config.ARGB_8888 : bitmapConfig;
        com.facebook.imagepipeline.cache.DefaultCacheKeyFactory cacheKeyFactory = builder.getCacheKeyFactory();
        if (cacheKeyFactory == null) {
            com.facebook.imagepipeline.cache.DefaultCacheKeyFactory defaultCacheKeyFactory = com.facebook.imagepipeline.cache.DefaultCacheKeyFactory.getInstance();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultCacheKeyFactory, "getInstance(...)");
            cacheKeyFactory = defaultCacheKeyFactory;
        }
        this.cacheKeyFactory = cacheKeyFactory;
        android.content.Context context = builder.getContext();
        if (context == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        this.context = context;
        this.downsampleMode = builder.getDownsampleMode();
        com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier encodedMemoryCacheParamsSupplier = builder.getEncodedMemoryCacheParamsSupplier();
        this.encodedMemoryCacheParamsSupplier = encodedMemoryCacheParamsSupplier == null ? new com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier() : encodedMemoryCacheParamsSupplier;
        com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker imageCacheStatsTracker = builder.getImageCacheStatsTracker();
        if (imageCacheStatsTracker == null) {
            com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker noOpImageCacheStatsTracker = com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker.getInstance();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(noOpImageCacheStatsTracker, "getInstance(...)");
            imageCacheStatsTracker = noOpImageCacheStatsTracker;
        }
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.imageDecoder = builder.getImageDecoder();
        com.facebook.common.internal.Supplier<java.lang.Boolean> BOOLEAN_FALSE = builder.getEnableEncodedImageColorSpaceUsage();
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = com.facebook.common.internal.Suppliers.BOOLEAN_FALSE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.enableEncodedImageColorSpaceUsage = BOOLEAN_FALSE;
        com.facebook.imagepipeline.core.ImagePipelineConfig.Companion companion = INSTANCE;
        this.imageTranscoderFactory = companion.getImageTranscoderFactory(builder);
        this.imageTranscoderType = builder.getImageTranscoderType();
        com.facebook.common.internal.Supplier<java.lang.Boolean> BOOLEAN_TRUE = builder.isPrefetchEnabledSupplier();
        if (BOOLEAN_TRUE == null) {
            BOOLEAN_TRUE = com.facebook.common.internal.Suppliers.BOOLEAN_TRUE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(BOOLEAN_TRUE, "BOOLEAN_TRUE");
        }
        this.isPrefetchEnabledSupplier = BOOLEAN_TRUE;
        com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig = builder.getMainDiskCacheConfig();
        this.mainDiskCacheConfig = mainDiskCacheConfig == null ? companion.getDefaultMainDiskCacheConfig(builder.getContext()) : mainDiskCacheConfig;
        com.facebook.common.memory.NoOpMemoryTrimmableRegistry memoryTrimmableRegistry = builder.getMemoryTrimmableRegistry();
        if (memoryTrimmableRegistry == null) {
            com.facebook.common.memory.NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry = com.facebook.common.memory.NoOpMemoryTrimmableRegistry.getInstance();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(noOpMemoryTrimmableRegistry, "getInstance(...)");
            memoryTrimmableRegistry = noOpMemoryTrimmableRegistry;
        }
        this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        this.memoryChunkType = companion.getMemoryChunkType(builder, getExperiments());
        int httpConnectionTimeout = builder.getHttpConnectionTimeout() < 0 ? com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : builder.getHttpConnectionTimeout();
        this.httpNetworkTimeout = httpConnectionTimeout;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            networkFetcher = builder.getNetworkFetcher();
            if (networkFetcher == null) {
                networkFetcher = new com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher(httpConnectionTimeout);
            }
        } else {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
            try {
                networkFetcher = builder.getNetworkFetcher();
                networkFetcher = networkFetcher == null ? new com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher(httpConnectionTimeout) : networkFetcher;
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            } catch (java.lang.Throwable th) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                throw th;
            }
        }
        this.networkFetcher = networkFetcher;
        this.platformBitmapFactory = builder.getPlatformBitmapFactory();
        com.facebook.imagepipeline.memory.PoolFactory poolFactory = builder.getPoolFactory();
        this.poolFactory = poolFactory == null ? new com.facebook.imagepipeline.memory.PoolFactory(com.facebook.imagepipeline.memory.PoolConfig.newBuilder().build()) : poolFactory;
        com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig progressiveJpegConfig = builder.getProgressiveJpegConfig();
        this.progressiveJpegConfig = progressiveJpegConfig == null ? new com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig() : progressiveJpegConfig;
        java.util.Set<com.facebook.imagepipeline.listener.RequestListener> requestListeners = builder.getRequestListeners();
        this.requestListeners = requestListeners == null ? kotlin.collections.SetsKt.emptySet() : requestListeners;
        java.util.Set<com.facebook.imagepipeline.listener.RequestListener2> requestListener2s = builder.getRequestListener2s();
        this.requestListener2s = requestListener2s == null ? kotlin.collections.SetsKt.emptySet() : requestListener2s;
        java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> customProducerSequenceFactories = builder.getCustomProducerSequenceFactories();
        this.customProducerSequenceFactories = customProducerSequenceFactories == null ? kotlin.collections.SetsKt.emptySet() : customProducerSequenceFactories;
        this.isResizeAndRotateEnabledForNetwork = builder.getResizeAndRotateEnabledForNetwork();
        com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig = builder.getSmallImageDiskCacheConfig();
        this.smallImageDiskCacheConfig = smallImageDiskCacheConfig == null ? getMainDiskCacheConfig() : smallImageDiskCacheConfig;
        this.imageDecoderConfig = builder.getImageDecoderConfig();
        int flexByteArrayPoolMaxNumThreads = getPoolFactory().getFlexByteArrayPoolMaxNumThreads();
        com.facebook.imagepipeline.core.DefaultExecutorSupplier executorSupplier = builder.getExecutorSupplier();
        this.executorSupplier = executorSupplier == null ? new com.facebook.imagepipeline.core.DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads) : executorSupplier;
        this.isDiskCacheEnabled = builder.getDiskCacheEnabled();
        this.callerContextVerifier = builder.getCallerContextVerifier();
        this.closeableReferenceLeakTracker = builder.getCloseableReferenceLeakTracker();
        this.bitmapCacheOverride = builder.getBitmapMemoryCache();
        com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory bitmapMemoryCacheFactory = builder.getBitmapMemoryCacheFactory();
        this.bitmapMemoryCacheFactory = bitmapMemoryCacheFactory == null ? new com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory() : bitmapMemoryCacheFactory;
        this.encodedMemoryCacheOverride = builder.getEncodedMemoryCache();
        this.executorServiceForAnimatedImages = builder.getSerialExecutorServiceForAnimatedImages();
        this.dynamicDiskCacheConfigMap = builder.getDynamicDiskCacheConfigMap();
        com.facebook.imagepipeline.core.DiskCachesStoreFactory diskCachesStoreSupplier = builder.getDiskCachesStoreSupplier();
        if (diskCachesStoreSupplier == null) {
            com.facebook.imagepipeline.core.DiskStorageCacheFactory fileCacheFactory = builder.getFileCacheFactory();
            diskCachesStoreSupplier = new com.facebook.imagepipeline.core.DiskCachesStoreFactory(fileCacheFactory == null ? new com.facebook.imagepipeline.core.DiskStorageCacheFactory(new com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory()) : fileCacheFactory, this);
        }
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory = getExperiments().getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            companion.setWebpBitmapFactory(webpBitmapFactory, getExperiments(), new com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator(getPoolFactory()));
        }
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public android.graphics.Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.bitmapMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.bitmapMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
        return this.encodedMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        return this.bitmapMemoryCacheEntryStateObserver;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public android.content.Context getContext() {
        return this.context;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.core.DownsampleMode getDownsampleMode() {
        return this.downsampleMode;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> getDiskCachesStoreSupplier() {
        return this.diskCachesStoreSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.encodedMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.core.ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.imageCacheStatsTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.decoder.ImageDecoder getImageDecoder() {
        return this.imageDecoder;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.transcoder.ImageTranscoderFactory getImageTranscoderFactory() {
        return this.imageTranscoderFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.internal.Supplier<java.lang.Boolean> getEnableEncodedImageColorSpaceUsage() {
        return this.enableEncodedImageColorSpaceUsage;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public java.lang.Integer getImageTranscoderType() {
        return this.imageTranscoderType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier() {
        return this.isPrefetchEnabledSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.cache.disk.DiskCacheConfig getMainDiskCacheConfig() {
        return this.mainDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.memory.MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.memoryTrimmableRegistry;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public int getMemoryChunkType() {
        return this.memoryChunkType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.producers.NetworkFetcher<?> getNetworkFetcher() {
        return this.networkFetcher;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.platformBitmapFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.memory.PoolFactory getPoolFactory() {
        return this.poolFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.decoder.ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.progressiveJpegConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public java.util.Set<com.facebook.imagepipeline.listener.RequestListener> getRequestListeners() {
        return this.requestListeners;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public java.util.Set<com.facebook.imagepipeline.listener.RequestListener2> getRequestListener2s() {
        return this.requestListener2s;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> getCustomProducerSequenceFactories() {
        return this.customProducerSequenceFactories;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    /* JADX INFO: renamed from: isResizeAndRotateEnabledForNetwork, reason: from getter */
    public boolean getIsResizeAndRotateEnabledForNetwork() {
        return this.isResizeAndRotateEnabledForNetwork;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.cache.disk.DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.smallImageDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.decoder.ImageDecoderConfig getImageDecoderConfig() {
        return this.imageDecoderConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.core.ImagePipelineExperiments getExperiments() {
        return this.experiments;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    /* JADX INFO: renamed from: isDiskCacheEnabled, reason: from getter */
    public boolean getIsDiskCacheEnabled() {
        return this.isDiskCacheEnabled;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.callercontext.CallerContextVerifier getCallerContextVerifier() {
        return this.callerContextVerifier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.closeableReferenceLeakTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> getBitmapCacheOverride() {
        return this.bitmapCacheOverride;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.encodedMemoryCacheOverride;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.common.executors.SerialExecutorService getExecutorServiceForAnimatedImages() {
        return this.executorServiceForAnimatedImages;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
        return this.bitmapMemoryCacheFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public java.util.Map<java.lang.String, com.facebook.cache.disk.DiskCacheConfig> getDynamicDiskCacheConfigMap() {
        return this.dynamicDiskCacheConfigMap;
    }

    /* JADX INFO: compiled from: ImagePipelineConfig.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "", "<init>", "()V", "isProgressiveRenderingEnabled", "", "()Z", "setProgressiveRenderingEnabled", "(Z)V", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImageRequestConfig {
        private boolean isProgressiveRenderingEnabled;

        /* JADX INFO: renamed from: isProgressiveRenderingEnabled, reason: from getter */
        public final boolean getIsProgressiveRenderingEnabled() {
            return this.isProgressiveRenderingEnabled;
        }

        public final void setProgressiveRenderingEnabled(boolean z) {
            this.isProgressiveRenderingEnabled = z;
        }
    }

    /* JADX INFO: compiled from: ImagePipelineConfig.kt */
    @kotlin.Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010¡\u0001\u001a\u00020\u00002\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0007J\u0017\u0010£\u0001\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0017\u0010¤\u0001\u001a\u00020\u00002\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0012\u0010¥\u0001\u001a\u00020\u00002\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0015J\u0012\u0010§\u0001\u001a\u00020\u00002\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0015J\u0011\u0010¨\u0001\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010©\u0001\u001a\u00020\u00002\u0007\u0010ª\u0001\u001a\u00020;J\u000f\u0010«\u0001\u001a\u00020\u00002\u0006\u0010q\u001a\u00020pJ\u0015\u0010¬\u0001\u001a\u00020\u00002\f\u0010u\u001a\b\u0012\u0004\u0012\u00020t0\u000bJ\u0007\u0010\u00ad\u0001\u001a\u000203J\u000f\u0010®\u0001\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!J\u0012\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u000203H\u0007J\u0007\u0010±\u0001\u001a\u000203J\u0010\u0010²\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u000203J\u0017\u0010³\u0001\u001a\u00020\u00002\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0011\u0010´\u0001\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010'J\u0011\u0010µ\u0001\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010+J\u0011\u0010¶\u0001\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010/J\u0017\u0010·\u0001\u001a\u00020\u00002\u000e\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000bJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;J\u0011\u0010¸\u0001\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u000106J\u0017\u0010¹\u0001\u001a\u00020\u00002\u000e\u0010C\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000bJ\u0011\u0010º\u0001\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010DJ\u0011\u0010»\u0001\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010HJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010L\u001a\u00020;J\u0015\u0010¼\u0001\u001a\u00020\u00002\f\u0010Q\u001a\b\u0012\u0002\b\u0003\u0018\u00010PJ\u0011\u0010½\u0001\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010TJ\u0011\u0010¾\u0001\u001a\u00020\u00002\b\u0010Y\u001a\u0004\u0018\u00010XJ\u0011\u0010¿\u0001\u001a\u00020\u00002\b\u0010]\u001a\u0004\u0018\u00010\\J\u0017\u0010À\u0001\u001a\u00020\u00002\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`J\u0017\u0010Á\u0001\u001a\u00020\u00002\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010`J\u0017\u0010Â\u0001\u001a\u00020\u00002\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010`J\u000f\u0010Ã\u0001\u001a\u00020\u00002\u0006\u0010k\u001a\u000203J\u0011\u0010Ä\u0001\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010DJ\u0011\u0010Å\u0001\u001a\u00020\u00002\b\u0010x\u001a\u0004\u0018\u00010wJ\u0013\u0010Æ\u0001\u001a\u00020\u00002\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001J\u0011\u0010Ç\u0001\u001a\u00020\u00002\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J \u0010È\u0001\u001a\u00020\u00002\u0017\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u0001J \u0010É\u0001\u001a\u00020\u00002\u0017\u0010\u0092\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u008c\u0001J\u0013\u0010Ê\u0001\u001a\u00020\u00002\n\u0010Ë\u0001\u001a\u0005\u0018\u00010\u0094\u0001J\u0013\u0010Ì\u0001\u001a\u00020\u00002\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u0001J\u001e\u0010Í\u0001\u001a\u00020\u00002\u0015\u0010\u009e\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020D0\u009c\u0001J\u0007\u0010Î\u0001\u001a\u00020\u007fJ\b\u0010Ï\u0001\u001a\u00030Ð\u0001R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR.\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR.\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R.\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000fR\"\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0006\u001a\u0004\u0018\u00010'@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\"\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0006\u001a\u0004\u0018\u00010+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\"\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0006\u001a\u0004\u0018\u00010/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R.\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000fR\"\u00107\u001a\u0004\u0018\u0001062\b\u0010\u0006\u001a\u0004\u0018\u000106@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u0016\n\u0002\u0010B\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR.\u0010C\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000fR\"\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u0006\u001a\u0004\u0018\u00010D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\"\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u0006\u001a\u0004\u0018\u00010H@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u0016\n\u0002\u0010B\u0012\u0004\bM\u0010=\u001a\u0004\bN\u0010?\"\u0004\bO\u0010AR*\u0010Q\u001a\b\u0012\u0002\b\u0003\u0018\u00010P2\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010P@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\"\u0010U\u001a\u0004\u0018\u00010T2\b\u0010\u0006\u001a\u0004\u0018\u00010T@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\"\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010\u0006\u001a\u0004\u0018\u00010X@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\"\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010\u0006\u001a\u0004\u0018\u00010\\@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R.\u0010b\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010`@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR.\u0010f\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010`2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010`@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bg\u0010dR.\u0010i\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010`2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010`@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010dR\u001e\u0010k\u001a\u0002032\u0006\u0010\u0006\u001a\u000203@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\"\u0010n\u001a\u0004\u0018\u00010D2\b\u0010\u0006\u001a\u0004\u0018\u00010D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010GR\"\u0010q\u001a\u0004\u0018\u00010p2\b\u0010\u0006\u001a\u0004\u0018\u00010p@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR.\u0010u\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u000fR\"\u0010x\u001a\u0004\u0018\u00010w2\b\u0010\u0006\u001a\u0004\u0018\u00010w@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u001e\u0010{\u001a\u00020;2\u0006\u0010\u0006\u001a\u00020;@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0013\u0010~\u001a\u00020\u007f¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0082\u0001\u001a\u0002032\u0006\u0010\u0006\u001a\u000203@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010mR'\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\t\u0010\u0006\u001a\u0005\u0018\u00010\u0084\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R#\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0006\u001a\u00030\u0088\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001RA\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u00012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u008c\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001RA\u0010\u0092\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u008c\u00012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u008c\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0090\u0001R'\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00012\t\u0010\u0006\u001a\u0005\u0018\u00010\u0094\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R'\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00012\t\u0010\u0006\u001a\u0005\u0018\u00010\u0098\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001RA\u0010\u009e\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020D\u0018\u00010\u009c\u00012\u0016\u0010\u0006\u001a\u0012\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020D\u0018\u00010\u009c\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001¨\u0006Ñ\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "bitmapMemoryCacheParamsSupplier", "getBitmapMemoryCacheParamsSupplier", "()Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "Lcom/facebook/cache/common/CacheKey;", "bitmapMemoryCacheEntryStateObserver", "getBitmapMemoryCacheEntryStateObserver", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "bitmapMemoryCacheTrimStrategy", "getBitmapMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "encodedMemoryCacheTrimStrategy", "getEncodedMemoryCacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "cacheKeyFactory", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getContext", "()Landroid/content/Context;", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "downsampleMode", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "encodedMemoryCacheParamsSupplier", "getEncodedMemoryCacheParamsSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "executorSupplier", "getExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "imageCacheStatsTracker", "getImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "imageDecoder", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "", "enableEncodedImageColorSpaceUsage", "getEnableEncodedImageColorSpaceUsage", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderFactory", "getImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderType", "", "getImageTranscoderType$annotations", "()V", "getImageTranscoderType", "()Ljava/lang/Integer;", "setImageTranscoderType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isPrefetchEnabledSupplier", "Lcom/facebook/cache/disk/DiskCacheConfig;", "mainDiskCacheConfig", "getMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "memoryTrimmableRegistry", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "memoryChunkType", "getMemoryChunkType$annotations", "getMemoryChunkType", "setMemoryChunkType", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "networkFetcher", "getNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "platformBitmapFactory", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "poolFactory", "getPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "progressiveJpegConfig", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListeners", "getRequestListeners", "()Ljava/util/Set;", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "requestListener2s", "getRequestListener2s", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "customProducerSequenceFactories", "getCustomProducerSequenceFactories", "resizeAndRotateEnabledForNetwork", "getResizeAndRotateEnabledForNetwork", "()Z", "smallImageDiskCacheConfig", "getSmallImageDiskCacheConfig", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "fileCacheFactory", "getFileCacheFactory", "()Lcom/facebook/imagepipeline/core/FileCacheFactory;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "diskCachesStoreSupplier", "getDiskCachesStoreSupplier", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "imageDecoderConfig", "getImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "httpConnectionTimeout", "getHttpConnectionTimeout", "()I", "experimentsBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "getExperimentsBuilder", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "diskCacheEnabled", "getDiskCacheEnabled", "Lcom/facebook/callercontext/CallerContextVerifier;", "callerContextVerifier", "getCallerContextVerifier", "()Lcom/facebook/callercontext/CallerContextVerifier;", "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "closeableReferenceLeakTracker", "getCloseableReferenceLeakTracker", "()Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "bitmapMemoryCache", "getBitmapMemoryCache", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/common/memory/PooledByteBuffer;", "encodedMemoryCache", "getEncodedMemoryCache", "Lcom/facebook/common/executors/SerialExecutorService;", "serialExecutorServiceForAnimatedImages", "getSerialExecutorServiceForAnimatedImages", "()Lcom/facebook/common/executors/SerialExecutorService;", "Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "bitmapMemoryCacheFactory", "getBitmapMemoryCacheFactory", "()Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "", "", "dynamicDiskCacheConfigMap", "getDynamicDiskCacheConfigMap", "()Ljava/util/Map;", "setBitmapsConfig", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG, "setBitmapMemoryCacheParamsSupplier", "setBitmapMemoryCacheEntryStateObserver", "setBitmapMemoryCacheTrimStrategy", "trimStrategy", "setEncodedMemoryCacheTrimStrategy", "setCacheKeyFactory", "setHttpConnectionTimeout", "httpConnectionTimeoutMs", "setFileCacheFactory", "setDiskCachesStoreSupplier", "isDownsampleEnabled", "setDownsampleMode", "setDownsampleEnabled", "downsampleEnabled", "isDiskCacheEnabled", "setDiskCacheEnabled", "setEncodedMemoryCacheParamsSupplier", "setExecutorSupplier", "setImageCacheStatsTracker", "setImageDecoder", "setEnableEncodedImageColorSpaceUsage", "setImageTranscoderFactory", "setIsPrefetchEnabledSupplier", "setMainDiskCacheConfig", "setMemoryTrimmableRegistry", "setNetworkFetcher", "setPlatformBitmapFactory", "setPoolFactory", "setProgressiveJpegConfig", "setRequestListeners", "setRequestListener2s", "setCustomFetchSequenceFactories", "setResizeAndRotateEnabledForNetwork", "setSmallImageDiskCacheConfig", "setImageDecoderConfig", "setCallerContextVerifier", "setCloseableReferenceLeakTracker", "setBitmapMemoryCache", "setEncodedMemoryCache", "setExecutorServiceForAnimatedImages", "serialExecutorService", "setBitmapMemoryCacheFactory", "setDynamicDiskCacheConfigMap", "experiment", "build", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private android.graphics.Bitmap.Config bitmapConfig;
        private com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache;
        private com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> bitmapMemoryCacheEntryStateObserver;
        private com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
        private com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> bitmapMemoryCacheParamsSupplier;
        private com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
        private com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory;
        private com.facebook.callercontext.CallerContextVerifier callerContextVerifier;
        private com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker closeableReferenceLeakTracker;
        private final android.content.Context context;
        private java.util.Set<? extends com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> customProducerSequenceFactories;
        private boolean diskCacheEnabled;
        private com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier;
        private com.facebook.imagepipeline.core.DownsampleMode downsampleMode;
        private java.util.Map<java.lang.String, ? extends com.facebook.cache.disk.DiskCacheConfig> dynamicDiskCacheConfigMap;
        private com.facebook.common.internal.Supplier<java.lang.Boolean> enableEncodedImageColorSpaceUsage;
        private com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache;
        private com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> encodedMemoryCacheParamsSupplier;
        private com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
        private com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier;
        private final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder experimentsBuilder;
        private com.facebook.imagepipeline.core.FileCacheFactory fileCacheFactory;
        private int httpConnectionTimeout;
        private com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker;
        private com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
        private com.facebook.imagepipeline.decoder.ImageDecoderConfig imageDecoderConfig;
        private com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory;
        private java.lang.Integer imageTranscoderType;
        private com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier;
        private com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig;
        private java.lang.Integer memoryChunkType;
        private com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry;
        private com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher;
        private com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory;
        private com.facebook.imagepipeline.memory.PoolFactory poolFactory;
        private com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig;
        private java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener2> requestListener2s;
        private java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener> requestListeners;
        private boolean resizeAndRotateEnabledForNetwork;
        private com.facebook.common.executors.SerialExecutorService serialExecutorServiceForAnimatedImages;
        private com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig;

        public static /* synthetic */ void getImageTranscoderType$annotations() {
        }

        public static /* synthetic */ void getMemoryChunkType$annotations() {
        }

        public Builder(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            this.downsampleMode = com.facebook.imagepipeline.core.DownsampleMode.AUTO;
            this.resizeAndRotateEnabledForNetwork = true;
            this.httpConnectionTimeout = -1;
            this.experimentsBuilder = new com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder(this);
            this.diskCacheEnabled = true;
            this.closeableReferenceLeakTracker = new com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker();
            this.context = context;
        }

        public final android.graphics.Bitmap.Config getBitmapConfig() {
            return this.bitmapConfig;
        }

        public final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
            return this.bitmapMemoryCacheParamsSupplier;
        }

        public final com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> getBitmapMemoryCacheEntryStateObserver() {
            return this.bitmapMemoryCacheEntryStateObserver;
        }

        public final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
            return this.bitmapMemoryCacheTrimStrategy;
        }

        public final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
            return this.encodedMemoryCacheTrimStrategy;
        }

        public final com.facebook.imagepipeline.cache.CacheKeyFactory getCacheKeyFactory() {
            return this.cacheKeyFactory;
        }

        public final android.content.Context getContext() {
            return this.context;
        }

        public final com.facebook.imagepipeline.core.DownsampleMode getDownsampleMode() {
            return this.downsampleMode;
        }

        public final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
            return this.encodedMemoryCacheParamsSupplier;
        }

        public final com.facebook.imagepipeline.core.ExecutorSupplier getExecutorSupplier() {
            return this.executorSupplier;
        }

        public final com.facebook.imagepipeline.cache.ImageCacheStatsTracker getImageCacheStatsTracker() {
            return this.imageCacheStatsTracker;
        }

        public final com.facebook.imagepipeline.decoder.ImageDecoder getImageDecoder() {
            return this.imageDecoder;
        }

        public final com.facebook.common.internal.Supplier<java.lang.Boolean> getEnableEncodedImageColorSpaceUsage() {
            return this.enableEncodedImageColorSpaceUsage;
        }

        public final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory getImageTranscoderFactory() {
            return this.imageTranscoderFactory;
        }

        public final java.lang.Integer getImageTranscoderType() {
            return this.imageTranscoderType;
        }

        public final void setImageTranscoderType(java.lang.Integer num) {
            this.imageTranscoderType = num;
        }

        public final com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier() {
            return this.isPrefetchEnabledSupplier;
        }

        public final com.facebook.cache.disk.DiskCacheConfig getMainDiskCacheConfig() {
            return this.mainDiskCacheConfig;
        }

        public final com.facebook.common.memory.MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
            return this.memoryTrimmableRegistry;
        }

        public final java.lang.Integer getMemoryChunkType() {
            return this.memoryChunkType;
        }

        public final void setMemoryChunkType(java.lang.Integer num) {
            this.memoryChunkType = num;
        }

        public final com.facebook.imagepipeline.producers.NetworkFetcher<?> getNetworkFetcher() {
            return this.networkFetcher;
        }

        public final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory getPlatformBitmapFactory() {
            return this.platformBitmapFactory;
        }

        public final com.facebook.imagepipeline.memory.PoolFactory getPoolFactory() {
            return this.poolFactory;
        }

        public final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig getProgressiveJpegConfig() {
            return this.progressiveJpegConfig;
        }

        public final java.util.Set<com.facebook.imagepipeline.listener.RequestListener> getRequestListeners() {
            return this.requestListeners;
        }

        public final java.util.Set<com.facebook.imagepipeline.listener.RequestListener2> getRequestListener2s() {
            return this.requestListener2s;
        }

        public final java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> getCustomProducerSequenceFactories() {
            return this.customProducerSequenceFactories;
        }

        public final boolean getResizeAndRotateEnabledForNetwork() {
            return this.resizeAndRotateEnabledForNetwork;
        }

        public final com.facebook.cache.disk.DiskCacheConfig getSmallImageDiskCacheConfig() {
            return this.smallImageDiskCacheConfig;
        }

        public final com.facebook.imagepipeline.core.FileCacheFactory getFileCacheFactory() {
            return this.fileCacheFactory;
        }

        public final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> getDiskCachesStoreSupplier() {
            return this.diskCachesStoreSupplier;
        }

        public final com.facebook.imagepipeline.decoder.ImageDecoderConfig getImageDecoderConfig() {
            return this.imageDecoderConfig;
        }

        public final int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder getExperimentsBuilder() {
            return this.experimentsBuilder;
        }

        public final boolean getDiskCacheEnabled() {
            return this.diskCacheEnabled;
        }

        public final com.facebook.callercontext.CallerContextVerifier getCallerContextVerifier() {
            return this.callerContextVerifier;
        }

        public final com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
            return this.closeableReferenceLeakTracker;
        }

        public final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> getBitmapMemoryCache() {
            return this.bitmapMemoryCache;
        }

        public final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> getEncodedMemoryCache() {
            return this.encodedMemoryCache;
        }

        public final com.facebook.common.executors.SerialExecutorService getSerialExecutorServiceForAnimatedImages() {
            return this.serialExecutorServiceForAnimatedImages;
        }

        public final com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
            return this.bitmapMemoryCacheFactory;
        }

        public final java.util.Map<java.lang.String, com.facebook.cache.disk.DiskCacheConfig> getDynamicDiskCacheConfigMap() {
            return this.dynamicDiskCacheConfigMap;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapsConfig(android.graphics.Bitmap.Config config) {
            this.bitmapConfig = config;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> bitmapMemoryCacheParamsSupplier) {
            if (bitmapMemoryCacheParamsSupplier == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            this.bitmapMemoryCacheParamsSupplier = bitmapMemoryCacheParamsSupplier;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCacheEntryStateObserver(com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> bitmapMemoryCacheEntryStateObserver) {
            this.bitmapMemoryCacheEntryStateObserver = bitmapMemoryCacheEntryStateObserver;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCacheTrimStrategy(com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy trimStrategy) {
            this.bitmapMemoryCacheTrimStrategy = trimStrategy;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEncodedMemoryCacheTrimStrategy(com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy trimStrategy) {
            this.encodedMemoryCacheTrimStrategy = trimStrategy;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setCacheKeyFactory(com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setHttpConnectionTimeout(int httpConnectionTimeoutMs) {
            this.httpConnectionTimeout = httpConnectionTimeoutMs;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setFileCacheFactory(com.facebook.imagepipeline.core.FileCacheFactory fileCacheFactory) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
            this.fileCacheFactory = fileCacheFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDiskCachesStoreSupplier(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            this.diskCachesStoreSupplier = diskCachesStoreSupplier;
            return this;
        }

        public final boolean isDownsampleEnabled() {
            return this.downsampleMode == com.facebook.imagepipeline.core.DownsampleMode.ALWAYS;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDownsampleMode(com.facebook.imagepipeline.core.DownsampleMode downsampleMode) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            this.downsampleMode = downsampleMode;
            return this;
        }

        @kotlin.Deprecated(message = "Use the new setDownsampleMode() method")
        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDownsampleEnabled(boolean downsampleEnabled) {
            if (downsampleEnabled) {
                setDownsampleMode(com.facebook.imagepipeline.core.DownsampleMode.ALWAYS);
                return this;
            }
            setDownsampleMode(com.facebook.imagepipeline.core.DownsampleMode.AUTO);
            return this;
        }

        public final boolean isDiskCacheEnabled() {
            return this.diskCacheEnabled;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDiskCacheEnabled(boolean diskCacheEnabled) {
            this.diskCacheEnabled = diskCacheEnabled;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEncodedMemoryCacheParamsSupplier(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> encodedMemoryCacheParamsSupplier) {
            if (encodedMemoryCacheParamsSupplier == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            this.encodedMemoryCacheParamsSupplier = encodedMemoryCacheParamsSupplier;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setExecutorSupplier(com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier) {
            this.executorSupplier = executorSupplier;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setImageCacheStatsTracker(com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker) {
            this.imageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setImageDecoder(com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder) {
            this.imageDecoder = imageDecoder;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEnableEncodedImageColorSpaceUsage(com.facebook.common.internal.Supplier<java.lang.Boolean> enableEncodedImageColorSpaceUsage) {
            this.enableEncodedImageColorSpaceUsage = enableEncodedImageColorSpaceUsage;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setImageTranscoderType(int imageTranscoderType) {
            this.imageTranscoderType = java.lang.Integer.valueOf(imageTranscoderType);
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setImageTranscoderFactory(com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory) {
            this.imageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setIsPrefetchEnabledSupplier(com.facebook.common.internal.Supplier<java.lang.Boolean> isPrefetchEnabledSupplier) {
            this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setMainDiskCacheConfig(com.facebook.cache.disk.DiskCacheConfig mainDiskCacheConfig) {
            this.mainDiskCacheConfig = mainDiskCacheConfig;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setMemoryTrimmableRegistry(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.memoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setMemoryChunkType(int memoryChunkType) {
            this.memoryChunkType = java.lang.Integer.valueOf(memoryChunkType);
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setNetworkFetcher(com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher) {
            this.networkFetcher = networkFetcher;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setPlatformBitmapFactory(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory) {
            this.platformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setPoolFactory(com.facebook.imagepipeline.memory.PoolFactory poolFactory) {
            this.poolFactory = poolFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setProgressiveJpegConfig(com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig) {
            this.progressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setRequestListeners(java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener> requestListeners) {
            this.requestListeners = requestListeners;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setRequestListener2s(java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener2> requestListeners) {
            this.requestListener2s = requestListeners;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setCustomFetchSequenceFactories(java.util.Set<? extends com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> customProducerSequenceFactories) {
            this.customProducerSequenceFactories = customProducerSequenceFactories;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setResizeAndRotateEnabledForNetwork(boolean resizeAndRotateEnabledForNetwork) {
            this.resizeAndRotateEnabledForNetwork = resizeAndRotateEnabledForNetwork;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setSmallImageDiskCacheConfig(com.facebook.cache.disk.DiskCacheConfig smallImageDiskCacheConfig) {
            this.smallImageDiskCacheConfig = smallImageDiskCacheConfig;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setImageDecoderConfig(com.facebook.imagepipeline.decoder.ImageDecoderConfig imageDecoderConfig) {
            this.imageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setCallerContextVerifier(com.facebook.callercontext.CallerContextVerifier callerContextVerifier) {
            this.callerContextVerifier = callerContextVerifier;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setCloseableReferenceLeakTracker(com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closeableReferenceLeakTracker, "closeableReferenceLeakTracker");
            this.closeableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCache(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache) {
            this.bitmapMemoryCache = bitmapMemoryCache;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEncodedMemoryCache(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache) {
            this.encodedMemoryCache = encodedMemoryCache;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setExecutorServiceForAnimatedImages(com.facebook.common.executors.SerialExecutorService serialExecutorService) {
            this.serialExecutorServiceForAnimatedImages = serialExecutorService;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapMemoryCacheFactory(com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory bitmapMemoryCacheFactory) {
            this.bitmapMemoryCacheFactory = bitmapMemoryCacheFactory;
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDynamicDiskCacheConfigMap(java.util.Map<java.lang.String, ? extends com.facebook.cache.disk.DiskCacheConfig> dynamicDiskCacheConfigMap) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dynamicDiskCacheConfigMap, "dynamicDiskCacheConfigMap");
            this.dynamicDiskCacheConfigMap = dynamicDiskCacheConfigMap;
            return this;
        }

        /* JADX INFO: renamed from: experiment, reason: from getter */
        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder getExperimentsBuilder() {
            return this.experimentsBuilder;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig build() {
            return new com.facebook.imagepipeline.core.ImagePipelineConfig(this, null);
        }
    }

    /* JADX INFO: compiled from: ImagePipelineConfig.kt */
    @kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Companion;", "", "<init>", "()V", "value", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "defaultImageRequestConfig", "getDefaultImageRequestConfig$annotations", "getDefaultImageRequestConfig", "()Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "setWebpBitmapFactory", "", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "imagePipelineExperiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "bitmapCreator", "Lcom/facebook/common/webp/BitmapCreator;", "getDefaultMainDiskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "context", "Landroid/content/Context;", "resetDefaultRequestConfig", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "getImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "builder", "getMemoryChunkType", "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.jvm.JvmStatic
        public static /* synthetic */ void getDefaultImageRequestConfig$annotations() {
        }

        private Companion() {
        }

        public final com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig getDefaultImageRequestConfig() {
            return com.facebook.imagepipeline.core.ImagePipelineConfig.defaultImageRequestConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setWebpBitmapFactory(com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory, com.facebook.imagepipeline.core.ImagePipelineExperiments imagePipelineExperiments, com.facebook.common.webp.BitmapCreator bitmapCreator) {
            com.facebook.common.webp.WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
            com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
            if (webpErrorLogger != null) {
                webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
            }
            if (bitmapCreator != null) {
                webpBitmapFactory.setBitmapCreator(bitmapCreator);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.facebook.cache.disk.DiskCacheConfig getDefaultMainDiskCacheConfig(android.content.Context context) {
            com.facebook.cache.disk.DiskCacheConfig diskCacheConfigBuild;
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                diskCacheConfigBuild = com.facebook.cache.disk.DiskCacheConfig.newBuilder(context).build();
            } else {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
                try {
                    diskCacheConfigBuild = com.facebook.cache.disk.DiskCacheConfig.newBuilder(context).build();
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                } catch (java.lang.Throwable th) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    throw th;
                }
            }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCacheConfigBuild, "traceSection(...)");
            return diskCacheConfigBuild;
        }

        @kotlin.jvm.JvmStatic
        public final void resetDefaultRequestConfig() {
            com.facebook.imagepipeline.core.ImagePipelineConfig.defaultImageRequestConfig = new com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig();
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder newBuilder(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return new com.facebook.imagepipeline.core.ImagePipelineConfig.Builder(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory getImageTranscoderFactory(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
            if (builder.getImageTranscoderFactory() == null || builder.getImageTranscoderType() == null) {
                return builder.getImageTranscoderFactory();
            }
            throw new java.lang.IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMemoryChunkType(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder, com.facebook.imagepipeline.core.ImagePipelineExperiments imagePipelineExperiments) {
            java.lang.Integer memoryChunkType = builder.getMemoryChunkType();
            if (memoryChunkType != null) {
                return memoryChunkType.intValue();
            }
            if (imagePipelineExperiments.getMemoryType() == 2 && android.os.Build.VERSION.SDK_INT >= 27) {
                return 2;
            }
            if (imagePipelineExperiments.getMemoryType() == 1) {
                return 1;
            }
            imagePipelineExperiments.getMemoryType();
            return 0;
        }
    }
}
