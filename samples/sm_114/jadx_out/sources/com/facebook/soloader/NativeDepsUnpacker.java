package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class NativeDepsUnpacker {
    private static final java.lang.String APK_IDENTIFIER_FILE_NAME = "apk_id";
    private static final java.lang.String LOCK_FILE_NAME = "lock";
    private static final java.lang.String NATIVE_DEPS_DIR_NAME = "native_deps";
    private static final java.lang.String NATIVE_DEPS_FILE_APK_PATH = "assets/native_deps.txt";
    private static final java.lang.String NATIVE_DEPS_FILE_NAME = "deps";
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final java.lang.String STATE_FILE_NAME = "state";

    private NativeDepsUnpacker() {
    }

    public static java.io.File getNativeDepsFilePath(android.content.Context context) {
        return new java.io.File(getNativeDepsDir(context), NATIVE_DEPS_FILE_NAME);
    }

    public static java.io.File getNativeDepsDir(android.content.Context context) {
        return new java.io.File(context.getApplicationInfo().dataDir, NATIVE_DEPS_DIR_NAME);
    }

    public static void ensureNativeDepsAvailable(android.content.Context context) throws java.lang.Throwable {
        java.io.File nativeDepsDir = getNativeDepsDir(context);
        if (ensureDirExists(nativeDepsDir)) {
            com.facebook.soloader.FileLocker orCreateLockOnDir = com.facebook.soloader.SysUtil.getOrCreateLockOnDir(nativeDepsDir, new java.io.File(nativeDepsDir, LOCK_FILE_NAME));
            try {
                byte state = readState(nativeDepsDir);
                if (state == 1 && apkChanged(context, nativeDepsDir)) {
                    state = 0;
                }
                if (state == 1) {
                    if (orCreateLockOnDir != null) {
                        orCreateLockOnDir.close();
                        return;
                    }
                    return;
                }
                writeState(nativeDepsDir, (byte) 0);
                extractNativeDeps(context);
                writeApkIdentifier(context, nativeDepsDir);
                com.facebook.soloader.SysUtil.fsyncAll(nativeDepsDir);
                writeState(nativeDepsDir, (byte) 1);
                if (orCreateLockOnDir != null) {
                    orCreateLockOnDir.close();
                }
            } catch (java.lang.Throwable th) {
                if (orCreateLockOnDir != null) {
                    try {
                        orCreateLockOnDir.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private static boolean ensureDirExists(java.io.File file) {
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file.isDirectory();
    }

    private static byte[] getApkIdentifier(android.content.Context context) throws java.io.IOException {
        return com.facebook.soloader.SysUtil.makeApkDepBlock(new java.io.File(context.getApplicationInfo().sourceDir), context);
    }

    static byte[] readAllBytes(java.io.InputStream inputStream, int i) throws java.io.IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new java.io.EOFException("EOF found unexpectedly");
            }
            i2 += i3;
            if (i2 > i) {
                throw new java.lang.IllegalStateException("Read more bytes than expected");
            }
        }
        return bArr;
    }

    static byte[] readNativeDepsFromDisk(android.content.Context context) throws java.io.IOException {
        java.io.File nativeDepsFilePath = getNativeDepsFilePath(context);
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(nativeDepsFilePath);
        try {
            byte[] allBytes = readAllBytes(fileInputStream, (int) nativeDepsFilePath.length());
            fileInputStream.close();
            return allBytes;
        } catch (java.lang.Throwable th) {
            try {
                fileInputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static byte[] readNativeDepsFromApk(android.content.Context context) throws java.io.IOException {
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(new java.io.File(context.getApplicationInfo().sourceDir));
        try {
            java.util.zip.ZipEntry entry = zipFile.getEntry(NATIVE_DEPS_FILE_APK_PATH);
            if (entry == null) {
                throw new java.io.FileNotFoundException("Could not find native_deps file in APK");
            }
            java.io.InputStream inputStream = zipFile.getInputStream(entry);
            try {
                if (inputStream == null) {
                    throw new java.io.FileNotFoundException("Failed to read native_deps file from APK");
                }
                byte[] allBytes = readAllBytes(inputStream, (int) entry.getSize());
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                return allBytes;
            } catch (java.lang.Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            try {
                zipFile.close();
            } catch (java.lang.Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    private static void extractNativeDeps(android.content.Context context) throws java.io.IOException {
        byte[] nativeDepsFromApk = readNativeDepsFromApk(context);
        byte[] apkIdentifier = getApkIdentifier(context);
        int length = nativeDepsFromApk.length;
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(getNativeDepsFilePath(context), "rw");
        try {
            randomAccessFile.write(apkIdentifier);
            randomAccessFile.writeInt(length);
            randomAccessFile.write(nativeDepsFromApk);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.close();
        } catch (java.lang.Throwable th) {
            try {
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void writeApkIdentifier(android.content.Context context, java.io.File file) throws java.io.IOException {
        java.io.File file2 = new java.io.File(file, APK_IDENTIFIER_FILE_NAME);
        byte[] apkIdentifier = getApkIdentifier(context);
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.write(apkIdentifier);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.close();
        } catch (java.lang.Throwable th) {
            try {
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void writeState(java.io.File file, byte b) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(file, "state"), "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (java.lang.Throwable th) {
            try {
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte readState(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(file, "state"), "rw");
        byte b = 0;
        try {
            byte b2 = randomAccessFile.readByte();
            if (b2 == 1) {
                b = b2;
            }
        } catch (java.io.EOFException unused) {
        } catch (java.lang.Throwable th) {
            try {
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        randomAccessFile.close();
        return b;
    }

    @javax.annotation.Nullable
    private static byte[] getExistingApkIdentifier(android.content.Context context, java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(file, APK_IDENTIFIER_FILE_NAME), "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr = new byte[length];
            if (randomAccessFile.read(bArr) != length) {
                randomAccessFile.close();
                return null;
            }
            randomAccessFile.close();
            return bArr;
        } catch (java.lang.Throwable th) {
            try {
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static boolean apkChanged(android.content.Context context, java.io.File file) throws java.io.IOException {
        byte[] existingApkIdentifier = getExistingApkIdentifier(context, file);
        byte[] apkIdentifier = getApkIdentifier(context);
        if (existingApkIdentifier == null || apkIdentifier == null || existingApkIdentifier.length != apkIdentifier.length) {
            return true;
        }
        return !java.util.Arrays.equals(existingApkIdentifier, apkIdentifier);
    }
}
