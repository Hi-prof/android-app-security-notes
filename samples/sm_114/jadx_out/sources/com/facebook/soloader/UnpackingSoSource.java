package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnpackingSoSource extends com.facebook.soloader.DirectorySoSource implements com.facebook.soloader.AsyncInitSoSource {
    protected static final java.lang.String DEPS_FILE_NAME = "dso_deps";
    protected static final java.lang.String LOCK_FILE_NAME = "dso_lock";
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    protected static final java.lang.String STATE_FILE_NAME = "dso_state";
    private static final java.lang.String TAG = "fb-UnpackingSoSource";

    @javax.annotation.Nullable
    private java.lang.String[] mAbis;
    protected final android.content.Context mContext;

    private static boolean forceRefresh(int i) {
        return (i & 2) != 0;
    }

    private static boolean rewriteStateAsync(int i) {
        return (i & 1) != 0;
    }

    protected abstract com.facebook.soloader.UnpackingSoSource.Unpacker makeUnpacker(boolean z) throws java.io.IOException;

    protected UnpackingSoSource(android.content.Context context, java.lang.String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(android.content.Context context, java.io.File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static java.io.File getSoStorePath(android.content.Context context, java.lang.String str) {
        return new java.io.File(context.getApplicationInfo().dataDir + "/" + str);
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String[] getSoSourceAbis() {
        java.lang.String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(java.lang.String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final java.lang.String hash;
        public final java.lang.String name;

        public Dso(java.lang.String str, java.lang.String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    protected static final class InputDso implements java.io.Closeable {
        private final java.io.InputStream content;
        private final com.facebook.soloader.UnpackingSoSource.Dso dso;

        public InputDso(com.facebook.soloader.UnpackingSoSource.Dso dso, java.io.InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        public com.facebook.soloader.UnpackingSoSource.Dso getDso() {
            return this.dso;
        }

        public int available() throws java.io.IOException {
            return this.content.available();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.content.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeState(java.io.File file, byte b, boolean z) throws java.io.IOException {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (z) {
                    randomAccessFile.getFD().sync();
                }
                randomAccessFile.close();
            } catch (java.lang.Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (java.io.SyncFailedException e) {
            com.facebook.soloader.LogUtil.w(TAG, "state file sync failed", e);
        }
    }

    private void deleteSoFiles() throws java.io.IOException {
        java.io.File[] fileArrListFiles = this.soDirectory.listFiles(new java.io.FilenameFilter() { // from class: com.facebook.soloader.UnpackingSoSource.1
            @Override // java.io.FilenameFilter
            public boolean accept(java.io.File file, java.lang.String str) {
                return (str.equals(com.facebook.soloader.UnpackingSoSource.STATE_FILE_NAME) || str.equals(com.facebook.soloader.UnpackingSoSource.LOCK_FILE_NAME) || str.equals(com.facebook.soloader.UnpackingSoSource.DEPS_FILE_NAME)) ? false : true;
            }
        });
        if (fileArrListFiles == null) {
            throw new java.io.IOException("unable to list directory " + this.soDirectory);
        }
        for (java.io.File file : fileArrListFiles) {
            com.facebook.soloader.LogUtil.v(TAG, "Deleting " + file);
            com.facebook.soloader.SysUtil.dumbDelete(file);
        }
    }

    protected static abstract class Unpacker implements java.io.Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        public abstract com.facebook.soloader.UnpackingSoSource.Dso[] getDsos() throws java.io.IOException;

        public abstract void unpack(java.io.File file) throws java.io.IOException;

        protected Unpacker() {
        }

        public void extractDso(com.facebook.soloader.UnpackingSoSource.InputDso inputDso, byte[] bArr, java.io.File file) throws java.io.IOException {
            java.io.RandomAccessFile randomAccessFile;
            java.lang.Throwable th;
            java.io.RandomAccessFile randomAccessFile2;
            com.facebook.soloader.LogUtil.i(com.facebook.soloader.UnpackingSoSource.TAG, "extracting DSO " + inputDso.getDso().name);
            java.io.File file2 = new java.io.File(file, inputDso.getDso().name);
            try {
                try {
                    java.io.RandomAccessFile randomAccessFile3 = new java.io.RandomAccessFile(file2, "rw");
                    try {
                        int iAvailable = inputDso.available();
                        if (iAvailable > 1) {
                            try {
                                randomAccessFile2 = randomAccessFile3;
                                try {
                                    com.facebook.soloader.SysUtil.fallocateIfSupported(randomAccessFile3.getFD(), iAvailable);
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    th = th;
                                    randomAccessFile = randomAccessFile2;
                                    try {
                                        randomAccessFile.close();
                                        throw th;
                                    } catch (java.lang.Throwable th3) {
                                        th.addSuppressed(th3);
                                        throw th;
                                    }
                                }
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                randomAccessFile2 = randomAccessFile3;
                            }
                        } else {
                            randomAccessFile2 = randomAccessFile3;
                        }
                        try {
                            randomAccessFile = randomAccessFile2;
                            try {
                                com.facebook.soloader.SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                                if (!file2.setExecutable(true, false)) {
                                    throw new java.io.IOException("cannot make file executable: " + file2);
                                }
                                randomAccessFile.close();
                                if (!file2.exists() || file2.setWritable(false)) {
                                    return;
                                }
                                com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                th = th;
                                randomAccessFile.close();
                                throw th;
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            randomAccessFile = randomAccessFile2;
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        randomAccessFile = randomAccessFile3;
                    }
                } catch (java.lang.Throwable th8) {
                    if (file2.exists() && !file2.setWritable(false)) {
                        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                    }
                    throw th8;
                }
            } catch (java.io.IOException e) {
                com.facebook.soloader.LogUtil.e(com.facebook.soloader.UnpackingSoSource.TAG, "error extracting dso  " + file2 + " due to: " + e);
                com.facebook.soloader.SysUtil.dumbDelete(file2);
                throw e;
            }
        }
    }

    protected java.security.MessageDigest getHashingAlgorithm() throws java.security.NoSuchAlgorithmException {
        return java.security.MessageDigest.getInstance("SHA-256");
    }

    protected java.lang.String computeFileHash(java.io.File file) {
        try {
            java.security.MessageDigest hashingAlgorithm = getHashingAlgorithm();
            try {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                try {
                    java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(fileInputStream, hashingAlgorithm);
                    try {
                        while (digestInputStream.read(new byte[8192]) != -1) {
                        }
                        byte[] bArrDigest = hashingAlgorithm.digest();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArrDigest.length * 2);
                        for (byte b : bArrDigest) {
                            sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
                        }
                        java.lang.String string = sb.toString();
                        digestInputStream.close();
                        fileInputStream.close();
                        return string;
                    } catch (java.lang.Throwable th) {
                        try {
                            digestInputStream.close();
                        } catch (java.lang.Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (java.io.IOException e) {
                com.facebook.soloader.LogUtil.w(TAG, "Failed to calculate hash for " + file.getName(), e);
                return "-1";
            }
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.facebook.soloader.LogUtil.w(TAG, "Failed to calculate hash for " + file.getName(), e2);
            return "-1";
        }
    }

    private boolean libraryIsCorrupted(com.facebook.soloader.UnpackingSoSource.Dso dso, java.io.File file) {
        return (file.exists() && dso.hash.equals(computeFileHash(file))) ? false : true;
    }

    protected boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !java.util.Arrays.equals(bArr, bArr2);
    }

    protected boolean depsChanged(byte[] bArr) {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(this.soDirectory, DEPS_FILE_NAME), "rw");
            try {
                if (randomAccessFile.length() != 0) {
                    int length = (int) randomAccessFile.length();
                    byte[] bArr2 = new byte[length];
                    if (randomAccessFile.read(bArr2) != length) {
                        com.facebook.soloader.LogUtil.v(TAG, "short read of so store deps file: marking unclean");
                    } else {
                        boolean zDepsChanged = depsChanged(bArr2, bArr);
                        randomAccessFile.close();
                        return zDepsChanged;
                    }
                }
                randomAccessFile.close();
                return true;
            } catch (java.lang.Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (java.io.IOException e) {
            com.facebook.soloader.LogUtil.w(TAG, "failed to compare whether deps changed", e);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006b  */
    private boolean refreshLocked(final com.facebook.soloader.FileLocker fileLocker, int i) throws java.io.IOException {
        byte b;
        final java.io.File file = new java.io.File(this.soDirectory, STATE_FILE_NAME);
        byte[] depsBlock = getDepsBlock();
        boolean zForceRefresh = forceRefresh(i);
        if (zForceRefresh || depsChanged(depsBlock)) {
            b = 0;
        } else {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                if (randomAccessFile.length() == 1) {
                    try {
                        b = randomAccessFile.readByte();
                        if (b == 1) {
                            com.facebook.soloader.LogUtil.v(TAG, "dso store " + this.soDirectory + " regeneration not needed: state file clean");
                        } else {
                            b = 0;
                        }
                    } catch (java.io.IOException e) {
                        com.facebook.soloader.LogUtil.v(TAG, "dso store " + this.soDirectory + " regeneration interrupted: " + e.getMessage());
                    }
                } else {
                    b = 0;
                }
                randomAccessFile.close();
            } catch (java.lang.Throwable th) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        if (b == 1) {
            return false;
        }
        final boolean z = (i & 4) == 0;
        com.facebook.soloader.LogUtil.v(TAG, "so store dirty: regenerating");
        writeState(file, (byte) 0, z);
        deleteSoFiles();
        com.facebook.soloader.UnpackingSoSource.Unpacker unpackerMakeUnpacker = makeUnpacker(zForceRefresh);
        try {
            unpackerMakeUnpacker.unpack(this.soDirectory);
            if (unpackerMakeUnpacker != null) {
                unpackerMakeUnpacker.close();
            }
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(new java.io.File(this.soDirectory, DEPS_FILE_NAME), "rw");
            try {
                randomAccessFile2.write(depsBlock);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                randomAccessFile2.close();
                java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.facebook.soloader.LogUtil.v(com.facebook.soloader.UnpackingSoSource.TAG, "starting syncer worker");
                        try {
                            try {
                                if (z) {
                                    com.facebook.soloader.SysUtil.fsyncAll(com.facebook.soloader.UnpackingSoSource.this.soDirectory);
                                }
                                com.facebook.soloader.UnpackingSoSource.writeState(file, (byte) 1, z);
                            } finally {
                                com.facebook.soloader.LogUtil.v(com.facebook.soloader.UnpackingSoSource.TAG, "releasing dso store lock for " + com.facebook.soloader.UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                                fileLocker.close();
                            }
                        } catch (java.io.IOException e2) {
                            throw new java.lang.RuntimeException(e2);
                        }
                    }
                };
                if (rewriteStateAsync(i)) {
                    new java.lang.Thread(runnable, "SoSync:" + this.soDirectory.getName()).start();
                } else {
                    runnable.run();
                }
                return true;
            } catch (java.lang.Throwable th3) {
                try {
                    randomAccessFile2.close();
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    throw th3;
                }
            }
        } finally {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (java.lang.Throwable th5) {
                    th3.addSuppressed(th5);
                }
            }
        }
    }

    @Override // com.facebook.soloader.AsyncInitSoSource
    public void waitUntilInitCompleted() throws java.lang.Throwable {
        try {
            com.facebook.soloader.FileLocker orCreateLockOnDir = com.facebook.soloader.SysUtil.getOrCreateLockOnDir(this.soDirectory, new java.io.File(this.soDirectory, LOCK_FILE_NAME));
            if (orCreateLockOnDir != null) {
                orCreateLockOnDir.close();
            }
        } catch (java.lang.Exception e) {
            com.facebook.soloader.LogUtil.e(TAG, "Encountered exception during wait for unpacking trying to acquire file lock for " + getClass().getName() + " (" + this.soDirectory + "): ", e);
        }
    }

    protected byte[] getDepsBlock() throws java.io.IOException {
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        com.facebook.soloader.UnpackingSoSource.Unpacker unpackerMakeUnpacker = makeUnpacker(false);
        try {
            com.facebook.soloader.UnpackingSoSource.Dso[] dsos = unpackerMakeUnpacker.getDsos();
            parcelObtain.writeInt(dsos.length);
            for (com.facebook.soloader.UnpackingSoSource.Dso dso : dsos) {
                parcelObtain.writeString(dso.name);
                parcelObtain.writeString(dso.hash);
            }
            if (unpackerMakeUnpacker != null) {
                unpackerMakeUnpacker.close();
            }
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (java.lang.Throwable th) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws java.io.IOException {
        com.facebook.soloader.SysUtil.mkdirOrThrow(this.soDirectory);
        if (!this.soDirectory.canWrite() && !this.soDirectory.setWritable(true)) {
            throw new java.io.IOException("error adding " + this.soDirectory.getCanonicalPath() + " write permission");
        }
        com.facebook.soloader.FileLocker fileLocker = null;
        try {
            try {
                com.facebook.soloader.FileLocker orCreateLockOnDir = com.facebook.soloader.SysUtil.getOrCreateLockOnDir(this.soDirectory, new java.io.File(this.soDirectory, LOCK_FILE_NAME));
                try {
                    com.facebook.soloader.LogUtil.v(TAG, "locked dso store " + this.soDirectory);
                    if (!this.soDirectory.canWrite() && !this.soDirectory.setWritable(true)) {
                        throw new java.io.IOException("error adding " + this.soDirectory.getCanonicalPath() + " write permission");
                    }
                    if (!refreshLocked(orCreateLockOnDir, i)) {
                        com.facebook.soloader.LogUtil.i(TAG, "dso store is up-to-date: " + this.soDirectory);
                        fileLocker = orCreateLockOnDir;
                    }
                    if (fileLocker != null) {
                        com.facebook.soloader.LogUtil.v(TAG, "releasing dso store lock for " + this.soDirectory);
                        fileLocker.close();
                    } else {
                        com.facebook.soloader.LogUtil.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
                    }
                    if (!this.soDirectory.canWrite() || this.soDirectory.setWritable(false)) {
                        return;
                    }
                    throw new java.io.IOException("error removing " + this.soDirectory.getCanonicalPath() + " write permission");
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileLocker = orCreateLockOnDir;
                    if (fileLocker != null) {
                        com.facebook.soloader.LogUtil.v(TAG, "releasing dso store lock for " + this.soDirectory);
                        fileLocker.close();
                    } else {
                        com.facebook.soloader.LogUtil.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                if (!this.soDirectory.canWrite() || this.soDirectory.setWritable(false)) {
                    throw th2;
                }
                throw new java.io.IOException("error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        java.io.File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    public void prepareForceRefresh() throws java.io.IOException {
        prepare(2);
    }
}
