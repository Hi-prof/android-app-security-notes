package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public abstract class NativeLibrary {
    private static final java.lang.String TAG = "com.facebook.soloader.NativeLibrary";

    @javax.annotation.Nullable
    private java.util.List<java.lang.String> mLibraryNames;
    private final java.lang.Object mLock = new java.lang.Object();
    private java.lang.Boolean mLoadLibraries = true;
    private boolean mLibrariesLoaded = false;

    @javax.annotation.Nullable
    private volatile java.lang.UnsatisfiedLinkError mLinkError = null;

    protected void initialNativeCheck() throws java.lang.UnsatisfiedLinkError {
    }

    protected NativeLibrary(java.util.List<java.lang.String> list) {
        this.mLibraryNames = list;
    }

    @javax.annotation.Nullable
    public boolean loadLibraries() {
        synchronized (this.mLock) {
            if (!this.mLoadLibraries.booleanValue()) {
                return this.mLibrariesLoaded;
            }
            try {
                try {
                    java.util.List<java.lang.String> list = this.mLibraryNames;
                    if (list != null) {
                        java.util.Iterator<java.lang.String> it = list.iterator();
                        while (it.hasNext()) {
                            com.facebook.soloader.SoLoader.loadLibrary(it.next());
                        }
                    }
                    initialNativeCheck();
                    this.mLibrariesLoaded = true;
                    this.mLibraryNames = null;
                } catch (java.lang.Throwable th) {
                    com.facebook.soloader.LogUtil.e(TAG, "Failed to load native lib (other error): ", th);
                    this.mLinkError = new java.lang.UnsatisfiedLinkError("Failed loading libraries");
                    this.mLinkError.initCause(th);
                    this.mLibrariesLoaded = false;
                }
            } catch (java.lang.UnsatisfiedLinkError e) {
                com.facebook.soloader.LogUtil.e(TAG, "Failed to load native lib (initial check): ", e);
                this.mLinkError = e;
                this.mLibrariesLoaded = false;
            }
            this.mLoadLibraries = false;
            return this.mLibrariesLoaded;
        }
    }

    public void ensureLoaded() throws java.lang.UnsatisfiedLinkError {
        if (!loadLibraries()) {
            throw this.mLinkError;
        }
    }

    @javax.annotation.Nullable
    public java.lang.UnsatisfiedLinkError getError() {
        return this.mLinkError;
    }
}
