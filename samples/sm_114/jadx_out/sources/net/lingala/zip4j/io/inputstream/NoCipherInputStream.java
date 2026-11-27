package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
class NoCipherInputStream extends net.lingala.zip4j.io.inputstream.CipherInputStream<net.lingala.zip4j.io.inputstream.NoCipherInputStream.NoDecrypter> {
    public NoCipherInputStream(net.lingala.zip4j.io.inputstream.ZipEntryInputStream zipEntryInputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, int i) throws java.io.IOException {
        super(zipEntryInputStream, localFileHeader, cArr, i, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.inputstream.CipherInputStream
    public net.lingala.zip4j.io.inputstream.NoCipherInputStream.NoDecrypter initializeDecrypter(net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, boolean z) {
        return new net.lingala.zip4j.io.inputstream.NoCipherInputStream.NoDecrypter();
    }

    static class NoDecrypter implements net.lingala.zip4j.crypto.Decrypter {
        @Override // net.lingala.zip4j.crypto.Decrypter
        public int decryptData(byte[] bArr, int i, int i2) {
            return i2;
        }

        NoDecrypter() {
        }
    }
}
