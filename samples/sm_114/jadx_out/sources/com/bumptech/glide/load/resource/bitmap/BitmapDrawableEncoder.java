package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class BitmapDrawableEncoder implements com.bumptech.glide.load.ResourceEncoder<android.graphics.drawable.BitmapDrawable> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> encoder;

    public BitmapDrawableEncoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> resourceEncoder) {
        this.bitmapPool = bitmapPool;
        this.encoder = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.drawable.BitmapDrawable> resource, java.io.File file, com.bumptech.glide.load.Options options) {
        return this.encoder.encode((android.graphics.Bitmap) new com.bumptech.glide.load.resource.bitmap.BitmapResource(resource.get().getBitmap(), this.bitmapPool), file, options);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(com.bumptech.glide.load.Options options) {
        return this.encoder.getEncodeStrategy(options);
    }
}
