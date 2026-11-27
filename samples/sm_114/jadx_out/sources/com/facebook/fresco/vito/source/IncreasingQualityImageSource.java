package com.facebook.fresco.vito.source;

/* JADX INFO: compiled from: IncreasingQualityImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0001HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/facebook/fresco/vito/source/IncreasingQualityImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "lowResSource", "highResSource", "extras", "", "", "", "<init>", "(Lcom/facebook/fresco/vito/source/ImageSource;Lcom/facebook/fresco/vito/source/ImageSource;Ljava/util/Map;)V", "getLowResSource", "()Lcom/facebook/fresco/vito/source/ImageSource;", "getHighResSource", "getExtras", "()Ljava/util/Map;", "getExtra", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "getStringExtra", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class IncreasingQualityImageSource implements com.facebook.fresco.vito.source.ImageSource {
    private final java.util.Map<java.lang.String, java.lang.Object> extras;
    private final com.facebook.fresco.vito.source.ImageSource highResSource;
    private final com.facebook.fresco.vito.source.ImageSource lowResSource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.facebook.fresco.vito.source.IncreasingQualityImageSource copy$default(com.facebook.fresco.vito.source.IncreasingQualityImageSource increasingQualityImageSource, com.facebook.fresco.vito.source.ImageSource imageSource, com.facebook.fresco.vito.source.ImageSource imageSource2, java.util.Map map, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            imageSource = increasingQualityImageSource.lowResSource;
        }
        if ((i & 2) != 0) {
            imageSource2 = increasingQualityImageSource.highResSource;
        }
        if ((i & 4) != 0) {
            map = increasingQualityImageSource.extras;
        }
        return increasingQualityImageSource.copy(imageSource, imageSource2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final com.facebook.fresco.vito.source.ImageSource getLowResSource() {
        return this.lowResSource;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final com.facebook.fresco.vito.source.ImageSource getHighResSource() {
        return this.highResSource;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> component3() {
        return this.extras;
    }

    public final com.facebook.fresco.vito.source.IncreasingQualityImageSource copy(com.facebook.fresco.vito.source.ImageSource lowResSource, com.facebook.fresco.vito.source.ImageSource highResSource, java.util.Map<java.lang.String, ? extends java.lang.Object> extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowResSource, "lowResSource");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(highResSource, "highResSource");
        return new com.facebook.fresco.vito.source.IncreasingQualityImageSource(lowResSource, highResSource, extras);
    }

    public java.lang.String toString() {
        return "IncreasingQualityImageSource(lowResSource=" + this.lowResSource + ", highResSource=" + this.highResSource + ", extras=" + this.extras + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    public IncreasingQualityImageSource(com.facebook.fresco.vito.source.ImageSource lowResSource, com.facebook.fresco.vito.source.ImageSource highResSource, java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowResSource, "lowResSource");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(highResSource, "highResSource");
        this.lowResSource = lowResSource;
        this.highResSource = highResSource;
        this.extras = map;
    }

    public /* synthetic */ IncreasingQualityImageSource(com.facebook.fresco.vito.source.ImageSource imageSource, com.facebook.fresco.vito.source.ImageSource imageSource2, java.util.Map map, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, imageSource2, (i & 4) != 0 ? null : map);
    }

    public final com.facebook.fresco.vito.source.ImageSource getLowResSource() {
        return this.lowResSource;
    }

    public final com.facebook.fresco.vito.source.ImageSource getHighResSource() {
        return this.highResSource;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.extras;
    }

    public final java.lang.Object getExtra(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.util.Map<java.lang.String, java.lang.Object> map = this.extras;
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public final java.lang.String getStringExtra(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object extra = getExtra(key);
        if (extra instanceof java.lang.String) {
            return (java.lang.String) extra;
        }
        return null;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.IncreasingQualityImageSource");
        com.facebook.fresco.vito.source.IncreasingQualityImageSource increasingQualityImageSource = (com.facebook.fresco.vito.source.IncreasingQualityImageSource) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.lowResSource, increasingQualityImageSource.lowResSource) && kotlin.jvm.internal.Intrinsics.areEqual(this.highResSource, increasingQualityImageSource.highResSource) && kotlin.jvm.internal.Intrinsics.areEqual(this.extras, increasingQualityImageSource.extras);
    }

    public int hashCode() {
        int iHashCode = ((this.lowResSource.hashCode() * 31) + this.highResSource.hashCode()) * 31;
        java.util.Map<java.lang.String, java.lang.Object> map = this.extras;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }
}
