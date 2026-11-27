package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class NativeDeps {
    private static final float HASHMAP_LOAD_FACTOR = 1.0f;
    private static final int INITIAL_HASH = 5381;
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_SUFFIX_LEN = 3;
    private static final java.lang.String LOG_TAG = "NativeDeps";
    private static final int WAITING_THREADS_WARNING_THRESHOLD = 3;

    @javax.annotation.Nullable
    private static byte[] sEncodedDeps = null;
    private static volatile boolean sInitialized = false;
    private static java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> sPrecomputedDeps = null;
    private static java.util.List<java.lang.Integer> sPrecomputedLibs = null;
    private static volatile boolean sUseDepsFileAsync = false;
    private static final int LIB_PREFIX_SUFFIX_LEN = 3 + 3;
    private static final java.util.concurrent.locks.ReentrantReadWriteLock sWaitForDepsFileLock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    public static void loadDependencies(java.lang.String str, com.facebook.soloader.ElfByteChannel elfByteChannel, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        java.lang.String[] dependencies = getDependencies(str, elfByteChannel);
        com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, "Loading " + str + "'s dependencies: " + java.util.Arrays.toString(dependencies));
        for (java.lang.String str2 : dependencies) {
            if (!str2.startsWith("/")) {
                com.facebook.soloader.SoLoader.loadDependency(str2, i, threadPolicy);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0030  */
    public static java.lang.String[] getDependencies(java.lang.String str, com.facebook.soloader.ElfByteChannel elfByteChannel) throws java.io.IOException {
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING) {
            com.facebook.soloader.Api18TraceUtils.beginTraceSection("soloader.NativeDeps.getDependencies[", str, com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        }
        try {
            try {
                java.lang.String[] strArrAwaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
                if (strArrAwaitGetDepsFromPrecomputedDeps == null) {
                    java.lang.String[] strArrExtract_DT_NEEDED = com.facebook.soloader.MinElf.extract_DT_NEEDED(elfByteChannel);
                    if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING) {
                        com.facebook.soloader.Api18TraceUtils.endSection();
                    }
                    return strArrExtract_DT_NEEDED;
                }
                if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    com.facebook.soloader.Api18TraceUtils.endSection();
                }
                return strArrAwaitGetDepsFromPrecomputedDeps;
            } catch (com.facebook.soloader.MinElf.ElfError e) {
                throw com.facebook.soloader.SoLoaderULErrorFactory.create(str, e);
            }
        } catch (java.lang.Throwable th) {
            if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING) {
                com.facebook.soloader.Api18TraceUtils.endSection();
            }
            throw th;
        }
        if (com.facebook.soloader.SoLoader.SYSTRACE_LIBRARY_LOADING) {
            com.facebook.soloader.Api18TraceUtils.endSection();
        }
        throw th;
    }

    @javax.annotation.Nullable
    private static java.lang.String[] awaitGetDepsFromPrecomputedDeps(java.lang.String str) {
        if (sInitialized) {
            return tryGetDepsFromPrecomputedDeps(str);
        }
        if (!sUseDepsFileAsync) {
            return null;
        }
        sWaitForDepsFileLock.readLock().lock();
        try {
            return tryGetDepsFromPrecomputedDeps(str);
        } finally {
            sWaitForDepsFileLock.readLock().unlock();
        }
    }

    public static boolean useDepsFile(final android.content.Context context, boolean z, final boolean z2) {
        if (!z) {
            return useDepsFileFromApkSync(context, z2);
        }
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.facebook.soloader.NativeDeps.1
            @Override // java.lang.Runnable
            public void run() {
                com.facebook.soloader.NativeDeps.sWaitForDepsFileLock.writeLock().lock();
                boolean unused = com.facebook.soloader.NativeDeps.sUseDepsFileAsync = true;
                try {
                    com.facebook.soloader.NativeDeps.useDepsFileFromApkSync(context, z2);
                } finally {
                    int readLockCount = com.facebook.soloader.NativeDeps.sWaitForDepsFileLock.getReadLockCount();
                    if (readLockCount >= 3) {
                        com.facebook.soloader.LogUtil.w(com.facebook.soloader.NativeDeps.LOG_TAG, "NativeDeps initialization finished with " + java.lang.Integer.toString(readLockCount) + " threads waiting.");
                    }
                    com.facebook.soloader.NativeDeps.sWaitForDepsFileLock.writeLock().unlock();
                    boolean unused2 = com.facebook.soloader.NativeDeps.sUseDepsFileAsync = false;
                }
            }
        }, "soloader-nativedeps-init").start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean useDepsFileFromApkSync(android.content.Context context, boolean z) throws java.lang.Throwable {
        boolean zInitDeps;
        try {
            zInitDeps = initDeps(context, z);
        } catch (java.io.IOException unused) {
            zInitDeps = false;
        }
        if (!zInitDeps && z) {
            try {
                com.facebook.soloader.NativeDepsUnpacker.ensureNativeDepsAvailable(context);
                zInitDeps = initDeps(context, z);
            } catch (java.io.IOException unused2) {
            }
        }
        if (!zInitDeps) {
            com.facebook.soloader.LogUtil.w(LOG_TAG, "Failed to extract native deps from APK, falling back to using MinElf to get library dependencies.");
        }
        return zInitDeps;
    }

    private static boolean initDeps(android.content.Context context, boolean z) throws java.io.IOException {
        byte[] nativeDepsFromApk;
        byte[] bArrMakeApkDepBlock;
        verifyUninitialized();
        if (z) {
            bArrMakeApkDepBlock = com.facebook.soloader.SysUtil.makeApkDepBlock(new java.io.File(context.getApplicationInfo().sourceDir), context);
            nativeDepsFromApk = com.facebook.soloader.NativeDepsUnpacker.readNativeDepsFromDisk(context);
        } else {
            nativeDepsFromApk = com.facebook.soloader.NativeDepsUnpacker.readNativeDepsFromApk(context);
            bArrMakeApkDepBlock = null;
        }
        return processDepsBytes(bArrMakeApkDepBlock, nativeDepsFromApk);
    }

    private static void indexLib(int i, int i2) {
        sPrecomputedLibs.add(java.lang.Integer.valueOf(i2));
        java.util.List<java.lang.Integer> arrayList = sPrecomputedDeps.get(java.lang.Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            sPrecomputedDeps.put(java.lang.Integer.valueOf(i), arrayList);
        }
        arrayList.add(java.lang.Integer.valueOf(i2));
    }

    private static void indexDepsBytes(byte[] bArr, int i) {
        int i2;
        byte b;
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (z) {
                i3 = INITIAL_HASH;
                i2 = i;
                while (true) {
                    try {
                        b = bArr[i2];
                        if (b <= 32) {
                            break;
                        }
                        i3 = (i3 << 5) + i3 + b;
                        i2++;
                    } catch (java.lang.IndexOutOfBoundsException unused) {
                        if (z || i == bArr.length) {
                            return;
                        }
                        indexLib(i3, i);
                        return;
                    }
                }
                indexLib(i3, i);
                z = b != 32;
            } else {
                while (bArr[i] != 10) {
                    try {
                        i++;
                    } catch (java.lang.IndexOutOfBoundsException unused2) {
                        i = i4;
                        if (z) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                int i5 = i4;
                i2 = i;
                i = i5;
            }
            int i6 = i2 + 1;
            i4 = i;
            i = i6;
        }
    }

    private static int verifyBytesAndGetOffset(@javax.annotation.Nullable byte[] bArr, @javax.annotation.Nullable byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2.length < bArr.length + 4) {
            return -1;
        }
        if (bArr2.length != bArr.length + 4 + java.nio.ByteBuffer.wrap(bArr2, bArr.length, 4).getInt()) {
            return -1;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return -1;
            }
        }
        return bArr.length + 4;
    }

    private static int findNextLine(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            i++;
        }
        return i < bArr.length ? i + 1 : i;
    }

    private static int parseLibCount(byte[] bArr, int i, int i2) {
        try {
            return java.lang.Integer.parseInt(new java.lang.String(bArr, i, i2));
        } catch (java.lang.NumberFormatException unused) {
            return -1;
        }
    }

    static boolean processDepsBytes(byte[] bArr, byte[] bArr2) throws java.io.IOException {
        int iVerifyBytesAndGetOffset;
        int libCount;
        if (bArr != null) {
            iVerifyBytesAndGetOffset = verifyBytesAndGetOffset(bArr, bArr2);
            if (iVerifyBytesAndGetOffset == -1) {
                return false;
            }
        } else {
            iVerifyBytesAndGetOffset = 0;
        }
        int iFindNextLine = findNextLine(bArr2, iVerifyBytesAndGetOffset);
        if (iFindNextLine >= bArr2.length || (libCount = parseLibCount(bArr2, iVerifyBytesAndGetOffset, (iFindNextLine - iVerifyBytesAndGetOffset) - 1)) <= 0) {
            return false;
        }
        sPrecomputedDeps = new java.util.HashMap(((int) (libCount / HASHMAP_LOAD_FACTOR)) + 1, HASHMAP_LOAD_FACTOR);
        sPrecomputedLibs = new java.util.ArrayList(libCount);
        indexDepsBytes(bArr2, iFindNextLine);
        if (sPrecomputedLibs.size() != libCount) {
            return false;
        }
        sEncodedDeps = bArr2;
        sInitialized = true;
        return true;
    }

    private static boolean libIsAtOffset(java.lang.String str, int i) {
        int i2;
        int i3 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i2 = LIB_SUFFIX_LEN;
            if (i3 >= length - i2 || i >= sEncodedDeps.length || (str.codePointAt(i3) & 255) != sEncodedDeps[i]) {
                break;
            }
            i3++;
            i++;
        }
        return i3 == str.length() - i2;
    }

    private static int hashLib(java.lang.String str) {
        int iCodePointAt = INITIAL_HASH;
        for (int i = LIB_PREFIX_LEN; i < str.length() - LIB_SUFFIX_LEN; i++) {
            iCodePointAt = str.codePointAt(i) + (iCodePointAt << 5) + iCodePointAt;
        }
        return iCodePointAt;
    }

    private static int getOffsetForLib(java.lang.String str) {
        java.util.List<java.lang.Integer> list = sPrecomputedDeps.get(java.lang.Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        java.util.Iterator<java.lang.Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (libIsAtOffset(str, iIntValue)) {
                return iIntValue;
            }
        }
        return -1;
    }

    @javax.annotation.Nullable
    private static java.lang.String getLibString(int i) {
        if (i >= sPrecomputedLibs.size()) {
            return null;
        }
        int iIntValue = sPrecomputedLibs.get(i).intValue();
        int i2 = iIntValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                break;
            }
            i2++;
        }
        int i3 = (i2 - iIntValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr = new char[i3];
        cArr[0] = 'l';
        cArr[1] = 'i';
        cArr[2] = 'b';
        for (int i4 = 0; i4 < i3 - LIB_PREFIX_SUFFIX_LEN; i4++) {
            cArr[LIB_PREFIX_LEN + i4] = (char) sEncodedDeps[iIntValue + i4];
        }
        cArr[i3 - 3] = com.taobao.weex.el.parse.Operators.DOT;
        cArr[i3 - 2] = 's';
        cArr[i3 - 1] = 'o';
        return new java.lang.String(cArr);
    }

    @javax.annotation.Nullable
    private static java.lang.String[] getDepsForLibAtOffset(int i, int i2) {
        byte b;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i3 = (i + i2) - LIB_PREFIX_SUFFIX_LEN;
        int i4 = 0;
        boolean z = false;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i3 >= bArr.length || (b = bArr[i3]) == 10) {
                break;
            }
            if (b == 32) {
                if (z) {
                    java.lang.String libString = getLibString(i4);
                    if (libString == null) {
                        return null;
                    }
                    arrayList.add(libString);
                    i4 = 0;
                    z = false;
                } else {
                    continue;
                }
            } else {
                if (b < 48 || b > 57) {
                    return null;
                }
                i4 = (i4 * 10) + (b - 48);
                z = true;
            }
            i3++;
        }
        if (z) {
            java.lang.String libString2 = getLibString(i4);
            if (libString2 == null) {
                return null;
            }
            arrayList.add(libString2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    @javax.annotation.Nullable
    static java.lang.String[] tryGetDepsFromPrecomputedDeps(java.lang.String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }

    private static void verifyUninitialized() {
        if (sInitialized) {
            synchronized (com.facebook.soloader.NativeDeps.class) {
                if (sInitialized) {
                    throw new java.lang.IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
                }
            }
        }
    }
}
