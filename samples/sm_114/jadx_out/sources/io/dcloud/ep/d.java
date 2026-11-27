package io.dcloud.ep;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    private static java.lang.String a = "RSA";

    public static byte[] a(byte[] bArr, java.security.PublicKey publicKey) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            int blockSize = cipher.getBlockSize();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(bArr.length);
            int i = 0;
            while (true) {
                int i2 = i * blockSize;
                if (bArr.length - i2 <= 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(cipher.doFinal(bArr, i2, blockSize));
                i++;
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.security.PublicKey a(java.lang.String str) throws java.lang.Exception {
        try {
            return (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(str, 0)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.cf.R.string.dcloud_feature_confusion_exception_no_key_input));
        } catch (java.security.NoSuchAlgorithmException unused2) {
            throw new java.lang.Exception(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.cf.R.string.dcloud_feature_confusion_exception_no_algorithm));
        } catch (java.security.spec.InvalidKeySpecException unused3) {
            throw new java.lang.Exception(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.cf.R.string.dcloud_feature_confusion_exception_invalid_key));
        }
    }
}
