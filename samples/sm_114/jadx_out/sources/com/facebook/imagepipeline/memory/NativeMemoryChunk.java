package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class NativeMemoryChunk implements com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable {
    private static final java.lang.String TAG = "NativeMemoryChunk";
    private boolean mIsClosed;
    private final long mNativePtr;
    private final int mSize;

    private static native long nativeAllocate(int i);

    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    private static native void nativeFree(long j);

    private static native void nativeMemcpy(long j, long j2, int i);

    private static native byte nativeReadByte(long j);

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @javax.annotation.Nullable
    public java.nio.ByteBuffer getByteBuffer() {
        return null;
    }

    static {
        com.facebook.soloader.nativeloader.NativeLoader.loadLibrary(com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader.DSO_NAME);
    }

    public NativeMemoryChunk(int i) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        this.mSize = i;
        this.mNativePtr = nativeAllocate(i);
        this.mIsClosed = false;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0L;
        this.mIsClosed = true;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mIsClosed) {
            this.mIsClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.mIsClosed;
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
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, this.mSize);
        nativeCopyFromByteArray(this.mNativePtr + ((long) i), bArr, i2, iAdjustByteCount);
        return iAdjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int iAdjustByteCount;
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        iAdjustByteCount = com.facebook.imagepipeline.memory.MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, bArr.length, i2, iAdjustByteCount, this.mSize);
        nativeCopyToByteArray(this.mNativePtr + ((long) i), bArr, i2, iAdjustByteCount);
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
        return nativeReadByte(this.mNativePtr + ((long) i));
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, com.facebook.imagepipeline.memory.MemoryChunk memoryChunk, int i2, int i3) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            android.util.Log.w(TAG, "Copying from NativeMemoryChunk " + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " to NativeMemoryChunk " + java.lang.Integer.toHexString(java.lang.System.identityHashCode(memoryChunk)) + " which share the same address " + java.lang.Long.toHexString(this.mNativePtr));
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
        if (!(memoryChunk instanceof com.facebook.imagepipeline.memory.NativeMemoryChunk)) {
            throw new java.lang.IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        com.facebook.common.internal.Preconditions.checkState(!isClosed());
        com.facebook.common.internal.Preconditions.checkState(!memoryChunk.isClosed());
        com.facebook.imagepipeline.memory.MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, this.mSize);
        nativeMemcpy(memoryChunk.getNativePtr() + ((long) i2), this.mNativePtr + ((long) i), i3);
    }

    protected void finalize() throws java.lang.Throwable {
        if (isClosed()) {
            return;
        }
        android.util.Log.w(TAG, "finalize: Chunk " + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
