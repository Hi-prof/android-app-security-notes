package com.nostra13.dcloudimageloader.cache.disc.naming;

/* JADX INFO: loaded from: classes.dex */
public class Md5FileNameGenerator implements com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator {
    private static final java.lang.String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    @Override // com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator
    public java.lang.String generate(java.lang.String str) {
        return new java.math.BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }

    private byte[] getMD5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (java.security.NoSuchAlgorithmException e) {
            com.nostra13.dcloudimageloader.utils.L.e(e);
            return null;
        }
    }
}
