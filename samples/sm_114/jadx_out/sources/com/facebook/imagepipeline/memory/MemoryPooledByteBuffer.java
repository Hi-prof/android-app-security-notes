package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class MemoryPooledByteBuffer implements com.facebook.common.memory.PooledByteBuffer {

    @javax.annotation.Nullable
    com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.memory.MemoryChunk> mBufRef;
    private final int mSize;

    public MemoryPooledByteBuffer(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.memory.MemoryChunk> closeableReference, int i) {
        com.facebook.common.internal.Preconditions.checkNotNull(closeableReference);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0 && i <= closeableReference.get().getSize()));
        this.mBufRef = closeableReference.mo248clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int i) {
        ensureValid();
        boolean z = true;
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        if (i >= this.mSize) {
            z = false;
        }
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(z));
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBufRef);
        return this.mBufRef.get().read(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i + i3 <= this.mSize));
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBufRef);
        return this.mBufRef.get().read(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long getNativePtr() throws java.lang.UnsupportedOperationException {
        ensureValid();
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBufRef);
        return this.mBufRef.get().getNativePtr();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    @javax.annotation.Nullable
    public synchronized java.nio.ByteBuffer getByteBuffer() {
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBufRef);
        return this.mBufRef.get().getByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.CloseableReference.isValid(this.mBufRef);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
    }

    synchronized void ensureValid() {
        if (isClosed()) {
            throw new com.facebook.common.memory.PooledByteBuffer.ClosedException();
        }
    }

    @javax.annotation.Nullable
    com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.memory.MemoryChunk> getCloseableReference() {
        return this.mBufRef;
    }
}
