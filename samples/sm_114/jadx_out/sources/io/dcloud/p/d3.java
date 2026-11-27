package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d3 {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String a(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(io.dcloud.common.util.Md5Utils.ALGORITHM);
            messageDigest.update(str.getBytes("UTF-8"));
            return a(messageDigest.digest());
        } catch (java.io.UnsupportedEncodingException | java.security.NoSuchAlgorithmException | java.lang.Exception unused) {
            return str;
        }
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            char[] cArr = a;
            sb.append(cArr[(b & 240) >> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }
}
