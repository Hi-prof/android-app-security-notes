package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.Downsampler downsampler;

    public ByteBufferBitmapDecoder(com.bumptech.glide.load.resource.bitmap.Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(java.nio.ByteBuffer byteBuffer, com.bumptech.glide.load.Options options) {
        return this.downsampler.handles(byteBuffer);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.downsampler.decode(byteBuffer, i, i2, options);
    }
}
