package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class CenterInside extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
    private static final java.lang.String ID = "com.bumptech.glide.load.resource.bitmap.CenterInside";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return -670243078;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected android.graphics.Bitmap transform(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2) {
        return com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerInside(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        return obj instanceof com.bumptech.glide.load.resource.bitmap.CenterInside;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
