package com.facebook.imagepipeline.postprocessors;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersPostprocessor extends com.facebook.imagepipeline.request.BasePostprocessor {

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheKey mCacheKey;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap bitmap) {
        int iMin = java.lang.Math.min(bitmap.getHeight(), bitmap.getWidth());
        com.facebook.imagepipeline.nativecode.NativeRoundingFilter.addRoundedCorners(bitmap, iMin / 2, iMin / 3, iMin / 4, iMin / 5);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new com.facebook.cache.common.SimpleCacheKey("RoundedCornersPostprocessor");
        }
        return this.mCacheKey;
    }
}
