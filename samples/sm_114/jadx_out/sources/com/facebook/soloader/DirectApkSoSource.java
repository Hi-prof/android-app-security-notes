package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class DirectApkSoSource extends com.facebook.soloader.SoSource implements com.facebook.soloader.RecoverableSoSource {
    private final java.util.Set<java.lang.String> mDirectApkLdPaths;
    private final java.util.Map<java.lang.String, java.util.Set<java.lang.String>> mLibsInApkCache = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.util.Set<java.lang.String>> mDepsCache = new java.util.HashMap();

    public DirectApkSoSource(android.content.Context context) {
        this.mDirectApkLdPaths = getDirectApkLdPaths(context);
    }

    public DirectApkSoSource(java.util.Set<java.lang.String> set) {
        this.mDirectApkLdPaths = set;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        if (com.facebook.soloader.SoLoader.sSoFileLoader == null) {
            throw new java.lang.IllegalStateException("SoLoader.init() not yet called");
        }
        for (java.lang.String str2 : this.mDirectApkLdPaths) {
            java.util.Set<java.lang.String> set = this.mLibsInApkCache.get(str2);
            if (android.text.TextUtils.isEmpty(str2) || set == null || !set.contains(str)) {
                com.facebook.soloader.LogUtil.v(com.facebook.soloader.SoLoader.TAG, str + " not found on " + str2);
            } else {
                loadDependencies(str2, str, i, threadPolicy);
                try {
                    i |= 4;
                    com.facebook.soloader.SoLoader.sSoFileLoader.load(str2 + java.io.File.separator + str, i);
                    com.facebook.soloader.LogUtil.d(com.facebook.soloader.SoLoader.TAG, str + " found on " + str2);
                    return 1;
                } catch (java.lang.UnsatisfiedLinkError e) {
                    com.facebook.soloader.LogUtil.w(com.facebook.soloader.SoLoader.TAG, str + " not found on " + str2 + " flag: " + i, e);
                }
            }
        }
        return 0;
    }

    @Override // com.facebook.soloader.SoSource
    public java.io.File unpackLibrary(java.lang.String str) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    public boolean isValid() {
        return !this.mDirectApkLdPaths.isEmpty();
    }

    @Override // com.facebook.soloader.SoSource
    @javax.annotation.Nullable
    public java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        for (java.lang.String str2 : this.mDirectApkLdPaths) {
            java.util.Set<java.lang.String> set = this.mLibsInApkCache.get(str2);
            if (!android.text.TextUtils.isEmpty(str2) && set != null && set.contains(str)) {
                return str2 + java.io.File.separator + str;
            }
        }
        return null;
    }

    static java.util.Set<java.lang.String> getDirectApkLdPaths(android.content.Context context) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.String fallbackApkLdPath = getFallbackApkLdPath(context.getApplicationInfo().sourceDir);
        if (fallbackApkLdPath != null) {
            hashSet.add(fallbackApkLdPath);
        }
        if (context.getApplicationInfo().splitSourceDirs != null) {
            for (java.lang.String str : context.getApplicationInfo().splitSourceDirs) {
                java.lang.String fallbackApkLdPath2 = getFallbackApkLdPath(str);
                if (fallbackApkLdPath2 != null) {
                    hashSet.add(fallbackApkLdPath2);
                }
            }
        }
        return hashSet;
    }

    @javax.annotation.Nullable
    private static java.lang.String getFallbackApkLdPath(java.lang.String str) {
        java.lang.String[] supportedAbis = com.facebook.soloader.SysUtil.getSupportedAbis();
        if (str == null || str.isEmpty()) {
            com.facebook.soloader.LogUtil.w(com.facebook.soloader.SoLoader.TAG, "Cannot compute fallback path, apk path is ".concat(str != null ? "empty" : "null"));
            return null;
        }
        if (supportedAbis == null || supportedAbis.length == 0) {
            com.facebook.soloader.LogUtil.w(com.facebook.soloader.SoLoader.TAG, "Cannot compute fallback path, supportedAbis is ".concat(supportedAbis != null ? "empty" : "null"));
            return null;
        }
        return str + "!/lib/" + supportedAbis[0];
    }

    private void loadDependencies(java.lang.String str, java.lang.String str2, int i, android.os.StrictMode.ThreadPolicy threadPolicy) throws java.io.IOException {
        java.util.Set<java.lang.String> depsFromCache = getDepsFromCache(str, str2);
        if (depsFromCache == null) {
            buildLibDepsCache(str, str2);
            depsFromCache = getDepsFromCache(str, str2);
        }
        if (depsFromCache != null) {
            java.util.Iterator<java.lang.String> it = depsFromCache.iterator();
            while (it.hasNext()) {
                com.facebook.soloader.SoLoader.loadDependency(it.next(), i, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws java.io.IOException {
        prepare();
    }

    private void prepare() throws java.io.IOException {
        int iIndexOf;
        int i;
        java.lang.String strSubstring = null;
        for (java.lang.String str : this.mDirectApkLdPaths) {
            if (!android.text.TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(33)) >= 0 && (i = iIndexOf + 2) < str.length()) {
                strSubstring = str.substring(i);
            }
            if (!android.text.TextUtils.isEmpty(strSubstring)) {
                java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(getApkPathFromLdPath(str));
                try {
                    java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null && zipEntryNextElement.getMethod() == 0 && zipEntryNextElement.getName().startsWith(strSubstring) && zipEntryNextElement.getName().endsWith(".so")) {
                            appendLibsInApkCache(str, zipEntryNextElement.getName().substring(strSubstring.length() + 1));
                        }
                    }
                    zipFile.close();
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
    }

    private void buildLibDepsCache(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(getApkPathFromLdPath(str));
        try {
            java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement != null) {
                    if (zipEntryNextElement.getName().endsWith("/" + str2)) {
                        buildLibDepsCacheImpl(str, zipFile, zipEntryNextElement, str2);
                    } else {
                        continue;
                    }
                }
            }
            zipFile.close();
        } catch (java.lang.Throwable th) {
            try {
                zipFile.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void buildLibDepsCacheImpl(java.lang.String str, java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry, java.lang.String str2) throws java.io.IOException {
        com.facebook.soloader.ElfZipFileChannel elfZipFileChannel = new com.facebook.soloader.ElfZipFileChannel(zipFile, zipEntry);
        try {
            for (java.lang.String str3 : com.facebook.soloader.NativeDeps.getDependencies(str2, elfZipFileChannel)) {
                if (!str3.startsWith("/")) {
                    appendDepsCache(str, str2, str3);
                }
            }
            elfZipFileChannel.close();
        } catch (java.lang.Throwable th) {
            try {
                elfZipFileChannel.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String getName() {
        return "DirectApkSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public java.lang.String toString() {
        return getName() + "[root = " + this.mDirectApkLdPaths.toString() + com.taobao.weex.el.parse.Operators.ARRAY_END;
    }

    private void appendLibsInApkCache(java.lang.String str, java.lang.String str2) {
        synchronized (this.mLibsInApkCache) {
            if (!this.mLibsInApkCache.containsKey(str)) {
                this.mLibsInApkCache.put(str, new java.util.HashSet());
            }
            this.mLibsInApkCache.get(str).add(str2);
        }
    }

    private void appendDepsCache(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (this.mDepsCache) {
            java.lang.String str4 = str + str2;
            if (!this.mDepsCache.containsKey(str4)) {
                this.mDepsCache.put(str4, new java.util.HashSet());
            }
            this.mDepsCache.get(str4).add(str3);
        }
    }

    @javax.annotation.Nullable
    private java.util.Set<java.lang.String> getDepsFromCache(java.lang.String str, java.lang.String str2) {
        java.util.Set<java.lang.String> set;
        synchronized (this.mDepsCache) {
            set = this.mDepsCache.get(str + str2);
        }
        return set;
    }

    private static java.lang.String getApkPathFromLdPath(java.lang.String str) {
        return str.substring(0, str.indexOf(33));
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public com.facebook.soloader.SoSource recover(android.content.Context context) {
        com.facebook.soloader.DirectApkSoSource directApkSoSource = new com.facebook.soloader.DirectApkSoSource(context);
        try {
            directApkSoSource.prepare();
            return directApkSoSource;
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
