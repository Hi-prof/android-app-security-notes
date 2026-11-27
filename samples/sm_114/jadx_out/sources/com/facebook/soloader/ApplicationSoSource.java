package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationSoSource extends com.facebook.soloader.SoSource implements com.facebook.soloader.RecoverableSoSource {
    private final int flags;
    private com.facebook.soloader.DirectorySoSource soSource;

    public ApplicationSoSource(android.content.Context context, int i) {
        this.flags = i;
        this.soSource = new com.facebook.soloader.DirectorySoSource(getNativeLibDirFromContext(context), i);
    }

    private static java.io.File getNativeLibDirFromContext(android.content.Context context) {
        return new java.io.File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        return this.soSource.loadLibrary(str, i, threadPolicy);
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.io.File getSoFileByName(java.lang.String str) throws java.io.IOException {
        return this.soSource.getSoFileByName(str);
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        return this.soSource.getLibraryPath(str);
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String[] getLibraryDependencies(java.lang.String str) throws java.io.IOException {
        return this.soSource.getLibraryDependencies(str);
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.io.File unpackLibrary(java.lang.String str) throws java.io.IOException {
        return this.soSource.unpackLibrary(str);
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws java.io.IOException {
        this.soSource.prepare(i);
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(java.util.Collection<java.lang.String> collection) {
        this.soSource.addToLdLibraryPath(collection);
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "ApplicationSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String toString() {
        return getName() + com.taobao.weex.el.parse.Operators.ARRAY_START_STR + this.soSource.toString() + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public com.facebook.soloader.SoSource recover(android.content.Context context) {
        this.soSource = new com.facebook.soloader.DirectorySoSource(getNativeLibDirFromContext(context), this.flags | 1);
        return this;
    }
}
