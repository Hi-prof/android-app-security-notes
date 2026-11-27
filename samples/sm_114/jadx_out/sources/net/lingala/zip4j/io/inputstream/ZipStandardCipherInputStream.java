package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
class ZipStandardCipherInputStream extends net.lingala.zip4j.io.inputstream.CipherInputStream<net.lingala.zip4j.crypto.StandardDecrypter> {
    public ZipStandardCipherInputStream(net.lingala.zip4j.io.inputstream.ZipEntryInputStream zipEntryInputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, int i, boolean z) throws java.io.IOException {
        super(zipEntryInputStream, localFileHeader, cArr, i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public net.lingala.zip4j.crypto.StandardDecrypter initializeDecrypter(net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, boolean z) throws java.io.IOException {
        return new net.lingala.zip4j.crypto.StandardDecrypter(cArr, localFileHeader.getCrc(), localFileHeader.getLastModifiedTime(), getStandardDecrypterHeaderBytes(), z);
    }

    private byte[] getStandardDecrypterHeaderBytes() throws java.io.IOException {
        byte[] bArr = new byte[12];
        readRaw(bArr);
        return bArr;
    }
}
