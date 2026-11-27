package com.facebook.imagepipeline.postprocessors;

/* JADX INFO: compiled from: BlurPostProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/imagepipeline/postprocessors/BlurPostProcessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "blurRadius", "", "context", "Landroid/content/Context;", "iterations", "<init>", "(ILandroid/content/Context;I)V", "getBlurRadius", "()I", "getContext", "()Landroid/content/Context;", "getIterations", "cacheKey", "Lcom/facebook/cache/common/CacheKey;", "getPostprocessorCacheKey", "process", "", "destBitmap", "Landroid/graphics/Bitmap;", "sourceBitmap", "bitmap", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlurPostProcessor extends com.facebook.imagepipeline.request.BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private final int blurRadius;
    private final com.facebook.cache.common.CacheKey cacheKey;
    private final android.content.Context context;
    private final int iterations;
    private static final boolean canUseRenderScript = com.facebook.imagepipeline.filter.RenderScriptBlurFilter.canUseRenderScript();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurPostProcessor(int i, android.content.Context context) {
        this(i, context, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BlurPostProcessor(int i, android.content.Context context, int i2, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, context, (i3 & 4) != 0 ? 3 : i2);
    }

    public final int getBlurRadius() {
        return this.blurRadius;
    }

    public final android.content.Context getContext() {
        return this.context;
    }

    public final int getIterations() {
        return this.iterations;
    }

    public BlurPostProcessor(int i, android.content.Context context, int i2) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.blurRadius = i;
        this.context = context;
        this.iterations = i2;
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0 && i <= 25));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > 0));
        if (canUseRenderScript) {
            kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
            str = java.lang.String.format(null, "IntrinsicBlur;%d", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Integer.valueOf(i)}, 1));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        } else {
            kotlin.jvm.internal.StringCompanionObject stringCompanionObject2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
            str = java.lang.String.format(null, "IterativeBoxBlur;%d;%d", java.util.Arrays.copyOf(new java.lang.Object[]{java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i)}, 2));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        this.cacheKey = new com.facebook.cache.common.SimpleCacheKey(str);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    /* JADX INFO: renamed from: getPostprocessorCacheKey, reason: from getter */
    public com.facebook.cache.common.CacheKey getCacheKey() {
        return this.cacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap destBitmap, android.graphics.Bitmap sourceBitmap) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destBitmap, "destBitmap");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        if (canUseRenderScript) {
            com.facebook.imagepipeline.filter.RenderScriptBlurFilter.blurBitmap(destBitmap, sourceBitmap, this.context, this.blurRadius);
        } else {
            super.process(destBitmap, sourceBitmap);
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        com.facebook.imagepipeline.filter.IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.iterations, this.blurRadius);
    }
}
