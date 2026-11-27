package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public abstract class SoSource {
    public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;

    @java.lang.Deprecated
    public static final int LOAD_FLAG_ALLOW_SOURCE_CHANGE = 2;
    public static final int LOAD_FLAG_MIN_CUSTOM_FLAG = 4;
    public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
    public static final int LOAD_RESULT_LOADED = 1;
    public static final int LOAD_RESULT_NOT_FOUND = 0;
    public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;
    public static final int PREPARE_FLAG_DISABLE_FS_SYNC_JOB = 4;
    public static final int PREPARE_FLAG_FORCE_REFRESH = 2;

    public void addToLdLibraryPath(java.util.Collection<java.lang.String> collection) {
    }

    @javax.annotation.Nullable
    public java.lang.String[] getLibraryDependencies(java.lang.String str) throws java.io.IOException {
        return null;
    }

    @javax.annotation.Nullable
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        return null;
    }

    public abstract java.lang.String getName();

    @javax.annotation.Nullable
    protected java.io.File getSoFileByName(java.lang.String str) throws java.io.IOException {
        return null;
    }

    public abstract int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException;

    protected void prepare(int i) throws java.io.IOException {
    }

    @javax.annotation.Nullable
    public abstract java.io.File unpackLibrary(java.lang.String str) throws java.io.IOException;

    public java.lang.String[] getSoSourceAbis() {
        return com.facebook.soloader.SysUtil.getSupportedAbis();
    }

    public java.lang.String toString() {
        return getName();
    }
}
