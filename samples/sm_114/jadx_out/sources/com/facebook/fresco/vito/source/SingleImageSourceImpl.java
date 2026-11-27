package com.facebook.fresco.vito.source;

/* JADX INFO: compiled from: SingleImageSourceImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0006J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0016\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/facebook/fresco/vito/source/SingleImageSourceImpl;", "Lcom/facebook/fresco/vito/source/SingleImageSource;", "uri", "Landroid/net/Uri;", "extras", "", "", "", "<init>", "(Landroid/net/Uri;Ljava/util/Map;)V", "getUri", "()Landroid/net/Uri;", "getExtras", "()Ljava/util/Map;", "getExtra", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "getStringExtra", "equals", "", "other", "hashCode", "", "imageUri", "getImageUri", "component1", "component2", "copy", "toString", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class SingleImageSourceImpl implements com.facebook.fresco.vito.source.SingleImageSource {
    private final java.util.Map<java.lang.String, java.lang.Object> extras;
    private final android.net.Uri imageUri;
    private final android.net.Uri uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.facebook.fresco.vito.source.SingleImageSourceImpl copy$default(com.facebook.fresco.vito.source.SingleImageSourceImpl singleImageSourceImpl, android.net.Uri uri, java.util.Map map, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            uri = singleImageSourceImpl.uri;
        }
        if ((i & 2) != 0) {
            map = singleImageSourceImpl.extras;
        }
        return singleImageSourceImpl.copy(uri, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final android.net.Uri getUri() {
        return this.uri;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> component2() {
        return this.extras;
    }

    public final com.facebook.fresco.vito.source.SingleImageSourceImpl copy(android.net.Uri uri, java.util.Map<java.lang.String, ? extends java.lang.Object> extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        return new com.facebook.fresco.vito.source.SingleImageSourceImpl(uri, extras);
    }

    public java.lang.String toString() {
        return "SingleImageSourceImpl(uri=" + this.uri + ", extras=" + this.extras + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    public SingleImageSourceImpl(android.net.Uri uri, java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.extras = map;
        this.imageUri = getUri();
    }

    public /* synthetic */ SingleImageSourceImpl(android.net.Uri uri, java.util.Map map, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : map);
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public android.net.Uri getUri() {
        return this.uri;
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.extras;
    }

    public final java.lang.Object getExtra(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.util.Map<java.lang.String, java.lang.Object> extras = getExtras();
        if (extras != null) {
            return extras.get(key);
        }
        return null;
    }

    @Override // com.facebook.fresco.vito.source.SingleImageSource
    public java.lang.String getStringExtra(java.lang.String key) {
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
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.fresco.vito.source.SingleImageSourceImpl");
        com.facebook.fresco.vito.source.SingleImageSourceImpl singleImageSourceImpl = (com.facebook.fresco.vito.source.SingleImageSourceImpl) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(getImageUri(), singleImageSourceImpl.getImageUri()) && kotlin.jvm.internal.Intrinsics.areEqual(getExtras(), singleImageSourceImpl.getExtras());
    }

    public int hashCode() {
        int iHashCode = getImageUri().hashCode() * 31;
        java.util.Map<java.lang.String, java.lang.Object> extras = getExtras();
        return iHashCode + (extras != null ? extras.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.source.UriImageSource
    public android.net.Uri getImageUri() {
        return this.imageUri;
    }
}
