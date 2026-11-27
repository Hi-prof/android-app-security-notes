package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SoFileLoaderImpl implements com.facebook.soloader.SoFileLoader {
    private static final java.lang.String TAG = "SoFileLoaderImpl";

    @javax.annotation.Nullable
    private final java.lang.String mLocalLdLibraryPath;

    @javax.annotation.Nullable
    private final java.lang.String mLocalLdLibraryPathNoZips;

    @javax.annotation.Nullable
    private final java.lang.reflect.Method mNativeLoadRuntimeMethod;
    private final java.lang.Runtime mRuntime = java.lang.Runtime.getRuntime();

    public SoFileLoaderImpl() {
        java.lang.reflect.Method nativeLoadRuntimeMethod = com.facebook.soloader.SysUtil.getNativeLoadRuntimeMethod();
        this.mNativeLoadRuntimeMethod = nativeLoadRuntimeMethod;
        java.lang.String classLoaderLdLoadLibrary = nativeLoadRuntimeMethod != null ? com.facebook.soloader.SysUtil.getClassLoaderLdLoadLibrary() : null;
        this.mLocalLdLibraryPath = classLoaderLdLoadLibrary;
        this.mLocalLdLibraryPathNoZips = com.facebook.soloader.SysUtil.makeNonZipPath(classLoaderLdLoadLibrary);
    }

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(java.lang.String str, com.facebook.soloader.ElfByteChannel elfByteChannel, int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0082 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoFileLoaderImpl.TAG, "Error when loading library: " + r3 + ", library hash is " + getLibHash(r10) + ", LD_LIBRARY_PATH is " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return;
     */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void load(java.lang.String r10, int r11) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoFileLoaderImpl.load(java.lang.String, int):void");
    }

    private java.lang.String getLibHash(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(io.dcloud.common.util.Md5Utils.ALGORITHM);
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        java.lang.String str2 = java.lang.String.format("%32x", new java.math.BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (java.io.IOException | java.lang.SecurityException | java.security.NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}
