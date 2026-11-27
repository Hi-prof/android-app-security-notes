package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f1 {
    private static java.lang.String a;
    private static java.lang.String b;

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(b)) {
            try {
                b = a("@\\ED=XD][Z]F\\AEM");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static java.lang.String b() {
        if (android.text.TextUtils.isEmpty(a)) {
            try {
                a = a("LKdg}l.:\"8V9+>88");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    private static java.lang.String a(java.lang.String str) throws java.io.UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return new java.lang.String(bytes, "GBK");
    }
}
