package com.facebook.cache.common;

/* JADX INFO: loaded from: classes.dex */
public interface CacheErrorLogger {

    public enum CacheErrorCategory {
        READ_DECODE,
        READ_FILE,
        READ_FILE_NOT_FOUND,
        READ_INVALID_ENTRY,
        WRITE_ENCODE,
        WRITE_CREATE_TEMPFILE,
        WRITE_UPDATE_FILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND,
        WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND,
        WRITE_RENAME_FILE_OTHER,
        WRITE_CREATE_DIR,
        WRITE_CALLBACK_ERROR,
        WRITE_INVALID_ENTRY,
        DELETE_FILE,
        EVICTION,
        GENERIC_IO,
        OTHER
    }

    void logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory cacheErrorCategory, java.lang.Class<?> cls, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th);
}
