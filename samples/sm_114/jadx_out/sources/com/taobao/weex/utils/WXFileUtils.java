package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXFileUtils {
    public static java.lang.String loadFileOrAsset(java.lang.String str, android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(str)) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                try {
                    return readStreamToString(new java.io.FileInputStream(file));
                } catch (java.io.FileNotFoundException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            return loadAsset(str, context);
        }
        return "";
    }

    public static java.lang.String loadAsset(java.lang.String str, android.content.Context context) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.lang.String assetPath = io.dcloud.weex.DCFileUtils.getAssetPath(str);
            java.io.InputStream inputStreamLoadWeexAsset = io.dcloud.weex.DCFileUtils.loadWeexAsset(assetPath, context);
            if (inputStreamLoadWeexAsset == null) {
                inputStreamLoadWeexAsset = context.getAssets().open(assetPath);
            }
            return readStreamToString(inputStreamLoadWeexAsset);
        } catch (java.io.IOException unused) {
            return "";
        }
    }

    private static java.lang.String readStreamToString(java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.IOException e;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(inputStream.available() + 10);
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            try {
                try {
                    char[] cArr = new char[4096];
                    while (true) {
                        int i = bufferedReader.read(cArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(cArr, 0, i);
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e2) {
                                com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e2);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (java.io.IOException e3) {
                                com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e3);
                                throw th;
                            }
                        }
                        throw th;
                    }
                    java.lang.String string = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e4) {
                        com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e5) {
                            com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e5);
                        }
                    }
                    return string;
                } catch (java.io.IOException e6) {
                    e = e6;
                    com.taobao.weex.utils.WXLogUtils.e("", e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e7) {
                            com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e7);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e8) {
                            com.taobao.weex.utils.WXLogUtils.e("WXFileUtils loadAsset: ", e8);
                        }
                    }
                    return "";
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
            }
        } catch (java.io.IOException e9) {
            bufferedReader = null;
            e = e9;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static byte[] readBytesFromAssets(java.lang.String str, android.content.Context context) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                java.io.InputStream inputStreamOpen = context.getAssets().open(str);
                byte[] bArr = new byte[4096];
                int i = inputStreamOpen.read(bArr);
                byte[] bArr2 = new byte[i];
                java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
                return bArr2;
            } catch (java.io.IOException e) {
                com.taobao.weex.utils.WXLogUtils.e("", e);
            }
        }
        return null;
    }

    public static boolean saveFile(java.lang.String str, byte[] bArr, android.content.Context context) {
        if (android.text.TextUtils.isEmpty(str) || bArr == null || context == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    com.taobao.weex.utils.WXLogUtils.e("WXFileUtils saveFile: " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String md5(java.lang.String str) {
        if (str == null) {
            return "";
        }
        try {
            return md5(str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static java.lang.String md5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(io.dcloud.common.util.Md5Utils.ALGORITHM);
            messageDigest.update(bArr);
            return new java.math.BigInteger(1, messageDigest.digest()).toString(16);
        } catch (java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static java.lang.String base64Md5(java.lang.String str) {
        if (str == null) {
            return "";
        }
        try {
            return base64Md5(str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static java.lang.String base64Md5(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(io.dcloud.common.util.Md5Utils.ALGORITHM);
            messageDigest.update(bArr);
            return android.util.Base64.encodeToString(messageDigest.digest(), 2);
        } catch (java.security.NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static java.lang.String[] validCPUABIS() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        return (strArr == null || strArr.length == 0) ? new java.lang.String[]{android.os.Build.CPU_ABI} : strArr;
    }

    private static boolean validLibPath(java.lang.String str) {
        for (java.lang.String str2 : validCPUABIS()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean replaceLib(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        boolean z = false;
        for (java.lang.String str3 : validCPUABIS()) {
            if (str2.contains(str3) && z) {
                return true;
            }
            if (str.contains(str3)) {
                z = true;
            }
        }
        return false;
    }

    public static boolean extractSo(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        boolean z = false;
        if (io.dcloud.common.util.PdrUtil.isSafeEntryName(str) && io.dcloud.common.util.PdrUtil.isSafeEntryName(str2)) {
            java.util.HashMap map = new java.util.HashMap();
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str);
            java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(str)));
            java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.getName().contains("../") && !zipEntryNextElement.isDirectory() && validLibPath(zipEntryNextElement.getName()) && (zipEntryNextElement.getName().contains("weex") || zipEntryNextElement.getName().equals("libjsc.so") || zipEntryNextElement.getName().equals("libJavaScriptCore.so"))) {
                    java.lang.String[] strArrSplit = zipEntryNextElement.getName().split("/");
                    java.lang.String str3 = strArrSplit[strArrSplit.length - 1];
                    java.io.File file = new java.io.File(str2 + "/" + str3);
                    if (replaceLib(zipEntryNextElement.getName(), (java.lang.String) map.get(str3))) {
                        map.put(str3, zipEntryNextElement.getName());
                        if (file.exists()) {
                            file.delete();
                        }
                        java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        byte[] bArr = new byte[1024];
                        file.createNewFile();
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                        while (inputStream.read(bArr) != -1) {
                            fileOutputStream.write(bArr);
                        }
                        fileOutputStream.close();
                    }
                    z = true;
                }
            }
            zipInputStream.closeEntry();
        }
        return z;
    }

    public static void copyFile(java.io.File file, java.io.File file2) {
        java.io.FileOutputStream fileOutputStream;
        java.lang.Exception e;
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new java.io.FileOutputStream(file2);
                while (fileInputStream.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.taobao.weex.utils.WXLogUtils.e("copyFile " + e.getMessage() + ": " + file.getAbsolutePath() + ": " + file2.getAbsolutePath());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (java.lang.Exception e5) {
                fileOutputStream = null;
                e = e5;
            }
        } catch (java.lang.Exception e6) {
            fileOutputStream = null;
            e = e6;
            fileInputStream = null;
        }
    }

    public static void copyFileWithException(java.io.File file, java.io.File file2) throws java.lang.Exception {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new java.io.FileOutputStream(file2);
                while (fileInputStream2.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            throw e;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            closeIo(fileInputStream);
                            closeIo(fileOutputStream);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        closeIo(fileInputStream);
                        closeIo(fileOutputStream);
                        throw th;
                    }
                }
                closeIo(fileInputStream2);
                closeIo(fileOutputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void closeIo(java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
