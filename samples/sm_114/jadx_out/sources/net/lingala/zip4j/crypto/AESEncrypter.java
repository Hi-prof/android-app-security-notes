package net.lingala.zip4j.crypto;

/* JADX INFO: loaded from: classes2.dex */
public class AESEncrypter implements net.lingala.zip4j.crypto.Encrypter {
    private net.lingala.zip4j.crypto.engine.AESEngine aesEngine;
    private final byte[] counterBlock;
    private byte[] derivedPasswordVerifier;
    private boolean finished;
    private final byte[] iv;
    private net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF mac;
    private byte[] saltBytes;
    private final java.security.SecureRandom random = new java.security.SecureRandom();
    private int nonce = 1;
    private int loopCount = 0;

    public AESEncrypter(char[] cArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length == 0) {
            throw new net.lingala.zip4j.exception.ZipException("input password is empty or null");
        }
        if (aesKeyStrength != net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_128 && aesKeyStrength != net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid AES key strength");
        }
        this.finished = false;
        this.counterBlock = new byte[16];
        this.iv = new byte[16];
        init(cArr, aesKeyStrength, z);
    }

    private void init(char[] cArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength, boolean z) throws net.lingala.zip4j.exception.ZipException {
        byte[] bArrGenerateSalt = generateSalt(aesKeyStrength.getSaltLength());
        this.saltBytes = bArrGenerateSalt;
        byte[] bArrDerivePasswordBasedKey = net.lingala.zip4j.crypto.AesCipherUtil.derivePasswordBasedKey(bArrGenerateSalt, cArr, aesKeyStrength, z);
        this.derivedPasswordVerifier = net.lingala.zip4j.crypto.AesCipherUtil.derivePasswordVerifier(bArrDerivePasswordBasedKey, aesKeyStrength);
        this.aesEngine = net.lingala.zip4j.crypto.AesCipherUtil.getAESEngine(bArrDerivePasswordBasedKey, aesKeyStrength);
        this.mac = net.lingala.zip4j.crypto.AesCipherUtil.getMacBasedPRF(bArrDerivePasswordBasedKey, aesKeyStrength);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        if (bArr == null) {
            throw new net.lingala.zip4j.exception.ZipException("input bytes are null, cannot perform AES encryption");
        }
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.Encrypter
    public int encryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        int i3;
        if (this.finished) {
            throw new net.lingala.zip4j.exception.ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (i2 % 16 != 0) {
            this.finished = true;
        }
        int i4 = i;
        while (true) {
            int i5 = i + i2;
            if (i4 >= i5) {
                return i2;
            }
            int i6 = i4 + 16;
            this.loopCount = i6 <= i5 ? 16 : i5 - i4;
            net.lingala.zip4j.crypto.AesCipherUtil.prepareBuffAESIVBytes(this.iv, this.nonce);
            this.aesEngine.processBlock(this.iv, this.counterBlock);
            int i7 = 0;
            while (true) {
                i3 = this.loopCount;
                if (i7 < i3) {
                    int i8 = i4 + i7;
                    bArr[i8] = (byte) (bArr[i8] ^ this.counterBlock[i7]);
                    i7++;
                }
            }
            this.mac.update(bArr, i4, i3);
            this.nonce++;
            i4 = i6;
        }
    }

    private byte[] generateSalt(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i != 8 && i != 16) {
            throw new net.lingala.zip4j.exception.ZipException("invalid salt size, cannot generate salt");
        }
        int i2 = i == 8 ? 2 : 4;
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt = this.random.nextInt();
            int i4 = i3 * 4;
            bArr[i4] = (byte) (iNextInt >> 24);
            bArr[i4 + 1] = (byte) (iNextInt >> 16);
            bArr[i4 + 2] = (byte) (iNextInt >> 8);
            bArr[i4 + 3] = (byte) iNextInt;
        }
        return bArr;
    }

    public byte[] getFinalMac() {
        byte[] bArr = new byte[10];
        java.lang.System.arraycopy(this.mac.doFinal(), 0, bArr, 0, 10);
        return bArr;
    }

    public byte[] getDerivedPasswordVerifier() {
        return this.derivedPasswordVerifier;
    }

    public byte[] getSaltBytes() {
        return this.saltBytes;
    }
}
