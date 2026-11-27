package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ZipUtils {
    private static final int BUFF_SIZE = 1048576;

    public static java.lang.String inflaterString(byte[] bArr) {
        java.util.zip.InflaterInputStream inflaterInputStream = new java.util.zip.InflaterInputStream(new java.io.ByteArrayInputStream(bArr), new java.util.zip.Inflater(true));
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i = inflaterInputStream.read(bArr2);
                        if (i == -1) {
                            java.lang.String str = new java.lang.String(byteArrayOutputStream.toByteArray());
                            inflaterInputStream.close();
                            byteArrayOutputStream.close();
                            byteArrayOutputStream.flush();
                            return str;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i);
                    }
                } catch (java.lang.Exception unused) {
                    return "";
                }
            } catch (java.lang.Exception unused2) {
                java.lang.String str2 = new java.lang.String(byteArrayOutputStream.toByteArray());
                inflaterInputStream.close();
                byteArrayOutputStream.close();
                byteArrayOutputStream.flush();
                return str2;
            } catch (java.lang.Throwable th) {
                try {
                    new java.lang.String(byteArrayOutputStream.toByteArray());
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    byteArrayOutputStream.flush();
                } catch (java.lang.Exception unused3) {
                }
                throw th;
            }
        } catch (java.lang.Exception unused4) {
            return 1024;
        }
    }

    public static void upZipFile(java.io.File file, java.lang.String str) throws java.io.IOException {
        if (!str.endsWith("/")) {
            str = str + java.io.File.separatorChar;
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
        java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.getName().contains("../")) {
                io.dcloud.common.adapter.util.Logger.d("ZIP", "util.ZipUtils Path traversal attack prevented path=" + zipEntryNextElement.getName());
            } else {
                java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                java.lang.String strReplace = new java.lang.String((str + zipEntryNextElement.getName()).getBytes(), "UTF-8").replace("\\", "/");
                java.io.File file3 = new java.io.File(strReplace);
                java.io.File parentFile = file3.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!strReplace.endsWith("/")) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file3.createNewFile();
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file3);
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    inputStream.close();
                    fileOutputStream.close();
                }
            }
        }
        zipFile.close();
    }

    private static void zipFile(java.io.File file, java.util.zip.ZipOutputStream zipOutputStream, java.lang.String str) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : java.io.File.separator);
        sb.append(file.getName());
        java.lang.String str2 = new java.lang.String(sb.toString().getBytes("UTF-8"), "UTF-8");
        if (file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                zipFile(file2, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(str2));
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, i);
        }
    }

    public static void zipFiles(java.io.File[] fileArr, java.io.File file) throws java.io.IOException {
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(file), 1048576));
        for (java.io.File file2 : fileArr) {
            zipFile(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public static byte[] zipString(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
