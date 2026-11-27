package com.nostra13.dcloudimageloader.utils;

/* JADX INFO: loaded from: classes.dex */
public final class IoUtils {
    private static final int BUFFER_SIZE = 32768;

    private IoUtils() {
    }

    public static void copyStream(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[1195];
        while (true) {
            int i = inputStream.read(bArr, 0, 1195);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void closeSilently(java.io.Closeable closeable) {
        try {
            closeable.close();
        } catch (java.lang.Exception unused) {
        }
    }
}
