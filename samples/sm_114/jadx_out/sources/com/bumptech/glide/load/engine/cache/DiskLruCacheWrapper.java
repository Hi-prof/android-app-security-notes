package com.bumptech.glide.load.engine.cache;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheWrapper implements com.bumptech.glide.load.engine.cache.DiskCache {
    private static final int APP_VERSION = 1;
    private static final java.lang.String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper wrapper;
    private final java.io.File directory;
    private com.bumptech.glide.disklrucache.DiskLruCache diskLruCache;
    private final long maxSize;
    private final com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker writeLocker = new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker();
    private final com.bumptech.glide.load.engine.cache.SafeKeyGenerator safeKeyGenerator = new com.bumptech.glide.load.engine.cache.SafeKeyGenerator();

    @java.lang.Deprecated
    public static synchronized com.bumptech.glide.load.engine.cache.DiskCache get(java.io.File file, long j) {
        if (wrapper == null) {
            wrapper = new com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper(file, j);
        }
        return wrapper;
    }

    public static com.bumptech.glide.load.engine.cache.DiskCache create(java.io.File file, long j) {
        return new com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper(file, j);
    }

    @java.lang.Deprecated
    protected DiskLruCacheWrapper(java.io.File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    private synchronized com.bumptech.glide.disklrucache.DiskLruCache getDiskCache() throws java.io.IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = com.bumptech.glide.disklrucache.DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public java.io.File get(com.bumptech.glide.load.Key key) {
        java.lang.String safeKey = this.safeKeyGenerator.getSafeKey(key);
        if (android.util.Log.isLoggable(TAG, 2)) {
            android.util.Log.v(TAG, "Get: Obtained: " + safeKey + " for for Key: " + key);
        }
        try {
            com.bumptech.glide.disklrucache.DiskLruCache.Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (java.io.IOException e) {
            if (!android.util.Log.isLoggable(TAG, 5)) {
                return null;
            }
            android.util.Log.w(TAG, "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.cache.DiskCache.Writer writer) {
        java.lang.String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(safeKey);
        try {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Put: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                com.bumptech.glide.disklrucache.DiskLruCache diskCache = getDiskCache();
                if (diskCache.get(safeKey) == null) {
                    com.bumptech.glide.disklrucache.DiskLruCache.Editor editorEdit = diskCache.edit(safeKey);
                    if (editorEdit == null) {
                        throw new java.lang.IllegalStateException("Had two simultaneous puts for: " + safeKey);
                    }
                    try {
                        if (writer.write(editorEdit.getFile(0))) {
                            editorEdit.commit();
                        }
                        editorEdit.abortUnlessCommitted();
                    } catch (java.lang.Throwable th) {
                        editorEdit.abortUnlessCommitted();
                        throw th;
                    }
                }
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable(TAG, 5)) {
                    android.util.Log.w(TAG, "Unable to put to disk cache", e);
                }
            }
            this.writeLocker.release(safeKey);
        } catch (java.lang.Throwable th2) {
            this.writeLocker.release(safeKey);
            throw th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(com.bumptech.glide.load.Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable(TAG, 5)) {
                android.util.Log.w(TAG, "Unable to delete from disk cache", e);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            try {
                getDiskCache().delete();
            } catch (java.io.IOException e) {
                if (android.util.Log.isLoggable(TAG, 5)) {
                    android.util.Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
            resetDiskCache();
        } catch (java.lang.Throwable th) {
            resetDiskCache();
            throw th;
        }
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }
}
