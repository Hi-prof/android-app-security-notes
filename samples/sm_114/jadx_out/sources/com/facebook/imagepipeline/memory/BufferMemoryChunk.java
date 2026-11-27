package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class BufferMemoryChunk implements com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable {
    private static final java.lang.String TAG = "BufferMemoryChunk";

    @javax.annotation.Nullable
    private java.nio.ByteBuffer mBuffer;
    private final long mId = java.lang.System.identityHashCode(this);
    private final int mSize;

    public BufferMemoryChunk(int i) {
        this.mBuffer = java.nio.ByteBuffer.allocateDirect(i);
        this.mSize = i;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mBuffer = null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.mBuffer == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.mSize;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int iAdjustByteCount;
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBuffer);
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, this.mSize);
        this.mBuffer.position(i);
        this.mBuffer.put(bArr, i2, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int iAdjustByteCount;
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBuffer);
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, this.mSize);
        this.mBuffer.position(i);
        this.mBuffer.get(bArr, i2, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i) {
        boolean z = true;
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        if (i >= this.mSize) {
            z = false;
        }
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(z));
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBuffer);
        return this.mBuffer.get(i);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, com.facebook.imagepipeline.memory.MemoryChunk memoryChunk, int i2, int i3) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            android.util.Log.w(TAG, "Copying from BufferMemoryChunk " + java.lang.Long.toHexString(getUniqueId()) + " to BufferMemoryChunk " + java.lang.Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ");
            com.facebook.common.internal.Preconditions.checkArgument(false);
        }
        if (memoryChunk.getUniqueId() < getUniqueId()) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    doCopy(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    doCopy(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new java.lang.UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @javax.annotation.Nullable
    public synchronized java.nio.ByteBuffer getByteBuffer() {
        return this.mBuffer;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mId;
    }

    private void doCopy(int i, com.facebook.imagepipeline.memory.MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof com.facebook.imagepipeline.memory.BufferMemoryChunk)) {
            throw new java.lang.IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkState(!memoryChunk.isClosed());
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBuffer);
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, this.mSize);
        this.mBuffer.position(i);
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk.getByteBuffer());
        byteBuffer.position(i2);
        byte[] bArr = new byte[i3];
        this.mBuffer.get(bArr, 0, i3);
        byteBuffer.put(bArr, 0, i3);
    }
}
