package com.facebook.imagepipeline.transcoder;

/* JADX INFO: compiled from: MultiImageTranscoderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/transcoder/MultiImageTranscoderFactory;", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "maxBitmapSize", "", "useDownSamplingRatio", "", "primaryImageTranscoderFactory", "imageTranscoderType", "ensureTranscoderLibraryLoaded", "<init>", "(IZLcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;Ljava/lang/Integer;Z)V", "Ljava/lang/Integer;", "createImageTranscoder", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoder;", "imageFormat", "Lcom/facebook/imageformat/ImageFormat;", "isResizingEnabled", "getCustomImageTranscoder", "getNativeImageTranscoder", "getSimpleImageTranscoder", "getImageTranscoderWithType", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiImageTranscoderFactory implements com.facebook.imagepipeline.transcoder.ImageTranscoderFactory {
    private final boolean ensureTranscoderLibraryLoaded;
    private final java.lang.Integer imageTranscoderType;
    private final int maxBitmapSize;
    private final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory primaryImageTranscoderFactory;
    private final boolean useDownSamplingRatio;

    public MultiImageTranscoderFactory(int i, boolean z, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory, java.lang.Integer num, boolean z2) {
        this.maxBitmapSize = i;
        this.useDownSamplingRatio = z;
        this.primaryImageTranscoderFactory = imageTranscoderFactory;
        this.imageTranscoderType = num;
        this.ensureTranscoderLibraryLoaded = z2;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public com.facebook.imagepipeline.transcoder.ImageTranscoder createImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean isResizingEnabled) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        com.facebook.imagepipeline.transcoder.ImageTranscoder customImageTranscoder = getCustomImageTranscoder(imageFormat, isResizingEnabled);
        if (customImageTranscoder == null) {
            customImageTranscoder = getImageTranscoderWithType(imageFormat, isResizingEnabled);
        }
        if (customImageTranscoder == null && com.facebook.imagepipeline.core.NativeCodeSetup.getUseNativeCode()) {
            customImageTranscoder = getNativeImageTranscoder(imageFormat, isResizingEnabled);
        }
        return customImageTranscoder == null ? getSimpleImageTranscoder(imageFormat, isResizingEnabled) : customImageTranscoder;
    }

    private final com.facebook.imagepipeline.transcoder.ImageTranscoder getCustomImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean isResizingEnabled) {
        com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory = this.primaryImageTranscoderFactory;
        if (imageTranscoderFactory != null) {
            return imageTranscoderFactory.createImageTranscoder(imageFormat, isResizingEnabled);
        }
        return null;
    }

    private final com.facebook.imagepipeline.transcoder.ImageTranscoder getNativeImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean isResizingEnabled) {
        return com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.maxBitmapSize, this.useDownSamplingRatio, this.ensureTranscoderLibraryLoaded).createImageTranscoder(imageFormat, isResizingEnabled);
    }

    private final com.facebook.imagepipeline.transcoder.ImageTranscoder getSimpleImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean isResizingEnabled) {
        com.facebook.imagepipeline.transcoder.ImageTranscoder imageTranscoderCreateImageTranscoder = new com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory(this.maxBitmapSize).createImageTranscoder(imageFormat, isResizingEnabled);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageTranscoderCreateImageTranscoder, "createImageTranscoder(...)");
        return imageTranscoderCreateImageTranscoder;
    }

    private final com.facebook.imagepipeline.transcoder.ImageTranscoder getImageTranscoderWithType(com.facebook.imageformat.ImageFormat imageFormat, boolean isResizingEnabled) {
        java.lang.Integer num = this.imageTranscoderType;
        if (num == null) {
            return null;
        }
        if (num != null && num.intValue() == 0) {
            return getNativeImageTranscoder(imageFormat, isResizingEnabled);
        }
        if (num != null && num.intValue() == 1) {
            return getSimpleImageTranscoder(imageFormat, isResizingEnabled);
        }
        throw new java.lang.IllegalArgumentException("Invalid ImageTranscoderType");
    }
}
