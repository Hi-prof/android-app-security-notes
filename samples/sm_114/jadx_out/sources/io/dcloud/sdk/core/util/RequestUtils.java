package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RequestUtils {
    public static java.lang.String get(android.content.Context context, java.lang.String str) {
        return io.dcloud.p.e4.a(context, "dcloud-ads", str);
    }

    public static java.lang.String getDid(android.content.Context context) {
        return io.dcloud.p.u4.a(context, true, true);
    }

    public static java.lang.String getOid(android.content.Context context) {
        return io.dcloud.p.m3.a().c(context);
    }

    public static java.lang.String getPost(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(str), str2, str3), 2);
    }

    public static byte[] httpGet(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        return io.dcloud.p.l3.a(str, (java.util.HashMap) map, true);
    }

    public static byte[] httpPost(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        return io.dcloud.p.l3.a(str, str2, map);
    }

    public static java.lang.String mc(android.content.Context context) {
        return io.dcloud.p.l0.a(context);
    }

    public static void postMessage(java.lang.Runnable runnable) {
        io.dcloud.p.a3.a().post(runnable);
    }

    public static void save(android.content.Context context, java.lang.String str, java.lang.String str2) {
        io.dcloud.p.e4.a(context, "dcloud-ads", str, str2);
    }
}
