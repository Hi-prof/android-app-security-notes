package com.facebook.imagepipeline.memory;

/* JADX INFO: compiled from: MemoryPooledByteBufferFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferFactory;", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pool", "Lcom/facebook/imagepipeline/memory/MemoryChunkPool;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "<init>", "(Lcom/facebook/imagepipeline/memory/MemoryChunkPool;Lcom/facebook/common/memory/PooledByteStreams;)V", "newByteBuffer", "Lcom/facebook/imagepipeline/memory/MemoryPooledByteBuffer;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "inputStream", "Ljava/io/InputStream;", "bytes", "", "initialCapacity", "newByteBuf", "outputStream", "Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream;", "newOutputStream", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryPooledByteBufferFactory implements com.facebook.common.memory.PooledByteBufferFactory {
    private final com.facebook.imagepipeline.memory.MemoryChunkPool pool;
    private final com.facebook.common.memory.PooledByteStreams pooledByteStreams;

    public MemoryPooledByteBufferFactory(com.facebook.imagepipeline.memory.MemoryChunkPool pool, com.facebook.common.memory.PooledByteStreams pooledByteStreams) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pool, "pool");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        this.pool = pool;
        this.pooledByteStreams = pooledByteStreams;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBuffer newByteBuffer(int size) {
        if (size <= 0) {
            throw new java.lang.IllegalStateException("Check failed.".toString());
        }
        com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(this.pool.get(size), this.pool);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
        try {
            return new com.facebook.imagepipeline.memory.MemoryPooledByteBuffer(closeableReferenceOf, size);
        } finally {
            closeableReferenceOf.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBuffer newByteBuffer(java.io.InputStream inputStream) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream(this.pool, 0, 2, null);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBuffer newByteBuffer(byte[] bytes) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bytes, "bytes");
        com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream(this.pool, bytes.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bytes, 0, bytes.length);
                com.facebook.imagepipeline.memory.MemoryPooledByteBuffer byteBuffer = memoryPooledByteBufferOutputStream.toByteBuffer();
                memoryPooledByteBufferOutputStream.close();
                return byteBuffer;
            } catch (java.io.IOException e) {
                throw com.facebook.common.internal.Throwables.propagate(e);
            }
        } catch (java.lang.Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBuffer newByteBuffer(java.io.InputStream inputStream, int initialCapacity) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream(this.pool, initialCapacity);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    public final com.facebook.imagepipeline.memory.MemoryPooledByteBuffer newByteBuf(java.io.InputStream inputStream, com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream outputStream) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        this.pooledByteStreams.copy(inputStream, outputStream);
        return outputStream.toByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream newOutputStream() {
        return new com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream(this.pool, 0, 2, null);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream newOutputStream(int initialCapacity) {
        return new com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream(this.pool, initialCapacity);
    }
}
