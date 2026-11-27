package com.bumptech.glide.disklrucache;

/* JADX INFO: loaded from: classes.dex */
final class Util {
    static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
    static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");

    private Util() {
    }

    static java.lang.String readFully(java.io.Reader reader) throws java.io.IOException {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i = reader.read(cArr);
                if (i != -1) {
                    stringWriter.write(cArr, 0, i);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    static void deleteContents(java.io.File file) throws java.io.IOException {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new java.io.IOException("not a readable directory: " + file);
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: " + file2);
            }
        }
    }

    static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
