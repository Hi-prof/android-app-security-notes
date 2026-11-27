package org.mozilla.universalchardet;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EncodingDetectorOutputStream extends java.io.OutputStream {
    private final org.mozilla.universalchardet.UniversalDetector detector = new org.mozilla.universalchardet.UniversalDetector(null);
    private java.io.OutputStream out;

    public EncodingDetectorOutputStream(java.io.OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.out.close();
        this.detector.dataEnd();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.out.flush();
    }

    public java.lang.String getDetectedCharset() {
        return this.detector.getDetectedCharset();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.out.write(bArr, i, i2);
        if (this.detector.isDone()) {
            return;
        }
        this.detector.handleData(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i});
    }
}
