package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s4 {
    public static byte[] a(java.lang.String str) {
        byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return bytes;
    }

    public static java.lang.String b(java.lang.String str) {
        return a(f(str));
    }

    public static java.lang.String c(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? str : a(android.util.Base64.decode(str, 2));
    }

    public static java.lang.String d(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("GBK");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 8);
            }
            return new java.lang.String(bytes, "GBK");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String e(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? str : android.util.Base64.encodeToString(a(str), 2);
    }

    public static byte[] f(java.lang.String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        java.lang.String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (java.lang.Integer.parseInt(lowerCase.substring(i2, i2 + 2), 16) & 255);
        }
        return bArr;
    }

    public static java.lang.String a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 8);
        }
        return new java.lang.String(bArr, java.nio.charset.StandardCharsets.UTF_8);
    }
}
