package com.facebook.imageformat;

/* JADX INFO: compiled from: DefaultImageFormatChecker.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/facebook/imageformat/DefaultImageFormatChecker;", "Lcom/facebook/imageformat/ImageFormat$FormatChecker;", "<init>", "()V", "headerSize", "", "getHeaderSize", "()I", "determineFormat", "Lcom/facebook/imageformat/ImageFormat;", "headerBytes", "", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultImageFormatChecker implements com.facebook.imageformat.ImageFormat.FormatChecker {
    private static final byte[] BMP_HEADER;
    private static final int BMP_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_II;
    private static final int DNG_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_MM;
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int GIF_HEADER_LENGTH = 6;
    private static final int HEIF_HEADER_LENGTH = 12;
    private static final byte[] HEIF_HEADER_PREFIX;
    private static final byte[][] HEIF_HEADER_SUFFIXES;
    private static final byte[] ICO_HEADER;
    private static final int ICO_HEADER_LENGTH;
    private static final byte[] JPEG_HEADER;
    private static final int JPEG_HEADER_LENGTH;
    private static final byte[] PNG_HEADER;
    private static final int PNG_HEADER_LENGTH;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private final int headerSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imageformat.DefaultImageFormatChecker.Companion INSTANCE = new com.facebook.imageformat.DefaultImageFormatChecker.Companion(null);
    private static final byte[] GIF_HEADER_87A = com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("GIF87a");
    private static final byte[] GIF_HEADER_89A = com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("GIF89a");

    public DefaultImageFormatChecker() {
        java.lang.Object objMaxOrNull = kotlin.collections.ArraysKt.maxOrNull(new java.lang.Integer[]{21, 20, java.lang.Integer.valueOf(JPEG_HEADER_LENGTH), java.lang.Integer.valueOf(PNG_HEADER_LENGTH), 6, java.lang.Integer.valueOf(BMP_HEADER_LENGTH), java.lang.Integer.valueOf(ICO_HEADER_LENGTH), 12});
        if (objMaxOrNull == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        this.headerSize = ((java.lang.Number) objMaxOrNull).intValue();
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.headerSize;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public com.facebook.imageformat.ImageFormat determineFormat(byte[] headerBytes, int headerSize) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(headerBytes, "headerBytes");
        if (!com.facebook.common.webp.WebpSupportStatus.isWebpHeader(headerBytes, 0, headerSize)) {
            com.facebook.imageformat.DefaultImageFormatChecker.Companion companion = INSTANCE;
            if (companion.isJpegHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.JPEG;
            }
            if (companion.isPngHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.PNG;
            }
            if (companion.isGifHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.GIF;
            }
            if (companion.isBmpHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.BMP;
            }
            if (companion.isIcoHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.ICO;
            }
            if (companion.isHeifHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.HEIF;
            }
            if (companion.isDngHeader(headerBytes, headerSize)) {
                return com.facebook.imageformat.DefaultImageFormats.DNG;
            }
            return com.facebook.imageformat.ImageFormat.UNKNOWN;
        }
        return INSTANCE.getWebpFormat(headerBytes, headerSize);
    }

    /* JADX INFO: compiled from: DefaultImageFormatChecker.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/facebook/imageformat/DefaultImageFormatChecker$Companion;", "", "<init>", "()V", "SIMPLE_WEBP_HEADER_LENGTH", "", "EXTENDED_WEBP_HEADER_LENGTH", "getWebpFormat", "Lcom/facebook/imageformat/ImageFormat;", "imageHeaderBytes", "", "headerSize", "JPEG_HEADER", "JPEG_HEADER_LENGTH", "isJpegHeader", "", "PNG_HEADER", "PNG_HEADER_LENGTH", "isPngHeader", "GIF_HEADER_87A", "GIF_HEADER_89A", "GIF_HEADER_LENGTH", "isGifHeader", "BMP_HEADER", "BMP_HEADER_LENGTH", "isBmpHeader", "ICO_HEADER", "ICO_HEADER_LENGTH", "isIcoHeader", "HEIF_HEADER_PREFIX", "HEIF_HEADER_SUFFIXES", "", "[[B", "HEIF_HEADER_LENGTH", "isHeifHeader", "DNG_HEADER_II", "DNG_HEADER_MM", "DNG_HEADER_LENGTH", "isDngHeader", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.facebook.imageformat.ImageFormat getWebpFormat(byte[] imageHeaderBytes, int headerSize) {
            if (!com.facebook.common.webp.WebpSupportStatus.isWebpHeader(imageHeaderBytes, 0, headerSize)) {
                throw new java.lang.IllegalStateException("Check failed.".toString());
            }
            if (com.facebook.common.webp.WebpSupportStatus.isSimpleWebpHeader(imageHeaderBytes, 0)) {
                return com.facebook.imageformat.DefaultImageFormats.WEBP_SIMPLE;
            }
            if (com.facebook.common.webp.WebpSupportStatus.isLosslessWebpHeader(imageHeaderBytes, 0)) {
                return com.facebook.imageformat.DefaultImageFormats.WEBP_LOSSLESS;
            }
            if (com.facebook.common.webp.WebpSupportStatus.isExtendedWebpHeader(imageHeaderBytes, 0, headerSize)) {
                if (com.facebook.common.webp.WebpSupportStatus.isAnimatedWebpHeader(imageHeaderBytes, 0)) {
                    return com.facebook.imageformat.DefaultImageFormats.WEBP_ANIMATED;
                }
                if (com.facebook.common.webp.WebpSupportStatus.isExtendedWebpHeaderWithAlpha(imageHeaderBytes, 0)) {
                    return com.facebook.imageformat.DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
                }
                return com.facebook.imageformat.DefaultImageFormats.WEBP_EXTENDED;
            }
            return com.facebook.imageformat.ImageFormat.UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isJpegHeader(byte[] imageHeaderBytes, int headerSize) {
            return headerSize >= com.facebook.imageformat.DefaultImageFormatChecker.JPEG_HEADER.length && com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.JPEG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isPngHeader(byte[] imageHeaderBytes, int headerSize) {
            return headerSize >= com.facebook.imageformat.DefaultImageFormatChecker.PNG_HEADER.length && com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.PNG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGifHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < 6) {
                return false;
            }
            return com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.GIF_HEADER_87A) || com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.GIF_HEADER_89A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBmpHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < com.facebook.imageformat.DefaultImageFormatChecker.BMP_HEADER.length) {
                return false;
            }
            return com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.BMP_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isIcoHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < com.facebook.imageformat.DefaultImageFormatChecker.ICO_HEADER.length) {
                return false;
            }
            return com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.ICO_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isHeifHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < 12 || imageHeaderBytes[3] < 8 || !com.facebook.imageformat.ImageFormatCheckerUtils.hasPatternAt(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.HEIF_HEADER_PREFIX, 4)) {
                return false;
            }
            for (byte[] bArr : com.facebook.imageformat.DefaultImageFormatChecker.HEIF_HEADER_SUFFIXES) {
                if (com.facebook.imageformat.ImageFormatCheckerUtils.hasPatternAt(imageHeaderBytes, bArr, 8)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDngHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize >= com.facebook.imageformat.DefaultImageFormatChecker.DNG_HEADER_LENGTH) {
                return com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.DNG_HEADER_II) || com.facebook.imageformat.ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, com.facebook.imageformat.DefaultImageFormatChecker.DNG_HEADER_MM);
            }
            return false;
        }
    }

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        byte[] bArrAsciiBytes = com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = bArrAsciiBytes;
        BMP_HEADER_LENGTH = bArrAsciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        HEIF_HEADER_PREFIX = com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("ftyp");
        HEIF_HEADER_SUFFIXES = new byte[][]{com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("heic"), com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("heix"), com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("hevc"), com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("hevx"), com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("mif1"), com.facebook.imageformat.ImageFormatCheckerUtils.asciiBytes("msf1")};
        byte[] bArr4 = {73, 73, 42, 0};
        DNG_HEADER_II = bArr4;
        DNG_HEADER_MM = new byte[]{77, 77, 0, 42};
        DNG_HEADER_LENGTH = bArr4.length;
    }
}
