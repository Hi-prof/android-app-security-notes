package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBufferUtil {
    private static final java.util.concurrent.atomic.AtomicReference<byte[]> BUFFER_REF = new java.util.concurrent.atomic.AtomicReference<>();
    private static final int BUFFER_SIZE = 16384;

    private ByteBufferUtil() {
    }

    public static java.nio.ByteBuffer fromFile(java.io.File file) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.RandomAccessFile randomAccessFile;
        java.nio.channels.FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new java.io.IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new java.io.IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new java.io.RandomAccessFile(file, "r");
            try {
                java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
                try {
                    java.nio.MappedByteBuffer mappedByteBufferLoad = channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (java.io.IOException unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static void toFile(java.nio.ByteBuffer byteBuffer, java.io.File file) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile;
        rewind(byteBuffer);
        java.nio.channels.FileChannel channel = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException unused2) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (java.io.IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void toStream(java.nio.ByteBuffer byteBuffer, java.io.OutputStream outputStream) throws java.io.IOException {
        com.bumptech.glide.util.ByteBufferUtil.SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null) {
            outputStream.write(safeArray.data, safeArray.offset, safeArray.offset + safeArray.limit);
            return;
        }
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int iMin = java.lang.Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, iMin);
            outputStream.write(andSet, 0, iMin);
        }
        BUFFER_REF.set(andSet);
    }

    public static byte[] toBytes(java.nio.ByteBuffer byteBuffer) {
        com.bumptech.glide.util.ByteBufferUtil.SafeArray safeArray = getSafeArray(byteBuffer);
        if (safeArray != null && safeArray.offset == 0 && safeArray.limit == safeArray.data.length) {
            return byteBuffer.array();
        }
        java.nio.ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        rewind(byteBufferAsReadOnlyBuffer);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static java.io.InputStream toStream(java.nio.ByteBuffer byteBuffer) {
        return new com.bumptech.glide.util.ByteBufferUtil.ByteBufferStream(byteBuffer);
    }

    public static java.nio.ByteBuffer fromStream(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        byte[] andSet = BUFFER_REF.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i = inputStream.read(andSet);
            if (i >= 0) {
                byteArrayOutputStream.write(andSet, 0, i);
            } else {
                BUFFER_REF.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return rewind(java.nio.ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    public static java.nio.ByteBuffer rewind(java.nio.ByteBuffer byteBuffer) {
        return (java.nio.ByteBuffer) byteBuffer.position(0);
    }

    private static com.bumptech.glide.util.ByteBufferUtil.SafeArray getSafeArray(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new com.bumptech.glide.util.ByteBufferUtil.SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        SafeArray(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    private static class ByteBufferStream extends java.io.InputStream {
        private static final int UNSET = -1;
        private final java.nio.ByteBuffer byteBuffer;
        private int markPos = -1;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        ByteBufferStream(java.nio.ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.byteBuffer.hasRemaining()) {
                return this.byteBuffer.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.markPos = this.byteBuffer.position();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!this.byteBuffer.hasRemaining()) {
                return -1;
            }
            int iMin = java.lang.Math.min(i2, available());
            this.byteBuffer.get(bArr, i, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws java.io.IOException {
            int i = this.markPos;
            if (i == -1) {
                throw new java.io.IOException("Cannot reset to unset mark position");
            }
            this.byteBuffer.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.byteBuffer.hasRemaining()) {
                return -1L;
            }
            long jMin = java.lang.Math.min(j, available());
            java.nio.ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }
    }
}
