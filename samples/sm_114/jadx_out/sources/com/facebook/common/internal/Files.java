package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public class Files {
    private Files() {
    }

    static byte[] readFile(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j <= 2147483647L) {
            if (j == 0) {
                return com.facebook.common.internal.ByteStreams.toByteArray(inputStream);
            }
            return com.facebook.common.internal.ByteStreams.toByteArray(inputStream, (int) j);
        }
        throw new java.lang.OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    public static byte[] toByteArray(java.io.File file) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                byte[] file2 = readFile(fileInputStream2, fileInputStream2.getChannel().size());
                fileInputStream2.close();
                return file2;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
