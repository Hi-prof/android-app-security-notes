package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BitmapPrepareProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    public static final java.lang.String PRODUCER_NAME = "BitmapPrepareProducer";
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> mInputProducer;
    private final int mMaxBitmapSizeBytes;
    private final int mMinBitmapSizeBytes;
    private final boolean mPreparePrefetch;

    public BitmapPrepareProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer, int i, int i2, boolean z) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i <= i2));
        this.mInputProducer = (com.facebook.imagepipeline.producers.Producer) com.facebook.common.internal.Preconditions.checkNotNull(producer);
        this.mMinBitmapSizeBytes = i;
        this.mMaxBitmapSizeBytes = i2;
        this.mPreparePrefetch = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        if (producerContext.isPrefetch() && !this.mPreparePrefetch) {
            this.mInputProducer.produceResults(consumer, producerContext);
        } else {
            this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.BitmapPrepareProducer.BitmapPrepareConsumer(consumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), producerContext);
        }
    }

    private static class BitmapPrepareConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private final int mMaxBitmapSizeBytes;
        private final int mMinBitmapSizeBytes;

        BitmapPrepareConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, int i, int i2) {
            super(consumer);
            this.mMinBitmapSizeBytes = i;
            this.mMaxBitmapSizeBytes = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            internalPrepareBitmap(closeableReference);
            getConsumer().onNewResult(closeableReference, i);
        }

        private void internalPrepareBitmap(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
            com.facebook.imagepipeline.image.CloseableImage closeableImage;
            android.graphics.Bitmap underlyingBitmap;
            int rowBytes;
            if (closeableReference == null || !closeableReference.isValid() || (closeableImage = closeableReference.get()) == null || closeableImage.isClosed() || !(closeableImage instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap) || (underlyingBitmap = ((com.facebook.imagepipeline.image.CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) == null || (rowBytes = underlyingBitmap.getRowBytes() * underlyingBitmap.getHeight()) < this.mMinBitmapSizeBytes || rowBytes > this.mMaxBitmapSizeBytes) {
                return;
            }
            underlyingBitmap.prepareToDraw();
        }
    }
}
