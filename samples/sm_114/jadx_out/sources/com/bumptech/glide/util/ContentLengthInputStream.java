package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public final class ContentLengthInputStream extends java.io.FilterInputStream {
    private static final java.lang.String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    public static java.io.InputStream obtain(java.io.InputStream inputStream, java.lang.String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    public static java.io.InputStream obtain(java.io.InputStream inputStream, long j) {
        return new com.bumptech.glide.util.ContentLengthInputStream(inputStream, j);
    }

    private static int parseContentLength(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException e) {
            if (!android.util.Log.isLoggable(TAG, 3)) {
                return -1;
            }
            android.util.Log.d(TAG, "failed to parse content length header: " + str, e);
            return -1;
        }
    }

    private ContentLengthInputStream(java.io.InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws java.io.IOException {
        return (int) java.lang.Math.max(this.contentLength - ((long) this.readSoFar), this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        int i;
        i = super.read();
        checkReadSoFarOrThrow(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i, i2));
    }

    private int checkReadSoFarOrThrow(int i) throws java.io.IOException {
        if (i >= 0) {
            this.readSoFar += i;
            return i;
        }
        if (this.contentLength - ((long) this.readSoFar) <= 0) {
            return i;
        }
        throw new java.io.IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
    }
}
