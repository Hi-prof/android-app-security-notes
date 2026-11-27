package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class AshmemMemoryChunk implements com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable {
    private static final java.lang.String TAG = "AshmemMemoryChunk";

    @javax.annotation.Nullable
    private java.nio.ByteBuffer mByteBuffer;
    private final long mId;

    @javax.annotation.Nullable
    private android.os.SharedMemory mSharedMemory;

    public AshmemMemoryChunk(int i) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        try {
            android.os.SharedMemory sharedMemoryCreate = android.os.SharedMemory.create(TAG, i);
            this.mSharedMemory = sharedMemoryCreate;
            this.mByteBuffer = sharedMemoryCreate.mapReadWrite();
            this.mId = java.lang.System.identityHashCode(this);
        } catch (android.system.ErrnoException e) {
            throw new java.lang.RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    public AshmemMemoryChunk() {
        this.mSharedMemory = null;
        this.mByteBuffer = null;
        this.mId = java.lang.System.identityHashCode(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            android.os.SharedMemory sharedMemory = this.mSharedMemory;
            if (sharedMemory != null) {
                sharedMemory.close();
            }
            java.nio.ByteBuffer byteBuffer = this.mByteBuffer;
            if (byteBuffer != null) {
                android.os.SharedMemory.unmap(byteBuffer);
            }
            this.mByteBuffer = null;
            this.mSharedMemory = null;
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.mByteBuffer == null || this.mSharedMemory == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        com.facebook.common.internal.Preconditions.checkNotNull(this.mSharedMemory);
        return this.mSharedMemory.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int iAdjustByteCount;
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        com.facebook.common.internal.Preconditions.checkNotNull(this.mByteBuffer);
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, getSize());
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, getSize());
        this.mByteBuffer.position(i);
        this.mByteBuffer.put(bArr, i2, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int iAdjustByteCount;
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        com.facebook.common.internal.Preconditions.checkNotNull(this.mByteBuffer);
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, getSize());
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, getSize());
        this.mByteBuffer.position(i);
        this.mByteBuffer.get(bArr, i2, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i) {
        boolean z = true;
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        if (i >= getSize()) {
            z = false;
        }
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(z));
        com.facebook.common.internal.Preconditions.checkNotNull(this.mByteBuffer);
        return this.mByteBuffer.get(i);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new java.lang.UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @javax.annotation.Nullable
    public java.nio.ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mId;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, com.facebook.imagepipeline.memory.MemoryChunk memoryChunk, int i2, int i3) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            android.util.Log.w(TAG, "Copying from AshmemMemoryChunk " + java.lang.Long.toHexString(getUniqueId()) + " to AshmemMemoryChunk " + java.lang.Long.toHexString(memoryChunk.getUniqueId()) + " which are the same ");
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

    private void doCopy(int i, com.facebook.imagepipeline.memory.MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof com.facebook.imagepipeline.memory.AshmemMemoryChunk)) {
            throw new java.lang.IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkState(!memoryChunk.isClosed());
        com.facebook.common.internal.Preconditions.checkNotNull(this.mByteBuffer);
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk.getByteBuffer());
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, getSize());
        this.mByteBuffer.position(i);
        memoryChunk.getByteBuffer().position(i2);
        byte[] bArr = new byte[i3];
        this.mByteBuffer.get(bArr, 0, i3);
        memoryChunk.getByteBuffer().put(bArr, 0, i3);
    }
}
