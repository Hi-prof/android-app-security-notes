package io.dcloud.feature.cf;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
public class cFeatureImpl {
    public static java.util.Map<java.lang.String, java.lang.String> getData(java.lang.String str) {
        return io.dcloud.ep.c.a().a(str);
    }

    public static java.io.InputStream getEncryptionInputStream(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        return io.dcloud.ep.c.a(str, iApp);
    }

    public static java.lang.String getString(char[] cArr) {
        return io.dcloud.ep.StringU.getString(cArr);
    }

    public static java.lang.String handleEncryption(android.content.Context context, byte[] bArr) {
        return io.dcloud.ep.c.a(context, bArr);
    }

    public static void recordEncryptionResources(java.lang.String str, org.json.JSONObject jSONObject) {
        io.dcloud.ep.c.a(str, jSONObject);
    }

    public static void removeData(java.lang.String str) {
        io.dcloud.ep.c.a().b(str);
    }

    public static java.lang.String getString(char[] cArr, int i) {
        return io.dcloud.ep.StringU.getString(cArr, i);
    }
}
