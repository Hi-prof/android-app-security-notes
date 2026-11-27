package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    private final int mBitmapPoolMaxBitmapSize;
    private final int mBitmapPoolMaxPoolSize;
    private final com.facebook.imagepipeline.memory.PoolParams mBitmapPoolParams;
    private final com.facebook.imagepipeline.memory.PoolStatsTracker mBitmapPoolStatsTracker;
    private final java.lang.String mBitmapPoolType;
    private final com.facebook.imagepipeline.memory.PoolParams mFlexByteArrayPoolParams;
    private final boolean mIgnoreBitmapPoolHardCap;
    private final com.facebook.imagepipeline.memory.PoolParams mMemoryChunkPoolParams;
    private final com.facebook.imagepipeline.memory.PoolStatsTracker mMemoryChunkPoolStatsTracker;
    private final com.facebook.common.memory.MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private final boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
    private final com.facebook.imagepipeline.memory.PoolParams mSmallByteArrayPoolParams;
    private final com.facebook.imagepipeline.memory.PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    private PoolConfig(com.facebook.imagepipeline.memory.PoolConfig.Builder builder) {
        com.facebook.imagepipeline.memory.PoolParams poolParams;
        com.facebook.imagepipeline.memory.PoolStatsTracker noOpPoolStatsTracker;
        com.facebook.imagepipeline.memory.PoolParams poolParams2;
        com.facebook.common.memory.MemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        com.facebook.imagepipeline.memory.PoolParams poolParams3;
        com.facebook.imagepipeline.memory.PoolStatsTracker noOpPoolStatsTracker2;
        com.facebook.imagepipeline.memory.PoolParams poolParams4;
        com.facebook.imagepipeline.memory.PoolStatsTracker noOpPoolStatsTracker3;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PoolConfig()");
        }
        if (builder.mBitmapPoolParams == null) {
            poolParams = com.facebook.imagepipeline.memory.DefaultBitmapPoolParams.get();
        } else {
            poolParams = builder.mBitmapPoolParams;
        }
        this.mBitmapPoolParams = poolParams;
        if (builder.mBitmapPoolStatsTracker == null) {
            noOpPoolStatsTracker = com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.getInstance();
        } else {
            noOpPoolStatsTracker = builder.mBitmapPoolStatsTracker;
        }
        this.mBitmapPoolStatsTracker = noOpPoolStatsTracker;
        if (builder.mFlexByteArrayPoolParams == null) {
            poolParams2 = com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams.get();
        } else {
            poolParams2 = builder.mFlexByteArrayPoolParams;
        }
        this.mFlexByteArrayPoolParams = poolParams2;
        if (builder.mMemoryTrimmableRegistry == null) {
            noOpMemoryTrimmableRegistry = com.facebook.common.memory.NoOpMemoryTrimmableRegistry.getInstance();
        } else {
            noOpMemoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        }
        this.mMemoryTrimmableRegistry = noOpMemoryTrimmableRegistry;
        if (builder.mMemoryChunkPoolParams == null) {
            poolParams3 = com.facebook.imagepipeline.memory.DefaultNativeMemoryChunkPoolParams.get();
        } else {
            poolParams3 = builder.mMemoryChunkPoolParams;
        }
        this.mMemoryChunkPoolParams = poolParams3;
        if (builder.mMemoryChunkPoolStatsTracker == null) {
            noOpPoolStatsTracker2 = com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.getInstance();
        } else {
            noOpPoolStatsTracker2 = builder.mMemoryChunkPoolStatsTracker;
        }
        this.mMemoryChunkPoolStatsTracker = noOpPoolStatsTracker2;
        if (builder.mSmallByteArrayPoolParams == null) {
            poolParams4 = com.facebook.imagepipeline.memory.DefaultByteArrayPoolParams.get();
        } else {
            poolParams4 = builder.mSmallByteArrayPoolParams;
        }
        this.mSmallByteArrayPoolParams = poolParams4;
        if (builder.mSmallByteArrayPoolStatsTracker == null) {
            noOpPoolStatsTracker3 = com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.getInstance();
        } else {
            noOpPoolStatsTracker3 = builder.mSmallByteArrayPoolStatsTracker;
        }
        this.mSmallByteArrayPoolStatsTracker = noOpPoolStatsTracker3;
        this.mBitmapPoolType = builder.mBitmapPoolType == null ? "legacy" : builder.mBitmapPoolType;
        this.mBitmapPoolMaxPoolSize = builder.mBitmapPoolMaxPoolSize;
        this.mBitmapPoolMaxBitmapSize = builder.mBitmapPoolMaxBitmapSize > 0 ? builder.mBitmapPoolMaxBitmapSize : 4194304;
        this.mRegisterLruBitmapPoolAsMemoryTrimmable = builder.mRegisterLruBitmapPoolAsMemoryTrimmable;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        this.mIgnoreBitmapPoolHardCap = builder.mIgnoreBitmapPoolHardCap;
    }

    public com.facebook.imagepipeline.memory.PoolParams getBitmapPoolParams() {
        return this.mBitmapPoolParams;
    }

    public com.facebook.imagepipeline.memory.PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.mBitmapPoolStatsTracker;
    }

    public com.facebook.common.memory.MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public com.facebook.imagepipeline.memory.PoolParams getMemoryChunkPoolParams() {
        return this.mMemoryChunkPoolParams;
    }

    public com.facebook.imagepipeline.memory.PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.mMemoryChunkPoolStatsTracker;
    }

    public com.facebook.imagepipeline.memory.PoolParams getFlexByteArrayPoolParams() {
        return this.mFlexByteArrayPoolParams;
    }

    public com.facebook.imagepipeline.memory.PoolParams getSmallByteArrayPoolParams() {
        return this.mSmallByteArrayPoolParams;
    }

    public com.facebook.imagepipeline.memory.PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.mSmallByteArrayPoolStatsTracker;
    }

    public java.lang.String getBitmapPoolType() {
        return this.mBitmapPoolType;
    }

    public int getBitmapPoolMaxPoolSize() {
        return this.mBitmapPoolMaxPoolSize;
    }

    public int getBitmapPoolMaxBitmapSize() {
        return this.mBitmapPoolMaxBitmapSize;
    }

    public boolean isRegisterLruBitmapPoolAsMemoryTrimmable() {
        return this.mRegisterLruBitmapPoolAsMemoryTrimmable;
    }

    public boolean isIgnoreBitmapPoolHardCap() {
        return this.mIgnoreBitmapPoolHardCap;
    }

    public static com.facebook.imagepipeline.memory.PoolConfig.Builder newBuilder() {
        return new com.facebook.imagepipeline.memory.PoolConfig.Builder();
    }

    public static final class Builder {
        private int mBitmapPoolMaxBitmapSize;
        private int mBitmapPoolMaxPoolSize;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolParams mBitmapPoolParams;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolStatsTracker mBitmapPoolStatsTracker;

        @javax.annotation.Nullable
        private java.lang.String mBitmapPoolType;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolParams mFlexByteArrayPoolParams;
        public boolean mIgnoreBitmapPoolHardCap;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolParams mMemoryChunkPoolParams;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolStatsTracker mMemoryChunkPoolStatsTracker;

        @javax.annotation.Nullable
        private com.facebook.common.memory.MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private boolean mRegisterLruBitmapPoolAsMemoryTrimmable;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolParams mSmallByteArrayPoolParams;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.memory.PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        private Builder() {
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setBitmapPoolParams(com.facebook.imagepipeline.memory.PoolParams poolParams) {
            this.mBitmapPoolParams = (com.facebook.imagepipeline.memory.PoolParams) com.facebook.common.internal.Preconditions.checkNotNull(poolParams);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setBitmapPoolStatsTracker(com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
            this.mBitmapPoolStatsTracker = (com.facebook.imagepipeline.memory.PoolStatsTracker) com.facebook.common.internal.Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setFlexByteArrayPoolParams(com.facebook.imagepipeline.memory.PoolParams poolParams) {
            this.mFlexByteArrayPoolParams = poolParams;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setMemoryTrimmableRegistry(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setNativeMemoryChunkPoolParams(com.facebook.imagepipeline.memory.PoolParams poolParams) {
            this.mMemoryChunkPoolParams = (com.facebook.imagepipeline.memory.PoolParams) com.facebook.common.internal.Preconditions.checkNotNull(poolParams);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setNativeMemoryChunkPoolStatsTracker(com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
            this.mMemoryChunkPoolStatsTracker = (com.facebook.imagepipeline.memory.PoolStatsTracker) com.facebook.common.internal.Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setSmallByteArrayPoolParams(com.facebook.imagepipeline.memory.PoolParams poolParams) {
            this.mSmallByteArrayPoolParams = (com.facebook.imagepipeline.memory.PoolParams) com.facebook.common.internal.Preconditions.checkNotNull(poolParams);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setSmallByteArrayPoolStatsTracker(com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
            this.mSmallByteArrayPoolStatsTracker = (com.facebook.imagepipeline.memory.PoolStatsTracker) com.facebook.common.internal.Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig build() {
            return new com.facebook.imagepipeline.memory.PoolConfig(this);
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setBitmapPoolType(java.lang.String str) {
            this.mBitmapPoolType = str;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setBitmapPoolMaxPoolSize(int i) {
            this.mBitmapPoolMaxPoolSize = i;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setBitmapPoolMaxBitmapSize(int i) {
            this.mBitmapPoolMaxBitmapSize = i;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean z) {
            this.mRegisterLruBitmapPoolAsMemoryTrimmable = z;
            return this;
        }

        public com.facebook.imagepipeline.memory.PoolConfig.Builder setIgnoreBitmapPoolHardCap(boolean z) {
            this.mIgnoreBitmapPoolHardCap = z;
            return this;
        }
    }
}
