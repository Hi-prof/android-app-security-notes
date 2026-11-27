package com.bumptech.glide.load.resource.gif;

/* JADX INFO: loaded from: classes.dex */
public final class GifBitmapProvider implements com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider {
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    public GifBitmapProvider(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(bitmapPool, null);
    }

    public GifBitmapProvider(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public android.graphics.Bitmap obtain(int i, int i2, android.graphics.Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(android.graphics.Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int i) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.get(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int i) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.get(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool = this.arrayPool;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }
}
