package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.DiskStorage {
    private static final java.lang.String CONTENT_FILE_EXTENSION = ".cnt";
    private static final java.lang.String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final java.lang.String TEMP_FILE_EXTENSION = ".tmp";
    private final com.facebook.cache.common.CacheErrorLogger mCacheErrorLogger;
    private final com.facebook.common.time.Clock mClock;
    private final boolean mIsExternal;
    private final java.io.File mRootDirectory;
    private final java.io.File mVersionDirectory;
    private static final java.lang.Class<?> TAG = com.facebook.cache.disk.DefaultDiskStorage.class;
    static final long TEMP_FILE_LIFETIME_MS = java.util.concurrent.TimeUnit.MINUTES.toMillis(30);

    public @interface FileType {
        public static final java.lang.String CONTENT = ".cnt";
        public static final java.lang.String TEMP = ".tmp";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    public DefaultDiskStorage(java.io.File file, int i, com.facebook.cache.common.CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mIsExternal = isExternal(file, cacheErrorLogger);
        this.mVersionDirectory = new java.io.File(file, getVersionSubdirectoryName(i));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
        this.mClock = com.facebook.common.time.SystemClock.get();
    }

    private static boolean isExternal(java.io.File file, com.facebook.cache.common.CacheErrorLogger cacheErrorLogger) {
        java.lang.String canonicalPath;
        boolean zContains = false;
        try {
            java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                java.lang.String string = externalStorageDirectory.toString();
                try {
                    canonicalPath = file.getCanonicalPath();
                    try {
                        zContains = canonicalPath.contains(string);
                    } catch (java.io.IOException e) {
                        e = e;
                        cacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to read folder to check if external: " + canonicalPath, e);
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    canonicalPath = null;
                }
            }
        } catch (java.lang.Exception e3) {
            cacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", e3);
        }
        return zContains;
    }

    static java.lang.String getVersionSubdirectoryName(int i) {
        return java.lang.String.format(null, "%s.ols%d.%d", DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, java.lang.Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.mIsExternal;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public java.lang.String getStorageName() {
        java.lang.String absolutePath = this.mRootDirectory.getAbsolutePath();
        return "_" + absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()) + "_" + absolutePath.hashCode();
    }

    private void recreateDirectoryIfVersionChanges() {
        if (this.mRootDirectory.exists()) {
            if (this.mVersionDirectory.exists()) {
                return;
            } else {
                com.facebook.common.file.FileTree.deleteRecursively(this.mRootDirectory);
            }
        }
        try {
            com.facebook.common.file.FileUtils.mkdirs(this.mVersionDirectory);
        } catch (com.facebook.common.file.FileUtils.CreateDirectoryException unused) {
            this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
        }
    }

    private static class IncompleteFileException extends java.io.IOException {
        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    java.io.File getContentFileFor(java.lang.String str) {
        return new java.io.File(getFilename(str));
    }

    private java.lang.String getSubdirectoryPath(java.lang.String str) {
        return this.mVersionDirectory + java.io.File.separator + java.lang.String.valueOf(java.lang.Math.abs(str.hashCode() % 100));
    }

    private java.io.File getSubdirectory(java.lang.String str) {
        return new java.io.File(getSubdirectoryPath(str));
    }

    private class EntriesCollector implements com.facebook.common.file.FileTreeVisitor {
        private final java.util.List<com.facebook.cache.disk.DiskStorage.Entry> result;

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(java.io.File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(java.io.File file) {
        }

        private EntriesCollector() {
            this.result = new java.util.ArrayList();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(java.io.File file) {
            com.facebook.cache.disk.DefaultDiskStorage.FileInfo shardFileInfo = com.facebook.cache.disk.DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null || shardFileInfo.type != ".cnt") {
                return;
            }
            this.result.add(new com.facebook.cache.disk.DefaultDiskStorage.EntryImpl(shardFileInfo.resourceId, file));
        }

        public java.util.List<com.facebook.cache.disk.DiskStorage.Entry> getEntries() {
            return java.util.Collections.unmodifiableList(this.result);
        }
    }

    private class PurgingVisitor implements com.facebook.common.file.FileTreeVisitor {
        private boolean insideBaseDirectory;

        private PurgingVisitor() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(java.io.File file) {
            if (this.insideBaseDirectory || !file.equals(com.facebook.cache.disk.DefaultDiskStorage.this.mVersionDirectory)) {
                return;
            }
            this.insideBaseDirectory = true;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(java.io.File file) {
            if (this.insideBaseDirectory && isExpectedFile(file)) {
                return;
            }
            file.delete();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(java.io.File file) {
            if (!com.facebook.cache.disk.DefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(com.facebook.cache.disk.DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        private boolean isExpectedFile(java.io.File file) {
            com.facebook.cache.disk.DefaultDiskStorage.FileInfo shardFileInfo = com.facebook.cache.disk.DefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null) {
                return false;
            }
            if (shardFileInfo.type == ".tmp") {
                return isRecentFile(file);
            }
            com.facebook.common.internal.Preconditions.checkState(shardFileInfo.type == ".cnt");
            return true;
        }

        private boolean isRecentFile(java.io.File file) {
            return file.lastModified() > com.facebook.cache.disk.DefaultDiskStorage.this.mClock.now() - com.facebook.cache.disk.DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        com.facebook.common.file.FileTree.walkFileTree(this.mRootDirectory, new com.facebook.cache.disk.DefaultDiskStorage.PurgingVisitor());
    }

    private void mkdirs(java.io.File file, java.lang.String str) throws java.io.IOException {
        try {
            com.facebook.common.file.FileUtils.mkdirs(file);
        } catch (com.facebook.common.file.FileUtils.CreateDirectoryException e) {
            this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public com.facebook.cache.disk.DiskStorage.Inserter insert(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        com.facebook.cache.disk.DefaultDiskStorage.FileInfo fileInfo = new com.facebook.cache.disk.DefaultDiskStorage.FileInfo(".tmp", str);
        java.io.File subdirectory = getSubdirectory(fileInfo.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            return new com.facebook.cache.disk.DefaultDiskStorage.InserterImpl(str, fileInfo.createTempFile(subdirectory));
        } catch (java.io.IOException e) {
            this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    @javax.annotation.Nullable
    public com.facebook.binaryresource.BinaryResource getResource(java.lang.String str, java.lang.Object obj) {
        java.io.File contentFileFor = getContentFileFor(str);
        if (!contentFileFor.exists()) {
            return null;
        }
        contentFileFor.setLastModified(this.mClock.now());
        return com.facebook.binaryresource.FileBinaryResource.createOrNull(contentFileFor);
    }

    private java.lang.String getFilename(java.lang.String str) {
        com.facebook.cache.disk.DefaultDiskStorage.FileInfo fileInfo = new com.facebook.cache.disk.DefaultDiskStorage.FileInfo(".cnt", str);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(java.lang.String str, java.lang.Object obj) {
        return query(str, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(java.lang.String str, java.lang.Object obj) {
        return query(str, true);
    }

    private boolean query(java.lang.String str, boolean z) {
        java.io.File contentFileFor = getContentFileFor(str);
        boolean zExists = contentFileFor.exists();
        if (z && zExists) {
            contentFileFor.setLastModified(this.mClock.now());
        }
        return zExists;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(com.facebook.cache.disk.DiskStorage.Entry entry) {
        return doRemove(((com.facebook.cache.disk.DefaultDiskStorage.EntryImpl) entry).getResource().getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(java.lang.String str) {
        return doRemove(getContentFileFor(str));
    }

    private long doRemove(java.io.File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        com.facebook.common.file.FileTree.deleteContents(this.mRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.lang.Throwable {
        java.util.List<com.facebook.cache.disk.DiskStorage.Entry> entries = getEntries();
        com.facebook.cache.disk.DiskStorage.DiskDumpInfo diskDumpInfo = new com.facebook.cache.disk.DiskStorage.DiskDumpInfo();
        java.util.Iterator<com.facebook.cache.disk.DiskStorage.Entry> it = entries.iterator();
        while (it.hasNext()) {
            com.facebook.cache.disk.DiskStorage.DiskDumpInfoEntry diskDumpInfoEntryDumpCacheEntry = dumpCacheEntry(it.next());
            java.lang.String str = diskDumpInfoEntryDumpCacheEntry.type;
            java.lang.Integer num = diskDumpInfo.typeCounts.get(str);
            if (num == null) {
                diskDumpInfo.typeCounts.put(str, 1);
            } else {
                diskDumpInfo.typeCounts.put(str, java.lang.Integer.valueOf(num.intValue() + 1));
            }
            diskDumpInfo.entries.add(diskDumpInfoEntryDumpCacheEntry);
        }
        return diskDumpInfo;
    }

    private com.facebook.cache.disk.DiskStorage.DiskDumpInfoEntry dumpCacheEntry(com.facebook.cache.disk.DiskStorage.Entry entry) throws java.lang.Throwable {
        java.lang.String str;
        com.facebook.cache.disk.DefaultDiskStorage.EntryImpl entryImpl = (com.facebook.cache.disk.DefaultDiskStorage.EntryImpl) entry;
        byte[] bytes = entryImpl.getResource().getBytes();
        java.lang.String strTypeOfBytes = typeOfBytes(bytes);
        if (strTypeOfBytes.equals(com.taobao.weex.common.Constants.Name.UNDEFINED) && bytes.length >= 4) {
            str = java.lang.String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", java.lang.Byte.valueOf(bytes[0]), java.lang.Byte.valueOf(bytes[1]), java.lang.Byte.valueOf(bytes[2]), java.lang.Byte.valueOf(bytes[3]));
        } else {
            str = "";
        }
        return new com.facebook.cache.disk.DiskStorage.DiskDumpInfoEntry(entryImpl.getId(), entryImpl.getResource().getFile().getPath(), strTypeOfBytes, entryImpl.getSize(), str);
    }

    private java.lang.String typeOfBytes(byte[] bArr) {
        if (bArr.length >= 2) {
            byte b = bArr[0];
            if (b == -1 && bArr[1] == -40) {
                return "jpg";
            }
            if (b == -119 && bArr[1] == 80) {
                return "png";
            }
            if (b == 82 && bArr[1] == 73) {
                return "webp";
            }
            if (b == 71 && bArr[1] == 73) {
                return "gif";
            }
            return com.taobao.weex.common.Constants.Name.UNDEFINED;
        }
        return com.taobao.weex.common.Constants.Name.UNDEFINED;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public java.util.List<com.facebook.cache.disk.DiskStorage.Entry> getEntries() throws java.io.IOException {
        com.facebook.cache.disk.DefaultDiskStorage.EntriesCollector entriesCollector = new com.facebook.cache.disk.DefaultDiskStorage.EntriesCollector();
        com.facebook.common.file.FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    static class EntryImpl implements com.facebook.cache.disk.DiskStorage.Entry {
        private final java.lang.String id;
        private final com.facebook.binaryresource.FileBinaryResource resource;
        private long size;
        private long timestamp;

        private EntryImpl(java.lang.String str, java.io.File file) {
            com.facebook.common.internal.Preconditions.checkNotNull(file);
            this.id = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(str);
            this.resource = com.facebook.binaryresource.FileBinaryResource.create(file);
            this.size = -1L;
            this.timestamp = -1L;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public java.lang.String getId() {
            return this.id;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public com.facebook.binaryresource.FileBinaryResource getResource() {
            return this.resource;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @javax.annotation.Nullable
    public com.facebook.cache.disk.DefaultDiskStorage.FileInfo getShardFileInfo(java.io.File file) {
        com.facebook.cache.disk.DefaultDiskStorage.FileInfo fileInfoFromFile = com.facebook.cache.disk.DefaultDiskStorage.FileInfo.fromFile(file);
        if (fileInfoFromFile != null && getSubdirectory(fileInfoFromFile.resourceId).equals(file.getParentFile())) {
            return fileInfoFromFile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @javax.annotation.Nullable
    public static java.lang.String getFileTypefromExtension(java.lang.String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    private static class FileInfo {
        public final java.lang.String resourceId;
        public final java.lang.String type;

        private FileInfo(java.lang.String str, java.lang.String str2) {
            this.type = str;
            this.resourceId = str2;
        }

        public java.lang.String toString() {
            return this.type + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.resourceId + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
        }

        public java.lang.String toPath(java.lang.String str) {
            return str + java.io.File.separator + this.resourceId + this.type;
        }

        public java.io.File createTempFile(java.io.File file) throws java.io.IOException {
            return java.io.File.createTempFile(this.resourceId + com.taobao.weex.el.parse.Operators.DOT_STR, ".tmp", file);
        }

        @javax.annotation.Nullable
        public static com.facebook.cache.disk.DefaultDiskStorage.FileInfo fromFile(java.io.File file) {
            java.lang.String fileTypefromExtension;
            java.lang.String name = file.getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (iLastIndexOf <= 0 || (fileTypefromExtension = com.facebook.cache.disk.DefaultDiskStorage.getFileTypefromExtension(name.substring(iLastIndexOf))) == null) {
                return null;
            }
            java.lang.String strSubstring = name.substring(0, iLastIndexOf);
            if (fileTypefromExtension.equals(".tmp")) {
                int iLastIndexOf2 = strSubstring.lastIndexOf(46);
                if (iLastIndexOf2 <= 0) {
                    return null;
                }
                strSubstring = strSubstring.substring(0, iLastIndexOf2);
            }
            return new com.facebook.cache.disk.DefaultDiskStorage.FileInfo(fileTypefromExtension, strSubstring);
        }
    }

    class InserterImpl implements com.facebook.cache.disk.DiskStorage.Inserter {
        private final java.lang.String mResourceId;
        final java.io.File mTemporaryFile;

        public InserterImpl(java.lang.String str, java.io.File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(com.facebook.cache.common.WriterCallback writerCallback, java.lang.Object obj) throws java.io.IOException {
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.mTemporaryFile);
                try {
                    com.facebook.common.internal.CountingOutputStream countingOutputStream = new com.facebook.common.internal.CountingOutputStream(fileOutputStream);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long count = countingOutputStream.getCount();
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != count) {
                        throw new com.facebook.cache.disk.DefaultDiskStorage.IncompleteFileException(count, this.mTemporaryFile.length());
                    }
                } catch (java.lang.Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (java.io.FileNotFoundException e) {
                com.facebook.cache.disk.DefaultDiskStorage.this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, com.facebook.cache.disk.DefaultDiskStorage.TAG, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public com.facebook.binaryresource.BinaryResource commit(java.lang.Object obj) throws java.io.IOException {
            return commit(obj, com.facebook.cache.disk.DefaultDiskStorage.this.mClock.now());
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public com.facebook.binaryresource.BinaryResource commit(java.lang.Object obj, long j) throws java.io.IOException {
            com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            java.io.File contentFileFor = com.facebook.cache.disk.DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                com.facebook.common.file.FileUtils.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    contentFileFor.setLastModified(j);
                }
                return com.facebook.binaryresource.FileBinaryResource.create(contentFileFor);
            } catch (com.facebook.common.file.FileUtils.RenameException e) {
                java.lang.Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof com.facebook.common.file.FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof java.io.FileNotFoundException) {
                    cacheErrorCategory = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                com.facebook.cache.disk.DefaultDiskStorage.this.mCacheErrorLogger.logError(cacheErrorCategory, com.facebook.cache.disk.DefaultDiskStorage.TAG, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }
    }
}
