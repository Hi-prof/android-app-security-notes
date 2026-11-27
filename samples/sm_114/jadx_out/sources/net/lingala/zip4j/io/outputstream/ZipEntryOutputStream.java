package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
class ZipEntryOutputStream extends java.io.OutputStream {
    private java.io.OutputStream outputStream;
    private long numberOfBytesWrittenForThisEntry = 0;
    private boolean entryClosed = false;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
    }

    public ZipEntryOutputStream(java.io.OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.entryClosed) {
            throw new java.lang.IllegalStateException("ZipEntryOutputStream is closed");
        }
        this.outputStream.write(bArr, i, i2);
        this.numberOfBytesWrittenForThisEntry += (long) i2;
    }

    public void closeEntry() throws java.io.IOException {
        this.entryClosed = true;
    }

    public long getNumberOfBytesWrittenForThisEntry() {
        return this.numberOfBytesWrittenForThisEntry;
    }
}
