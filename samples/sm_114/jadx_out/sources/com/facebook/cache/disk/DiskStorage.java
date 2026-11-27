package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public interface DiskStorage {

    public static class DiskDumpInfo {
        public java.util.List<com.facebook.cache.disk.DiskStorage.DiskDumpInfoEntry> entries = new java.util.ArrayList();
        public java.util.Map<java.lang.String, java.lang.Integer> typeCounts = new java.util.HashMap();
    }

    public interface Entry {
        java.lang.String getId();

        com.facebook.binaryresource.BinaryResource getResource();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
        boolean cleanUp();

        com.facebook.binaryresource.BinaryResource commit(java.lang.Object obj) throws java.io.IOException;

        com.facebook.binaryresource.BinaryResource commit(java.lang.Object obj, long j) throws java.io.IOException;

        void writeData(com.facebook.cache.common.WriterCallback writerCallback, java.lang.Object obj) throws java.io.IOException;
    }

    void clearAll() throws java.io.IOException;

    boolean contains(java.lang.String str, java.lang.Object obj) throws java.io.IOException;

    com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.io.IOException;

    java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> getEntries() throws java.io.IOException;

    @javax.annotation.Nullable
    com.facebook.binaryresource.BinaryResource getResource(java.lang.String str, java.lang.Object obj) throws java.io.IOException;

    java.lang.String getStorageName();

    com.facebook.cache.disk.DiskStorage.Inserter insert(java.lang.String str, java.lang.Object obj) throws java.io.IOException;

    boolean isEnabled();

    boolean isExternal();

    void purgeUnexpectedResources();

    long remove(com.facebook.cache.disk.DiskStorage.Entry entry) throws java.io.IOException;

    long remove(java.lang.String str) throws java.io.IOException;

    boolean touch(java.lang.String str, java.lang.Object obj) throws java.io.IOException;

    public static class DiskDumpInfoEntry {
        public final java.lang.String firstBits;
        public final java.lang.String id;
        public final java.lang.String path;
        public final float size;
        public final java.lang.String type;

        protected DiskDumpInfoEntry(java.lang.String str, java.lang.String str2, java.lang.String str3, float f, java.lang.String str4) {
            this.id = str;
            this.path = str2;
            this.type = str3;
            this.size = f;
            this.firstBits = str4;
        }
    }
}
