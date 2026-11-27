package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class DefaultCacheKeyFactory implements com.facebook.imagepipeline.cache.CacheKeyFactory {

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.cache.DefaultCacheKeyFactory sInstance;

    protected android.net.Uri getCacheKeySourceUri(android.net.Uri uri) {
        return uri;
    }

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized com.facebook.imagepipeline.cache.DefaultCacheKeyFactory getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.imagepipeline.cache.DefaultCacheKeyFactory();
        }
        return sInstance;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public com.facebook.cache.common.CacheKey getBitmapCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.imagepipeline.cache.BitmapMemoryCacheKey bitmapMemoryCacheKey = new com.facebook.imagepipeline.cache.BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null);
        bitmapMemoryCacheKey.setCallerContext(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public com.facebook.cache.common.CacheKey getPostprocessedBitmapCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.cache.common.CacheKey cacheKey;
        java.lang.String name;
        com.facebook.imagepipeline.request.Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            com.facebook.cache.common.CacheKey cacheKey2 = postprocessor.getCacheKey();
            name = postprocessor.getClass().getName();
            cacheKey = cacheKey2;
        } else {
            cacheKey = null;
            name = null;
        }
        com.facebook.imagepipeline.cache.BitmapMemoryCacheKey bitmapMemoryCacheKey = new com.facebook.imagepipeline.cache.BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, name);
        bitmapMemoryCacheKey.setCallerContext(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public com.facebook.cache.common.CacheKey getEncodedCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj) {
        return getEncodedCacheKey(imageRequest, imageRequest.getSourceUri(), obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public com.facebook.cache.common.CacheKey getEncodedCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, android.net.Uri uri, @javax.annotation.Nullable java.lang.Object obj) {
        return new com.facebook.cache.common.SimpleCacheKey(getCacheKeySourceUri(uri).toString());
    }
}
