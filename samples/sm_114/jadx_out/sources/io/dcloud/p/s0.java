package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 {
    private static boolean a = false;

    public static io.dcloud.p.w4 a(io.dcloud.p.v2.c cVar, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(context);
        return new io.dcloud.p.w4(cVar, context, str, str2, str3, str4);
    }

    private static void a(android.content.Context context) {
        java.io.File[] fileArrListFiles;
        if (a) {
            return;
        }
        a = true;
        if (context != null) {
            try {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - 604800000;
                java.io.File file = new java.io.File(context.getCacheDir().getAbsolutePath() + "/dcloud_ad/img/");
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                    return;
                }
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.lastModified() < jCurrentTimeMillis) {
                        file2.delete();
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
