package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a5 {
    static final java.nio.charset.Charset a = java.nio.charset.Charset.forName("US-ASCII");
    static final java.nio.charset.Charset b = java.nio.charset.Charset.forName("UTF-8");

    static java.lang.String a(java.io.Reader reader) throws java.io.IOException {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int i = reader.read(cArr);
                if (i == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i);
            }
        } finally {
            reader.close();
        }
    }

    static void a(java.io.File file) throws java.io.IOException {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new java.io.IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new java.io.IOException("not a readable directory: " + file);
    }

    static void a(java.io.Closeable closeable) {
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
