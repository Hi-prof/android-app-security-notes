package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public class ImageInfoImpl implements com.facebook.imagepipeline.image.ImageInfo {
    private final java.util.Map<java.lang.String, java.lang.Object> extras;
    private final int height;
    private final com.facebook.imagepipeline.image.QualityInfo qualityInfo;
    private final int sizeInBytes;
    private final int width;

    public ImageInfoImpl(int i, int i2, int i3, com.facebook.imagepipeline.image.QualityInfo qualityInfo, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.width = i;
        this.height = i2;
        this.sizeInBytes = i3;
        this.qualityInfo = qualityInfo;
        this.extras = map;
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata, com.facebook.fresco.middleware.HasExtraData
    public java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.extras;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        return this.width;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        return this.height;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public com.facebook.imagepipeline.image.QualityInfo getQualityInfo() {
        return this.qualityInfo;
    }
}
