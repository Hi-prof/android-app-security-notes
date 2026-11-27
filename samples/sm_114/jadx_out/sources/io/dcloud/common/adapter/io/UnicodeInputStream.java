package io.dcloud.common.adapter.io;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeInputStream extends java.io.InputStream {
    private static final int BOM_SIZE = 4;
    java.lang.String defaultEnc;
    java.lang.String encoding;
    java.io.PushbackInputStream internalIn;
    boolean isInited = false;

    public UnicodeInputStream(java.io.InputStream inputStream, java.lang.String str) {
        this.internalIn = new java.io.PushbackInputStream(inputStream, 4);
        this.defaultEnc = str;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.isInited = true;
        this.internalIn.close();
    }

    public java.lang.String getDefaultEncoding() {
        return this.defaultEnc;
    }

    public java.lang.String getEncoding() throws java.lang.Throwable {
        if (!this.isInited) {
            try {
                init();
            } catch (java.io.IOException unused) {
                java.lang.Throwable illegalStateException = new java.lang.IllegalStateException("Init method failed.");
                illegalStateException.initCause(illegalStateException);
                throw illegalStateException;
            }
        }
        return this.encoding;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    protected void init() throws java.io.IOException {
        int i;
        if (this.isInited) {
            return;
        }
        byte[] bArr = new byte[4];
        int i2 = this.internalIn.read(bArr, 0, 4);
        byte b = bArr[0];
        if (b != 0 || bArr[1] != 0 || bArr[2] != -2 || bArr[3] != -1) {
            if (b == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0) {
                this.encoding = "UTF-32LE";
            } else if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
                this.encoding = "UTF-8";
                i = i2 - 3;
            } else {
                if (b == -2 && bArr[1] == -1) {
                    this.encoding = "UTF-16BE";
                } else if (b == -1 && bArr[1] == -2) {
                    this.encoding = "UTF-16LE";
                } else {
                    this.encoding = this.defaultEnc;
                    i = i2;
                }
                i = i2 - 2;
            }
            if (i > 0) {
                this.internalIn.unread(bArr, i2 - i, i);
            }
            this.isInited = true;
        }
        this.encoding = "UTF-32BE";
        i = i2 - 4;
        if (i > 0) {
            this.internalIn.unread(bArr, i2 - i, i);
        }
        this.isInited = true;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        init();
        this.isInited = true;
        return this.internalIn.read();
    }
}
