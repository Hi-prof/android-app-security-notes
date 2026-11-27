package com.facebook.imageformat;

/* JADX INFO: compiled from: DefaultImageFormats.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/imageformat/DefaultImageFormats;", "", "<init>", "()V", "JPEG", "Lcom/facebook/imageformat/ImageFormat;", "PNG", "GIF", "BMP", "ICO", "WEBP_SIMPLE", "WEBP_LOSSLESS", "WEBP_EXTENDED", "WEBP_EXTENDED_WITH_ALPHA", "WEBP_ANIMATED", "HEIF", "DNG", "isWebpFormat", "", "imageFormat", "isStaticWebpFormat", "defaultFormats", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultImageFormats {
    public static final com.facebook.imageformat.ImageFormat BMP;
    public static final com.facebook.imageformat.ImageFormat DNG;
    public static final com.facebook.imageformat.ImageFormat GIF;
    public static final com.facebook.imageformat.ImageFormat HEIF;
    public static final com.facebook.imageformat.ImageFormat ICO;
    public static final com.facebook.imageformat.DefaultImageFormats INSTANCE = new com.facebook.imageformat.DefaultImageFormats();
    public static final com.facebook.imageformat.ImageFormat JPEG;
    public static final com.facebook.imageformat.ImageFormat PNG;
    public static final com.facebook.imageformat.ImageFormat WEBP_ANIMATED;
    public static final com.facebook.imageformat.ImageFormat WEBP_EXTENDED;
    public static final com.facebook.imageformat.ImageFormat WEBP_EXTENDED_WITH_ALPHA;
    public static final com.facebook.imageformat.ImageFormat WEBP_LOSSLESS;
    public static final com.facebook.imageformat.ImageFormat WEBP_SIMPLE;
    public static final java.util.List<com.facebook.imageformat.ImageFormat> defaultFormats;

    private DefaultImageFormats() {
    }

    static {
        com.facebook.imageformat.ImageFormat imageFormat = new com.facebook.imageformat.ImageFormat("JPEG", "jpeg");
        JPEG = imageFormat;
        com.facebook.imageformat.ImageFormat imageFormat2 = new com.facebook.imageformat.ImageFormat("PNG", "png");
        PNG = imageFormat2;
        com.facebook.imageformat.ImageFormat imageFormat3 = new com.facebook.imageformat.ImageFormat("GIF", "gif");
        GIF = imageFormat3;
        com.facebook.imageformat.ImageFormat imageFormat4 = new com.facebook.imageformat.ImageFormat("BMP", "bmp");
        BMP = imageFormat4;
        com.facebook.imageformat.ImageFormat imageFormat5 = new com.facebook.imageformat.ImageFormat("ICO", "ico");
        ICO = imageFormat5;
        com.facebook.imageformat.ImageFormat imageFormat6 = new com.facebook.imageformat.ImageFormat("WEBP_SIMPLE", "webp");
        WEBP_SIMPLE = imageFormat6;
        com.facebook.imageformat.ImageFormat imageFormat7 = new com.facebook.imageformat.ImageFormat("WEBP_LOSSLESS", "webp");
        WEBP_LOSSLESS = imageFormat7;
        com.facebook.imageformat.ImageFormat imageFormat8 = new com.facebook.imageformat.ImageFormat("WEBP_EXTENDED", "webp");
        WEBP_EXTENDED = imageFormat8;
        com.facebook.imageformat.ImageFormat imageFormat9 = new com.facebook.imageformat.ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
        WEBP_EXTENDED_WITH_ALPHA = imageFormat9;
        com.facebook.imageformat.ImageFormat imageFormat10 = new com.facebook.imageformat.ImageFormat("WEBP_ANIMATED", "webp");
        WEBP_ANIMATED = imageFormat10;
        com.facebook.imageformat.ImageFormat imageFormat11 = new com.facebook.imageformat.ImageFormat("HEIF", "heif");
        HEIF = imageFormat11;
        DNG = new com.facebook.imageformat.ImageFormat("DNG", "dng");
        defaultFormats = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new com.facebook.imageformat.ImageFormat[]{imageFormat, imageFormat2, imageFormat3, imageFormat4, imageFormat5, imageFormat6, imageFormat7, imageFormat8, imageFormat9, imageFormat10, imageFormat11});
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isWebpFormat(com.facebook.imageformat.ImageFormat imageFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return isStaticWebpFormat(imageFormat) || imageFormat == WEBP_ANIMATED;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isStaticWebpFormat(com.facebook.imageformat.ImageFormat imageFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return imageFormat == WEBP_SIMPLE || imageFormat == WEBP_LOSSLESS || imageFormat == WEBP_EXTENDED || imageFormat == WEBP_EXTENDED_WITH_ALPHA;
    }
}
