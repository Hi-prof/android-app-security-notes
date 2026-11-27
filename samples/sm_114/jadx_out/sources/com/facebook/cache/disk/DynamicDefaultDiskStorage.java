package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class DynamicDefaultDiskStorage implements com.facebook.cache.disk.DiskStorage {
    private static final java.lang.Class<?> TAG = com.facebook.cache.disk.DynamicDefaultDiskStorage.class;
    private final java.lang.String mBaseDirectoryName;
    private final com.facebook.common.internal.Supplier<java.io.File> mBaseDirectoryPathSupplier;
    private final com.facebook.cache.common.CacheErrorLogger mCacheErrorLogger;
    volatile com.facebook.cache.disk.DynamicDefaultDiskStorage.State mCurrentState = new com.facebook.cache.disk.DynamicDefaultDiskStorage.State(null, null);
    private final int mVersion;

    static class State {

        @javax.annotation.Nullable
        public final com.facebook.cache.disk.DiskStorage delegate;

        @javax.annotation.Nullable
        public final java.io.File rootDirectory;

        State(@javax.annotation.Nullable java.io.File file, @javax.annotation.Nullable com.facebook.cache.disk.DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, com.facebook.common.internal.Supplier<java.io.File> supplier, java.lang.String str, com.facebook.cache.common.CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        try {
            return get().isEnabled();
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        try {
            return get().isExternal();
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public java.lang.String getStorageName() {
        try {
            return get().getStorageName();
        } catch (java.io.IOException unused) {
            return "";
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    @javax.annotation.Nullable
    public com.facebook.binaryresource.BinaryResource getResource(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return get().getResource(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return get().contains(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return get().touch(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (java.io.IOException e) {
            com.facebook.common.logging.FLog.e(TAG, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public com.facebook.cache.disk.DiskStorage.Inserter insert(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return get().insert(str, obj);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> getEntries() throws java.io.IOException {
        return get().getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(com.facebook.cache.disk.DiskStorage.Entry entry) throws java.io.IOException {
        return get().remove(entry);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(java.lang.String str) throws java.io.IOException {
        return get().remove(str);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws java.io.IOException {
        get().clearAll();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.io.IOException {
        return get().getDumpInfo();
    }

    synchronized com.facebook.cache.disk.DiskStorage get() throws java.io.IOException {
        if (shouldCreateNewStorage()) {
            deleteOldStorageIfNecessary();
            createStorage();
        }
        return (com.facebook.cache.disk.DiskStorage) com.facebook.common.internal.Preconditions.checkNotNull(this.mCurrentState.delegate);
    }

    private boolean shouldCreateNewStorage() {
        com.facebook.cache.disk.DynamicDefaultDiskStorage.State state = this.mCurrentState;
        return state.delegate == null || state.rootDirectory == null || !state.rootDirectory.exists();
    }

    void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate == null || this.mCurrentState.rootDirectory == null) {
            return;
        }
        com.facebook.common.file.FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }

    private void createStorage() throws java.io.IOException {
        java.io.File file = new java.io.File(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        createRootDirectoryIfNecessary(file);
        this.mCurrentState = new com.facebook.cache.disk.DynamicDefaultDiskStorage.State(file, new com.facebook.cache.disk.DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
    }

    void createRootDirectoryIfNecessary(java.io.File file) throws java.io.IOException {
        try {
            com.facebook.common.file.FileUtils.mkdirs(file);
            com.facebook.common.logging.FLog.d(TAG, "Created cache directory %s", file.getAbsolutePath());
        } catch (com.facebook.common.file.FileUtils.CreateDirectoryException e) {
            this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
