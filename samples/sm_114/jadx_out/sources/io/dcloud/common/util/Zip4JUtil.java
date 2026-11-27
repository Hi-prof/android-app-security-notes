package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Zip4JUtil {
    public static boolean isEncryptedZip(java.io.File file) {
        try {
            net.lingala.zip4j.ZipFile zipFile = new net.lingala.zip4j.ZipFile(file);
            if (zipFile.isValidZipFile()) {
                return zipFile.isEncrypted();
            }
            return false;
        } catch (net.lingala.zip4j.exception.ZipException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void upZipFileWithPassword(java.io.File file, java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (!str.endsWith("/")) {
            str = str + java.io.File.separatorChar;
        }
        java.io.File file2 = new java.io.File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        net.lingala.zip4j.ZipFile zipFile = new net.lingala.zip4j.ZipFile(file, str2 != null ? str2.toCharArray() : null);
        zipFile.setCharset(java.nio.charset.Charset.forName("UTF-8"));
        zipFile.extractAll(file2.getPath());
    }
}
