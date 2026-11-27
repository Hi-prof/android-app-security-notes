package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v0 {
    public static boolean a(java.lang.Object obj) {
        boolean zDelete;
        if (obj == null) {
            return false;
        }
        try {
            java.io.File fileC = c(obj);
            if (!fileC.exists()) {
                return false;
            }
            if (fileC.isFile()) {
                return fileC.delete();
            }
            java.io.File[] fileArrListFiles = fileC.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    io.dcloud.p.c3.a("delete:" + fileArrListFiles[i].getPath());
                    if (fileArrListFiles[i].isDirectory()) {
                        zDelete = a((java.lang.Object) (fileC.getPath() + "/" + fileArrListFiles[i].getName()));
                    } else {
                        zDelete = fileArrListFiles[i].delete();
                        java.lang.Thread.sleep(2L);
                    }
                    if (!zDelete) {
                        return false;
                    }
                }
            }
            boolean zDelete2 = fileC.delete();
            io.dcloud.p.c3.a("delete " + obj + ":" + java.lang.String.valueOf(zDelete2));
            return zDelete2;
        } catch (java.lang.Exception e) {
            io.dcloud.p.c3.d("DHFile.delete" + e);
            return false;
        }
    }

    public static boolean b(java.lang.Object obj) {
        try {
            if (!(obj instanceof java.lang.String)) {
                if (obj instanceof java.io.File) {
                    return ((java.io.File) obj).exists();
                }
                return false;
            }
            java.lang.String strSubstring = (java.lang.String) obj;
            if (strSubstring.endsWith("/")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return new java.io.File(strSubstring).exists();
        } catch (java.lang.Exception unused) {
        }
    }

    private static java.io.File c(java.lang.Object obj) {
        if (!(obj instanceof java.lang.String)) {
            if (obj instanceof java.io.File) {
                return (java.io.File) obj;
            }
            return null;
        }
        java.lang.String strSubstring = (java.lang.String) obj;
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        return new java.io.File(strSubstring);
    }

    public static java.io.InputStream d(java.lang.Object obj) {
        java.io.File file;
        if (obj instanceof java.lang.String) {
            java.lang.String strSubstring = (java.lang.String) obj;
            if (strSubstring.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                strSubstring = strSubstring.substring(7);
            }
            file = new java.io.File(strSubstring);
        } else {
            file = obj instanceof java.io.File ? (java.io.File) obj : null;
        }
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            return new java.io.FileInputStream(file);
        } catch (java.io.FileNotFoundException unused) {
            io.dcloud.p.c3.b("uniAD", "DHFile getInputStream not found file: " + file.getPath());
            return null;
        } catch (java.lang.SecurityException e) {
            io.dcloud.p.c3.d("getInputStream2" + e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0067 A[EXC_TOP_SPLITTER, PHI: r4
  0x0067: PHI (r4v8 java.io.InputStream) = (r4v5 java.io.InputStream), (r4v6 java.io.InputStream), (r4v7 java.io.InputStream), (r4v10 java.io.InputStream) binds: [B:32:0x004f, B:27:0x003b, B:36:0x0065, B:19:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public static byte[] e(java.lang.Object obj) throws java.lang.Throwable {
        java.io.InputStream inputStreamD;
        ?? r3 = 0;
        try {
            try {
                inputStreamD = d(obj);
                if (inputStreamD == null) {
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                }
                try {
                    byte[] bArrA = a(inputStreamD);
                    try {
                        inputStreamD.close();
                        return bArrA;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                        return bArrA;
                    }
                } catch (java.io.FileNotFoundException e2) {
                    e = e2;
                    io.dcloud.p.c3.a("readAll 0:" + e.getLocalizedMessage());
                    if (inputStreamD != null) {
                        try {
                            inputStreamD.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (java.io.IOException e4) {
                    e = e4;
                    io.dcloud.p.c3.d("readAll 2:" + e);
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                } catch (java.lang.SecurityException e5) {
                    e = e5;
                    io.dcloud.p.c3.d("readAll 1:" + e);
                    if (inputStreamD != null) {
                        inputStreamD.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                r3 = obj;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.io.FileNotFoundException e7) {
            e = e7;
            inputStreamD = null;
        } catch (java.io.IOException e8) {
            e = e8;
            inputStreamD = null;
        } catch (java.lang.SecurityException e9) {
            e = e9;
            inputStreamD = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
    }

    public static byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[io.dcloud.common.adapter.io.DHFile.BUF_SIZE];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a((java.io.OutputStream) byteArrayOutputStream);
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static void a(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(java.lang.String str) {
        return b(c(str));
    }

    public static void a(byte[] bArr, int i, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.p.c3.a(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rws");
                randomAccessFile.setLength(bArr.length + i);
                randomAccessFile.seek(i);
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                return;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            file.createNewFile();
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
        }
        try {
            fileOutputStream = new java.io.FileOutputStream(file);
        } catch (java.io.FileNotFoundException e4) {
            e4.printStackTrace();
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                if (bArr != null) {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public static void a(java.io.InputStream inputStream, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            io.dcloud.p.c3.a(str + "cannot create!");
            return;
        }
        if (file.exists()) {
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rws");
                randomAccessFile.seek(file.length());
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr, 0, 8192);
                    if (i != -1) {
                        randomAccessFile.write(bArr, 0, i);
                    } else {
                        randomAccessFile.close();
                        return;
                    }
                }
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.io.FileNotFoundException e4) {
                e4.printStackTrace();
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    try {
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int i2 = inputStream.read(bArr2, 0, 8192);
                            if (i2 == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr2, 0, i2);
                            }
                        }
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e6) {
                        e6.printStackTrace();
                    }
                }
            }
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return false;
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (-1 != i) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
