package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBufferBitmapImageDecoderResourceDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder wrapped = new com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.wrapped.decode2(android.graphics.ImageDecoder.createSource(byteBuffer), i, i2, options);
    }
}
