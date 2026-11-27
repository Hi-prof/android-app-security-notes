package com.facebook.fresco.vito.source;

/* JADX INFO: compiled from: ImageSourceProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0007J*\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H\u0007J*\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H\u0007J!\u0010\u0013\u001a\u00020\r2\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\rH\u0007¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0007J0\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H\u0007J\u001c\u0010\u0017\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/facebook/fresco/vito/source/ImageSourceProvider;", "", "<init>", "()V", "uriParser", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "getUriParser", "()Lkotlin/jvm/functions/Function1;", "setUriParser", "(Lkotlin/jvm/functions/Function1;)V", "emptySource", "Lcom/facebook/fresco/vito/source/ImageSource;", "forUri", "uri", "extras", "", "uriString", "firstAvailable", "imageSources", "", "([Lcom/facebook/fresco/vito/source/ImageSource;)Lcom/facebook/fresco/vito/source/ImageSource;", "increasingQuality", "lowResImageSource", "highResImageSource", "lowResImageUri", "highResImageUri", "bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "source_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageSourceProvider {
    public static final com.facebook.fresco.vito.source.ImageSourceProvider INSTANCE = new com.facebook.fresco.vito.source.ImageSourceProvider();
    private static kotlin.jvm.functions.Function1<? super java.lang.String, ? extends android.net.Uri> uriParser = new kotlin.jvm.functions.Function1() { // from class: com.facebook.fresco.vito.source.ImageSourceProvider$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return com.facebook.fresco.vito.source.ImageSourceProvider.uriParser$lambda$0((java.lang.String) obj);
        }
    };

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource forUri(android.net.Uri uri) {
        return forUri$default(uri, (java.util.Map) null, 2, (java.lang.Object) null);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource forUri(java.lang.String str) {
        return forUri$default(str, (java.util.Map) null, 2, (java.lang.Object) null);
    }

    private ImageSourceProvider() {
    }

    public final kotlin.jvm.functions.Function1<java.lang.String, android.net.Uri> getUriParser() {
        return uriParser;
    }

    public final void setUriParser(kotlin.jvm.functions.Function1<? super java.lang.String, ? extends android.net.Uri> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "<set-?>");
        uriParser = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.net.Uri uriParser$lambda$0(java.lang.String it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        android.net.Uri uri = android.net.Uri.parse(it);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource emptySource() {
        return com.facebook.fresco.vito.source.EmptyImageSource.INSTANCE;
    }

    public static /* synthetic */ com.facebook.fresco.vito.source.ImageSource forUri$default(android.net.Uri uri, java.util.Map map, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(uri, (java.util.Map<java.lang.String, ? extends java.lang.Object>) map);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource forUri(android.net.Uri uri, java.util.Map<java.lang.String, ? extends java.lang.Object> extras) {
        if (uri == null) {
            return emptySource();
        }
        java.util.Map mapCreateMapBuilder = kotlin.collections.MapsKt.createMapBuilder();
        if (extras != null) {
            mapCreateMapBuilder.putAll(extras);
        }
        mapCreateMapBuilder.put("uri_source", uri);
        return new com.facebook.fresco.vito.source.SingleImageSourceImpl(uri, kotlin.collections.MapsKt.build(mapCreateMapBuilder));
    }

    public static /* synthetic */ com.facebook.fresco.vito.source.ImageSource forUri$default(java.lang.String str, java.util.Map map, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return forUri(str, (java.util.Map<java.lang.String, ? extends java.lang.Object>) map);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource forUri(java.lang.String uriString, java.util.Map<java.lang.String, ? extends java.lang.Object> extras) {
        return forUri(uriString != null ? uriParser.invoke(uriString) : null, extras);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource firstAvailable(com.facebook.fresco.vito.source.ImageSource... imageSources) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageSources, "imageSources");
        return new com.facebook.fresco.vito.source.FirstAvailableImageSource(imageSources);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource increasingQuality(com.facebook.fresco.vito.source.ImageSource lowResImageSource, com.facebook.fresco.vito.source.ImageSource highResImageSource) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new com.facebook.fresco.vito.source.IncreasingQualityImageSource(lowResImageSource, highResImageSource, null);
    }

    public static /* synthetic */ com.facebook.fresco.vito.source.ImageSource increasingQuality$default(com.facebook.fresco.vito.source.ImageSource imageSource, com.facebook.fresco.vito.source.ImageSource imageSource2, java.util.Map map, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return increasingQuality(imageSource, imageSource2, map);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource increasingQuality(com.facebook.fresco.vito.source.ImageSource lowResImageSource, com.facebook.fresco.vito.source.ImageSource highResImageSource, java.util.Map<java.lang.String, ? extends java.lang.Object> extras) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowResImageSource, "lowResImageSource");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(highResImageSource, "highResImageSource");
        return new com.facebook.fresco.vito.source.IncreasingQualityImageSource(lowResImageSource, highResImageSource, extras);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource increasingQuality(android.net.Uri lowResImageUri, android.net.Uri highResImageUri) {
        if (lowResImageUri == null) {
            return forUri$default(highResImageUri, (java.util.Map) null, 2, (java.lang.Object) null);
        }
        return new com.facebook.fresco.vito.source.IncreasingQualityImageSource(forUri$default(lowResImageUri, (java.util.Map) null, 2, (java.lang.Object) null), forUri$default(highResImageUri, (java.util.Map) null, 2, (java.lang.Object) null), null, 4, null);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource bitmap(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new com.facebook.fresco.vito.source.BitmapImageSource(bitmap);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.fresco.vito.source.ImageSource drawable(android.graphics.drawable.Drawable drawable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new com.facebook.fresco.vito.source.DrawableImageSource(drawable);
    }
}
