package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: ImagePipelineExperiments.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0004WXYZB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u0011\u0010\"\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0011\u0010%\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070+¢\u0006\b\n\u0000\u001a\u0004\b*\u0010,R\u0011\u0010-\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\bR\u0011\u0010.\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070+¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u00102\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u0011\u00109\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u0011\u0010;\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\bR\u0011\u0010<\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR\u0011\u0010=\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\bR\u0011\u0010>\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0011\u0010?\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001bR\u0011\u0010A\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u0011\u0010C\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u0011\u0010E\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u0011\u0010G\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0011\u0010I\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u0011\u0010K\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0011\u0010M\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\bR\u0011\u0010O\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001bR\u0011\u0010Q\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\bR\u0011\u0010S\u001a\u00020T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010V¨\u0006["}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;)V", "isWebpSupportEnabled", "", "()Z", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "getWebpErrorLogger", "()Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "isDecodeCancellationEnabled", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "getWebpBitmapFactory", "()Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "getUseDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "getUseBitmapPrepareToDraw", "useBalancedAnimationStrategy", "getUseBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "getAnimationStrategyBufferLengthMilliseconds", "()I", "bitmapPrepareToDrawMinSizeBytes", "getBitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "getBitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "getBitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "getMaxBitmapDimension", "isNativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "getProducerFactoryMethod", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "isLazyDataSource", "Lcom/facebook/common/internal/Supplier;", "()Lcom/facebook/common/internal/Supplier;", "isGingerbreadDecoderEnabled", "downscaleFrameToDrawableDimensions", "getDownscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "getSuppressBitmapPrefetchingSupplier", "isExperimentalThreadHandoffQueueEnabled", "memoryType", "", "getMemoryType", "()J", "keepCancelledFetchAsLowPriority", "getKeepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "getDownsampleIfLargeBitmap", "isEncodedCacheEnabled", "isEnsureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "getTrackedKeysSize", "allowDelay", "getAllowDelay", "handOffOnUiThreadOnly", "getHandOffOnUiThreadOnly", "shouldStoreCacheEntrySize", "getShouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "getShouldIgnoreCacheSizeMismatch", "shouldUseDecodingBufferHelper", "getShouldUseDecodingBufferHelper", "allowProgressiveOnPrefetch", "getAllowProgressiveOnPrefetch", "cancelDecodeOnCacheMiss", "getCancelDecodeOnCacheMiss", "animationRenderFpsLimit", "getAnimationRenderFpsLimit", "prefetchShortcutEnabled", "getPrefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "getPlatformDecoderOptions", "()Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "Builder", "ProducerFactoryMethod", "DefaultProducerFactoryMethod", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagePipelineExperiments {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.core.ImagePipelineExperiments.Companion INSTANCE = new com.facebook.imagepipeline.core.ImagePipelineExperiments.Companion(null);
    private final boolean allowDelay;
    private final boolean allowProgressiveOnPrefetch;
    private final int animationRenderFpsLimit;
    private final int animationStrategyBufferLengthMilliseconds;
    private final boolean bitmapPrepareToDrawForPrefetch;
    private final int bitmapPrepareToDrawMaxSizeBytes;
    private final int bitmapPrepareToDrawMinSizeBytes;
    private final boolean cancelDecodeOnCacheMiss;
    private final boolean downsampleIfLargeBitmap;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean handOffOnUiThreadOnly;
    private final boolean isDecodeCancellationEnabled;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedCacheEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final boolean isEnsureTranscoderLibraryLoaded;
    private final boolean isExperimentalThreadHandoffQueueEnabled;
    private final boolean isGingerbreadDecoderEnabled;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> isLazyDataSource;
    private final boolean isNativeCodeDisabled;
    private final boolean isPartialImageCachingEnabled;
    private final boolean isWebpSupportEnabled;
    private final boolean keepCancelledFetchAsLowPriority;
    private final int maxBitmapDimension;
    private final long memoryType;
    private final com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions;
    private final boolean prefetchShortcutEnabled;
    private final com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod;
    private final boolean shouldIgnoreCacheSizeMismatch;
    private final boolean shouldStoreCacheEntrySize;
    private final boolean shouldUseDecodingBufferHelper;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> suppressBitmapPrefetchingSupplier;
    private final int trackedKeysSize;
    private final boolean useBalancedAnimationStrategy;
    private final boolean useBitmapPrepareToDraw;
    private final boolean useDownsamplingRatioForResizing;
    private final com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory;
    private final com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger;

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JÞ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020%H&¨\u0006-"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "context", "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ProducerFactoryMethod {
        com.facebook.imagepipeline.core.ProducerFactory createProducerFactory(android.content.Context context, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, com.facebook.imagepipeline.core.DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.PooledByteStreams pooledByteStreams, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize);
    }

    public /* synthetic */ ImagePipelineExperiments(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder builder, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder newBuilder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
        return INSTANCE.newBuilder(builder);
    }

    private ImagePipelineExperiments(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder builder) {
        this.isWebpSupportEnabled = builder.webpSupportEnabled;
        this.webpErrorLogger = builder.webpErrorLogger;
        this.isDecodeCancellationEnabled = builder.decodeCancellationEnabled;
        this.webpBitmapFactory = builder.webpBitmapFactory;
        this.useDownsamplingRatioForResizing = builder.useDownsamplingRatioForResizing;
        this.useBitmapPrepareToDraw = builder.useBitmapPrepareToDraw;
        this.useBalancedAnimationStrategy = builder.useBalancedAnimationStrategy;
        this.animationStrategyBufferLengthMilliseconds = builder.animationStrategyBufferLengthMilliseconds;
        this.bitmapPrepareToDrawMinSizeBytes = builder.bitmapPrepareToDrawMinSizeBytes;
        this.bitmapPrepareToDrawMaxSizeBytes = builder.bitmapPrepareToDrawMaxSizeBytes;
        this.bitmapPrepareToDrawForPrefetch = builder.bitmapPrepareToDrawForPrefetch;
        this.maxBitmapDimension = builder.maxBitmapDimension;
        this.isNativeCodeDisabled = builder.nativeCodeDisabled;
        this.isPartialImageCachingEnabled = builder.isPartialImageCachingEnabled;
        com.facebook.imagepipeline.core.ImagePipelineExperiments.DefaultProducerFactoryMethod defaultProducerFactoryMethod = builder.producerFactoryMethod;
        this.producerFactoryMethod = defaultProducerFactoryMethod == null ? new com.facebook.imagepipeline.core.ImagePipelineExperiments.DefaultProducerFactoryMethod() : defaultProducerFactoryMethod;
        com.facebook.common.internal.Supplier<java.lang.Boolean> BOOLEAN_FALSE = builder.lazyDataSource;
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = com.facebook.common.internal.Suppliers.BOOLEAN_FALSE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.isLazyDataSource = BOOLEAN_FALSE;
        this.isGingerbreadDecoderEnabled = builder.gingerbreadDecoderEnabled;
        this.downscaleFrameToDrawableDimensions = builder.downscaleFrameToDrawableDimensions;
        this.suppressBitmapPrefetchingSupplier = builder.suppressBitmapPrefetchingSupplier;
        this.isExperimentalThreadHandoffQueueEnabled = builder.experimentalThreadHandoffQueueEnabled;
        this.memoryType = builder.memoryType;
        this.keepCancelledFetchAsLowPriority = builder.keepCancelledFetchAsLowPriority;
        this.downsampleIfLargeBitmap = builder.downsampleIfLargeBitmap;
        this.isEncodedCacheEnabled = builder.encodedCacheEnabled;
        this.isEnsureTranscoderLibraryLoaded = builder.ensureTranscoderLibraryLoaded;
        this.isEncodedMemoryCacheProbingEnabled = builder.isEncodedMemoryCacheProbingEnabled;
        this.isDiskCacheProbingEnabled = builder.isDiskCacheProbingEnabled;
        this.trackedKeysSize = builder.trackedKeysSize;
        this.allowProgressiveOnPrefetch = builder.allowProgressiveOnPrefetch;
        this.animationRenderFpsLimit = builder.animationRenderFpsLimit;
        this.allowDelay = builder.allowDelay;
        this.handOffOnUiThreadOnly = builder.handOffOnUiThreadOnly;
        this.shouldStoreCacheEntrySize = builder.shouldStoreCacheEntrySize;
        this.shouldIgnoreCacheSizeMismatch = builder.shouldIgnoreCacheSizeMismatch;
        this.shouldUseDecodingBufferHelper = builder.shouldUseDecodingBufferHelper;
        this.cancelDecodeOnCacheMiss = builder.cancelDecodeOnCacheMiss;
        this.prefetchShortcutEnabled = builder.prefetchShortcutEnabled;
        this.platformDecoderOptions = builder.platformDecoderOptions;
    }

    /* JADX INFO: renamed from: isWebpSupportEnabled, reason: from getter */
    public final boolean getIsWebpSupportEnabled() {
        return this.isWebpSupportEnabled;
    }

    public final com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger() {
        return this.webpErrorLogger;
    }

    /* JADX INFO: renamed from: isDecodeCancellationEnabled, reason: from getter */
    public final boolean getIsDecodeCancellationEnabled() {
        return this.isDecodeCancellationEnabled;
    }

    public final com.facebook.common.webp.WebpBitmapFactory getWebpBitmapFactory() {
        return this.webpBitmapFactory;
    }

    public final boolean getUseDownsamplingRatioForResizing() {
        return this.useDownsamplingRatioForResizing;
    }

    public final boolean getUseBitmapPrepareToDraw() {
        return this.useBitmapPrepareToDraw;
    }

    public final boolean getUseBalancedAnimationStrategy() {
        return this.useBalancedAnimationStrategy;
    }

    public final int getAnimationStrategyBufferLengthMilliseconds() {
        return this.animationStrategyBufferLengthMilliseconds;
    }

    public final int getBitmapPrepareToDrawMinSizeBytes() {
        return this.bitmapPrepareToDrawMinSizeBytes;
    }

    public final int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.bitmapPrepareToDrawMaxSizeBytes;
    }

    public final boolean getBitmapPrepareToDrawForPrefetch() {
        return this.bitmapPrepareToDrawForPrefetch;
    }

    public final int getMaxBitmapDimension() {
        return this.maxBitmapDimension;
    }

    /* JADX INFO: renamed from: isNativeCodeDisabled, reason: from getter */
    public final boolean getIsNativeCodeDisabled() {
        return this.isNativeCodeDisabled;
    }

    /* JADX INFO: renamed from: isPartialImageCachingEnabled, reason: from getter */
    public final boolean getIsPartialImageCachingEnabled() {
        return this.isPartialImageCachingEnabled;
    }

    public final com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod getProducerFactoryMethod() {
        return this.producerFactoryMethod;
    }

    public final com.facebook.common.internal.Supplier<java.lang.Boolean> isLazyDataSource() {
        return this.isLazyDataSource;
    }

    /* JADX INFO: renamed from: isGingerbreadDecoderEnabled, reason: from getter */
    public final boolean getIsGingerbreadDecoderEnabled() {
        return this.isGingerbreadDecoderEnabled;
    }

    public final boolean getDownscaleFrameToDrawableDimensions() {
        return this.downscaleFrameToDrawableDimensions;
    }

    public final com.facebook.common.internal.Supplier<java.lang.Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.suppressBitmapPrefetchingSupplier;
    }

    /* JADX INFO: renamed from: isExperimentalThreadHandoffQueueEnabled, reason: from getter */
    public final boolean getIsExperimentalThreadHandoffQueueEnabled() {
        return this.isExperimentalThreadHandoffQueueEnabled;
    }

    public final long getMemoryType() {
        return this.memoryType;
    }

    public final boolean getKeepCancelledFetchAsLowPriority() {
        return this.keepCancelledFetchAsLowPriority;
    }

    public final boolean getDownsampleIfLargeBitmap() {
        return this.downsampleIfLargeBitmap;
    }

    /* JADX INFO: renamed from: isEncodedCacheEnabled, reason: from getter */
    public final boolean getIsEncodedCacheEnabled() {
        return this.isEncodedCacheEnabled;
    }

    /* JADX INFO: renamed from: isEnsureTranscoderLibraryLoaded, reason: from getter */
    public final boolean getIsEnsureTranscoderLibraryLoaded() {
        return this.isEnsureTranscoderLibraryLoaded;
    }

    /* JADX INFO: renamed from: isEncodedMemoryCacheProbingEnabled, reason: from getter */
    public final boolean getIsEncodedMemoryCacheProbingEnabled() {
        return this.isEncodedMemoryCacheProbingEnabled;
    }

    /* JADX INFO: renamed from: isDiskCacheProbingEnabled, reason: from getter */
    public final boolean getIsDiskCacheProbingEnabled() {
        return this.isDiskCacheProbingEnabled;
    }

    public final int getTrackedKeysSize() {
        return this.trackedKeysSize;
    }

    public final boolean getAllowDelay() {
        return this.allowDelay;
    }

    public final boolean getHandOffOnUiThreadOnly() {
        return this.handOffOnUiThreadOnly;
    }

    public final boolean getShouldStoreCacheEntrySize() {
        return this.shouldStoreCacheEntrySize;
    }

    public final boolean getShouldIgnoreCacheSizeMismatch() {
        return this.shouldIgnoreCacheSizeMismatch;
    }

    public final boolean getShouldUseDecodingBufferHelper() {
        return this.shouldUseDecodingBufferHelper;
    }

    public final boolean getAllowProgressiveOnPrefetch() {
        return this.allowProgressiveOnPrefetch;
    }

    public final boolean getCancelDecodeOnCacheMiss() {
        return this.cancelDecodeOnCacheMiss;
    }

    public final int getAnimationRenderFpsLimit() {
        return this.animationRenderFpsLimit;
    }

    public final boolean getPrefetchShortcutEnabled() {
        return this.prefetchShortcutEnabled;
    }

    public final com.facebook.imagepipeline.platform.PlatformDecoderOptions getPlatformDecoderOptions() {
        return this.platformDecoderOptions;
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u00105\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u000e\u00109\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0007J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010C\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010D\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ&\u0010E\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010M\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010N\u001a\u00020\u00002\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007J\u0014\u0010Q\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020#J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0007J\u000e\u0010^\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0012J\u000e\u0010_\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u0010`\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u0006\u0010a\u001a\u00020bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u00070\u00070\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "<init>", "(Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V", "shouldUseDecodingBufferHelper", "", "webpSupportEnabled", "webpErrorLogger", "Lcom/facebook/common/webp/WebpBitmapFactory$WebpErrorLogger;", "decodeCancellationEnabled", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "useDownsamplingRatioForResizing", "useBitmapPrepareToDraw", "useBalancedAnimationStrategy", "animationStrategyBufferLengthMilliseconds", "", "bitmapPrepareToDrawMinSizeBytes", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapDimension", "nativeCodeDisabled", "isPartialImageCachingEnabled", "producerFactoryMethod", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "lazyDataSource", "Lcom/facebook/common/internal/Supplier;", "gingerbreadDecoderEnabled", "downscaleFrameToDrawableDimensions", "suppressBitmapPrefetchingSupplier", "kotlin.jvm.PlatformType", "experimentalThreadHandoffQueueEnabled", "memoryType", "", "keepCancelledFetchAsLowPriority", "downsampleIfLargeBitmap", "encodedCacheEnabled", "ensureTranscoderLibraryLoaded", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "trackedKeysSize", "allowDelay", "handOffOnUiThreadOnly", "shouldStoreCacheEntrySize", "shouldIgnoreCacheSizeMismatch", "allowProgressiveOnPrefetch", "animationRenderFpsLimit", "cancelDecodeOnCacheMiss", "prefetchShortcutEnabled", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "asBuilder", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function0;", "", "setHandOffOnUiThreadOnly", "setStoreCacheEntrySize", "setIgnoreCacheSizeMismatch", "setWebpSupportEnabled", "setPrefetchShortcutEnabled", "setShouldUseDecodingBufferHelper", "setUseDownsampligRatioForResizing", "setPartialImageCachingEnabled", "partialImageCachingEnabled", "setDecodeCancellationEnabled", "setWebpErrorLogger", "setWebpBitmapFactory", "setBitmapPrepareToDraw", "minBitmapSizeBytes", "maxBitmapSizeBytes", "preparePrefetch", "setBalancedAnimationStrategy", "setAnimationStrategyBufferLengthMilliseconds", "setMaxBitmapDimension", "setNativeCodeDisabled", "setProducerFactoryMethod", "setLazyDataSource", "setGingerbreadDecoderEnabled", "setShouldDownscaleFrameToDrawableDimensions", "setSuppressBitmapPrefetchingSupplier", "setExperimentalThreadHandoffQueueEnabled", "setExperimentalMemoryType", "MemoryType", "setKeepCancelledFetchAsLowPriority", "setDownsampleIfLargeBitmap", "setEncodedCacheEnabled", "setEnsureTranscoderLibraryLoaded", "setIsDiskCacheProbingEnabled", "setIsEncodedMemoryCacheProbingEnabled", "setTrackedKeysSize", "setAllowDelay", "setAllowProgressiveOnPrefetch", "setAnimationRenderFpsLimit", "setCancelDecodeOnCacheMiss", "setPlatformDecoderOptions", "build", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public boolean allowDelay;
        public boolean allowProgressiveOnPrefetch;
        public int animationRenderFpsLimit;
        public int animationStrategyBufferLengthMilliseconds;
        public boolean bitmapPrepareToDrawForPrefetch;
        public int bitmapPrepareToDrawMaxSizeBytes;
        public int bitmapPrepareToDrawMinSizeBytes;
        public boolean cancelDecodeOnCacheMiss;
        private final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder configBuilder;
        public boolean decodeCancellationEnabled;
        public boolean downsampleIfLargeBitmap;
        public boolean downscaleFrameToDrawableDimensions;
        public boolean encodedCacheEnabled;
        public boolean ensureTranscoderLibraryLoaded;
        public boolean experimentalThreadHandoffQueueEnabled;
        public boolean gingerbreadDecoderEnabled;
        public boolean handOffOnUiThreadOnly;
        public boolean isDiskCacheProbingEnabled;
        public boolean isEncodedMemoryCacheProbingEnabled;
        public boolean isPartialImageCachingEnabled;
        public boolean keepCancelledFetchAsLowPriority;
        public com.facebook.common.internal.Supplier<java.lang.Boolean> lazyDataSource;
        public int maxBitmapDimension;
        public long memoryType;
        public boolean nativeCodeDisabled;
        public com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions;
        public boolean prefetchShortcutEnabled;
        public com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod;
        public boolean shouldIgnoreCacheSizeMismatch;
        public boolean shouldStoreCacheEntrySize;
        public boolean shouldUseDecodingBufferHelper;
        public com.facebook.common.internal.Supplier<java.lang.Boolean> suppressBitmapPrefetchingSupplier;
        public int trackedKeysSize;
        public boolean useBalancedAnimationStrategy;
        public boolean useBitmapPrepareToDraw;
        public boolean useDownsamplingRatioForResizing;
        public com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory;
        public com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger;
        public boolean webpSupportEnabled;

        public Builder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder configBuilder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            this.configBuilder = configBuilder;
            this.animationStrategyBufferLengthMilliseconds = 1000;
            this.maxBitmapDimension = 2048;
            com.facebook.common.internal.Supplier<java.lang.Boolean> supplierOf = com.facebook.common.internal.Suppliers.of(false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(supplierOf, "of(...)");
            this.suppressBitmapPrefetchingSupplier = supplierOf;
            this.encodedCacheEnabled = true;
            this.ensureTranscoderLibraryLoaded = true;
            this.trackedKeysSize = 20;
            this.animationRenderFpsLimit = 30;
            this.platformDecoderOptions = new com.facebook.imagepipeline.platform.PlatformDecoderOptions(false, false, 3, null);
        }

        private final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder asBuilder(kotlin.jvm.functions.Function0<kotlin.Unit> block) {
            block.invoke();
            return this;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setHandOffOnUiThreadOnly(final boolean handOffOnUiThreadOnly) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setHandOffOnUiThreadOnly$lambda$0(this.f$0, handOffOnUiThreadOnly);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setHandOffOnUiThreadOnly$lambda$0(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.handOffOnUiThreadOnly = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setStoreCacheEntrySize(final boolean shouldStoreCacheEntrySize) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setStoreCacheEntrySize$lambda$1(this.f$0, shouldStoreCacheEntrySize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setStoreCacheEntrySize$lambda$1(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldStoreCacheEntrySize = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setIgnoreCacheSizeMismatch(final boolean shouldIgnoreCacheSizeMismatch) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setIgnoreCacheSizeMismatch$lambda$2(this.f$0, shouldIgnoreCacheSizeMismatch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setIgnoreCacheSizeMismatch$lambda$2(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldIgnoreCacheSizeMismatch = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setWebpSupportEnabled(final boolean webpSupportEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setWebpSupportEnabled$lambda$3(this.f$0, webpSupportEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setWebpSupportEnabled$lambda$3(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpSupportEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setPrefetchShortcutEnabled(final boolean prefetchShortcutEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setPrefetchShortcutEnabled$lambda$4(this.f$0, prefetchShortcutEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setPrefetchShortcutEnabled$lambda$4(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.prefetchShortcutEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: shouldUseDecodingBufferHelper, reason: from getter */
        public final boolean getShouldUseDecodingBufferHelper() {
            return this.shouldUseDecodingBufferHelper;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setShouldUseDecodingBufferHelper(final boolean shouldUseDecodingBufferHelper) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setShouldUseDecodingBufferHelper$lambda$5(this.f$0, shouldUseDecodingBufferHelper);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setShouldUseDecodingBufferHelper$lambda$5(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.shouldUseDecodingBufferHelper = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setUseDownsampligRatioForResizing(final boolean useDownsamplingRatioForResizing) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setUseDownsampligRatioForResizing$lambda$6(this.f$0, useDownsamplingRatioForResizing);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setUseDownsampligRatioForResizing$lambda$6(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useDownsamplingRatioForResizing = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setPartialImageCachingEnabled(final boolean partialImageCachingEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setPartialImageCachingEnabled$lambda$7(this.f$0, partialImageCachingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setPartialImageCachingEnabled$lambda$7(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isPartialImageCachingEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setDecodeCancellationEnabled(final boolean decodeCancellationEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setDecodeCancellationEnabled$lambda$8(this.f$0, decodeCancellationEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setDecodeCancellationEnabled$lambda$8(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.decodeCancellationEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setWebpErrorLogger(final com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setWebpErrorLogger$lambda$9(this.f$0, webpErrorLogger);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setWebpErrorLogger$lambda$9(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpErrorLogger = webpErrorLogger;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setWebpBitmapFactory(final com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setWebpBitmapFactory$lambda$10(this.f$0, webpBitmapFactory);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setWebpBitmapFactory$lambda$10(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.webpBitmapFactory = webpBitmapFactory;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setBitmapPrepareToDraw(final boolean useBitmapPrepareToDraw, final int minBitmapSizeBytes, final int maxBitmapSizeBytes, final boolean preparePrefetch) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setBitmapPrepareToDraw$lambda$11(this.f$0, useBitmapPrepareToDraw, minBitmapSizeBytes, maxBitmapSizeBytes, preparePrefetch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setBitmapPrepareToDraw$lambda$11(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z, int i, int i2, boolean z2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useBitmapPrepareToDraw = z;
            this$0.bitmapPrepareToDrawMinSizeBytes = i;
            this$0.bitmapPrepareToDrawMaxSizeBytes = i2;
            this$0.bitmapPrepareToDrawForPrefetch = z2;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setBalancedAnimationStrategy(final boolean useBalancedAnimationStrategy) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setBalancedAnimationStrategy$lambda$12(this.f$0, useBalancedAnimationStrategy);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setBalancedAnimationStrategy$lambda$12(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.useBalancedAnimationStrategy = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setAnimationStrategyBufferLengthMilliseconds(final int animationStrategyBufferLengthMilliseconds) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setAnimationStrategyBufferLengthMilliseconds$lambda$13(this.f$0, animationStrategyBufferLengthMilliseconds);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setAnimationStrategyBufferLengthMilliseconds$lambda$13(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.animationStrategyBufferLengthMilliseconds = i;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setMaxBitmapDimension(final int maxBitmapDimension) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setMaxBitmapDimension$lambda$14(this.f$0, maxBitmapDimension);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setMaxBitmapDimension$lambda$14(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.maxBitmapDimension = i;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setNativeCodeDisabled(final boolean nativeCodeDisabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setNativeCodeDisabled$lambda$15(this.f$0, nativeCodeDisabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setNativeCodeDisabled$lambda$15(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.nativeCodeDisabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setProducerFactoryMethod(final com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setProducerFactoryMethod$lambda$16(this.f$0, producerFactoryMethod);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setProducerFactoryMethod$lambda$16(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod producerFactoryMethod) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.producerFactoryMethod = producerFactoryMethod;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setLazyDataSource(final com.facebook.common.internal.Supplier<java.lang.Boolean> lazyDataSource) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setLazyDataSource$lambda$17(this.f$0, lazyDataSource);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setLazyDataSource$lambda$17(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.common.internal.Supplier supplier) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.lazyDataSource = supplier;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setGingerbreadDecoderEnabled(final boolean gingerbreadDecoderEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setGingerbreadDecoderEnabled$lambda$18(this.f$0, gingerbreadDecoderEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setGingerbreadDecoderEnabled$lambda$18(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.gingerbreadDecoderEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setShouldDownscaleFrameToDrawableDimensions(final boolean downscaleFrameToDrawableDimensions) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setShouldDownscaleFrameToDrawableDimensions$lambda$19(this.f$0, downscaleFrameToDrawableDimensions);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setShouldDownscaleFrameToDrawableDimensions$lambda$19(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.downscaleFrameToDrawableDimensions = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setSuppressBitmapPrefetchingSupplier(final com.facebook.common.internal.Supplier<java.lang.Boolean> suppressBitmapPrefetchingSupplier) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setSuppressBitmapPrefetchingSupplier$lambda$20(this.f$0, suppressBitmapPrefetchingSupplier);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setSuppressBitmapPrefetchingSupplier$lambda$20(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.common.internal.Supplier suppressBitmapPrefetchingSupplier) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "$suppressBitmapPrefetchingSupplier");
            this$0.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setExperimentalThreadHandoffQueueEnabled(final boolean experimentalThreadHandoffQueueEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setExperimentalThreadHandoffQueueEnabled$lambda$21(this.f$0, experimentalThreadHandoffQueueEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setExperimentalThreadHandoffQueueEnabled$lambda$21(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.experimentalThreadHandoffQueueEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setExperimentalMemoryType$lambda$22(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, long j) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.memoryType = j;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setExperimentalMemoryType(final long MemoryType) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setExperimentalMemoryType$lambda$22(this.f$0, MemoryType);
                }
            });
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setKeepCancelledFetchAsLowPriority(final boolean keepCancelledFetchAsLowPriority) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setKeepCancelledFetchAsLowPriority$lambda$23(this.f$0, keepCancelledFetchAsLowPriority);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setKeepCancelledFetchAsLowPriority$lambda$23(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.keepCancelledFetchAsLowPriority = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setDownsampleIfLargeBitmap(final boolean downsampleIfLargeBitmap) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setDownsampleIfLargeBitmap$lambda$24(this.f$0, downsampleIfLargeBitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setDownsampleIfLargeBitmap$lambda$24(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.downsampleIfLargeBitmap = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setEncodedCacheEnabled(final boolean encodedCacheEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setEncodedCacheEnabled$lambda$25(this.f$0, encodedCacheEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setEncodedCacheEnabled$lambda$25(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.encodedCacheEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setEnsureTranscoderLibraryLoaded(final boolean ensureTranscoderLibraryLoaded) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setEnsureTranscoderLibraryLoaded$lambda$26(this.f$0, ensureTranscoderLibraryLoaded);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setEnsureTranscoderLibraryLoaded$lambda$26(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.ensureTranscoderLibraryLoaded = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setIsDiskCacheProbingEnabled(final boolean isDiskCacheProbingEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setIsDiskCacheProbingEnabled$lambda$27(this.f$0, isDiskCacheProbingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setIsDiskCacheProbingEnabled$lambda$27(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isDiskCacheProbingEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setIsEncodedMemoryCacheProbingEnabled(final boolean isEncodedMemoryCacheProbingEnabled) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setIsEncodedMemoryCacheProbingEnabled$lambda$28(this.f$0, isEncodedMemoryCacheProbingEnabled);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setIsEncodedMemoryCacheProbingEnabled$lambda$28(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isEncodedMemoryCacheProbingEnabled = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setTrackedKeysSize(final int trackedKeysSize) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setTrackedKeysSize$lambda$29(this.f$0, trackedKeysSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setTrackedKeysSize$lambda$29(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.trackedKeysSize = i;
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setAllowDelay$lambda$30(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.allowDelay = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setAllowDelay(final boolean allowDelay) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setAllowDelay$lambda$30(this.f$0, allowDelay);
                }
            });
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setAllowProgressiveOnPrefetch(final boolean allowProgressiveOnPrefetch) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setAllowProgressiveOnPrefetch$lambda$31(this.f$0, allowProgressiveOnPrefetch);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setAllowProgressiveOnPrefetch$lambda$31(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.allowProgressiveOnPrefetch = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setAnimationRenderFpsLimit(final int animationRenderFpsLimit) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setAnimationRenderFpsLimit$lambda$32(this.f$0, animationRenderFpsLimit);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setAnimationRenderFpsLimit$lambda$32(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.animationRenderFpsLimit = i;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setCancelDecodeOnCacheMiss(final boolean cancelDecodeOnCacheMiss) {
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setCancelDecodeOnCacheMiss$lambda$33(this.f$0, cancelDecodeOnCacheMiss);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setCancelDecodeOnCacheMiss$lambda$33(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.cancelDecodeOnCacheMiss = z;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder setPlatformDecoderOptions(final com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
            return asBuilder(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder.setPlatformDecoderOptions$lambda$34(this.f$0, platformDecoderOptions);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit setPlatformDecoderOptions$lambda$34(com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder this$0, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDecoderOptions, "$platformDecoderOptions");
            this$0.platformDecoderOptions = platformDecoderOptions;
            return kotlin.Unit.INSTANCE;
        }

        public final com.facebook.imagepipeline.core.ImagePipelineExperiments build() {
            return new com.facebook.imagepipeline.core.ImagePipelineExperiments(this, null);
        }
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JÞ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a2\u0016\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020'H\u0016¨\u0006/"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$DefaultProducerFactoryMethod;", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$ProducerFactoryMethod;", "<init>", "()V", "createProducerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "context", "Landroid/content/Context;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "resizeAndRotateEnabledForNetwork", "", "decodeCancellationEnabled", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "bitmapMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedMemoryCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "diskCachesStoreSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/core/DiskCachesStore;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPrepareToDrawMinSizeBytes", "", "bitmapPrepareToDrawMaxSizeBytes", "bitmapPrepareToDrawForPrefetch", "maxBitmapSize", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "keepCancelledFetchAsLowPriority", "trackedKeysSize", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultProducerFactoryMethod implements com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public com.facebook.imagepipeline.core.ProducerFactory createProducerFactory(android.content.Context context, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, com.facebook.imagepipeline.core.DownsampleMode downsampleMode, boolean resizeAndRotateEnabledForNetwork, boolean decodeCancellationEnabled, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.PooledByteStreams pooledByteStreams, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> bitmapMemoryCache, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedMemoryCache, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> diskCachesStoreSupplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, int bitmapPrepareToDrawMinSizeBytes, int bitmapPrepareToDrawMaxSizeBytes, boolean bitmapPrepareToDrawForPrefetch, int maxBitmapSize, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory, boolean keepCancelledFetchAsLowPriority, int trackedKeysSize) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
            return new com.facebook.imagepipeline.core.ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, downsampleMode, resizeAndRotateEnabledForNetwork, decodeCancellationEnabled, executorSupplier, pooledByteBufferFactory, bitmapMemoryCache, encodedMemoryCache, diskCachesStoreSupplier, cacheKeyFactory, platformBitmapFactory, bitmapPrepareToDrawMinSizeBytes, bitmapPrepareToDrawMaxSizeBytes, bitmapPrepareToDrawForPrefetch, maxBitmapSize, closeableReferenceFactory, keepCancelledFetchAsLowPriority, trackedKeysSize);
        }
    }

    /* JADX INFO: compiled from: ImagePipelineExperiments.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Companion;", "", "<init>", "()V", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "configBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder newBuilder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder configBuilder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            return new com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder(configBuilder);
        }
    }
}
