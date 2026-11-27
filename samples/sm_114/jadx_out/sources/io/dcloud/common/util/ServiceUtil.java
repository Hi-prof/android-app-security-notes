package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ServiceUtil {
    public static boolean isServiceRunning(android.content.Context context, java.lang.Class<?> cls) {
        java.util.Iterator<android.app.ActivityManager.RunningServiceInfo> it = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningServices(1024).iterator();
        while (it.hasNext()) {
            if (cls.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
