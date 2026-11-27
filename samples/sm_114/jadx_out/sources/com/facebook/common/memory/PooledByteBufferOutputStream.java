package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class PooledByteBufferOutputStream extends java.io.OutputStream {
    public abstract int size();

    public abstract com.facebook.common.memory.PooledByteBuffer toByteBuffer();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        try {
            super.close();
        } catch (java.io.IOException e) {
            com.facebook.common.internal.Throwables.propagate(e);
        }
    }
}
