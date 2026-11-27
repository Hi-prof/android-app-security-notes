package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapImageDecoderResourceDecoder implements com.bumptech.glide.load.ResourceDecoder<android.graphics.ImageDecoder.Source, android.graphics.Bitmap> {
    private static final java.lang.String TAG = "BitmapImageDecoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = new com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter();

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(android.graphics.ImageDecoder.Source source, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.graphics.ImageDecoder.Source source, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode2(dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) source), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(android.graphics.ImageDecoder.Source source, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return handles2(dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m((java.lang.Object) source), options);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode2(android.graphics.ImageDecoder.Source source, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        android.graphics.Bitmap bitmapDecodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, new com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener(i, i2, options));
        if (android.util.Log.isLoggable(TAG, 2)) {
            android.util.Log.v(TAG, "Decoded [" + bitmapDecodeBitmap.getWidth() + com.taobao.weex.common.Constants.Name.X + bitmapDecodeBitmap.getHeight() + "] for [" + i + com.taobao.weex.common.Constants.Name.X + i2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        }
        return new com.bumptech.glide.load.resource.bitmap.BitmapResource(bitmapDecodeBitmap, this.bitmapPool);
    }
}
