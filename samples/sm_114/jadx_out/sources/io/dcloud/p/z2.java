package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z2 extends io.dcloud.common.adapter.util.Logger {
    private static java.lang.String a;
    private static java.io.File b;
    private static java.lang.Boolean c = java.lang.Boolean.TRUE;

    private static void WriteLogToSDcard(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.lang.String strGenerateLog = io.dcloud.common.adapter.util.Logger.generateLog(str, str2, str3);
        if (b == null || strGenerateLog == null) {
            return;
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(b, true);
                    try {
                        fileOutputStream.write(strGenerateLog.getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.io.IOException e4) {
            e4.printStackTrace();
        }
    }

    public static void a(java.lang.String str) {
        if (c.booleanValue()) {
            a = str;
            storeLogToSDcard();
            c = java.lang.Boolean.FALSE;
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.util.Log.d(str, str2);
        WriteLogToSDcard(io.dcloud.common.adapter.util.Logger.D, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.util.Log.e(str, str2);
        WriteLogToSDcard(io.dcloud.common.adapter.util.Logger.E, str, str2);
    }

    public static void i(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.util.Log.i(str, str2);
        WriteLogToSDcard(io.dcloud.common.adapter.util.Logger.I, str, str2);
    }

    public static void storeLogToSDcard() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(a).append(java.io.File.separatorChar).append(io.dcloud.common.adapter.util.Logger.generateTimeStamp(java.lang.Boolean.FALSE)).append(".log");
        java.io.File file = new java.io.File(a);
        b = new java.io.File(stringBuffer.toString());
        if (file.exists()) {
            io.dcloud.common.adapter.util.Logger.deleteOldLog(file);
        } else {
            file.mkdirs();
        }
        if (b.exists()) {
            return;
        }
        try {
            b.createNewFile();
        } catch (java.io.IOException e) {
            b = null;
            e.printStackTrace();
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.util.Log.i(str, str2);
        WriteLogToSDcard(io.dcloud.common.adapter.util.Logger.W, str, str2);
    }
}
