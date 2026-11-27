package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IOUtil {
    static final int BUF_SIZE = 20480;

    public static final java.io.InputStream byte2InputStream(byte[] bArr) {
        return new java.io.ByteArrayInputStream(bArr);
    }

    public static void close(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] getBytes(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[BUF_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                close(byteArrayOutputStream);
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static java.lang.String readStringFile(java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
            try {
                java.lang.String str2 = new java.lang.String(getBytes(fileInputStream));
                try {
                    fileInputStream.close();
                } catch (java.io.IOException unused) {
                }
                return str2;
            } catch (java.io.IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static java.lang.String toString(java.io.InputStream inputStream) throws java.io.IOException {
        return inputStream == null ? "" : toStringBuffer(inputStream).toString();
    }

    private static java.lang.StringBuilder toStringBuffer(java.io.InputStream inputStream) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return sb;
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    public static boolean writeStringFile(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(str);
                try {
                    java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(fileOutputStream, "utf-8");
                    outputStreamWriter.write(str2, 0, str2.length());
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    close(fileOutputStream);
                    return true;
                } catch (java.io.IOException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    close(fileOutputStream2);
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    close(fileOutputStream);
                    throw th;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }

    public static void close(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
