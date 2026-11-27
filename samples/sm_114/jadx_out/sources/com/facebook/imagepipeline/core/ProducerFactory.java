package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public class ProducerFactory {
    private static final int MAX_SIMULTANEOUS_REQUESTS = 5;
    protected android.content.res.AssetManager mAssetManager;
    protected final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBitmapMemoryCache;
    protected boolean mBitmapPrepareToDrawForPrefetch;
    protected final int mBitmapPrepareToDrawMaxSizeBytes;
    protected final int mBitmapPrepareToDrawMinSizeBytes;
    protected final com.facebook.common.memory.ByteArrayPool mByteArrayPool;
    protected final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    protected final com.facebook.imagepipeline.core.CloseableReferenceFactory mCloseableReferenceFactory;
    protected android.content.ContentResolver mContentResolver;
    protected final boolean mDecodeCancellationEnabled;
    protected final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mDiskCacheHistory;
    protected final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    protected final com.facebook.imagepipeline.core.DownsampleMode mDownsampleMode;
    protected final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mEncodedMemoryCache;
    protected final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mEncodedMemoryCacheHistory;
    protected final com.facebook.imagepipeline.core.ExecutorSupplier mExecutorSupplier;
    protected final com.facebook.imagepipeline.decoder.ImageDecoder mImageDecoder;
    protected final boolean mKeepCancelledFetchAsLowPriority;
    protected final int mMaxBitmapSize;
    protected final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mPlatformBitmapFactory;
    protected final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;
    protected final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig mProgressiveJpegConfig;
    protected final boolean mResizeAndRotateEnabledForNetwork;
    protected android.content.res.Resources mResources;

    public ProducerFactory(android.content.Context context, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, com.facebook.imagepipeline.core.DownsampleMode downsampleMode, boolean z, boolean z2, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache2, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z3, int i3, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory, boolean z4, int i4) {
        this.mContentResolver = context.getApplicationContext().getContentResolver();
        this.mResources = context.getApplicationContext().getResources();
        this.mAssetManager = context.getApplicationContext().getAssets();
        this.mByteArrayPool = byteArrayPool;
        this.mImageDecoder = imageDecoder;
        this.mProgressiveJpegConfig = progressiveJpegConfig;
        this.mDownsampleMode = downsampleMode;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mDecodeCancellationEnabled = z2;
        this.mExecutorSupplier = executorSupplier;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mEncodedMemoryCacheHistory = new com.facebook.imagepipeline.cache.BoundedLinkedHashSet<>(i4);
        this.mDiskCacheHistory = new com.facebook.imagepipeline.cache.BoundedLinkedHashSet<>(i4);
        this.mBitmapPrepareToDrawMinSizeBytes = i;
        this.mBitmapPrepareToDrawMaxSizeBytes = i2;
        this.mBitmapPrepareToDrawForPrefetch = z3;
        this.mMaxBitmapSize = i3;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
        this.mKeepCancelledFetchAsLowPriority = z4;
    }

    @java.lang.Deprecated
    public ProducerFactory(android.content.Context context, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache2, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory, boolean z5, int i4) {
        this(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z ? com.facebook.imagepipeline.core.DownsampleMode.ALWAYS : com.facebook.imagepipeline.core.DownsampleMode.AUTO, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, supplier, cacheKeyFactory, platformBitmapFactory, i, i2, z4, i3, closeableReferenceFactory, z5, i4);
    }

    public static com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer(producer);
    }

    public com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public static com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer2) {
        return new com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer(producer, producer2);
    }

    public com.facebook.imagepipeline.producers.DataFetchProducer newDataFetchProducer() {
        return new com.facebook.imagepipeline.producers.DataFetchProducer(this.mPooledByteBufferFactory);
    }

    public com.facebook.imagepipeline.producers.DecodeProducer newDecodeProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.getDecodeExecutor(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleMode, this.mResizeAndRotateEnabledForNetwork, this.mDecodeCancellationEnabled, producer, this.mMaxBitmapSize, this.mCloseableReferenceFactory, null, com.facebook.common.internal.Suppliers.BOOLEAN_FALSE);
    }

    public com.facebook.imagepipeline.producers.DiskCacheReadProducer newDiskCacheReadProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.DiskCacheReadProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.DiskCacheWriteProducer newDiskCacheWriteProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.DiskCacheWriteProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.PartialDiskCacheProducer newPartialDiskCacheProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.PartialDiskCacheProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mPooledByteBufferFactory, this.mByteArrayPool, producer);
    }

    public com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, this.mKeepCancelledFetchAsLowPriority, producer);
    }

    public com.facebook.imagepipeline.producers.BitmapProbeProducer newBitmapProbeProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.BitmapProbeProducer(this.mEncodedMemoryCache, this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
    }

    public com.facebook.imagepipeline.producers.EncodedProbeProducer newEncodedProbeProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.EncodedProbeProducer(this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, producer);
    }

    public com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newEncodedMemoryCacheProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        return new com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.LocalAssetFetchProducer newLocalAssetFetchProducer() {
        return new com.facebook.imagepipeline.producers.LocalAssetFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mAssetManager);
    }

    public com.facebook.imagepipeline.producers.LocalContentUriFetchProducer newLocalContentUriFetchProducer() {
        return new com.facebook.imagepipeline.producers.LocalContentUriFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer() {
        return new com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public com.facebook.imagepipeline.producers.LocalExifThumbnailProducer newLocalExifThumbnailProducer() {
        return new com.facebook.imagepipeline.producers.LocalExifThumbnailProducer(this.mExecutorSupplier.forThumbnailProducer(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public com.facebook.imagepipeline.producers.ThumbnailBranchProducer newThumbnailBranchProducer(com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducerArr) {
        return new com.facebook.imagepipeline.producers.ThumbnailBranchProducer(thumbnailProducerArr);
    }

    public com.facebook.imagepipeline.producers.LocalFileFetchProducer newLocalFileFetchProducer() {
        return new com.facebook.imagepipeline.producers.LocalFileFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory);
    }

    public com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer newQualifiedResourceFetchProducer() {
        return new com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mContentResolver);
    }

    public com.facebook.imagepipeline.producers.LocalResourceFetchProducer newLocalResourceFetchProducer() {
        return new com.facebook.imagepipeline.producers.LocalResourceFetchProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mPooledByteBufferFactory, this.mResources);
    }

    public com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer newLocalVideoThumbnailProducer() {
        return new com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer(this.mExecutorSupplier.getIoBoundExecutor(), this.mContentResolver);
    }

    public com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newNetworkFetchProducer(com.facebook.imagepipeline.producers.NetworkFetcher networkFetcher) {
        return new com.facebook.imagepipeline.producers.NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, networkFetcher);
    }

    public com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, producer);
    }

    public com.facebook.imagepipeline.producers.PostprocessorProducer newPostprocessorProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.PostprocessorProducer(producer, this.mPlatformBitmapFactory, this.mExecutorSupplier.getBackgroundExecutor());
    }

    public com.facebook.imagepipeline.producers.ResizeAndRotateProducer newResizeAndRotateProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer, boolean z, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory) {
        return new com.facebook.imagepipeline.producers.ResizeAndRotateProducer(this.mExecutorSupplier.getBackgroundExecutor(), this.mPooledByteBufferFactory, producer, z, imageTranscoderFactory);
    }

    public <T> com.facebook.imagepipeline.producers.SwallowResultProducer<T> newSwallowResultProducer(com.facebook.imagepipeline.producers.Producer<T> producer) {
        return new com.facebook.imagepipeline.producers.SwallowResultProducer<>(producer);
    }

    public <T> com.facebook.imagepipeline.producers.Producer<T> newBackgroundThreadHandoffProducer(com.facebook.imagepipeline.producers.Producer<T> producer, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        return new com.facebook.imagepipeline.producers.ThreadHandoffProducer(producer, threadHandoffProducerQueue);
    }

    public <T> com.facebook.imagepipeline.producers.ThrottlingProducer<T> newThrottlingProducer(com.facebook.imagepipeline.producers.Producer<T> producer) {
        return new com.facebook.imagepipeline.producers.ThrottlingProducer<>(5, this.mExecutorSupplier.getLightWeightBackgroundExecutor(), producer);
    }

    public com.facebook.imagepipeline.producers.BitmapPrepareProducer newBitmapPrepareProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.BitmapPrepareProducer(producer, this.mBitmapPrepareToDrawMinSizeBytes, this.mBitmapPrepareToDrawMaxSizeBytes, this.mBitmapPrepareToDrawForPrefetch);
    }

    public com.facebook.imagepipeline.producers.DelayProducer newDelayProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        return new com.facebook.imagepipeline.producers.DelayProducer(producer, this.mExecutorSupplier.getBackgroundScheduledExecutorService());
    }

    public com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer newLocalThumbnailBitmapSdk29Producer() {
        return new com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer(this.mExecutorSupplier.getBackgroundExecutor(), this.mContentResolver);
    }
}
