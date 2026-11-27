package com.facebook.soloader.nativeloader;

/* JADX INFO: loaded from: classes.dex */
public class NativeLoader {
    private static com.facebook.soloader.nativeloader.NativeLoaderDelegate sDelegate;

    private NativeLoader() {
    }

    public static boolean loadLibrary(java.lang.String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(java.lang.String str, int i) {
        com.facebook.soloader.nativeloader.NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (com.facebook.soloader.nativeloader.NativeLoader.class) {
            nativeLoaderDelegate = sDelegate;
            if (nativeLoaderDelegate == null) {
                throw new java.lang.IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.loadLibrary(str, i);
    }

    public static java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        com.facebook.soloader.nativeloader.NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (com.facebook.soloader.nativeloader.NativeLoader.class) {
            nativeLoaderDelegate = sDelegate;
            if (nativeLoaderDelegate == null) {
                throw new java.lang.IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.getLibraryPath(str);
    }

    public static int getSoSourcesVersion() {
        com.facebook.soloader.nativeloader.NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (com.facebook.soloader.nativeloader.NativeLoader.class) {
            nativeLoaderDelegate = sDelegate;
            if (nativeLoaderDelegate == null) {
                throw new java.lang.IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.getSoSourcesVersion();
    }

    public static void init(com.facebook.soloader.nativeloader.NativeLoaderDelegate nativeLoaderDelegate) {
        synchronized (com.facebook.soloader.nativeloader.NativeLoader.class) {
            if (sDelegate != null) {
                throw new java.lang.IllegalStateException("Cannot re-initialize NativeLoader.");
            }
            sDelegate = nativeLoaderDelegate;
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (com.facebook.soloader.nativeloader.NativeLoader.class) {
            z = sDelegate != null;
        }
        return z;
    }

    public static void initIfUninitialized(com.facebook.soloader.nativeloader.NativeLoaderDelegate nativeLoaderDelegate) {
        if (isInitialized()) {
            return;
        }
        init(nativeLoaderDelegate);
    }
}
