package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SystemLoadWrapperSoSource extends com.facebook.soloader.SoSource {
    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.io.File unpackLibrary(java.lang.String str) throws java.io.IOException {
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        try {
            java.lang.System.loadLibrary(str.substring(3, str.length() - 3));
            return 1;
        } catch (java.lang.Exception e) {
            com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Error loading library: " + str, e);
            return 0;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "SystemLoadWrapperSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String toString() {
        return getName() + com.taobao.weex.el.parse.Operators.ARRAY_START_STR + com.facebook.soloader.SysUtil.getClassLoaderLdLoadLibrary() + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
    }
}
