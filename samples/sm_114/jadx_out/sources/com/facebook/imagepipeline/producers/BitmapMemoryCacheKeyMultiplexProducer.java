package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends com.facebook.imagepipeline.producers.MultiplexProducer<android.util.Pair<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.request.ImageRequest.RequestLevel>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;

    public BitmapMemoryCacheKeyMultiplexProducer(com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer producer) {
        super(producer, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public android.util.Pair<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.request.ImageRequest.RequestLevel> getKey(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return android.util.Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> cloneOrNull(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        return com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference);
    }
}
