package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public class InflaterInputStream extends net.lingala.zip4j.io.inputstream.DecompressedInputStream {
    private byte[] buff;
    private java.util.zip.Inflater inflater;
    private int len;
    private byte[] singleByteBuffer;

    public InflaterInputStream(net.lingala.zip4j.io.inputstream.CipherInputStream<?> cipherInputStream, int i) {
        super(cipherInputStream);
        this.singleByteBuffer = new byte[1];
        this.inflater = new java.util.zip.Inflater(true);
        this.buff = new byte[i];
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0];
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream, java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        while (true) {
            try {
                int iInflate = this.inflater.inflate(bArr, i, i2);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                    if (this.inflater.needsInput()) {
                        fill();
                    }
                }
                return -1;
            } catch (java.util.zip.DataFormatException e) {
                throw new java.io.IOException(e);
            }
        }
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream
    public void endOfEntryReached(java.io.InputStream inputStream, int i) throws java.io.IOException {
        java.util.zip.Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
            this.inflater = null;
        }
        super.endOfEntryReached(inputStream, i);
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream
    public int pushBackInputStreamIfNecessary(java.io.PushbackInputStream pushbackInputStream) throws java.io.IOException {
        int remaining = this.inflater.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(getLastReadRawDataCache(), this.len - remaining, remaining);
        }
        return remaining;
    }

    @Override // net.lingala.zip4j.io.inputstream.DecompressedInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.util.zip.Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    private void fill() throws java.io.IOException {
        byte[] bArr = this.buff;
        int i = super.read(bArr, 0, bArr.length);
        this.len = i;
        if (i == -1) {
            throw new java.io.EOFException("Unexpected end of input stream");
        }
        this.inflater.setInput(this.buff, 0, i);
    }
}
