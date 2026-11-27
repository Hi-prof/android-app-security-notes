package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocalFetchProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    @javax.annotation.Nullable
    protected abstract com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException;

    protected abstract java.lang.String getProducerName();

    protected LocalFetchProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, final com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        final com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "fetch");
        final com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.imagepipeline.image.EncodedImage> statefulProducerRunnable = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.imagepipeline.image.EncodedImage>(consumer, producerListener, producerContext, getProducerName()) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @javax.annotation.Nullable
            public com.facebook.imagepipeline.image.EncodedImage getResult() throws java.lang.Exception {
                com.facebook.imagepipeline.image.EncodedImage encodedImage = com.facebook.imagepipeline.producers.LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalFetchProducer.this.getProducerName(), false);
                    producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "fetch");
                    return null;
                }
                encodedImage.parseMetaData();
                producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalFetchProducer.this.getProducerName(), true);
                producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "fetch");
                producerContext.putExtra("image_color_space", encodedImage.getColorSpace());
                return encodedImage;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
            }
        };
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    protected com.facebook.imagepipeline.image.EncodedImage getByteBufferBackedEncodedImage(java.io.InputStream inputStream, int i) throws java.io.IOException {
        com.facebook.common.references.CloseableReference closeableReferenceOf;
        com.facebook.common.references.CloseableReference closeableReference = null;
        try {
            if (i <= 0) {
                closeableReferenceOf = com.facebook.common.references.CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } else {
                closeableReferenceOf = com.facebook.common.references.CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i));
            }
            closeableReference = closeableReferenceOf;
            com.facebook.imagepipeline.image.EncodedImage encodedImage = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReference);
            com.facebook.common.internal.Closeables.closeQuietly(inputStream);
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
            return encodedImage;
        } catch (java.lang.Throwable th) {
            com.facebook.common.internal.Closeables.closeQuietly(inputStream);
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
            throw th;
        }
    }

    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(java.io.InputStream inputStream, int i) throws java.io.IOException {
        return getByteBufferBackedEncodedImage(inputStream, i);
    }
}
