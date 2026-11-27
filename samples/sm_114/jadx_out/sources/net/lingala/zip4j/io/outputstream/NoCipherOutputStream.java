package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
class NoCipherOutputStream extends net.lingala.zip4j.io.outputstream.CipherOutputStream<net.lingala.zip4j.io.outputstream.NoCipherOutputStream.NoEncrypter> {
    public NoCipherOutputStream(net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr) throws java.io.IOException {
        super(zipEntryOutputStream, zipParameters, cArr, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.io.outputstream.CipherOutputStream
    public net.lingala.zip4j.io.outputstream.NoCipherOutputStream.NoEncrypter initializeEncrypter(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) {
        return new net.lingala.zip4j.io.outputstream.NoCipherOutputStream.NoEncrypter();
    }

    static class NoEncrypter implements net.lingala.zip4j.crypto.Encrypter {
        @Override // net.lingala.zip4j.crypto.Encrypter
        public int encryptData(byte[] bArr, int i, int i2) {
            return i2;
        }

        NoEncrypter() {
        }

        @Override // net.lingala.zip4j.crypto.Encrypter
        public int encryptData(byte[] bArr) {
            return encryptData(bArr, 0, bArr.length);
        }
    }
}
