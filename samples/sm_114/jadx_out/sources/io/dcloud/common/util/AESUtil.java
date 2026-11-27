package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AESUtil {
    private static javax.crypto.Cipher createCipher(int i, byte[] bArr, java.lang.String str, byte[] bArr2) throws java.lang.Exception {
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(str);
        if (bArr2 == null) {
            bArr2 = new byte[cipher.getBlockSize()];
        }
        cipher.init(i, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr2));
        return cipher;
    }

    public static java.lang.String decrypt(java.lang.String str, java.lang.String str2, byte[] bArr) {
        try {
            return new java.lang.String(decrypt(str.getBytes(), str2.getBytes(), bArr));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return encrypt(str, str2, str3.getBytes());
    }

    public static java.lang.String getDefaultTransformation() {
        return io.dcloud.p.e1.b("IM['KJK'XCK[=Xillafo");
    }

    public static byte[] encrypt(java.lang.String str, java.lang.String str2, byte[] bArr) {
        try {
            return encrypt(str.getBytes(), bArr, getDefaultTransformation(), str2 != null ? str2.getBytes() : null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws java.lang.Exception {
        return createCipher(2, bArr, getDefaultTransformation(), bArr2).doFinal(bArr3);
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2, java.lang.String str, byte[] bArr3) throws java.lang.Exception {
        return createCipher(1, bArr, str, bArr3).doFinal(bArr2);
    }
}
