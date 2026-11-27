package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class ResizeAndRotateProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    private static final java.lang.String INPUT_IMAGE_FORMAT = "Image format";
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final java.lang.String ORIGINAL_SIZE_KEY = "Original size";
    private static final java.lang.String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final java.lang.String REQUESTED_SIZE_KEY = "Requested size";
    private static final java.lang.String TRANSCODER_ID = "Transcoder id";
    private static final java.lang.String TRANSCODING_RESULT = "Transcoding result";
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory mImageTranscoderFactory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;
    private final boolean mIsResizingEnabled;
    private final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    public ResizeAndRotateProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer, boolean z, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory) {
        this.mExecutor = (java.util.concurrent.Executor) com.facebook.common.internal.Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (com.facebook.common.memory.PooledByteBufferFactory) com.facebook.common.internal.Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (com.facebook.imagepipeline.producers.Producer) com.facebook.common.internal.Preconditions.checkNotNull(producer);
        this.mImageTranscoderFactory = (com.facebook.imagepipeline.transcoder.ImageTranscoderFactory) com.facebook.common.internal.Preconditions.checkNotNull(imageTranscoderFactory);
        this.mIsResizingEnabled = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
    }

    private class TransformingConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory mImageTranscoderFactory;
        private boolean mIsCancelled;
        private final boolean mIsResizingEnabled;
        private final com.facebook.imagepipeline.producers.JobScheduler mJobScheduler;
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        TransformingConsumer(final com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, boolean z, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mIsCancelled = false;
            this.mProducerContext = producerContext;
            java.lang.Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new com.facebook.imagepipeline.producers.JobScheduler(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.this.mExecutor, new com.facebook.imagepipeline.producers.JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) throws java.lang.Throwable {
                    if (encodedImage != null) {
                        com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer transformingConsumer = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this;
                        transformingConsumer.doTransform(encodedImage, i, (com.facebook.imagepipeline.transcoder.ImageTranscoder) com.facebook.common.internal.Preconditions.checkNotNull(transformingConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.mIsResizingEnabled)));
                    } else {
                        com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.getConsumer().onNewResult(null, i);
                    }
                }
            }, 100);
            producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
                    com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            if (this.mIsCancelled) {
                return;
            }
            boolean zIsLast = isLast(i);
            if (encodedImage == null) {
                if (zIsLast) {
                    getConsumer().onNewResult(null, 1);
                    return;
                }
                return;
            }
            com.facebook.imageformat.ImageFormat imageFormat = encodedImage.getImageFormat();
            com.facebook.common.util.TriState triStateShouldTransform = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, (com.facebook.imagepipeline.transcoder.ImageTranscoder) com.facebook.common.internal.Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled)));
            if (zIsLast || triStateShouldTransform != com.facebook.common.util.TriState.UNSET) {
                if (triStateShouldTransform != com.facebook.common.util.TriState.YES) {
                    forwardNewResult(encodedImage, i, imageFormat);
                } else if (this.mJobScheduler.updateJob(encodedImage, i)) {
                    if (zIsLast || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }

        private void forwardNewResult(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imageformat.ImageFormat imageFormat) {
            com.facebook.imagepipeline.image.EncodedImage newResultsForJpegOrHeif;
            if (imageFormat == com.facebook.imageformat.DefaultImageFormats.JPEG || imageFormat == com.facebook.imageformat.DefaultImageFormats.HEIF) {
                newResultsForJpegOrHeif = getNewResultsForJpegOrHeif(encodedImage);
            } else {
                newResultsForJpegOrHeif = getNewResultForImagesWithoutExifData(encodedImage);
            }
            getConsumer().onNewResult(newResultsForJpegOrHeif, i);
        }

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.image.EncodedImage getNewResultForImagesWithoutExifData(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
            com.facebook.imagepipeline.common.RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
            return (rotationOptions.useImageMetadata() || !rotationOptions.rotationEnabled()) ? encodedImage : getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
        }

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.image.EncodedImage getNewResultsForJpegOrHeif(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
            return (this.mProducerContext.getImageRequest().getRotationOptions().getDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1) ? encodedImage : getCloneWithRotationApplied(encodedImage, 0);
        }

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.image.EncodedImage getCloneWithRotationApplied(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            com.facebook.imagepipeline.image.EncodedImage encodedImageCloneOrNull = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage);
            if (encodedImageCloneOrNull != null) {
                encodedImageCloneOrNull.setRotationAngle(i);
            }
            return encodedImageCloneOrNull;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doTransform(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.transcoder.ImageTranscoder imageTranscoder) throws java.lang.Throwable {
            this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, com.facebook.imagepipeline.producers.ResizeAndRotateProducer.PRODUCER_NAME);
            com.facebook.imagepipeline.request.ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream = com.facebook.imagepipeline.producers.ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            try {
                try {
                    com.facebook.imagepipeline.transcoder.ImageTranscodeResult imageTranscodeResultTranscode = imageTranscoder.transcode(encodedImage, pooledByteBufferOutputStreamNewOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, 85, encodedImage.getColorSpace());
                    if (imageTranscodeResultTranscode.getTranscodeStatus() == 2) {
                        throw new java.lang.RuntimeException("Error while transcoding the image");
                    }
                    java.util.Map<java.lang.String, java.lang.String> extraMap = getExtraMap(encodedImage, imageRequest.getResizeOptions(), imageTranscodeResultTranscode, imageTranscoder.getIdentifier());
                    com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(pooledByteBufferOutputStreamNewOutputStream.toByteBuffer());
                    try {
                        com.facebook.imagepipeline.image.EncodedImage encodedImage2 = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceOf);
                        encodedImage2.setImageFormat(com.facebook.imageformat.DefaultImageFormats.JPEG);
                        try {
                            encodedImage2.parseMetaData();
                            this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, com.facebook.imagepipeline.producers.ResizeAndRotateProducer.PRODUCER_NAME, extraMap);
                            if (imageTranscodeResultTranscode.getTranscodeStatus() != 1) {
                                i |= 16;
                            }
                            getConsumer().onNewResult(encodedImage2, i);
                            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                            pooledByteBufferOutputStreamNewOutputStream.close();
                        } catch (java.lang.Throwable th) {
                            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                        throw th2;
                    }
                } catch (java.lang.Exception e) {
                    this.mProducerContext.getProducerListener().onProducerFinishWithFailure(this.mProducerContext, com.facebook.imagepipeline.producers.ResizeAndRotateProducer.PRODUCER_NAME, e, null);
                    if (isLast(i)) {
                        getConsumer().onFailure(e);
                    }
                    pooledByteBufferOutputStreamNewOutputStream.close();
                }
            } catch (java.lang.Throwable th3) {
                pooledByteBufferOutputStreamNewOutputStream.close();
                throw th3;
            }
        }

        @javax.annotation.Nullable
        private java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.image.EncodedImage encodedImage, @javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions, @javax.annotation.Nullable com.facebook.imagepipeline.transcoder.ImageTranscodeResult imageTranscodeResult, @javax.annotation.Nullable java.lang.String str) {
            java.lang.String str2;
            if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, com.facebook.imagepipeline.producers.ResizeAndRotateProducer.PRODUCER_NAME)) {
                return null;
            }
            java.lang.String str3 = encodedImage.getWidth() + com.taobao.weex.common.Constants.Name.X + encodedImage.getHeight();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + com.taobao.weex.common.Constants.Name.X + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.INPUT_IMAGE_FORMAT, java.lang.String.valueOf(encodedImage.getImageFormat()));
            map.put(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, str3);
            map.put(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.REQUESTED_SIZE_KEY, str2);
            map.put("queueTime", java.lang.String.valueOf(this.mJobScheduler.getQueuedTime()));
            map.put(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TRANSCODER_ID, str);
            map.put(com.facebook.imagepipeline.producers.ResizeAndRotateProducer.TRANSCODING_RESULT, java.lang.String.valueOf(imageTranscodeResult));
            return com.facebook.common.internal.ImmutableMap.copyOf((java.util.Map) map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.facebook.common.util.TriState shouldTransform(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.transcoder.ImageTranscoder imageTranscoder) {
        if (encodedImage == null || encodedImage.getImageFormat() == com.facebook.imageformat.ImageFormat.UNKNOWN) {
            return com.facebook.common.util.TriState.UNSET;
        }
        if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
            return com.facebook.common.util.TriState.NO;
        }
        return com.facebook.common.util.TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions()));
    }

    private static boolean shouldRotate(com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        if (rotationOptions.getDeferUntilRendered()) {
            return false;
        }
        return com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage);
    }

    private static boolean shouldRotateUsingExifOrientation(com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled() || rotationOptions.getDeferUntilRendered()) {
            encodedImage.setExifOrientation(0);
            return false;
        }
        return com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(java.lang.Integer.valueOf(encodedImage.getExifOrientation()));
    }
}
