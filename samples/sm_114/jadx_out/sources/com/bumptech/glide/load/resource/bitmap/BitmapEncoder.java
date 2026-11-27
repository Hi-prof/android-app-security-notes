package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class BitmapEncoder implements com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> {
    private static final java.lang.String TAG = "BitmapEncoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    public static final com.bumptech.glide.load.Option<java.lang.Integer> COMPRESSION_QUALITY = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.bumptech.glide.load.Option<android.graphics.Bitmap.CompressFormat> COMPRESSION_FORMAT = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    public BitmapEncoder(com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    @java.lang.Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource, java.io.File file, com.bumptech.glide.load.Options options) {
        boolean z;
        android.graphics.Bitmap bitmap = resource.get();
        android.graphics.Bitmap.CompressFormat format = getFormat(bitmap, options);
        com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat("encode: [%dx%d] %s", java.lang.Integer.valueOf(bitmap.getWidth()), java.lang.Integer.valueOf(bitmap.getHeight()), format);
        try {
            long logTime = com.bumptech.glide.util.LogTime.getLogTime();
            int iIntValue = ((java.lang.Integer) options.get(COMPRESSION_QUALITY)).intValue();
            java.io.OutputStream bufferedOutputStream = null;
            try {
                try {
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                    try {
                        bufferedOutputStream = this.arrayPool != null ? new com.bumptech.glide.load.data.BufferedOutputStream(fileOutputStream, this.arrayPool) : fileOutputStream;
                        bitmap.compress(format, iIntValue, bufferedOutputStream);
                        bufferedOutputStream.close();
                        try {
                            bufferedOutputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                        z = true;
                    } catch (java.io.IOException e) {
                        e = e;
                        bufferedOutputStream = fileOutputStream;
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Failed to encode Bitmap", e);
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        z = false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedOutputStream = fileOutputStream;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                }
                if (android.util.Log.isLoggable(TAG, 2)) {
                    android.util.Log.v(TAG, "Compressed with type: " + format + " of size " + com.bumptech.glide.util.Util.getBitmapByteSize(bitmap) + " in " + com.bumptech.glide.util.LogTime.getElapsedMillis(logTime) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
                }
                com.bumptech.glide.util.pool.GlideTrace.endSection();
                return z;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            com.bumptech.glide.util.pool.GlideTrace.endSection();
            throw th3;
        }
    }

    private android.graphics.Bitmap.CompressFormat getFormat(android.graphics.Bitmap bitmap, com.bumptech.glide.load.Options options) {
        android.graphics.Bitmap.CompressFormat compressFormat = (android.graphics.Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return android.graphics.Bitmap.CompressFormat.PNG;
        }
        return android.graphics.Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.EncodeStrategy.TRANSFORMED;
    }
}
