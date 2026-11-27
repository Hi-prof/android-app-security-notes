package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class DirectorySoSource extends com.facebook.soloader.SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final java.util.List<java.lang.String> denyList;
    protected final int flags;
    protected final java.io.File soDirectory;

    public DirectorySoSource(java.io.File file, int i) {
        this(file, i, new java.lang.String[0]);
    }

    public DirectorySoSource(java.io.File file, int i, java.lang.String[] strArr) {
        this.soDirectory = file;
        this.flags = i;
        this.denyList = java.util.Arrays.asList(strArr);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    protected int loadLibraryFrom(java.lang.String str, int i, java.io.File file, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        if (com.facebook.soloader.SoLoader.sSoFileLoader == null) {
            throw new java.lang.IllegalStateException("SoLoader.init() not yet called");
        }
        if (this.denyList.contains(str)) {
            com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, str + " is on the denyList, skip loading from " + file.getCanonicalPath());
            return 0;
        }
        java.io.File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            com.facebook.soloader.LogUtil.v(com.facebook.soloader.SoLoader.TAG, str + " file not found on " + file.getCanonicalPath());
            return 0;
        }
        java.lang.String canonicalPath = soFileByName.getCanonicalPath();
        com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, str + " file found at " + canonicalPath);
        if ((i & 1) != 0 && (this.flags & 2) != 0) {
            com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, str + " loaded implicitly");
            return 2;
        }
        if ((this.flags & 1) != 0) {
            com.facebook.soloader.ElfFileChannel elfFileChannel = new com.facebook.soloader.ElfFileChannel(soFileByName);
            try {
                com.facebook.soloader.NativeDeps.loadDependencies(str, elfFileChannel, i, threadPolicy);
                elfFileChannel.close();
            } catch (java.lang.Throwable th) {
                try {
                    elfFileChannel.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, "Not resolving dependencies for " + str);
        }
        try {
            com.facebook.soloader.SoLoader.sSoFileLoader.load(canonicalPath, i);
            return 1;
        } catch (java.lang.UnsatisfiedLinkError e) {
            throw com.facebook.soloader.SoLoaderULErrorFactory.create(str, e);
        }
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    protected java.io.File getSoFileByName(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        java.io.File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String[] getLibraryDependencies(java.lang.String str) throws java.io.IOException {
        java.io.File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        com.facebook.soloader.ElfFileChannel elfFileChannel = new com.facebook.soloader.ElfFileChannel(soFileByName);
        try {
            java.lang.String[] dependencies = com.facebook.soloader.NativeDeps.getDependencies(str, elfFileChannel);
            elfFileChannel.close();
            return dependencies;
        } catch (java.lang.Throwable th) {
            try {
                elfFileChannel.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.io.File unpackLibrary(java.lang.String str) throws java.io.IOException {
        return getSoFileByName(str);
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(java.util.Collection<java.lang.String> collection) {
        try {
            collection.add(this.soDirectory.getCanonicalPath());
        } catch (java.io.IOException e) {
            com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Failed to get canonical path for " + this.soDirectory.getName() + " due to " + e.toString() + ", falling to the absolute one");
            collection.add(this.soDirectory.getAbsolutePath());
        }
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "DirectorySoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String toString() {
        java.lang.String name;
        try {
            name = java.lang.String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (java.io.IOException unused) {
            name = this.soDirectory.getName();
        }
        return getName() + "[root = " + name + " flags = " + this.flags + com.taobao.weex.el.parse.Operators.ARRAY_END;
    }
}
