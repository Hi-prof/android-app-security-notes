package net.lingala.zip4j.crypto;

/* JADX INFO: loaded from: classes2.dex */
public class AesCipherUtil {
    private static final int START_INDEX = 0;

    public static byte[] derivePasswordBasedKey(byte[] bArr, char[] cArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength, boolean z) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine pBKDF2Engine = new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Engine(new net.lingala.zip4j.crypto.PBKDF2.PBKDF2Parameters(net.lingala.zip4j.util.InternalZipConstants.AES_MAC_ALGORITHM, net.lingala.zip4j.util.InternalZipConstants.AES_HASH_CHARSET, bArr, 1000));
        int keyLength = aesKeyStrength.getKeyLength();
        int macLength = aesKeyStrength.getMacLength();
        int i = keyLength + macLength + 2;
        byte[] bArrDeriveKey = pBKDF2Engine.deriveKey(cArr, i, z);
        if (bArrDeriveKey == null || bArrDeriveKey.length != i) {
            throw new net.lingala.zip4j.exception.ZipException(java.lang.String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", java.lang.Integer.valueOf(keyLength), java.lang.Integer.valueOf(macLength)));
        }
        return bArrDeriveKey;
    }

    public static byte[] derivePasswordVerifier(byte[] bArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength) {
        byte[] bArr2 = new byte[2];
        java.lang.System.arraycopy(bArr, aesKeyStrength.getKeyLength() + aesKeyStrength.getMacLength(), bArr2, 0, 2);
        return bArr2;
    }

    public static net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF getMacBasedPRF(byte[] bArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength) {
        int macLength = aesKeyStrength.getMacLength();
        byte[] bArr2 = new byte[macLength];
        java.lang.System.arraycopy(bArr, aesKeyStrength.getKeyLength(), bArr2, 0, macLength);
        net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF macBasedPRF = new net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF(net.lingala.zip4j.util.InternalZipConstants.AES_MAC_ALGORITHM);
        macBasedPRF.init(bArr2);
        return macBasedPRF;
    }

    public static net.lingala.zip4j.crypto.engine.AESEngine getAESEngine(byte[] bArr, net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength) throws net.lingala.zip4j.exception.ZipException {
        int keyLength = aesKeyStrength.getKeyLength();
        byte[] bArr2 = new byte[keyLength];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, keyLength);
        return new net.lingala.zip4j.crypto.engine.AESEngine(bArr2);
    }

    public static void prepareBuffAESIVBytes(byte[] bArr, int i) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
        for (int i2 = 4; i2 <= 15; i2++) {
            bArr[i2] = 0;
        }
    }
}
