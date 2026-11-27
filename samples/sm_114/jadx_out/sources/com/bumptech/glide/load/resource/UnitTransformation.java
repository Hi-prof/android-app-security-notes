package com.bumptech.glide.load.resource;

/* JADX INFO: loaded from: classes.dex */
public final class UnitTransformation<T> implements com.bumptech.glide.load.Transformation<T> {
    private static final com.bumptech.glide.load.Transformation<?> TRANSFORMATION = new com.bumptech.glide.load.resource.UnitTransformation();

    @Override // com.bumptech.glide.load.Transformation
    public com.bumptech.glide.load.engine.Resource<T> transform(android.content.Context context, com.bumptech.glide.load.engine.Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(java.security.MessageDigest messageDigest) {
    }

    public static <T> com.bumptech.glide.load.resource.UnitTransformation<T> get() {
        return (com.bumptech.glide.load.resource.UnitTransformation) TRANSFORMATION;
    }

    private UnitTransformation() {
    }
}
