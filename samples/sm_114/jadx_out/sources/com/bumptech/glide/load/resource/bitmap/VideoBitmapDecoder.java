package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class VideoBitmapDecoder extends com.bumptech.glide.load.resource.bitmap.VideoDecoder<android.os.ParcelFileDescriptor> {
    public VideoBitmapDecoder(android.content.Context context) {
        this(com.bumptech.glide.Glide.get(context).getBitmapPool());
    }

    public VideoBitmapDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        super(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer());
    }
}
