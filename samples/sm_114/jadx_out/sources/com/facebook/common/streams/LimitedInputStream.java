package com.facebook.common.streams;

/* JADX INFO: loaded from: classes.dex */
public class LimitedInputStream extends java.io.FilterInputStream {
    private int mBytesToRead;
    private int mBytesToReadWhenMarked;

    public LimitedInputStream(java.io.InputStream inputStream, int i) {
        super(inputStream);
        inputStream.getClass();
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("limit must be >= 0");
        }
        this.mBytesToRead = i;
        this.mBytesToReadWhenMarked = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (this.mBytesToRead == 0) {
            return -1;
        }
        int i = this.in.read();
        if (i != -1) {
            this.mBytesToRead--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = this.mBytesToRead;
        if (i3 == 0) {
            return -1;
        }
        int i4 = this.in.read(bArr, i, java.lang.Math.min(i2, i3));
        if (i4 > 0) {
            this.mBytesToRead -= i4;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        long jSkip = this.in.skip(java.lang.Math.min(j, this.mBytesToRead));
        this.mBytesToRead = (int) (((long) this.mBytesToRead) - jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws java.io.IOException {
        return java.lang.Math.min(this.in.available(), this.mBytesToRead);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (this.in.markSupported()) {
            this.in.mark(i);
            this.mBytesToReadWhenMarked = this.mBytesToRead;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws java.io.IOException {
        if (!this.in.markSupported()) {
            throw new java.io.IOException("mark is not supported");
        }
        if (this.mBytesToReadWhenMarked == -1) {
            throw new java.io.IOException("mark not set");
        }
        this.in.reset();
        this.mBytesToRead = this.mBytesToReadWhenMarked;
    }
}
