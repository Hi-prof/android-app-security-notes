package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtil {
    private static java.lang.String currentProcessName;

    public static java.lang.String getCurrentProcessName(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return currentProcessName;
        }
        java.lang.String currentProcessNameByCmdline = getCurrentProcessNameByCmdline();
        currentProcessName = currentProcessNameByCmdline;
        if (!android.text.TextUtils.isEmpty(currentProcessNameByCmdline)) {
            return currentProcessName;
        }
        java.lang.String packageName = context.getPackageName();
        currentProcessName = packageName;
        return packageName;
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

    public static java.lang.String getCurrentProcessNameByCmdline() {
        java.io.FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new java.io.FileInputStream("/proc/self/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i = 0;
                    while (true) {
                        int i2 = fileInputStream.read();
                        if (i2 <= 0 || i >= 256) {
                            break;
                        }
                        bArr[i] = (byte) i2;
                        i++;
                    }
                    if (i > 0) {
                        java.lang.String str = new java.lang.String(bArr, 0, i, "UTF-8");
                        try {
                            fileInputStream.close();
                            return str;
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                            return str;
                        }
                    }
                    fileInputStream.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (java.lang.Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        return null;
    }
}
