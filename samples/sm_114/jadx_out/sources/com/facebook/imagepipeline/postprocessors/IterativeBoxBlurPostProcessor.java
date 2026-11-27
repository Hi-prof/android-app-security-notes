package com.facebook.imagepipeline.postprocessors;

/* JADX INFO: loaded from: classes.dex */
public class IterativeBoxBlurPostProcessor extends com.facebook.imagepipeline.request.BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int mBlurRadius;

    @javax.annotation.Nullable
    private com.facebook.cache.common.CacheKey mCacheKey;
    private final int mIterations;

    public IterativeBoxBlurPostProcessor(int i) {
        this(3, i);
    }

    public IterativeBoxBlurPostProcessor(int i, int i2) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > 0));
        this.mIterations = i;
        this.mBlurRadius = i2;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap bitmap) {
        com.facebook.imagepipeline.nativecode.NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new com.facebook.cache.common.SimpleCacheKey(java.lang.String.format(null, "i%dr%d", java.lang.Integer.valueOf(this.mIterations), java.lang.Integer.valueOf(this.mBlurRadius)));
        }
        return this.mCacheKey;
    }
}
