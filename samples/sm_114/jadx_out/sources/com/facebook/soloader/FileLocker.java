package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class FileLocker implements java.io.Closeable {

    @javax.annotation.Nullable
    private final java.nio.channels.FileLock mLock;
    private final java.io.FileOutputStream mLockFileOutputStream;

    public static com.facebook.soloader.FileLocker lock(java.io.File file) throws java.io.IOException {
        return new com.facebook.soloader.FileLocker(file);
    }

    private FileLocker(java.io.File file) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        this.mLockFileOutputStream = fileOutputStream;
        try {
            java.nio.channels.FileLock fileLockLock = fileOutputStream.getChannel().lock();
            if (fileLockLock == null) {
                fileOutputStream.close();
            }
            this.mLock = fileLockLock;
        } catch (java.lang.Throwable th) {
            this.mLockFileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        try {
            java.nio.channels.FileLock fileLock = this.mLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.mLockFileOutputStream.close();
        }
    }
}
