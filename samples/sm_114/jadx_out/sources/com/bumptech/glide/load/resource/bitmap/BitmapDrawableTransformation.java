package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class BitmapDrawableTransformation implements com.bumptech.glide.load.Transformation<android.graphics.drawable.BitmapDrawable> {
    private final com.bumptech.glide.load.Transformation<android.graphics.drawable.Drawable> wrapped;

    private static com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> convertToDrawableResource(com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> resource) {
        return resource;
    }

    public BitmapDrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        this.wrapped = (com.bumptech.glide.load.Transformation) com.bumptech.glide.util.Preconditions.checkNotNull(new com.bumptech.glide.load.resource.bitmap.DrawableTransformation(transformation, false));
    }

    @Override // com.bumptech.glide.load.Transformation
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> transform(android.content.Context context, com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> resource, int i, int i2) {
        return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(resource), i, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> convertToBitmapDrawableResource(com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resource) {
        if (resource.get() instanceof android.graphics.drawable.BitmapDrawable) {
            return resource;
        }
        throw new java.lang.IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.resource.bitmap.BitmapDrawableTransformation) {
            return this.wrapped.equals(((com.bumptech.glide.load.resource.bitmap.BitmapDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
