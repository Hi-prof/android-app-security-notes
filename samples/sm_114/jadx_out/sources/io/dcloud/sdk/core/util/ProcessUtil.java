package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtil {
    private static java.lang.String a;

    public static java.lang.String getCurrentProcessName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        java.lang.String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        a = currentProcessNameByApplication;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByApplication)) {
            return a;
        }
        java.lang.String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        a = currentProcessNameByActivityThread;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return a;
        }
        java.lang.String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        a = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    public static java.lang.String getCurrentProcessNameByActivityManager(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = android.os.Process.myPid();
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static java.lang.String getCurrentProcessNameByActivityThread() {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread", false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            java.lang.Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof java.lang.String) {
                return (java.lang.String) objInvoke;
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getCurrentProcessNameByApplication() {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return android.app.Application.getProcessName();
        }
        return null;
    }

    public static boolean isMainProcess(android.content.Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageName().equals(getCurrentProcessName(context));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
