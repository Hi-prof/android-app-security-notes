package com.facebook.imagepipeline.platform;

/* JADX INFO: loaded from: classes.dex */
public class GingerbreadPurgeableDecoder extends com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder {
    private static java.lang.reflect.Method sGetFileDescriptorMethod;

    @javax.annotation.Nullable
    private final com.facebook.common.webp.WebpBitmapFactory mWebpBitmapFactory = com.facebook.common.webp.WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected android.graphics.Bitmap decodeByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, android.graphics.BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected android.graphics.Bitmap decodeJPEGByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i, android.graphics.BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i, endsWithEOI(closeableReference, i) ? null : EOI, options);
    }

    private static android.os.MemoryFile copyToMemoryFile(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i, @javax.annotation.Nullable byte[] bArr) throws java.lang.Throwable {
        java.io.OutputStream outputStream;
        com.facebook.common.streams.LimitedInputStream limitedInputStream;
        com.facebook.common.memory.PooledByteBufferInputStream pooledByteBufferInputStream = null;
        java.io.OutputStream outputStream2 = null;
        android.os.MemoryFile memoryFile = new android.os.MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            com.facebook.common.memory.PooledByteBufferInputStream pooledByteBufferInputStream2 = new com.facebook.common.memory.PooledByteBufferInputStream(closeableReference.get());
            try {
                limitedInputStream = new com.facebook.common.streams.LimitedInputStream(pooledByteBufferInputStream2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    com.facebook.common.internal.ByteStreams.copy(limitedInputStream, outputStream2);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                    com.facebook.common.internal.Closeables.closeQuietly(pooledByteBufferInputStream2);
                    com.facebook.common.internal.Closeables.closeQuietly(limitedInputStream);
                    com.facebook.common.internal.Closeables.close(outputStream2, true);
                    return memoryFile;
                } catch (java.lang.Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                    com.facebook.common.internal.Closeables.closeQuietly(pooledByteBufferInputStream);
                    com.facebook.common.internal.Closeables.closeQuietly(limitedInputStream);
                    com.facebook.common.internal.Closeables.close(outputStream, true);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    private synchronized java.lang.reflect.Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = android.os.MemoryFile.class.getDeclaredMethod("getFileDescriptor", null);
            } catch (java.lang.Exception e) {
                throw com.facebook.common.internal.Throwables.propagate(e);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private java.io.FileDescriptor getMemoryFileDescriptor(android.os.MemoryFile memoryFile) {
        try {
            return (java.io.FileDescriptor) com.facebook.common.internal.Preconditions.checkNotNull(getFileDescriptorMethod().invoke(memoryFile, null));
        } catch (java.lang.Exception e) {
            throw com.facebook.common.internal.Throwables.propagate(e);
        }
    }

    private android.graphics.Bitmap decodeFileDescriptorAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i, @javax.annotation.Nullable byte[] bArr, android.graphics.BitmapFactory.Options options) throws java.lang.Throwable {
        android.os.MemoryFile memoryFile = null;
        try {
            try {
                android.os.MemoryFile memoryFileCopyToMemoryFile = copyToMemoryFile(closeableReference, i, bArr);
                try {
                    java.io.FileDescriptor memoryFileDescriptor = getMemoryFileDescriptor(memoryFileCopyToMemoryFile);
                    com.facebook.common.webp.WebpBitmapFactory webpBitmapFactory = this.mWebpBitmapFactory;
                    if (webpBitmapFactory != null) {
                        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) com.facebook.common.internal.Preconditions.checkNotNull(webpBitmapFactory.decodeFileDescriptor(memoryFileDescriptor, null, options), "BitmapFactory returned null");
                        if (memoryFileCopyToMemoryFile != null) {
                            memoryFileCopyToMemoryFile.close();
                        }
                        return bitmap;
                    }
                    throw new java.lang.IllegalStateException("WebpBitmapFactory is null");
                } catch (java.io.IOException e) {
                    e = e;
                    memoryFile = memoryFileCopyToMemoryFile;
                    throw com.facebook.common.internal.Throwables.propagate(e);
                } catch (java.lang.Throwable th) {
                    th = th;
                    memoryFile = memoryFileCopyToMemoryFile;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
