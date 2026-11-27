package io.dcloud.ep;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
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

    public static byte[] b(java.lang.String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (java.lang.Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
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

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        byte[] bArrB;
        try {
            bArrB = b(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            bArrB = null;
        }
        byte[] bArrA = a(bArrB, str2, str3);
        if (bArrA == null) {
            return null;
        }
        try {
            return new java.lang.String(bArrA, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
