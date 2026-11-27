package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public class PooledByteStreams {
    private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
    private final com.facebook.common.memory.ByteArrayPool mByteArrayPool;
    private final int mTempBufSize;

    public PooledByteStreams(com.facebook.common.memory.ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 16384);
    }

    public PooledByteStreams(com.facebook.common.memory.ByteArrayPool byteArrayPool, int i) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        this.mTempBufSize = i;
        this.mByteArrayPool = byteArrayPool;
    }

    public long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.mTempBufSize);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                    j += (long) i;
                } else {
                    this.mByteArrayPool.release(bArr);
                    return j;
                }
            } catch (java.lang.Throwable th) {
                this.mByteArrayPool.release(bArr);
                throw th;
            }
        }
    }

    public long copy(java.io.InputStream inputStream, java.io.OutputStream outputStream, long j) throws java.io.IOException {
        long j2 = 0;
        com.facebook.common.internal.Preconditions.checkState(j > 0);
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        while (j2 < j) {
            try {
                int i = inputStream.read(bArr, 0, (int) java.lang.Math.min(this.mTempBufSize, j - j2));
                if (i == -1) {
                    break;
                }
                outputStream.write(bArr, 0, i);
                j2 += (long) i;
            } catch (java.lang.Throwable th) {
                this.mByteArrayPool.release(bArr);
                throw th;
            }
        }
        this.mByteArrayPool.release(bArr);
        return j2;
    }
}
