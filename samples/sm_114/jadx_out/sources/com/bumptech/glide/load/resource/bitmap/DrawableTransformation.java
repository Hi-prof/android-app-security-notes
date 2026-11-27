package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class DrawableTransformation implements com.bumptech.glide.load.Transformation<android.graphics.drawable.Drawable> {
    private final boolean isRequired;
    private final com.bumptech.glide.load.Transformation<android.graphics.Bitmap> wrapped;

    public com.bumptech.glide.load.Transformation<android.graphics.drawable.BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public DrawableTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    public com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> transform(android.content.Context context, com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resource, int i, int i2) {
        com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = com.bumptech.glide.Glide.get(context).getBitmapPool();
        android.graphics.drawable.Drawable drawable = resource.get();
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resourceConvert = com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.convert(bitmapPool, drawable, i, i2);
        if (resourceConvert == null) {
            if (!this.isRequired) {
                return resource;
            }
            throw new java.lang.IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resourceTransform = this.wrapped.transform(context, resourceConvert, i, i2);
        if (resourceTransform.equals(resourceConvert)) {
            resourceTransform.recycle();
            return resource;
        }
        return newDrawableResource(context, resourceTransform);
    }

    private com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> newDrawableResource(android.content.Context context, com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        return com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.resource.bitmap.DrawableTransformation) {
            return this.wrapped.equals(((com.bumptech.glide.load.resource.bitmap.DrawableTransformation) obj).wrapped);
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
