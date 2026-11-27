package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapTransformation implements com.bumptech.glide.load.Transformation<android.graphics.Bitmap> {
    protected abstract android.graphics.Bitmap transform(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Transformation
    public final com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> transform(android.content.Context context, com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource, int i, int i2) {
        if (!com.bumptech.glide.util.Util.isValidDimensions(i, i2)) {
            throw new java.lang.IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = com.bumptech.glide.Glide.get(context).getBitmapPool();
        android.graphics.Bitmap bitmap = resource.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        android.graphics.Bitmap bitmapTransform = transform(bitmapPool, bitmap, i, i2);
        return bitmap.equals(bitmapTransform) ? resource : com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(bitmapTransform, bitmapPool);
    }
}
