package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheConfig {
    private final java.lang.String mBaseDirectoryName;
    private final com.facebook.common.internal.Supplier<java.io.File> mBaseDirectoryPathSupplier;
    private final com.facebook.cache.common.CacheErrorLogger mCacheErrorLogger;

    @javax.annotation.Nullable
    private final com.facebook.cache.common.CacheEventListener mCacheEventListener;

    @javax.annotation.Nullable
    private final android.content.Context mContext;
    private final long mDefaultSizeLimit;
    private final com.facebook.common.disk.DiskTrimmableRegistry mDiskTrimmableRegistry;
    private final com.facebook.cache.disk.EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    private final long mLowDiskSpaceSizeLimit;
    private final long mMinimumSizeLimit;
    private final int mVersion;

    protected DiskCacheConfig(com.facebook.cache.disk.DiskCacheConfig.Builder builder) {
        com.facebook.cache.common.CacheErrorLogger noOpCacheErrorLogger;
        com.facebook.cache.common.CacheEventListener noOpCacheEventListener;
        com.facebook.common.disk.DiskTrimmableRegistry noOpDiskTrimmableRegistry;
        android.content.Context context = builder.mContext;
        this.mContext = context;
        com.facebook.common.internal.Preconditions.checkState((builder.mBaseDirectoryPathSupplier == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (builder.mBaseDirectoryPathSupplier == null && context != null) {
            builder.mBaseDirectoryPathSupplier = new com.facebook.common.internal.Supplier<java.io.File>() { // from class: com.facebook.cache.disk.DiskCacheConfig.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.facebook.common.internal.Supplier
                public java.io.File get() {
                    com.facebook.common.internal.Preconditions.checkNotNull(com.facebook.cache.disk.DiskCacheConfig.this.mContext);
                    return com.facebook.cache.disk.DiskCacheConfig.this.mContext.getApplicationContext().getCacheDir();
                }
            };
        }
        this.mVersion = builder.mVersion;
        this.mBaseDirectoryName = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(builder.mBaseDirectoryName);
        this.mBaseDirectoryPathSupplier = (com.facebook.common.internal.Supplier) com.facebook.common.internal.Preconditions.checkNotNull(builder.mBaseDirectoryPathSupplier);
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        this.mEntryEvictionComparatorSupplier = (com.facebook.cache.disk.EntryEvictionComparatorSupplier) com.facebook.common.internal.Preconditions.checkNotNull(builder.mEntryEvictionComparatorSupplier);
        if (builder.mCacheErrorLogger == null) {
            noOpCacheErrorLogger = com.facebook.cache.common.NoOpCacheErrorLogger.getInstance();
        } else {
            noOpCacheErrorLogger = builder.mCacheErrorLogger;
        }
        this.mCacheErrorLogger = noOpCacheErrorLogger;
        if (builder.mCacheEventListener == null) {
            noOpCacheEventListener = com.facebook.cache.common.NoOpCacheEventListener.getInstance();
        } else {
            noOpCacheEventListener = builder.mCacheEventListener;
        }
        this.mCacheEventListener = noOpCacheEventListener;
        if (builder.mDiskTrimmableRegistry == null) {
            noOpDiskTrimmableRegistry = com.facebook.common.disk.NoOpDiskTrimmableRegistry.getInstance();
        } else {
            noOpDiskTrimmableRegistry = builder.mDiskTrimmableRegistry;
        }
        this.mDiskTrimmableRegistry = noOpDiskTrimmableRegistry;
        this.mIndexPopulateAtStartupEnabled = builder.mIndexPopulateAtStartupEnabled;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public java.lang.String getBaseDirectoryName() {
        return this.mBaseDirectoryName;
    }

    public com.facebook.common.internal.Supplier<java.io.File> getBaseDirectoryPathSupplier() {
        return this.mBaseDirectoryPathSupplier;
    }

    public long getDefaultSizeLimit() {
        return this.mDefaultSizeLimit;
    }

    public long getLowDiskSpaceSizeLimit() {
        return this.mLowDiskSpaceSizeLimit;
    }

    public long getMinimumSizeLimit() {
        return this.mMinimumSizeLimit;
    }

    public com.facebook.cache.disk.EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
        return this.mEntryEvictionComparatorSupplier;
    }

    public com.facebook.cache.common.CacheErrorLogger getCacheErrorLogger() {
        return this.mCacheErrorLogger;
    }

    @javax.annotation.Nullable
    public com.facebook.cache.common.CacheEventListener getCacheEventListener() {
        return this.mCacheEventListener;
    }

    public com.facebook.common.disk.DiskTrimmableRegistry getDiskTrimmableRegistry() {
        return this.mDiskTrimmableRegistry;
    }

    @javax.annotation.Nullable
    public android.content.Context getContext() {
        return this.mContext;
    }

    public boolean getIndexPopulateAtStartupEnabled() {
        return this.mIndexPopulateAtStartupEnabled;
    }

    public static com.facebook.cache.disk.DiskCacheConfig.Builder newBuilder(@javax.annotation.Nullable android.content.Context context) {
        return new com.facebook.cache.disk.DiskCacheConfig.Builder(context);
    }

    public static final class Builder {
        private java.lang.String mBaseDirectoryName;

        @javax.annotation.Nullable
        private com.facebook.common.internal.Supplier<java.io.File> mBaseDirectoryPathSupplier;

        @javax.annotation.Nullable
        private com.facebook.cache.common.CacheErrorLogger mCacheErrorLogger;

        @javax.annotation.Nullable
        private com.facebook.cache.common.CacheEventListener mCacheEventListener;

        @javax.annotation.Nullable
        private final android.content.Context mContext;

        @javax.annotation.Nullable
        private com.facebook.common.disk.DiskTrimmableRegistry mDiskTrimmableRegistry;
        private com.facebook.cache.disk.EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
        private boolean mIndexPopulateAtStartupEnabled;
        private long mMaxCacheSize;
        private long mMaxCacheSizeOnLowDiskSpace;
        private long mMaxCacheSizeOnVeryLowDiskSpace;
        private int mVersion;

        private Builder(@javax.annotation.Nullable android.content.Context context) {
            this.mVersion = 1;
            this.mBaseDirectoryName = "image_cache";
            this.mMaxCacheSize = 41943040L;
            this.mMaxCacheSizeOnLowDiskSpace = 10485760L;
            this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
            this.mEntryEvictionComparatorSupplier = new com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier();
            this.mContext = context;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setVersion(int i) {
            this.mVersion = i;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setBaseDirectoryName(java.lang.String str) {
            this.mBaseDirectoryName = str;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setBaseDirectoryPath(java.io.File file) {
            this.mBaseDirectoryPathSupplier = com.facebook.common.internal.Suppliers.of(file);
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setBaseDirectoryPathSupplier(com.facebook.common.internal.Supplier<java.io.File> supplier) {
            this.mBaseDirectoryPathSupplier = supplier;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setMaxCacheSize(long j) {
            this.mMaxCacheSize = j;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setMaxCacheSizeOnLowDiskSpace(long j) {
            this.mMaxCacheSizeOnLowDiskSpace = j;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setMaxCacheSizeOnVeryLowDiskSpace(long j) {
            this.mMaxCacheSizeOnVeryLowDiskSpace = j;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setEntryEvictionComparatorSupplier(com.facebook.cache.disk.EntryEvictionComparatorSupplier entryEvictionComparatorSupplier) {
            this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setCacheErrorLogger(com.facebook.cache.common.CacheErrorLogger cacheErrorLogger) {
            this.mCacheErrorLogger = cacheErrorLogger;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setCacheEventListener(com.facebook.cache.common.CacheEventListener cacheEventListener) {
            this.mCacheEventListener = cacheEventListener;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setDiskTrimmableRegistry(com.facebook.common.disk.DiskTrimmableRegistry diskTrimmableRegistry) {
            this.mDiskTrimmableRegistry = diskTrimmableRegistry;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig.Builder setIndexPopulateAtStartupEnabled(boolean z) {
            this.mIndexPopulateAtStartupEnabled = z;
            return this;
        }

        public com.facebook.cache.disk.DiskCacheConfig build() {
            return new com.facebook.cache.disk.DiskCacheConfig(this);
        }
    }
}
