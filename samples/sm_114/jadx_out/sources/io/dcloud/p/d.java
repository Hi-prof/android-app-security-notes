package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    private static javax.crypto.spec.IvParameterSpec a(java.lang.String str) {
        byte[] bytes;
        if (str == null) {
            str = "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bytes = stringBuffer.toString().getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            bytes = null;
        }
        return new javax.crypto.spec.IvParameterSpec(bytes);
    }

    public static byte[] b(byte[] bArr, java.lang.String str, java.lang.String str2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, a(str2));
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, java.lang.String str, java.lang.String str2) {
        try {
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(), "AES");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, a(str2));
            return cipher.doFinal(bArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
