package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class PartialDiskCacheProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    public static final java.lang.String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final java.lang.String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final java.lang.String PRODUCER_NAME = "PartialDiskCacheProducer";
    private final com.facebook.common.memory.ByteArrayPool mByteArrayPool;
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;
    private final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    public PartialDiskCacheProducer(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        boolean zIsCacheEnabled = producerContext.getImageRequest().isCacheEnabled(16);
        boolean zIsCacheEnabled2 = producerContext.getImageRequest().isCacheEnabled(32);
        if (!zIsCacheEnabled && !zIsCacheEnabled2) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        producerListener.onProducerStart(producerContext, PRODUCER_NAME);
        com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
        if (!zIsCacheEnabled) {
            producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, getExtraMap(producerListener, producerContext, false, 0));
            startInputProducer(consumer, producerContext, encodedCacheKey, null);
        } else {
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            this.mDiskCachesStoreSupplier.get().getMainBufferedDiskCache().get(encodedCacheKey, atomicBoolean).continueWith(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
        }
    }

    private bolts.Continuation<com.facebook.imagepipeline.image.EncodedImage, java.lang.Void> onFinishDiskReads(final com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, final com.facebook.imagepipeline.producers.ProducerContext producerContext, final com.facebook.cache.common.CacheKey cacheKey) {
        final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        return new bolts.Continuation<com.facebook.imagepipeline.image.EncodedImage, java.lang.Void>() { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.1
            @Override // bolts.Continuation
            @javax.annotation.Nullable
            public java.lang.Void then(bolts.Task<com.facebook.imagepipeline.image.EncodedImage> task) throws java.lang.Exception {
                if (com.facebook.imagepipeline.producers.PartialDiskCacheProducer.isTaskCancelled(task)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    producerListener.onProducerFinishWithFailure(producerContext, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, task.getError(), null);
                    com.facebook.imagepipeline.producers.PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, null);
                } else {
                    com.facebook.imagepipeline.image.EncodedImage result = task.getResult();
                    if (result != null) {
                        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = producerListener;
                        com.facebook.imagepipeline.producers.ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.getExtraMap(producerListener2, producerContext2, true, result.getSize()));
                        com.facebook.imagepipeline.common.BytesRange max = com.facebook.imagepipeline.common.BytesRange.toMax(result.getSize() - 1);
                        result.setBytesRange(max);
                        int size = result.getSize();
                        com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
                        if (max.contains(imageRequest.getBytesRange())) {
                            producerContext.putOriginExtra("disk", "partial");
                            producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, true);
                            consumer.onNewResult(result, 9);
                        } else {
                            consumer.onNewResult(result, 8);
                            com.facebook.imagepipeline.producers.PartialDiskCacheProducer.this.startInputProducer(consumer, new com.facebook.imagepipeline.producers.SettableProducerContext(com.facebook.imagepipeline.request.ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(com.facebook.imagepipeline.common.BytesRange.from(size - 1)).build(), producerContext), cacheKey, result);
                        }
                    } else {
                        com.facebook.imagepipeline.producers.ProducerListener2 producerListener3 = producerListener;
                        com.facebook.imagepipeline.producers.ProducerContext producerContext3 = producerContext;
                        producerListener3.onProducerFinishWithSuccess(producerContext3, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, com.facebook.imagepipeline.producers.PartialDiskCacheProducer.getExtraMap(producerListener3, producerContext3, false, 0));
                        com.facebook.imagepipeline.producers.PartialDiskCacheProducer.this.startInputProducer(consumer, producerContext, cacheKey, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInputProducer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.cache.common.CacheKey cacheKey, @javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PartialDiskCacheConsumer(consumer, this.mDiskCachesStoreSupplier, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage, producerContext.getImageRequest().isCacheEnabled(32)), producerContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(bolts.Task<?> task) {
        if (task.isCancelled()) {
            return true;
        }
        return task.isFaulted() && (task.getError() instanceof java.util.concurrent.CancellationException);
    }

    @javax.annotation.Nullable
    static java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, com.facebook.imagepipeline.producers.ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (!z) {
            return com.facebook.common.internal.ImmutableMap.of("cached_value_found", java.lang.String.valueOf(z));
        }
        return com.facebook.common.internal.ImmutableMap.of("cached_value_found", java.lang.String.valueOf(z), "encodedImageSize", java.lang.String.valueOf(i));
    }

    private void subscribeTaskForRequestCancellation(final java.util.concurrent.atomic.AtomicBoolean atomicBoolean, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    private static android.net.Uri createUriForPartialCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", io.dcloud.common.constant.AbsoluteConst.TRUE).build();
    }

    private static class PartialDiskCacheConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private static final int READ_SIZE = 16384;
        private final com.facebook.common.memory.ByteArrayPool mByteArrayPool;
        private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
        private final boolean mIsDiskCacheEnabledForWrite;

        @javax.annotation.Nullable
        private final com.facebook.imagepipeline.image.EncodedImage mPartialEncodedImageFromCache;
        private final com.facebook.cache.common.CacheKey mPartialImageCacheKey;
        private final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

        private PartialDiskCacheConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.cache.common.CacheKey cacheKey, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.ByteArrayPool byteArrayPool, @javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, boolean z) {
            super(consumer);
            this.mDiskCachesStoreSupplier = supplier;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
            this.mIsDiskCacheEnabledForWrite = z;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            if (isNotLast(i)) {
                return;
            }
            if (this.mPartialEncodedImageFromCache != null && encodedImage != null && encodedImage.getBytesRange() != null) {
                try {
                    try {
                        sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                    } catch (java.io.IOException e) {
                        com.facebook.common.logging.FLog.e(com.facebook.imagepipeline.producers.PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e);
                        getConsumer().onFailure(e);
                    }
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                    this.mDiskCachesStoreSupplier.get().getMainBufferedDiskCache().remove(this.mPartialImageCacheKey);
                    return;
                } catch (java.lang.Throwable th) {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                    throw th;
                }
            }
            if (this.mIsDiskCacheEnabledForWrite && statusHasFlag(i, 8) && isLast(i) && encodedImage != null && encodedImage.getImageFormat() != com.facebook.imageformat.ImageFormat.UNKNOWN) {
                this.mDiskCachesStoreSupplier.get().getMainBufferedDiskCache().put(this.mPartialImageCacheKey, encodedImage);
                getConsumer().onNewResult(encodedImage, i);
            } else {
                getConsumer().onNewResult(encodedImage, i);
            }
        }

        private com.facebook.common.memory.PooledByteBufferOutputStream merge(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.image.EncodedImage encodedImage2) throws java.io.IOException {
            int i = ((com.facebook.imagepipeline.common.BytesRange) com.facebook.common.internal.Preconditions.checkNotNull(encodedImage2.getBytesRange())).from;
            com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + i);
            copy(encodedImage.getInputStreamOrThrow(), pooledByteBufferOutputStreamNewOutputStream, i);
            copy(encodedImage2.getInputStreamOrThrow(), pooledByteBufferOutputStreamNewOutputStream, encodedImage2.getSize());
            return pooledByteBufferOutputStreamNewOutputStream;
        }

        private void copy(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i) throws java.io.IOException {
            byte[] bArr = this.mByteArrayPool.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int i3 = inputStream.read(bArr, 0, java.lang.Math.min(16384, i2));
                    if (i3 < 0) {
                        break;
                    } else if (i3 > 0) {
                        outputStream.write(bArr, 0, i3);
                        i2 -= i3;
                    }
                } catch (java.lang.Throwable th) {
                    this.mByteArrayPool.release(bArr);
                    throw th;
                }
            }
            this.mByteArrayPool.release(bArr);
            if (i2 <= 0) {
                return;
            }
            throw new java.io.IOException(java.lang.String.format(null, "Failed to read %d bytes - finished %d short", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        }

        private void sendFinalResultToConsumer(com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStream) throws java.lang.Throwable {
            com.facebook.imagepipeline.image.EncodedImage encodedImage;
            java.lang.Throwable th;
            com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            try {
                encodedImage = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceOf);
                try {
                    encodedImage.parseMetaData();
                    getConsumer().onNewResult(encodedImage, 1);
                    com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                encodedImage = null;
                th = th3;
            }
        }
    }
}
