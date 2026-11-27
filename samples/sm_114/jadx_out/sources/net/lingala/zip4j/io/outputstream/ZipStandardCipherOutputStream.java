package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
class ZipStandardCipherOutputStream extends net.lingala.zip4j.io.outputstream.CipherOutputStream<net.lingala.zip4j.crypto.StandardEncrypter> {
    public ZipStandardCipherOutputStream(net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException {
        super(zipEntryOutputStream, zipParameters, cArr, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public net.lingala.zip4j.crypto.StandardEncrypter initializeEncrypter(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException {
        net.lingala.zip4j.crypto.StandardEncrypter standardEncrypter = new net.lingala.zip4j.crypto.StandardEncrypter(cArr, getEncryptionKey(zipParameters), z);
        writeHeaders(standardEncrypter.getHeaderBytes());
        return standardEncrypter;
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
        super.write(bArr, i, i2);
    }

    private long getEncryptionKey(net.lingala.zip4j.model.ZipParameters zipParameters) {
        if (zipParameters.isWriteExtendedLocalFileHeader()) {
            return (net.lingala.zip4j.util.Zip4jUtil.epochToExtendedDosTime(zipParameters.getLastModifiedFileTime()) & 65535) << 16;
        }
        return zipParameters.getEntryCRC();
    }
}
