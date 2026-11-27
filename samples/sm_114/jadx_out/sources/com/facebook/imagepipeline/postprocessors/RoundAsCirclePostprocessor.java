package com.facebook.imagepipeline.postprocessors;

/* JADX INFO: loaded from: classes.dex */
public class RoundAsCirclePostprocessor extends com.facebook.imagepipeline.request.BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor() {
        this(true);
    }

    public RoundAsCirclePostprocessor(boolean z) {
        this.mEnableAntiAliasing = z;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap bitmap) {
        com.facebook.imagepipeline.nativecode.NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new com.facebook.cache.common.SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new com.facebook.cache.common.SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }
}
