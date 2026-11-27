package net.lingala.zip4j.crypto;

/* JADX INFO: loaded from: classes2.dex */
public class AESDecrypter implements net.lingala.zip4j.crypto.Decrypter {
    private net.lingala.zip4j.crypto.engine.AESEngine aesEngine;
    private net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF mac;
    private int nonce = 1;
    private byte[] iv = new byte[16];
    private byte[] counterBlock = new byte[16];

    public AESDecrypter(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord, char[] cArr, byte[] bArr, byte[] bArr2, boolean z) throws net.lingala.zip4j.exception.ZipException {
        init(bArr, bArr2, cArr, aESExtraDataRecord, z);
    }

    private void init(byte[] bArr, byte[] bArr2, char[] cArr, net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("empty or null password provided for AES decryption", net.lingala.zip4j.exception.ZipException.Type.WRONG_PASSWORD);
        }
        net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength = aESExtraDataRecord.getAesKeyStrength();
        byte[] bArrDerivePasswordBasedKey = net.lingala.zip4j.crypto.AesCipherUtil.derivePasswordBasedKey(bArr, cArr, aesKeyStrength, z);
        if (!java.util.Arrays.equals(bArr2, net.lingala.zip4j.crypto.AesCipherUtil.derivePasswordVerifier(bArrDerivePasswordBasedKey, aesKeyStrength))) {
            throw new net.lingala.zip4j.exception.ZipException("Wrong Password", net.lingala.zip4j.exception.ZipException.Type.WRONG_PASSWORD);
        }
        this.aesEngine = net.lingala.zip4j.crypto.AesCipherUtil.getAESEngine(bArrDerivePasswordBasedKey, aesKeyStrength);
        this.mac = net.lingala.zip4j.crypto.AesCipherUtil.getMacBasedPRF(bArrDerivePasswordBasedKey, aesKeyStrength);
    }

    @Override // net.lingala.zip4j.crypto.Decrypter
    public int decryptData(byte[] bArr, int i, int i2) throws net.lingala.zip4j.exception.ZipException {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            this.mac.update(bArr, i3, i6);
            net.lingala.zip4j.crypto.AesCipherUtil.prepareBuffAESIVBytes(this.iv, this.nonce);
            this.aesEngine.processBlock(this.iv, this.counterBlock);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i3 + i7;
                bArr[i8] = (byte) (bArr[i8] ^ this.counterBlock[i7]);
            }
            this.nonce++;
            i3 = i5;
        }
    }

    public byte[] getCalculatedAuthenticationBytes(int i) {
        return this.mac.doFinal(i);
    }
}
