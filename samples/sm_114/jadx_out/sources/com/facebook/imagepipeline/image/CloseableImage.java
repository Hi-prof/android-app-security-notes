package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public interface CloseableImage extends java.io.Closeable, com.facebook.imagepipeline.image.ImageInfo, com.facebook.common.references.HasBitmap, com.facebook.fresco.middleware.HasExtraData {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getHeight();

    com.facebook.imagepipeline.image.ImageInfo getImageInfo();

    com.facebook.imagepipeline.image.QualityInfo getQualityInfo();

    int getSizeInBytes();

    int getWidth();

    boolean isClosed();

    boolean isStateful();
}
