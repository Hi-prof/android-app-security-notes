package com.facebook.imagepipeline.postprocessors;

/* JADX INFO: compiled from: RoundPostprocessor.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/postprocessors/RoundPostprocessor;", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "enableAntiAliasing", "", "<init>", "(Z)V", "cacheKey", "Lcom/facebook/cache/common/CacheKey;", "getPostprocessorCacheKey", "process", "", "destBitmap", "Landroid/graphics/Bitmap;", "sourceBitmap", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoundPostprocessor extends com.facebook.imagepipeline.request.BasePostprocessor {
    private final com.facebook.cache.common.CacheKey cacheKey;
    private final boolean enableAntiAliasing;

    public RoundPostprocessor() {
        this(false, 1, null);
    }

    public /* synthetic */ RoundPostprocessor(boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public RoundPostprocessor(boolean z) {
        this.enableAntiAliasing = z;
        this.cacheKey = new com.facebook.cache.common.SimpleCacheKey("XferRoundFilter");
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    /* JADX INFO: renamed from: getPostprocessorCacheKey, reason: from getter */
    public com.facebook.cache.common.CacheKey getCacheKey() {
        return this.cacheKey;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(android.graphics.Bitmap destBitmap, android.graphics.Bitmap sourceBitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destBitmap, "destBitmap");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        com.facebook.imagepipeline.filter.XferRoundFilter.xferRoundBitmap(destBitmap, sourceBitmap, this.enableAntiAliasing);
    }
}
