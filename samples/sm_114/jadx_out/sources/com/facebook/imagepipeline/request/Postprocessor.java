package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes.dex */
public interface Postprocessor {
    java.lang.String getName();

    @javax.annotation.Nullable
    com.facebook.cache.common.CacheKey getPostprocessorCacheKey();

    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> process(android.graphics.Bitmap bitmap, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory);
}
