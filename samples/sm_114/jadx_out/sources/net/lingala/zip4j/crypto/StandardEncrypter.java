package net.lingala.zip4j.crypto;

/* JADX INFO: loaded from: classes2.dex */
public class StandardEncrypter implements net.lingala.zip4j.crypto.Encrypter {
    private byte[] headerBytes;
    private final net.lingala.zip4j.crypto.engine.ZipCryptoEngine zipCryptoEngine = new net.lingala.zip4j.crypto.engine.ZipCryptoEngine();

    public StandardEncrypter(char[] cArr, long j, boolean z) throws net.lingala.zip4j.exception.ZipException {
        init(cArr, j, z);
    }

    private void init(char[] cArr, long j, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.zipCryptoEngine.initKeys(cArr, z);
        this.headerBytes = generateRandomBytes();
        this.zipCryptoEngine.initKeys(cArr, z);
        byte[] bArr = this.headerBytes;
        bArr[11] = (byte) (j >>> 24);
        bArr[10] = (byte) (j >>> 16);
        encryptData(bArr);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        bArr.getClass();
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        if (i2 < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invalid length specified to decrpyt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            bArr[i3] = encryptByte(bArr[i3]);
        }
        return i2;
    }

    protected byte encryptByte(byte b) {
        byte bDecryptByte = (byte) ((this.zipCryptoEngine.decryptByte() & 255) ^ b);
        this.zipCryptoEngine.updateKeys(b);
        return bDecryptByte;
    }

    protected byte[] generateRandomBytes() {
        byte[] bArr = new byte[12];
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        for (int i = 0; i < 12; i++) {
            bArr[i] = encryptByte((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}
