package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashManager {
    public static void initNativeCrash(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(context.getExternalCacheDir(), "dcCrashDump");
            if (!file.exists()) {
                file.mkdirs();
            }
            com.sample.breakpad.BreakpadInit.initBreakpad(file.getAbsolutePath());
        } catch (java.lang.Exception unused) {
        }
    }
}
