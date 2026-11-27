package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class EncodedCacheKeyMultiplexProducer extends com.facebook.imagepipeline.producers.MultiplexProducer<android.util.Pair<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.request.ImageRequest.RequestLevel>, com.facebook.imagepipeline.image.EncodedImage> {
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;

    public EncodedCacheKeyMultiplexProducer(com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, boolean z, com.facebook.imagepipeline.producers.Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public android.util.Pair<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.request.ImageRequest.RequestLevel> getKey(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return android.util.Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.EncodedImage cloneOrNull(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        return com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage);
    }
}
