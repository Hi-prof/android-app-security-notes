package com.facebook.common.statfs;

/* JADX INFO: loaded from: classes.dex */
public class StatFsHelper {
    public static final long DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES = 1048576000;
    public static final long DEFAULT_DISK_RED_LEVEL_IN_BYTES = 104857600;
    public static final int DEFAULT_DISK_RED_LEVEL_IN_MB = 100;
    public static final long DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES = 419430400;
    public static final int DEFAULT_DISK_YELLOW_LEVEL_IN_MB = 400;
    private static final long RESTAT_INTERVAL_MS = java.util.concurrent.TimeUnit.MINUTES.toMillis(2);
    private static com.facebook.common.statfs.StatFsHelper sStatsFsHelper;

    @javax.annotation.Nullable
    private volatile java.io.File mExternalPath;

    @javax.annotation.Nullable
    private volatile java.io.File mInternalPath;
    private long mLastRestatTime;

    @javax.annotation.Nullable
    private volatile android.os.StatFs mInternalStatFs = null;

    @javax.annotation.Nullable
    private volatile android.os.StatFs mExternalStatFs = null;
    private volatile boolean mInitialized = false;
    private final java.util.concurrent.locks.Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static synchronized com.facebook.common.statfs.StatFsHelper getInstance() {
        if (sStatsFsHelper == null) {
            sStatsFsHelper = new com.facebook.common.statfs.StatFsHelper();
        }
        return sStatsFsHelper;
    }

    protected StatFsHelper() {
    }

    private void ensureInitialized() {
        if (this.mInitialized) {
            return;
        }
        this.lock.lock();
        try {
            if (!this.mInitialized) {
                this.mInternalPath = android.os.Environment.getDataDirectory();
                this.mExternalPath = android.os.Environment.getExternalStorageDirectory();
                updateStats();
                this.mInitialized = true;
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean testLowDiskSpace(com.facebook.common.statfs.StatFsHelper.StorageType storageType, long j) {
        ensureInitialized();
        long availableStorageSpace = getAvailableStorageSpace(storageType);
        return availableStorageSpace <= 0 || availableStorageSpace < j;
    }

    public long getFreeStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        android.os.StatFs statFs = storageType == com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getFreeBlocksLong();
        }
        return -1L;
    }

    public long getTotalStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        android.os.StatFs statFs = storageType == com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        }
        return -1L;
    }

    public long getAvailableStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType storageType) {
        ensureInitialized();
        maybeUpdateStats();
        android.os.StatFs statFs = storageType == com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL ? this.mInternalStatFs : this.mExternalStatFs;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return 0L;
    }

    public boolean isLowSpaceCondition() {
        return getAvailableStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL) < DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES;
    }

    public boolean isVeryLowSpaceCondition() {
        return getAvailableStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL) < DEFAULT_DISK_RED_LEVEL_IN_BYTES;
    }

    public boolean isHighSpaceCondition() {
        return getAvailableStorageSpace(com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL) > DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES;
    }

    private void maybeUpdateStats() {
        if (this.lock.tryLock()) {
            try {
                if (android.os.SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS) {
                    updateStats();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void resetStats() {
        if (this.lock.tryLock()) {
            try {
                ensureInitialized();
                updateStats();
            } finally {
                this.lock.unlock();
            }
        }
    }

    private void updateStats() {
        this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
        this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
        this.mLastRestatTime = android.os.SystemClock.uptimeMillis();
    }

    @javax.annotation.Nullable
    private android.os.StatFs updateStatsHelper(@javax.annotation.Nullable android.os.StatFs statFs, @javax.annotation.Nullable java.io.File file) {
        if (file != null && file.exists()) {
            try {
                if (statFs == null) {
                    return createStatFs(file.getAbsolutePath());
                }
                statFs.restat(file.getAbsolutePath());
                return statFs;
            } catch (java.lang.IllegalArgumentException unused) {
            } catch (java.lang.Throwable th) {
                throw com.facebook.common.internal.Throwables.propagate(th);
            }
        }
        return null;
    }

    protected static android.os.StatFs createStatFs(java.lang.String str) {
        return new android.os.StatFs(str);
    }
}
