package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public class WriterCallbacks {
    public static com.facebook.cache.common.WriterCallback from(final java.io.InputStream inputStream) {
        return new com.facebook.cache.common.WriterCallback() { // from class: com.facebook.cache.common.WriterCallbacks.1
            @Override // com.facebook.cache.common.WriterCallback
            public void write(java.io.OutputStream outputStream) throws java.io.IOException {
                com.facebook.common.internal.ByteStreams.copy(inputStream, outputStream);
            }
        };
    }

    public static com.facebook.cache.common.WriterCallback from(final byte[] bArr) {
        return new com.facebook.cache.common.WriterCallback() { // from class: com.facebook.cache.common.WriterCallbacks.2
            @Override // com.facebook.cache.common.WriterCallback
            public void write(java.io.OutputStream outputStream) throws java.io.IOException {
                outputStream.write(bArr);
            }
        };
    }
}
