package org.mozilla.universalchardet;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EncodingDetectorInputStream extends java.io.InputStream {
    private final org.mozilla.universalchardet.UniversalDetector detector = new org.mozilla.universalchardet.UniversalDetector(null);
    private java.io.InputStream in;

    public EncodingDetectorInputStream(java.io.InputStream inputStream) {
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.in.close();
    }

    public java.lang.String getDetectedCharset() {
        return this.detector.getDetectedCharset();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) >= 0) {
            return bArr[0];
        }
        return -1;
    }

    @Override // java.io.InputStream
    public void reset() throws java.io.IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        if (this.detector.isDone()) {
            return this.in.skip(j);
        }
        int i = 0;
        long j2 = -1;
        for (long j3 = 0; j3 < j && i >= 0; j3++) {
            i = this.in.read();
            j2++;
        }
        return j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (!this.detector.isDone() && i3 > 0) {
            this.detector.handleData(bArr, i, i3);
        }
        if (i3 == -1) {
            this.detector.dataEnd();
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }
}
