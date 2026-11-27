package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCloseableImage implements com.facebook.imagepipeline.image.CloseableImage {
    private static final java.util.Set<java.lang.String> mImageExtrasList = new java.util.HashSet(java.util.Arrays.asList("encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded", "non_fatal_decode_error", "original_url", "modified_url", "image_color_space"));

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.image.ImageInfo mCacheImageInfo;
    private java.util.Map<java.lang.String, java.lang.Object> mExtras = new java.util.HashMap();

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return false;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public com.facebook.imagepipeline.image.QualityInfo getQualityInfo() {
        return com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;
    }

    @Override // com.facebook.imagepipeline.image.HasImageMetadata, com.facebook.fresco.middleware.HasExtraData
    public java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.mExtras;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public void putExtras(@javax.annotation.Nullable java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
        if (map == null) {
            return;
        }
        for (java.lang.String str : mImageExtrasList) {
            java.lang.Object obj = map.get(str);
            if (obj != null) {
                this.mExtras.put(str, obj);
            }
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <E> void putExtra(java.lang.String str, @javax.annotation.Nullable E e) {
        if (mImageExtrasList.contains(str)) {
            this.mExtras.put(str, e);
        }
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <T> T getExtra(java.lang.String str) {
        return (T) getExtra(str, null);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public <T> T getExtra(java.lang.String str, @javax.annotation.Nullable T t) {
        T t2 = (T) this.mExtras.get(str);
        return t2 == null ? t : t2;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public com.facebook.imagepipeline.image.ImageInfo getImageInfo() {
        if (this.mCacheImageInfo == null) {
            this.mCacheImageInfo = new com.facebook.imagepipeline.image.ImageInfoImpl(getWidth(), getHeight(), getSizeInBytes(), getQualityInfo(), getExtras());
        }
        return this.mCacheImageInfo;
    }
}
