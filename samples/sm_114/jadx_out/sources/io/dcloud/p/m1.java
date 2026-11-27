package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m1 {
    public static void a(byte[] bArr, int i, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
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
                if (bArr != null) {
                    try {
                        try {
                            fileOutputStream.write(bArr, 0, bArr.length);
                            fileOutputStream.flush();
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
    }
}
