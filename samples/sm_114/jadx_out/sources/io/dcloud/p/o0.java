package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 {
    private static java.lang.String a = "";
    private static java.lang.String b = "";

    private static boolean a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return !android.text.TextUtils.isEmpty((java.lang.String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    public static java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    private static java.lang.String d(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getDeclaredMethod("get", java.lang.String.class).invoke(cls, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ec, code lost:
    
        if (r6.equals("XIAOMI") != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0101, code lost:
    
        if (r6.equals("REALME") != false) goto L59;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.p.o0.e(java.lang.String):void");
    }

    public static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : str.replaceAll(com.taobao.weex.el.parse.Operators.SPACE_STR, "").toUpperCase();
    }
}
