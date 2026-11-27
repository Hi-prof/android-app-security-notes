package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class d1 {
    private static java.lang.String[] a = {"sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2"};

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class b {
        public int a;
        public java.lang.String b;

        public b(int i, java.lang.String str) {
            this.a = i;
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class c {
        private static final io.dcloud.p.d1 a = new io.dcloud.p.d1();
    }

    private java.lang.String b(java.lang.String str) {
        java.lang.String strA = a(str);
        if (android.text.TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA;
    }

    private io.dcloud.p.d1.b c() {
        java.lang.String strB = b("ro.build.flavor");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        java.lang.String lowerCase = strB.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.p.d1.b((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, strB);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0026  */
    private io.dcloud.p.d1.b d() {
        java.lang.String strB = b("ro.hardware");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        java.lang.String lowerCase = strB.toLowerCase(java.util.Locale.ENGLISH);
        lowerCase.getClass();
        lowerCase.hashCode();
        int i = 2;
        switch (lowerCase) {
            case "cancro":
            case "vbox86":
            case "nox":
            case "ttvm":
            case "vbox":
            case "intel":
            case "android_x86":
                i = 1;
                break;
        }
        return new io.dcloud.p.d1.b(i, strB);
    }

    private io.dcloud.p.d1.b e() {
        java.lang.String strB = b("ro.product.manufacturer");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        java.lang.String lowerCase = strB.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.p.d1.b((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, strB);
    }

    private io.dcloud.p.d1.b f() {
        java.lang.String strB = b("ro.product.model");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        java.lang.String lowerCase = strB.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.p.d1.b((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, strB);
    }

    private io.dcloud.p.d1.b g() {
        java.lang.String strB = b("ro.board.platform");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        return new io.dcloud.p.d1.b(strB.toLowerCase(java.util.Locale.ENGLISH).contains(com.taobao.weex.WXEnvironment.OS) ? 1 : 2, strB);
    }

    public static io.dcloud.p.d1.b h() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 2;
        while (true) {
            java.lang.String[] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            if (new java.io.File(strArr[i2]).exists()) {
                i3++;
            } else {
                i4 = 0;
            }
            if (i3 > 2) {
                break;
            }
            i2++;
        }
        if (i3 != 1) {
            i = i3 != 2 ? i4 : 1;
        }
        return new io.dcloud.p.d1.b(i, "PkgName");
    }

    public static final io.dcloud.p.d1 i() {
        return io.dcloud.p.d1.c.a;
    }

    public boolean a(android.content.Context context) {
        int i;
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context must not be null");
        }
        int i2 = d().a;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 == 1) {
                return true;
            }
            i = 0;
        }
        int i3 = h().a;
        if (i3 == 0) {
            i++;
        } else if (i3 == 1) {
            return true;
        }
        int i4 = c().a;
        if (i4 == 0) {
            i++;
        } else if (i4 == 1) {
            return true;
        }
        int i5 = f().a;
        if (i5 == 0) {
            i++;
        } else if (i5 == 1) {
            return true;
        }
        int i6 = e().a;
        if (i6 == 0) {
            i++;
        } else if (i6 == 1) {
            return true;
        }
        int i7 = b().a;
        if (i7 == 0) {
            i++;
        } else if (i7 == 1) {
            return true;
        }
        int i8 = g().a;
        if (i8 == 0) {
            i++;
        } else if (i8 == 1) {
            return true;
        }
        int i9 = a().a;
        if (i9 == 0) {
            i += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (!c(context)) {
            i++;
        }
        if (!b(context)) {
            i++;
        }
        return i > 3;
    }

    private d1() {
    }

    private io.dcloud.p.d1.b b() {
        java.lang.String strB = b("ro.product.board");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        java.lang.String lowerCase = strB.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.p.d1.b((lowerCase.contains(com.taobao.weex.WXEnvironment.OS) || lowerCase.contains("goldfish")) ? 1 : 2, strB);
    }

    private boolean c(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private boolean b(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private java.lang.String a(java.lang.String str) {
        try {
            java.lang.Object objInvoke = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class).invoke(null, str);
            if (objInvoke != null) {
                return (java.lang.String) objInvoke;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private io.dcloud.p.d1.b a() {
        java.lang.String strB = b("gsm.version.baseband");
        if (strB == null) {
            return new io.dcloud.p.d1.b(0, null);
        }
        return new io.dcloud.p.d1.b(strB.contains("1.0.0.0") ? 1 : 2, strB);
    }
}
