package com.bumptech.glide.load.resource.gif;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawableEncoder implements com.bumptech.glide.load.ResourceEncoder<com.bumptech.glide.load.resource.gif.GifDrawable> {
    private static final java.lang.String TAG = "GifEncoder";

    @Override // com.bumptech.glide.load.ResourceEncoder
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> resource, java.io.File file, com.bumptech.glide.load.Options options) throws java.lang.Throwable {
        try {
            com.bumptech.glide.util.ByteBufferUtil.toFile(resource.get().getBuffer(), file);
            return true;
        } catch (java.io.IOException e) {
            if (!android.util.Log.isLoggable(TAG, 5)) {
                return false;
            }
            android.util.Log.w(TAG, "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
