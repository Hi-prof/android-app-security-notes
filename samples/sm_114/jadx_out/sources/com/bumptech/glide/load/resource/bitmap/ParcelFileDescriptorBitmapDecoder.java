package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelFileDescriptorBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> {
    private static final int MAXIMUM_FILE_BYTE_SIZE_FOR_FILE_DESCRIPTOR_DECODER = 536870912;
    private final com.bumptech.glide.load.resource.bitmap.Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(com.bumptech.glide.load.resource.bitmap.Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(android.os.ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.Options options) {
        return isSafeToTryDecoding(parcelFileDescriptor) && this.downsampler.handles(parcelFileDescriptor);
    }

    private boolean isSafeToTryDecoding(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        return !("HUAWEI".equalsIgnoreCase(android.os.Build.MANUFACTURER) || "HONOR".equalsIgnoreCase(android.os.Build.MANUFACTURER)) || parcelFileDescriptor.getStatSize() <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_LEFT;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.downsampler.decode(parcelFileDescriptor, i, i2, options);
    }
}
