package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
class AesCipherOutputStream extends net.lingala.zip4j.io.outputstream.CipherOutputStream<net.lingala.zip4j.crypto.AESEncrypter> {
    private byte[] pendingBuffer;
    private int pendingBufferLength;

    public AesCipherOutputStream(net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException {
        super(zipEntryOutputStream, zipParameters, cArr, z);
        this.pendingBuffer = new byte[16];
        this.pendingBufferLength = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public net.lingala.zip4j.crypto.AESEncrypter initializeEncrypter(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException {
        net.lingala.zip4j.crypto.AESEncrypter aESEncrypter = new net.lingala.zip4j.crypto.AESEncrypter(cArr, zipParameters.getAesKeyStrength(), z);
        writeAesEncryptionHeaderData(aESEncrypter);
        return aESEncrypter;
    }

    private void writeAesEncryptionHeaderData(net.lingala.zip4j.crypto.AESEncrypter aESEncrypter) throws java.io.IOException {
        writeHeaders(aESEncrypter.getSaltBytes());
        writeHeaders(aESEncrypter.getDerivedPasswordVerifier());
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i});
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        int i4 = this.pendingBufferLength;
        if (i2 >= 16 - i4) {
            java.lang.System.arraycopy(bArr, i, this.pendingBuffer, i4, 16 - i4);
            byte[] bArr2 = this.pendingBuffer;
            super.write(bArr2, 0, bArr2.length);
            int i5 = 16 - this.pendingBufferLength;
            int i6 = i2 - i5;
            this.pendingBufferLength = 0;
            if (i6 != 0 && (i3 = i6 % 16) != 0) {
                java.lang.System.arraycopy(bArr, (i6 + i5) - i3, this.pendingBuffer, 0, i3);
                this.pendingBufferLength = i3;
                i6 -= i3;
            }
            super.write(bArr, i5, i6);
            return;
        }
        java.lang.System.arraycopy(bArr, i, this.pendingBuffer, i4, i2);
        this.pendingBufferLength += i2;
    }

    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public void closeEntry() throws java.io.IOException {
        int i = this.pendingBufferLength;
        if (i != 0) {
            super.write(this.pendingBuffer, 0, i);
            this.pendingBufferLength = 0;
        }
        writeHeaders(getEncrypter().getFinalMac());
        super.closeEntry();
    }
}
