package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e1 {
    private static io.dcloud.common.DHInterface.IConfusionMgr a;

    public static void a(io.dcloud.common.DHInterface.INativeAppInfo iNativeAppInfo) {
        if (iNativeAppInfo != null) {
            a = iNativeAppInfo.getCofusionMgr();
        }
    }

    public static java.lang.String b(java.lang.String str, boolean z, int i) {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.encodeString(str, z, i);
        }
        return null;
    }

    public static java.lang.String c() {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.getSK();
        }
        return null;
    }

    public static java.lang.String d() {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.getSPK();
        }
        return null;
    }

    public static java.lang.String e() {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.getSQK();
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str, boolean z, int i) {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.decodeString(str, z, i);
        }
        return null;
    }

    public static java.lang.String b(java.lang.String str) {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.decryptStr(str);
        }
        return null;
    }

    public static java.lang.String a(android.content.Context context, byte[] bArr) {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.handleEncryption(context, bArr);
        }
        return null;
    }

    public static java.lang.String b() {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.getSIV();
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str) {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.decodeString(str);
        }
        return null;
    }

    public static java.lang.String a() {
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = a;
        if (iConfusionMgr != null) {
            return iConfusionMgr.getS5DS();
        }
        return null;
    }
}
