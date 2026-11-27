package dc.squareup.okhttp3.internal.cache2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final dc.squareup.okio.ByteString PREFIX_CLEAN = dc.squareup.okio.ByteString.encodeUtf8("OkHttp cache v1\n");
    static final dc.squareup.okio.ByteString PREFIX_DIRTY = dc.squareup.okio.ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    java.io.RandomAccessFile file;
    private final dc.squareup.okio.ByteString metadata;
    int sourceCount;
    dc.squareup.okio.Source upstream;
    long upstreamPos;
    java.lang.Thread upstreamReader;
    final dc.squareup.okio.Buffer upstreamBuffer = new dc.squareup.okio.Buffer();
    final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RelaySource implements dc.squareup.okio.Source {
        private dc.squareup.okhttp3.internal.cache2.FileOperator fileOperator;
        private long sourcePos;
        private final dc.squareup.okio.Timeout timeout = new dc.squareup.okio.Timeout();

        RelaySource() {
            this.fileOperator = new dc.squareup.okhttp3.internal.cache2.FileOperator(dc.squareup.okhttp3.internal.cache2.Relay.this.file.getChannel());
        }

        @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.fileOperator == null) {
                return;
            }
            java.io.RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (dc.squareup.okhttp3.internal.cache2.Relay.this) {
                dc.squareup.okhttp3.internal.cache2.Relay relay = dc.squareup.okhttp3.internal.cache2.Relay.this;
                int i = relay.sourceCount - 1;
                relay.sourceCount = i;
                if (i == 0) {
                    java.io.RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // dc.squareup.okio.Source
        public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            dc.squareup.okhttp3.internal.cache2.Relay relay;
            if (this.fileOperator == null) {
                throw new java.lang.IllegalStateException("closed");
            }
            synchronized (dc.squareup.okhttp3.internal.cache2.Relay.this) {
                while (true) {
                    long j2 = this.sourcePos;
                    dc.squareup.okhttp3.internal.cache2.Relay relay2 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                    long j3 = relay2.upstreamPos;
                    if (j2 != j3) {
                        long size = j3 - relay2.buffer.size();
                        long j4 = this.sourcePos;
                        if (j4 < size) {
                            long jMin = java.lang.Math.min(j, j3 - j4);
                            this.fileOperator.read(this.sourcePos + 32, buffer, jMin);
                            this.sourcePos += jMin;
                            return jMin;
                        }
                        long jMin2 = java.lang.Math.min(j, j3 - j4);
                        dc.squareup.okhttp3.internal.cache2.Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin2);
                        this.sourcePos += jMin2;
                        return jMin2;
                    }
                    if (relay2.complete) {
                        return -1L;
                    }
                    if (relay2.upstreamReader == null) {
                        relay2.upstreamReader = java.lang.Thread.currentThread();
                        try {
                            dc.squareup.okhttp3.internal.cache2.Relay relay3 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                            long j5 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                            if (j5 == -1) {
                                dc.squareup.okhttp3.internal.cache2.Relay.this.commit(j3);
                                synchronized (dc.squareup.okhttp3.internal.cache2.Relay.this) {
                                    dc.squareup.okhttp3.internal.cache2.Relay relay4 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                    relay4.upstreamReader = null;
                                    relay4.notifyAll();
                                }
                                return -1L;
                            }
                            long jMin3 = java.lang.Math.min(j5, j);
                            dc.squareup.okhttp3.internal.cache2.Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                            this.sourcePos += jMin3;
                            this.fileOperator.write(j3 + 32, dc.squareup.okhttp3.internal.cache2.Relay.this.upstreamBuffer.m405clone(), j5);
                            synchronized (dc.squareup.okhttp3.internal.cache2.Relay.this) {
                                dc.squareup.okhttp3.internal.cache2.Relay relay5 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                relay5.buffer.write(relay5.upstreamBuffer, j5);
                                long size2 = dc.squareup.okhttp3.internal.cache2.Relay.this.buffer.size();
                                dc.squareup.okhttp3.internal.cache2.Relay relay6 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                if (size2 > relay6.bufferMaxSize) {
                                    dc.squareup.okio.Buffer buffer2 = relay6.buffer;
                                    buffer2.skip(buffer2.size() - dc.squareup.okhttp3.internal.cache2.Relay.this.bufferMaxSize);
                                }
                                relay = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                relay.upstreamPos += j5;
                            }
                            synchronized (relay) {
                                dc.squareup.okhttp3.internal.cache2.Relay relay7 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                relay7.upstreamReader = null;
                                relay7.notifyAll();
                            }
                            return jMin3;
                        } catch (java.lang.Throwable th) {
                            synchronized (dc.squareup.okhttp3.internal.cache2.Relay.this) {
                                dc.squareup.okhttp3.internal.cache2.Relay relay8 = dc.squareup.okhttp3.internal.cache2.Relay.this;
                                relay8.upstreamReader = null;
                                relay8.notifyAll();
                                throw th;
                            }
                        }
                    }
                    this.timeout.waitUntilNotified(relay2);
                }
            }
        }

        @Override // dc.squareup.okio.Source
        public dc.squareup.okio.Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(java.io.RandomAccessFile randomAccessFile, dc.squareup.okio.Source source, long j, dc.squareup.okio.ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static dc.squareup.okhttp3.internal.cache2.Relay edit(java.io.File file, dc.squareup.okio.Source source, dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        dc.squareup.okhttp3.internal.cache2.Relay relay = new dc.squareup.okhttp3.internal.cache2.Relay(randomAccessFile, source, 0L, byteString, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static dc.squareup.okhttp3.internal.cache2.Relay read(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        dc.squareup.okhttp3.internal.cache2.FileOperator fileOperator = new dc.squareup.okhttp3.internal.cache2.FileOperator(randomAccessFile.getChannel());
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        fileOperator.read(0L, buffer, 32L);
        dc.squareup.okio.ByteString byteString = PREFIX_CLEAN;
        if (!buffer.readByteString(byteString.size()).equals(byteString)) {
            throw new java.io.IOException("unreadable cache file");
        }
        long j = buffer.readLong();
        long j2 = buffer.readLong();
        dc.squareup.okio.Buffer buffer2 = new dc.squareup.okio.Buffer();
        fileOperator.read(32 + j, buffer2, j2);
        return new dc.squareup.okhttp3.internal.cache2.Relay(randomAccessFile, null, j, buffer2.readByteString(), 0L);
    }

    private void writeHeader(dc.squareup.okio.ByteString byteString, long j, long j2) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() != 32) {
            throw new java.lang.IllegalArgumentException();
        }
        new dc.squareup.okhttp3.internal.cache2.FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
    }

    private void writeMetadata(long j) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        buffer.write(this.metadata);
        new dc.squareup.okhttp3.internal.cache2.FileOperator(this.file.getChannel()).write(32 + j, buffer, this.metadata.size());
    }

    void commit(long j) throws java.io.IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    boolean isClosed() {
        return this.file == null;
    }

    public dc.squareup.okio.ByteString metadata() {
        return this.metadata;
    }

    public dc.squareup.okio.Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new dc.squareup.okhttp3.internal.cache2.Relay.RelaySource();
        }
    }
}
