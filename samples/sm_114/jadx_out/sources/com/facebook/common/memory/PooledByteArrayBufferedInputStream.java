package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public class PooledByteArrayBufferedInputStream extends java.io.InputStream {
    private static final java.lang.String TAG = "PooledByteInputStream";
    private final byte[] mByteArray;
    private final java.io.InputStream mInputStream;
    private final com.facebook.common.references.ResourceReleaser<byte[]> mResourceReleaser;
    private int mBufferedSize = 0;
    private int mBufferOffset = 0;
    private boolean mClosed = false;

    public PooledByteArrayBufferedInputStream(java.io.InputStream inputStream, byte[] bArr, com.facebook.common.references.ResourceReleaser<byte[]> resourceReleaser) {
        this.mInputStream = (java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(inputStream);
        this.mByteArray = (byte[]) com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        this.mResourceReleaser = (com.facebook.common.references.ResourceReleaser) com.facebook.common.internal.Preconditions.checkNotNull(resourceReleaser);
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mBufferOffset;
        this.mBufferOffset = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        int iMin = java.lang.Math.min(this.mBufferedSize - this.mBufferOffset, i2);
        java.lang.System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i, iMin);
        this.mBufferOffset += iMin;
        return iMin;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mResourceReleaser.release(this.mByteArray);
        super.close();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        com.facebook.common.internal.Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        int i = this.mBufferedSize;
        int i2 = this.mBufferOffset;
        long j2 = i - i2;
        if (j2 >= j) {
            this.mBufferOffset = (int) (((long) i2) + j);
            return j;
        }
        this.mBufferOffset = i;
        return j2 + this.mInputStream.skip(j - j2);
    }

    private boolean ensureDataInBuffer() throws java.io.IOException {
        if (this.mBufferOffset < this.mBufferedSize) {
            return true;
        }
        int i = this.mInputStream.read(this.mByteArray);
        if (i <= 0) {
            return false;
        }
        this.mBufferedSize = i;
        this.mBufferOffset = 0;
        return true;
    }

    private void ensureNotClosed() throws java.io.IOException {
        if (this.mClosed) {
            throw new java.io.IOException("stream already closed");
        }
    }

    protected void finalize() throws java.lang.Throwable {
        if (!this.mClosed) {
            com.facebook.common.logging.FLog.e(TAG, "Finalized without closing");
            close();
        }
        super.finalize();
    }
}
