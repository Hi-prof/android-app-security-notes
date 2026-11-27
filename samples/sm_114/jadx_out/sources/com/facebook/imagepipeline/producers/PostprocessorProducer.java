package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class PostprocessorProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    public static final java.lang.String NAME = "PostprocessorProducer";
    static final java.lang.String POSTPROCESSOR = "Postprocessor";
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mBitmapFactory;
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> mInputProducer;

    public PostprocessorProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, java.util.concurrent.Executor executor) {
        this.mInputProducer = (com.facebook.imagepipeline.producers.Producer) com.facebook.common.internal.Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (java.util.concurrent.Executor) com.facebook.common.internal.Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.producers.PostprocessorProducer postprocessorProducer;
        com.facebook.imagepipeline.producers.ProducerContext producerContext2;
        com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> singleUsePostprocessorConsumer;
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        com.facebook.imagepipeline.request.Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        com.facebook.common.internal.Preconditions.checkNotNull(postprocessor);
        com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer postprocessorConsumer = new com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer(consumer, producerListener, postprocessor, producerContext);
        if (postprocessor instanceof com.facebook.imagepipeline.request.RepeatedPostprocessor) {
            producerContext2 = producerContext;
            singleUsePostprocessorConsumer = new com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer(postprocessorConsumer, (com.facebook.imagepipeline.request.RepeatedPostprocessor) postprocessor, producerContext2);
            postprocessorProducer = this;
        } else {
            postprocessorProducer = this;
            producerContext2 = producerContext;
            singleUsePostprocessorConsumer = new com.facebook.imagepipeline.producers.PostprocessorProducer.SingleUsePostprocessorConsumer(postprocessorConsumer);
        }
        postprocessorProducer.mInputProducer.produceResults(singleUsePostprocessorConsumer, producerContext2);
    }

    private class PostprocessorConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final com.facebook.imagepipeline.producers.ProducerListener2 mListener;
        private final com.facebook.imagepipeline.request.Postprocessor mPostprocessor;
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        @javax.annotation.Nullable
        private com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> mSourceImageRef;
        private int mStatus;

        public PostprocessorConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, com.facebook.imagepipeline.request.Postprocessor postprocessor, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            super(consumer);
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener2;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
            producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            if (!com.facebook.common.references.CloseableReference.isValid(closeableReference)) {
                if (isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                    return;
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(java.lang.Throwable th) {
            maybeNotifyOnFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        private void updateSourceImageRef(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference);
                this.mStatus = i;
                this.mIsDirty = true;
                boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference2);
                if (runningIfDirtyAndNotRunning) {
                    submitPostprocessing();
                }
            }
        }

        private void submitPostprocessing() {
            com.facebook.imagepipeline.producers.PostprocessorProducer.this.mExecutor.execute(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                @Override // java.lang.Runnable
                public void run() {
                    com.facebook.common.references.CloseableReference closeableReference;
                    int i;
                    synchronized (com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this) {
                        closeableReference = com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.mSourceImageRef;
                        i = com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.mStatus;
                        com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.mSourceImageRef = null;
                        com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (com.facebook.common.references.CloseableReference.isValid(closeableReference)) {
                        try {
                            com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
                        } catch (java.lang.Throwable th) {
                            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
                            throw th;
                        }
                    }
                    com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !com.facebook.common.references.CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.common.references.CloseableReference.isValid(closeableReference)));
            if (!shouldPostprocess(closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mProducerContext, com.facebook.imagepipeline.producers.PostprocessorProducer.NAME);
            try {
                try {
                    com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferencePostprocessInternal = postprocessInternal(closeableReference.get());
                    com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.mListener;
                    com.facebook.imagepipeline.producers.ProducerContext producerContext = this.mProducerContext;
                    producerListener2.onProducerFinishWithSuccess(producerContext, com.facebook.imagepipeline.producers.PostprocessorProducer.NAME, getExtraMap(producerListener2, producerContext, this.mPostprocessor));
                    maybeNotifyOnNewResult(closeableReferencePostprocessInternal, i);
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferencePostprocessInternal);
                } catch (java.lang.Exception e) {
                    com.facebook.imagepipeline.producers.ProducerListener2 producerListener3 = this.mListener;
                    com.facebook.imagepipeline.producers.ProducerContext producerContext2 = this.mProducerContext;
                    producerListener3.onProducerFinishWithFailure(producerContext2, com.facebook.imagepipeline.producers.PostprocessorProducer.NAME, e, getExtraMap(producerListener3, producerContext2, this.mPostprocessor));
                    maybeNotifyOnFailure(e);
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                }
            } catch (java.lang.Throwable th) {
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                throw th;
            }
        }

        @javax.annotation.Nullable
        private java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.imagepipeline.request.Postprocessor postprocessor) {
            if (producerListener2.requiresExtraMap(producerContext, com.facebook.imagepipeline.producers.PostprocessorProducer.NAME)) {
                return com.facebook.common.internal.ImmutableMap.of(com.facebook.imagepipeline.producers.PostprocessorProducer.POSTPROCESSOR, postprocessor.getName());
            }
            return null;
        }

        private boolean shouldPostprocess(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
            return closeableImage instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap;
        }

        private com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> postprocessInternal(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
            com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmap = (com.facebook.imagepipeline.image.CloseableStaticBitmap) closeableImage;
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceProcess = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), com.facebook.imagepipeline.producers.PostprocessorProducer.this.mBitmapFactory);
            try {
                com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(closeableReferenceProcess, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                closeableStaticBitmapOf.putExtras(closeableStaticBitmap.getExtras());
                return com.facebook.common.references.CloseableReference.of(closeableStaticBitmapOf);
            } finally {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceProcess);
            }
        }

        private void maybeNotifyOnNewResult(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            boolean zIsLast = isLast(i);
            if ((zIsLast || isClosed()) && !(zIsLast && close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }

        private void maybeNotifyOnFailure(java.lang.Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        private boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }

    class SingleUsePostprocessorConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private SingleUsePostprocessorConsumer(com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }

    class RepeatedPostprocessorConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> implements com.facebook.imagepipeline.request.RepeatedPostprocessorRunner {
        private boolean mIsClosed;

        @javax.annotation.Nullable
        private com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> mSourceImageRef;

        private RepeatedPostprocessorConsumer(com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer postprocessorConsumer, com.facebook.imagepipeline.request.RepeatedPostprocessor repeatedPostprocessor, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            super(postprocessorConsumer);
            this.mIsClosed = false;
            this.mSourceImageRef = null;
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.this.close()) {
                        com.facebook.imagepipeline.producers.PostprocessorProducer.RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            if (isNotLast(i)) {
                return;
            }
            setSourceImageRef(closeableReference);
            updateInternal();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(java.lang.Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            updateInternal();
        }

        private void updateInternal() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferenceCloneOrNull = com.facebook.common.references.CloseableReference.cloneOrNull(this.mSourceImageRef);
                try {
                    getConsumer().onNewResult(closeableReferenceCloneOrNull, 0);
                } finally {
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCloneOrNull);
                }
            }
        }

        private void setSourceImageRef(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
            synchronized (this) {
                if (this.mIsClosed) {
                    return;
                }
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference2 = this.mSourceImageRef;
                this.mSourceImageRef = com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference);
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean close() {
            synchronized (this) {
                if (this.mIsClosed) {
                    return false;
                }
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = this.mSourceImageRef;
                this.mSourceImageRef = null;
                this.mIsClosed = true;
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }
    }
}
