package com.facebook.common.util;

/* JADX INFO: loaded from: classes.dex */
public class StreamUtil {
    public static byte[] getBytesFromStream(java.io.InputStream inputStream) throws java.io.IOException {
        return getBytesFromStream(inputStream, inputStream.available());
    }

    public static byte[] getBytesFromStream(java.io.InputStream inputStream, int i) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(i) { // from class: com.facebook.common.util.StreamUtil.1
            @Override // java.io.ByteArrayOutputStream
            public byte[] toByteArray() {
                if (this.count == this.buf.length) {
                    return this.buf;
                }
                return super.toByteArray();
            }
        };
        com.facebook.common.internal.ByteStreams.copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long skip(java.io.InputStream inputStream, long j) throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(j >= 0));
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }
}
