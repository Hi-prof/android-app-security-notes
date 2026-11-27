package com.facebook.common.util;

/* JADX INFO: loaded from: classes.dex */
public class SecureHashUtil {
    private static final int BUFFER_SIZE = 4096;
    static final byte[] HEX_CHAR_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static java.lang.String makeSHA1Hash(java.lang.String str) {
        try {
            return makeSHA1Hash(str.getBytes("utf-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String makeSHA1Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-1");
    }

    public static java.lang.String makeSHA256Hash(byte[] bArr) {
        return makeHash(bArr, "SHA-256");
    }

    public static java.lang.String makeSHA1HashBase64(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr, 0, bArr.length);
            return android.util.Base64.encodeToString(messageDigest.digest(), 11);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String makeMD5Hash(java.lang.String str) {
        try {
            return makeMD5Hash(str.getBytes("utf-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String makeMD5Hash(byte[] bArr) {
        return makeHash(bArr, io.dcloud.common.util.Md5Utils.ALGORITHM);
    }

    public static java.lang.String makeMD5Hash(java.io.InputStream inputStream) throws java.io.IOException {
        return makeHash(inputStream, io.dcloud.common.util.Md5Utils.ALGORITHM);
    }

    public static java.lang.String convertToHex(byte[] bArr) throws java.io.UnsupportedEncodingException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length);
        for (byte b : bArr) {
            byte[] bArr2 = HEX_CHAR_TABLE;
            sb.append((char) bArr2[(b & 255) >>> 4]);
            sb.append((char) bArr2[b & 15]);
        }
        return sb.toString();
    }

    private static java.lang.String makeHash(byte[] bArr, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            messageDigest.update(bArr, 0, bArr.length);
            return convertToHex(messageDigest.digest());
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.security.NoSuchAlgorithmException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    private static java.lang.String makeHash(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    return convertToHex(messageDigest.digest());
                }
            }
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.security.NoSuchAlgorithmException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }
}
