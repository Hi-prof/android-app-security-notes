package com.bun.miitmdid.core;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static final java.lang.String CPU_ABI_X86 = "x86";

    private static java.lang.String CPUABI() {
        try {
            return new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine().contains("x86") ? "x86" : "arm";
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "arm";
        }
    }

    public static void PrintClassMethod(java.lang.Class<?> cls) {
        for (java.lang.reflect.Method method : cls.getMethods()) {
            java.lang.System.out.println(method.getName());
        }
    }

    public static void PrintObjectType(java.lang.Class<?> cls) {
        java.lang.String name = cls.getName();
        java.lang.System.out.println("PrintObjectType:" + name);
    }

    public static void PrintObjectType(java.lang.Object obj) {
        java.lang.String name = obj.getClass().getName();
        java.lang.System.out.println("PrintObjectType:" + name);
    }

    public static long getFileCRC(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return -1L;
            }
            int length = (int) file.length();
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i += fileInputStream.read(bArr, i, length - i)) {
            }
            crc32.update(length);
            return crc32.getValue();
        } catch (java.io.IOException unused) {
            return -1L;
        }
    }

    public static void getFileListame(java.lang.String str) {
        java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                android.util.Log.i("Utils", fileArrListFiles[i].getName());
                if (fileArrListFiles[i].isDirectory()) {
                    getFileListame(fileArrListFiles[i].getAbsolutePath());
                    android.util.Log.i("Utils", java.lang.String.valueOf(fileArrListFiles[i].getAbsolutePath()) + fileArrListFiles[i].getName());
                }
            }
        }
    }

    public static java.lang.String getLibraryDir(android.content.Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    public static java.lang.String getUserDir(android.content.Context context) {
        return context.getFilesDir().getParent();
    }

    public static java.lang.String getXdataDir(android.content.Context context, java.lang.String str) {
        return new java.lang.StringBuffer().append(java.lang.String.valueOf(getUserDir(context)) + "/" + com.bun.miitmdid.core.JLibrary.xdata + "/" + str).toString();
    }

    public static java.lang.String getYdataDir(android.content.Context context, java.lang.String str) {
        return new java.lang.StringBuffer().append(java.lang.String.valueOf(getUserDir(context)) + "/" + com.bun.miitmdid.core.JLibrary.ydata + "/" + str).toString();
    }

    public static boolean isX86() {
        return android.os.Build.CPU_ABI.equals("x86") || CPUABI().equals("x86");
    }

    public static boolean update(android.content.Context context) throws java.lang.Exception {
        long zipCrc = com.bun.miitmdid.core.ZipUtils.getZipCrc(new java.io.File(context.getApplicationInfo().sourceDir));
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("update", 0);
        boolean z = zipCrc != sharedPreferences.getLong("crc", 0L);
        sharedPreferences.edit().putLong("crc", zipCrc).commit();
        return z;
    }

    public static void x0xooXdata(java.io.InputStream inputStream, java.lang.String str, android.content.Context context) throws java.lang.Exception {
        java.io.File file = new java.io.File(str);
        byte[] bArr = new byte[65536];
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i <= 0) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
                return;
            }
            bufferedOutputStream.write(bArr, 0, i);
        }
    }
}
