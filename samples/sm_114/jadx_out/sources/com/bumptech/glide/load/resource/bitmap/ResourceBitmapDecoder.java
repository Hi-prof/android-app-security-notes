package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class ResourceBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<android.net.Uri, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder resourceDrawableDecoder, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(android.net.Uri uri, com.bumptech.glide.load.Options options) {
        return com.facebook.common.util.UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.net.Uri uri, int i, int i2, com.bumptech.glide.load.Options options) {
        com.bumptech.glide.load.engine.Resource<android.graphics.drawable.Drawable> resourceDecode = this.drawableDecoder.decode(uri, i, i2, options);
        if (resourceDecode == null) {
            return null;
        }
        return com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.convert(this.bitmapPool, resourceDecode.get(), i, i2);
    }
}
