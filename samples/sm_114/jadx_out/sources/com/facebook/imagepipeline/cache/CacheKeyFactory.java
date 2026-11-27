package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public interface CacheKeyFactory {
    com.facebook.cache.common.CacheKey getBitmapCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj);

    com.facebook.cache.common.CacheKey getEncodedCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, android.net.Uri uri, @javax.annotation.Nullable java.lang.Object obj);

    com.facebook.cache.common.CacheKey getEncodedCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj);

    com.facebook.cache.common.CacheKey getPostprocessedBitmapCacheKey(com.facebook.imagepipeline.request.ImageRequest imageRequest, @javax.annotation.Nullable java.lang.Object obj);
}
