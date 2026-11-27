package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class CustomProducerSequenceFactory {
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getCustomDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.core.ProducerSequenceFactory producerSequenceFactory) {
        return null;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> getCustomEncodedImageSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.core.ProducerSequenceFactory producerSequenceFactory, com.facebook.imagepipeline.core.ProducerFactory producerFactory, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        return null;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getCustomDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.core.ProducerSequenceFactory producerSequenceFactory, com.facebook.imagepipeline.core.ProducerFactory producerFactory, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z, boolean z2) {
        return getCustomDecodedImageSequence(imageRequest, producerSequenceFactory);
    }
}
