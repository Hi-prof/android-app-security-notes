package com.facebook.common.file;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    public static void mkdirs(java.io.File file) throws com.facebook.common.file.FileUtils.CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                throw new com.facebook.common.file.FileUtils.CreateDirectoryException(file.getAbsolutePath(), new com.facebook.common.file.FileUtils.FileDeleteException(file.getAbsolutePath()));
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new com.facebook.common.file.FileUtils.CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static void rename(java.io.File file, java.io.File file2) throws com.facebook.common.file.FileUtils.RenameException {
        java.lang.Throwable fileDeleteException;
        com.facebook.common.internal.Preconditions.checkNotNull(file);
        com.facebook.common.internal.Preconditions.checkNotNull(file2);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        if (file2.exists()) {
            fileDeleteException = new com.facebook.common.file.FileUtils.FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            fileDeleteException = new com.facebook.common.file.FileUtils.ParentDirNotFoundException(file.getAbsolutePath());
        } else {
            fileDeleteException = !file.exists() ? new java.io.FileNotFoundException(file.getAbsolutePath()) : null;
        }
        throw new com.facebook.common.file.FileUtils.RenameException("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath(), fileDeleteException);
    }

    public static class CreateDirectoryException extends java.io.IOException {
        public CreateDirectoryException(java.lang.String str) {
            super(str);
        }

        public CreateDirectoryException(java.lang.String str, java.lang.Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static class ParentDirNotFoundException extends java.io.FileNotFoundException {
        public ParentDirNotFoundException(java.lang.String str) {
            super(str);
        }
    }

    public static class FileDeleteException extends java.io.IOException {
        public FileDeleteException(java.lang.String str) {
            super(str);
        }
    }

    public static class RenameException extends java.io.IOException {
        public RenameException(java.lang.String str) {
            super(str);
        }

        public RenameException(java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
            super(str);
            initCause(th);
        }
    }
}
