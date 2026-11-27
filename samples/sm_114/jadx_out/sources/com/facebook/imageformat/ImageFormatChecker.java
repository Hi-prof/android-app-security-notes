package com.facebook.imageformat;

/* JADX INFO: compiled from: ImageFormatChecker.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/imageformat/ImageFormatChecker;", "", "<init>", "()V", "maxHeaderLength", "", "customImageFormatCheckers", "", "Lcom/facebook/imageformat/ImageFormat$FormatChecker;", "defaultFormatChecker", "Lcom/facebook/imageformat/DefaultImageFormatChecker;", "setCustomImageFormatCheckers", "", "determineImageFormat", "Lcom/facebook/imageformat/ImageFormat;", "is", "Ljava/io/InputStream;", "updateMaxHeaderLength", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageFormatChecker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imageformat.ImageFormatChecker.Companion INSTANCE = new com.facebook.imageformat.ImageFormatChecker.Companion(null);
    private static final kotlin.Lazy<com.facebook.imageformat.ImageFormatChecker> instance$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.SYNCHRONIZED, new kotlin.jvm.functions.Function0() { // from class: com.facebook.imageformat.ImageFormatChecker$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return com.facebook.imageformat.ImageFormatChecker.instance_delegate$lambda$1();
        }
    });
    private java.util.List<? extends com.facebook.imageformat.ImageFormat.FormatChecker> customImageFormatCheckers;
    private final com.facebook.imageformat.DefaultImageFormatChecker defaultFormatChecker = new com.facebook.imageformat.DefaultImageFormatChecker();
    private int maxHeaderLength;

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imageformat.ImageFormat getImageFormat(java.io.InputStream inputStream) throws java.io.IOException {
        return INSTANCE.getImageFormat(inputStream);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imageformat.ImageFormat getImageFormat(java.lang.String str) {
        return INSTANCE.getImageFormat(str);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imageformat.ImageFormat getImageFormat_WrapIOException(java.io.InputStream inputStream) {
        return INSTANCE.getImageFormat_WrapIOException(inputStream);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imageformat.ImageFormatChecker getInstance() {
        return INSTANCE.getInstance();
    }

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public final void setCustomImageFormatCheckers(java.util.List<? extends com.facebook.imageformat.ImageFormat.FormatChecker> customImageFormatCheckers) {
        this.customImageFormatCheckers = customImageFormatCheckers;
        updateMaxHeaderLength();
    }

    public final com.facebook.imageformat.ImageFormat determineImageFormat(java.io.InputStream is) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(is, "is");
        int i = this.maxHeaderLength;
        byte[] bArr = new byte[i];
        int headerFromStream = INSTANCE.readHeaderFromStream(i, is, bArr);
        com.facebook.imageformat.ImageFormat imageFormatDetermineFormat = this.defaultFormatChecker.determineFormat(bArr, headerFromStream);
        if (imageFormatDetermineFormat != com.facebook.imageformat.ImageFormat.UNKNOWN) {
            return imageFormatDetermineFormat;
        }
        java.util.List<? extends com.facebook.imageformat.ImageFormat.FormatChecker> list = this.customImageFormatCheckers;
        if (list != null) {
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                com.facebook.imageformat.ImageFormat imageFormatDetermineFormat2 = ((com.facebook.imageformat.ImageFormat.FormatChecker) it.next()).determineFormat(bArr, headerFromStream);
                if (imageFormatDetermineFormat2 != com.facebook.imageformat.ImageFormat.UNKNOWN) {
                    return imageFormatDetermineFormat2;
                }
            }
        }
        return com.facebook.imageformat.ImageFormat.UNKNOWN;
    }

    private final void updateMaxHeaderLength() {
        this.maxHeaderLength = this.defaultFormatChecker.getHeaderSize();
        java.util.List<? extends com.facebook.imageformat.ImageFormat.FormatChecker> list = this.customImageFormatCheckers;
        if (list != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(list);
            java.util.Iterator<? extends com.facebook.imageformat.ImageFormat.FormatChecker> it = list.iterator();
            while (it.hasNext()) {
                this.maxHeaderLength = java.lang.Math.max(this.maxHeaderLength, it.next().getHeaderSize());
            }
        }
    }

    /* JADX INFO: compiled from: ImageFormatChecker.kt */
    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u001b\u0010\u000b\u001a\u00020\f8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/facebook/imageformat/ImageFormatChecker$Companion;", "", "<init>", "()V", "readHeaderFromStream", "", "maxHeaderLength", "is", "Ljava/io/InputStream;", "imageHeaderBytes", "", "instance", "Lcom/facebook/imageformat/ImageFormatChecker;", "getInstance", "()Lcom/facebook/imageformat/ImageFormatChecker;", "instance$delegate", "Lkotlin/Lazy;", "getImageFormat", "Lcom/facebook/imageformat/ImageFormat;", "getImageFormat_WrapIOException", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME, "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int readHeaderFromStream(int maxHeaderLength, java.io.InputStream is, byte[] imageHeaderBytes) throws java.io.IOException {
            if (imageHeaderBytes.length < maxHeaderLength) {
                throw new java.lang.IllegalStateException("Check failed.".toString());
            }
            if (is.markSupported()) {
                try {
                    is.mark(maxHeaderLength);
                    return com.facebook.common.internal.ByteStreams.read(is, imageHeaderBytes, 0, maxHeaderLength);
                } finally {
                    is.reset();
                }
            }
            return com.facebook.common.internal.ByteStreams.read(is, imageHeaderBytes, 0, maxHeaderLength);
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imageformat.ImageFormatChecker getInstance() {
            return (com.facebook.imageformat.ImageFormatChecker) com.facebook.imageformat.ImageFormatChecker.instance$delegate.getValue();
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imageformat.ImageFormat getImageFormat(java.io.InputStream is) throws java.io.IOException {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(is, "is");
            return getInstance().determineImageFormat(is);
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imageformat.ImageFormat getImageFormat_WrapIOException(java.io.InputStream is) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(is, "is");
            try {
                return getImageFormat(is);
            } catch (java.io.IOException e) {
                throw com.facebook.common.internal.Throwables.propagate(e);
            }
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imageformat.ImageFormat getImageFormat(java.lang.String filename) throws java.lang.Throwable {
            java.io.FileInputStream fileInputStream = null;
            try {
                try {
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(filename);
                    try {
                        com.facebook.imageformat.ImageFormat imageFormat = getImageFormat(fileInputStream2);
                        com.facebook.common.internal.Closeables.closeQuietly(fileInputStream2);
                        return imageFormat;
                    } catch (java.io.IOException unused) {
                        fileInputStream = fileInputStream2;
                        com.facebook.imageformat.ImageFormat imageFormat2 = com.facebook.imageformat.ImageFormat.UNKNOWN;
                        com.facebook.common.internal.Closeables.closeQuietly(fileInputStream);
                        return imageFormat2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        com.facebook.common.internal.Closeables.closeQuietly(fileInputStream);
                        throw th;
                    }
                } catch (java.io.IOException unused2) {
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imageformat.ImageFormatChecker instance_delegate$lambda$1() {
        return new com.facebook.imageformat.ImageFormatChecker();
    }
}
