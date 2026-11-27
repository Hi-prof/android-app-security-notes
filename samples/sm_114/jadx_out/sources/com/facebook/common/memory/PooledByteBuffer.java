package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public interface PooledByteBuffer extends java.io.Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @javax.annotation.Nullable
    java.nio.ByteBuffer getByteBuffer();

    long getNativePtr();

    boolean isClosed();

    byte read(int i);

    int read(int i, byte[] bArr, int i2, int i3);

    int size();

    public static class ClosedException extends java.lang.RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }
}
