package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class SysUtil {
    private static final long APK_DEP_BLOCK_METADATA_LENGTH = 20;
    private static final byte APK_SIGNATURE_VERSION = 1;
    private static final java.lang.String TAG = "SysUtil";

    public static int findAbiScore(java.lang.String[] strArr, java.lang.String str) {
        for (int i = 0; i < strArr.length; i++) {
            java.lang.String str2 = strArr[i];
            if (str2 != null && str.equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteOrThrow(java.io.File file) throws java.io.IOException {
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            com.facebook.soloader.LogUtil.e(TAG, "Enable write permission failed: " + parentFile);
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new java.io.IOException("Could not delete file " + file);
    }

    public static java.lang.String[] getSupportedAbis() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return com.facebook.soloader.SysUtil.MarshmallowSysdeps.getSupportedAbis();
        }
        return com.facebook.soloader.SysUtil.LollipopSysdeps.getSupportedAbis();
    }

    public static void fallocateIfSupported(java.io.FileDescriptor fileDescriptor, long j) throws java.io.IOException {
        com.facebook.soloader.SysUtil.LollipopSysdeps.fallocateIfSupported(fileDescriptor, j);
    }

    public static void dumbDelete(java.io.File file) throws java.io.IOException {
        java.util.Stack stack = new java.util.Stack();
        stack.push(file);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (!stack.isEmpty()) {
            java.io.File file2 = (java.io.File) stack.pop();
            if (!file2.isDirectory()) {
                deleteOrThrow(file2);
            } else {
                arrayList.add(file2);
                java.io.File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles != null) {
                    for (java.io.File file3 : fileArrListFiles) {
                        stack.push(file3);
                    }
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            deleteOrThrow((java.io.File) arrayList.get(size));
        }
    }

    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        public static java.lang.String[] getSupportedAbis() {
            java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
            java.util.TreeSet treeSet = new java.util.TreeSet();
            try {
                if (is64Bit()) {
                    treeSet.add(com.facebook.soloader.MinElf.ISA.AARCH64);
                    treeSet.add(com.facebook.soloader.MinElf.ISA.X86_64);
                } else {
                    treeSet.add(com.facebook.soloader.MinElf.ISA.ARM);
                    treeSet.add("x86");
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
            } catch (android.system.ErrnoException e) {
                com.facebook.soloader.LogUtil.e(com.facebook.soloader.SysUtil.TAG, java.lang.String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", java.util.Arrays.toString(strArr), java.lang.Integer.valueOf(e.errno), e.getMessage()));
                return android.os.Build.SUPPORTED_ABIS;
            }
        }

        public static void fallocateIfSupported(java.io.FileDescriptor fileDescriptor, long j) throws java.io.IOException {
            try {
                android.system.Os.posix_fallocate(fileDescriptor, 0L, j);
            } catch (android.system.ErrnoException e) {
                if (e.errno != android.system.OsConstants.EOPNOTSUPP && e.errno != android.system.OsConstants.ENOSYS && e.errno != android.system.OsConstants.EINVAL) {
                    throw new java.io.IOException(e.toString(), e);
                }
            }
        }

        public static boolean is64Bit() throws android.system.ErrnoException {
            return android.system.Os.readlink("/proc/self/exe").contains("64");
        }
    }

    private static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static java.lang.String[] getSupportedAbis() {
            java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
            java.util.TreeSet treeSet = new java.util.TreeSet();
            if (is64Bit()) {
                treeSet.add(com.facebook.soloader.MinElf.ISA.AARCH64);
                treeSet.add(com.facebook.soloader.MinElf.ISA.X86_64);
            } else {
                treeSet.add(com.facebook.soloader.MinElf.ISA.ARM);
                treeSet.add("x86");
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        }

        public static boolean is64Bit() {
            return android.os.Process.is64Bit();
        }

        public static boolean isSupportedDirectLoad(@javax.annotation.Nullable android.content.Context context, int i) {
            if (i == 2) {
                return true;
            }
            return isDisabledExtractNativeLibs(context);
        }

        public static boolean isDisabledExtractNativeLibs(@javax.annotation.Nullable android.content.Context context) {
            return context != null && (context.getApplicationInfo().flags & 268435456) == 0;
        }

        private static boolean isApkUncompressedDso(android.content.Context context) throws java.io.IOException {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(new java.io.File(context.getApplicationInfo().sourceDir));
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                while (true) {
                    if (!enumerationEntries.hasMoreElements()) {
                        zipFile.close();
                        return false;
                    }
                    java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement != null && zipEntryNextElement.getName().endsWith(".so") && zipEntryNextElement.getName().contains("/lib") && !zipEntryNextElement.getName().startsWith("assets/")) {
                        boolean z = zipEntryNextElement.getMethod() == 0;
                        zipFile.close();
                        return z;
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    zipFile.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void mkdirOrThrow(java.io.File file) throws java.io.IOException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new java.io.IOException("cannot mkdir: " + file);
    }

    static int copyBytes(java.io.RandomAccessFile randomAccessFile, java.io.InputStream inputStream, int i, byte[] bArr) throws java.io.IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, 0, java.lang.Math.min(bArr.length, i - i2));
            if (i3 == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, i3);
            i2 += i3;
        }
        return i2;
    }

    public static void fsyncAll(java.io.File file) throws java.io.IOException {
        java.util.Stack stack = new java.util.Stack();
        stack.push(file);
        while (!stack.isEmpty()) {
            java.io.File file2 = (java.io.File) stack.pop();
            if (file2.isDirectory()) {
                java.io.File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles == null) {
                    throw new java.io.IOException("cannot list directory " + file2);
                }
                for (java.io.File file3 : fileArrListFiles) {
                    stack.push(file3);
                }
            } else if (file2.getPath().endsWith("_lock")) {
                continue;
            } else {
                try {
                    java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file2, "r");
                    try {
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
                } catch (java.io.IOException e) {
                    com.facebook.soloader.LogUtil.e(TAG, "Syncing failed for " + file2 + ": " + e.getMessage());
                }
            }
        }
    }

    private static long getParcelPadSize(long j) {
        return j + ((4 - (j % 4)) % 4);
    }

    public static long getApkDepBlockLength(java.io.File file) throws java.io.IOException {
        return getParcelPadSize(((long) (file.getCanonicalFile().getPath().length() + 1)) * 2) + APK_DEP_BLOCK_METADATA_LENGTH;
    }

    public static byte[] makeApkDepBlock(java.io.File file, android.content.Context context) throws java.io.IOException {
        java.io.File canonicalFile = file.getCanonicalFile();
        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            parcelObtain.writeInt(getAppVersionCode(context));
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static int getAppVersionCode(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.RuntimeException unused) {
            }
        }
        return 0;
    }

    public static boolean is64Bit() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return com.facebook.soloader.SysUtil.MarshmallowSysdeps.is64Bit();
        }
        try {
            return com.facebook.soloader.SysUtil.LollipopSysdeps.is64Bit();
        } catch (java.lang.Exception e) {
            com.facebook.soloader.LogUtil.e(TAG, java.lang.String.format("Could not read /proc/self/exe. Err msg: %s", e.getMessage()));
            return false;
        }
    }

    public static boolean isSupportedDirectLoad(@javax.annotation.Nullable android.content.Context context, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return com.facebook.soloader.SysUtil.MarshmallowSysdeps.isSupportedDirectLoad(context, i);
        }
        return false;
    }

    public static boolean isDisabledExtractNativeLibs(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return com.facebook.soloader.SysUtil.MarshmallowSysdeps.isDisabledExtractNativeLibs(context);
        }
        return false;
    }

    @javax.annotation.Nullable
    public static com.facebook.soloader.FileLocker getOrCreateLockOnDir(java.io.File file, java.io.File file2) throws java.lang.Throwable {
        boolean z;
        try {
            return getFileLocker(file2);
        } catch (java.io.FileNotFoundException e) {
            z = true;
            try {
                if (!file.setWritable(true)) {
                    throw e;
                }
                com.facebook.soloader.FileLocker fileLocker = getFileLocker(file2);
                if (!file.setWritable(false)) {
                    com.facebook.soloader.LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                return fileLocker;
            } catch (java.lang.Throwable th) {
                th = th;
                if (z && !file.setWritable(false)) {
                    com.facebook.soloader.LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            z = false;
            if (z) {
                com.facebook.soloader.LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
            }
            throw th;
        }
    }

    public static com.facebook.soloader.FileLocker getFileLocker(java.io.File file) throws java.io.IOException {
        return com.facebook.soloader.FileLocker.lock(file);
    }

    public static java.lang.String getBaseName(java.lang.String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf > 0 ? str.substring(0, iLastIndexOf) : str;
    }

    @javax.annotation.Nullable
    public static java.lang.String makeNonZipPath(@javax.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String[] strArrSplit = str.split(":");
        java.util.ArrayList arrayList = new java.util.ArrayList(strArrSplit.length);
        for (java.lang.String str2 : strArrSplit) {
            if (!str2.contains(com.taobao.weex.el.parse.Operators.AND_NOT)) {
                arrayList.add(str2);
            }
        }
        return android.text.TextUtils.join(":", arrayList);
    }

    @javax.annotation.Nullable
    public static java.lang.String getClassLoaderLdLoadLibrary() {
        java.lang.ClassLoader classLoader = com.facebook.soloader.SoLoader.class.getClassLoader();
        if (classLoader != null && !(classLoader instanceof dalvik.system.BaseDexClassLoader)) {
            throw new java.lang.IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
        try {
            return (java.lang.String) dalvik.system.BaseDexClassLoader.class.getMethod("getLdLibraryPath", null).invoke((dalvik.system.BaseDexClassLoader) classLoader, null);
        } catch (java.lang.Exception e) {
            com.facebook.soloader.LogUtil.e(TAG, "Cannot call getLdLibraryPath", e);
            return null;
        }
    }

    @javax.annotation.Nullable
    public static java.lang.reflect.Method getNativeLoadRuntimeMethod() {
        if (android.os.Build.VERSION.SDK_INT < 23 || android.os.Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Runtime.class.getDeclaredMethod("nativeLoad", java.lang.String.class, java.lang.ClassLoader.class, java.lang.String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Exception e) {
            com.facebook.soloader.LogUtil.w(TAG, "Cannot get nativeLoad method", e);
            return null;
        }
    }
}
