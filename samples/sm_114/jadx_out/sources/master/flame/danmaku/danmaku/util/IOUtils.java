package master.flame.danmaku.danmaku.util;

/* JADX INFO: loaded from: classes2.dex */
public class IOUtils {
    public static java.lang.String getString(java.io.InputStream inputStream) {
        byte[] bytes = getBytes(inputStream);
        if (bytes == null) {
            return null;
        }
        return new java.lang.String(bytes);
    }

    public static byte[] getBytes(java.io.InputStream inputStream) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public static void closeQuietly(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
