package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class ByteStreams {
    private static final int BUF_SIZE = 4096;

    private ByteStreams() {
    }

    public static long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        com.facebook.common.internal.Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static int read(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(java.io.InputStream inputStream, int i) throws java.io.IOException {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            int i3 = i - i2;
            int i4 = inputStream.read(bArr, i3, i2);
            if (i4 == -1) {
                return java.util.Arrays.copyOf(bArr, i3);
            }
            i2 -= i4;
        }
        int i5 = inputStream.read();
        if (i5 == -1) {
            return bArr;
        }
        com.facebook.common.internal.ByteStreams.FastByteArrayOutputStream fastByteArrayOutputStream = new com.facebook.common.internal.ByteStreams.FastByteArrayOutputStream();
        fastByteArrayOutputStream.write(i5);
        copy(inputStream, fastByteArrayOutputStream);
        byte[] bArr2 = new byte[fastByteArrayOutputStream.size() + i];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        fastByteArrayOutputStream.writeTo(bArr2, i);
        return bArr2;
    }

    private static final class FastByteArrayOutputStream extends java.io.ByteArrayOutputStream {
        private FastByteArrayOutputStream() {
        }

        void writeTo(byte[] bArr, int i) {
            java.lang.System.arraycopy(this.buf, 0, bArr, i, this.count);
        }
    }

    public static void readFully(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = read(inputStream, bArr, i, i2);
        if (i3 == i2) {
            return;
        }
        throw new java.io.EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
    }
}
