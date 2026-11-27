package com.facebook.imagepipeline.cache;

/* JADX INFO: compiled from: BitmapMemoryCacheKey.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0013\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheKey;", "Lcom/facebook/cache/common/CacheKey;", "sourceString", "", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "rotationOptions", "Lcom/facebook/imagepipeline/common/RotationOptions;", "imageDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "postprocessorCacheKey", "postprocessorName", "<init>", "(Ljava/lang/String;Lcom/facebook/imagepipeline/common/ResizeOptions;Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/common/ImageDecodeOptions;Lcom/facebook/cache/common/CacheKey;Ljava/lang/String;)V", "getSourceString", "()Ljava/lang/String;", "getResizeOptions", "()Lcom/facebook/imagepipeline/common/ResizeOptions;", "getRotationOptions", "()Lcom/facebook/imagepipeline/common/RotationOptions;", "getImageDecodeOptions", "()Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "getPostprocessorCacheKey", "()Lcom/facebook/cache/common/CacheKey;", "getPostprocessorName", "callerContext", "", "getCallerContext", "()Ljava/lang/Object;", "setCallerContext", "(Ljava/lang/Object;)V", "hash", "", "inBitmapCacheSince", "", "getInBitmapCacheSince", "()J", "hashCode", "containsUri", "", "uri", "Landroid/net/Uri;", "getUriString", "isResourceIdForDebugging", "equals", "other", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "toString", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BitmapMemoryCacheKey implements com.facebook.cache.common.CacheKey {
    private java.lang.Object callerContext;
    private final int hash;
    private final com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions;
    private final long inBitmapCacheSince;
    private final com.facebook.cache.common.CacheKey postprocessorCacheKey;
    private final java.lang.String postprocessorName;
    private final com.facebook.imagepipeline.common.ResizeOptions resizeOptions;
    private final com.facebook.imagepipeline.common.RotationOptions rotationOptions;
    private final java.lang.String sourceString;

    public static /* synthetic */ com.facebook.imagepipeline.cache.BitmapMemoryCacheKey copy$default(com.facebook.imagepipeline.cache.BitmapMemoryCacheKey bitmapMemoryCacheKey, java.lang.String str, com.facebook.imagepipeline.common.ResizeOptions resizeOptions, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, com.facebook.cache.common.CacheKey cacheKey, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = bitmapMemoryCacheKey.sourceString;
        }
        if ((i & 2) != 0) {
            resizeOptions = bitmapMemoryCacheKey.resizeOptions;
        }
        if ((i & 4) != 0) {
            rotationOptions = bitmapMemoryCacheKey.rotationOptions;
        }
        if ((i & 8) != 0) {
            imageDecodeOptions = bitmapMemoryCacheKey.imageDecodeOptions;
        }
        if ((i & 16) != 0) {
            cacheKey = bitmapMemoryCacheKey.postprocessorCacheKey;
        }
        if ((i & 32) != 0) {
            str2 = bitmapMemoryCacheKey.postprocessorName;
        }
        com.facebook.cache.common.CacheKey cacheKey2 = cacheKey;
        java.lang.String str3 = str2;
        return bitmapMemoryCacheKey.copy(str, resizeOptions, rotationOptions, imageDecodeOptions, cacheKey2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final java.lang.String getSourceString() {
        return this.sourceString;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
        return this.resizeOptions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
        return this.rotationOptions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
        return this.imageDecodeOptions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        return this.postprocessorCacheKey;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final java.lang.String getPostprocessorName() {
        return this.postprocessorName;
    }

    public final com.facebook.imagepipeline.cache.BitmapMemoryCacheKey copy(java.lang.String sourceString, com.facebook.imagepipeline.common.ResizeOptions resizeOptions, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, com.facebook.cache.common.CacheKey postprocessorCacheKey, java.lang.String postprocessorName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        return new com.facebook.imagepipeline.cache.BitmapMemoryCacheKey(sourceString, resizeOptions, rotationOptions, imageDecodeOptions, postprocessorCacheKey, postprocessorName);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public java.lang.String toString() {
        return "BitmapMemoryCacheKey(sourceString=" + this.sourceString + ", resizeOptions=" + this.resizeOptions + ", rotationOptions=" + this.rotationOptions + ", imageDecodeOptions=" + this.imageDecodeOptions + ", postprocessorCacheKey=" + this.postprocessorCacheKey + ", postprocessorName=" + this.postprocessorName + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    public BitmapMemoryCacheKey(java.lang.String sourceString, com.facebook.imagepipeline.common.ResizeOptions resizeOptions, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, com.facebook.cache.common.CacheKey cacheKey, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        this.sourceString = sourceString;
        this.resizeOptions = resizeOptions;
        this.rotationOptions = rotationOptions;
        this.imageDecodeOptions = imageDecodeOptions;
        this.postprocessorCacheKey = cacheKey;
        this.postprocessorName = str;
        int iHashCode = this.sourceString.hashCode() * 31;
        com.facebook.imagepipeline.common.ResizeOptions resizeOptions2 = this.resizeOptions;
        int iHashCode2 = (((((iHashCode + (resizeOptions2 != null ? resizeOptions2.hashCode() : 0)) * 31) + this.rotationOptions.hashCode()) * 31) + this.imageDecodeOptions.hashCode()) * 31;
        com.facebook.cache.common.CacheKey cacheKey2 = this.postprocessorCacheKey;
        int iHashCode3 = (iHashCode2 + (cacheKey2 != null ? cacheKey2.hashCode() : 0)) * 31;
        java.lang.String str2 = this.postprocessorName;
        this.hash = iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        this.inBitmapCacheSince = com.facebook.common.time.RealtimeSinceBootClock.get().now();
    }

    public final java.lang.String getSourceString() {
        return this.sourceString;
    }

    public final com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
        return this.resizeOptions;
    }

    public final com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
        return this.rotationOptions;
    }

    public final com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
        return this.imageDecodeOptions;
    }

    public final com.facebook.cache.common.CacheKey getPostprocessorCacheKey() {
        return this.postprocessorCacheKey;
    }

    public final java.lang.String getPostprocessorName() {
        return this.postprocessorName;
    }

    public final java.lang.Object getCallerContext() {
        return this.callerContext;
    }

    public final void setCallerContext(java.lang.Object obj) {
        this.callerContext = obj;
    }

    public final long getInBitmapCacheSince() {
        return this.inBitmapCacheSince;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getHash() {
        return this.hash;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        java.lang.String animationUriString = getAnimationUriString();
        java.lang.String string = uri.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) animationUriString, (java.lang.CharSequence) string, false, 2, (java.lang.Object) null);
    }

    @Override // com.facebook.cache.common.CacheKey
    /* JADX INFO: renamed from: getUriString */
    public java.lang.String getAnimationUriString() {
        return this.sourceString;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.imagepipeline.cache.BitmapMemoryCacheKey");
        com.facebook.imagepipeline.cache.BitmapMemoryCacheKey bitmapMemoryCacheKey = (com.facebook.imagepipeline.cache.BitmapMemoryCacheKey) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.sourceString, bitmapMemoryCacheKey.sourceString) && kotlin.jvm.internal.Intrinsics.areEqual(this.resizeOptions, bitmapMemoryCacheKey.resizeOptions) && kotlin.jvm.internal.Intrinsics.areEqual(this.rotationOptions, bitmapMemoryCacheKey.rotationOptions) && kotlin.jvm.internal.Intrinsics.areEqual(this.imageDecodeOptions, bitmapMemoryCacheKey.imageDecodeOptions) && kotlin.jvm.internal.Intrinsics.areEqual(this.postprocessorCacheKey, bitmapMemoryCacheKey.postprocessorCacheKey) && kotlin.jvm.internal.Intrinsics.areEqual(this.postprocessorName, bitmapMemoryCacheKey.postprocessorName);
    }
}
