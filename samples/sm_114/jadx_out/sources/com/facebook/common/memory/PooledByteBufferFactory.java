package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public interface PooledByteBufferFactory {
    com.facebook.common.memory.PooledByteBuffer newByteBuffer(int i);

    com.facebook.common.memory.PooledByteBuffer newByteBuffer(java.io.InputStream inputStream) throws java.io.IOException;

    com.facebook.common.memory.PooledByteBuffer newByteBuffer(java.io.InputStream inputStream, int i) throws java.io.IOException;

    com.facebook.common.memory.PooledByteBuffer newByteBuffer(byte[] bArr);

    com.facebook.common.memory.PooledByteBufferOutputStream newOutputStream();

    com.facebook.common.memory.PooledByteBufferOutputStream newOutputStream(int i);
}
