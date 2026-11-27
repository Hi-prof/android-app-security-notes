package com.facebook.fresco.vito.source;

/* JADX INFO: compiled from: FirstAvailableImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/fresco/vito/source/FirstAvailableImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "imageSources", "", "<init>", "([Lcom/facebook/fresco/vito/source/ImageSource;)V", "getImageSources", "()[Lcom/facebook/fresco/vito/source/ImageSource;", "[Lcom/facebook/fresco/vito/source/ImageSource;", "equals", "", "other", "", "hashCode", "", "component1", "copy", "([Lcom/facebook/fresco/vito/source/ImageSource;)Lcom/facebook/fresco/vito/source/FirstAvailableImageSource;", "toString", "", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class FirstAvailableImageSource implements com.facebook.fresco.vito.source.ImageSource {
    private final com.facebook.fresco.vito.source.ImageSource[] imageSources;

    public static /* synthetic */ com.facebook.fresco.vito.source.FirstAvailableImageSource copy$default(com.facebook.fresco.vito.source.FirstAvailableImageSource firstAvailableImageSource, com.facebook.fresco.vito.source.ImageSource[] imageSourceArr, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            imageSourceArr = firstAvailableImageSource.imageSources;
        }
        return firstAvailableImageSource.copy(imageSourceArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final com.facebook.fresco.vito.source.ImageSource[] getImageSources() {
        return this.imageSources;
    }

    public final com.facebook.fresco.vito.source.FirstAvailableImageSource copy(com.facebook.fresco.vito.source.ImageSource[] imageSources) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new com.facebook.fresco.vito.source.FirstAvailableImageSource(imageSources);
    }

    public java.lang.String toString() {
        return "FirstAvailableImageSource(imageSources=" + java.util.Arrays.toString(this.imageSources) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    public FirstAvailableImageSource(com.facebook.fresco.vito.source.ImageSource[] imageSources) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        this.imageSources = imageSources;
    }

    public final com.facebook.fresco.vito.source.ImageSource[] getImageSources() {
        return this.imageSources;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        com.facebook.fresco.vito.source.ImageSource[] imageSourceArr = this.imageSources;
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.FirstAvailableImageSource");
        return java.util.Arrays.equals(imageSourceArr, ((com.facebook.fresco.vito.source.FirstAvailableImageSource) other).imageSources);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.imageSources);
    }
}
