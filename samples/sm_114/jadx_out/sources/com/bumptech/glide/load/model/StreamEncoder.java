package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public class StreamEncoder implements com.bumptech.glide.load.Encoder<java.io.InputStream> {
    private static final java.lang.String TAG = "StreamEncoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;

    public StreamEncoder(com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(java.io.InputStream inputStream, java.io.File file, com.bumptech.glide.load.Options options) throws java.lang.Throwable {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    } catch (java.io.IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException unused3) {
                }
                this.byteArrayPool.put(bArr);
                return true;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e2) {
            e = e2;
        }
    }
}
