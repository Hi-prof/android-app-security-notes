package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class CountingOutputStream extends java.io.FilterOutputStream {
    private long mCount;

    public CountingOutputStream(java.io.OutputStream outputStream) {
        super(outputStream);
        this.mCount = 0L;
    }

    public long getCount() {
        return this.mCount;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.out.write(bArr, i, i2);
        this.mCount += (long) i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.out.write(i);
        this.mCount++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.out.close();
    }
}
