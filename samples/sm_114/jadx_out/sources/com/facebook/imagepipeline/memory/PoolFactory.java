package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class PoolFactory {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.MemoryChunkPool mAshmemMemoryChunkPool;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.BitmapPool mBitmapPool;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.MemoryChunkPool mBufferMemoryChunkPool;
    private final com.facebook.imagepipeline.memory.PoolConfig mConfig;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.FlexByteArrayPool mFlexByteArrayPool;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.MemoryChunkPool mNativeMemoryChunkPool;

    @javax.annotation.Nullable
    private com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    @javax.annotation.Nullable
    private com.facebook.common.memory.PooledByteStreams mPooledByteStreams;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.SharedByteArray mSharedByteArray;

    @javax.annotation.Nullable
    private com.facebook.common.memory.ByteArrayPool mSmallByteArrayPool;

    public PoolFactory(com.facebook.imagepipeline.memory.PoolConfig poolConfig) {
        this.mConfig = (com.facebook.imagepipeline.memory.PoolConfig) com.facebook.common.internal.Preconditions.checkNotNull(poolConfig);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0092  */
    public com.facebook.imagepipeline.memory.BitmapPool getBitmapPool() {
        if (this.mBitmapPool == null) {
            java.lang.String bitmapPoolType = this.mConfig.getBitmapPoolType();
            switch (bitmapPoolType.hashCode()) {
                case -1868884870:
                    if (!bitmapPoolType.equals("legacy_default_params")) {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    } else {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), com.facebook.imagepipeline.memory.DefaultBitmapPoolParams.get(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    }
                    break;
                case -1106578487:
                    bitmapPoolType.equals("legacy");
                    this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    break;
                case -404562712:
                    if (!bitmapPoolType.equals("experimental")) {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    } else {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.LruBitmapPool(this.mConfig.getBitmapPoolMaxPoolSize(), this.mConfig.getBitmapPoolMaxBitmapSize(), com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.getInstance(), this.mConfig.isRegisterLruBitmapPoolAsMemoryTrimmable() ? this.mConfig.getMemoryTrimmableRegistry() : null);
                    }
                    break;
                case -402149703:
                    if (!bitmapPoolType.equals("dummy_with_tracking")) {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    } else {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.DummyTrackingInUseBitmapPool();
                    }
                    break;
                case 95945896:
                    if (!bitmapPoolType.equals("dummy")) {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    } else {
                        this.mBitmapPool = new com.facebook.imagepipeline.memory.DummyBitmapPool();
                    }
                    break;
                default:
                    this.mBitmapPool = new com.facebook.imagepipeline.memory.BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
                    break;
            }
        }
        return this.mBitmapPool;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.memory.MemoryChunkPool getBufferMemoryChunkPool() {
        if (this.mBufferMemoryChunkPool == null) {
            try {
                this.mBufferMemoryChunkPool = (com.facebook.imagepipeline.memory.MemoryChunkPool) java.lang.Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(com.facebook.common.memory.MemoryTrimmableRegistry.class, com.facebook.imagepipeline.memory.PoolParams.class, com.facebook.imagepipeline.memory.PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
            } catch (java.lang.ClassNotFoundException unused) {
                this.mBufferMemoryChunkPool = null;
            } catch (java.lang.IllegalAccessException unused2) {
                this.mBufferMemoryChunkPool = null;
            } catch (java.lang.InstantiationException unused3) {
                this.mBufferMemoryChunkPool = null;
            } catch (java.lang.NoSuchMethodException unused4) {
                this.mBufferMemoryChunkPool = null;
            } catch (java.lang.reflect.InvocationTargetException unused5) {
                this.mBufferMemoryChunkPool = null;
            }
        }
        return this.mBufferMemoryChunkPool;
    }

    public com.facebook.imagepipeline.memory.FlexByteArrayPool getFlexByteArrayPool() {
        if (this.mFlexByteArrayPool == null) {
            this.mFlexByteArrayPool = new com.facebook.imagepipeline.memory.FlexByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
        }
        return this.mFlexByteArrayPool;
    }

    public int getFlexByteArrayPoolMaxNumThreads() {
        return this.mConfig.getFlexByteArrayPoolParams().maxNumThreads;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.memory.MemoryChunkPool getNativeMemoryChunkPool() {
        if (this.mNativeMemoryChunkPool == null) {
            try {
                this.mNativeMemoryChunkPool = (com.facebook.imagepipeline.memory.MemoryChunkPool) java.lang.Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(com.facebook.common.memory.MemoryTrimmableRegistry.class, com.facebook.imagepipeline.memory.PoolParams.class, com.facebook.imagepipeline.memory.PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
            } catch (java.lang.ClassNotFoundException e) {
                com.facebook.common.logging.FLog.e("PoolFactory", "", e);
                this.mNativeMemoryChunkPool = null;
            } catch (java.lang.IllegalAccessException e2) {
                com.facebook.common.logging.FLog.e("PoolFactory", "", e2);
                this.mNativeMemoryChunkPool = null;
            } catch (java.lang.InstantiationException e3) {
                com.facebook.common.logging.FLog.e("PoolFactory", "", e3);
                this.mNativeMemoryChunkPool = null;
            } catch (java.lang.NoSuchMethodException e4) {
                com.facebook.common.logging.FLog.e("PoolFactory", "", e4);
                this.mNativeMemoryChunkPool = null;
            } catch (java.lang.reflect.InvocationTargetException e5) {
                com.facebook.common.logging.FLog.e("PoolFactory", "", e5);
                this.mNativeMemoryChunkPool = null;
            }
        }
        return this.mNativeMemoryChunkPool;
    }

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.MemoryChunkPool getAshmemMemoryChunkPool() {
        if (this.mAshmemMemoryChunkPool == null) {
            try {
                this.mAshmemMemoryChunkPool = (com.facebook.imagepipeline.memory.MemoryChunkPool) java.lang.Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(com.facebook.common.memory.MemoryTrimmableRegistry.class, com.facebook.imagepipeline.memory.PoolParams.class, com.facebook.imagepipeline.memory.PoolStatsTracker.class).newInstance(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
            } catch (java.lang.ClassNotFoundException unused) {
                this.mAshmemMemoryChunkPool = null;
            } catch (java.lang.IllegalAccessException unused2) {
                this.mAshmemMemoryChunkPool = null;
            } catch (java.lang.InstantiationException unused3) {
                this.mAshmemMemoryChunkPool = null;
            } catch (java.lang.NoSuchMethodException unused4) {
                this.mAshmemMemoryChunkPool = null;
            } catch (java.lang.reflect.InvocationTargetException unused5) {
                this.mAshmemMemoryChunkPool = null;
            }
        }
        return this.mAshmemMemoryChunkPool;
    }

    public com.facebook.common.memory.PooledByteBufferFactory getPooledByteBufferFactory() {
        return getPooledByteBufferFactory(!com.facebook.imagepipeline.core.NativeCodeSetup.getUseNativeCode() ? 1 : 0);
    }

    public com.facebook.common.memory.PooledByteBufferFactory getPooledByteBufferFactory(int i) {
        if (this.mPooledByteBufferFactory == null) {
            com.facebook.imagepipeline.memory.MemoryChunkPool memoryChunkPool = getMemoryChunkPool(i);
            com.facebook.common.internal.Preconditions.checkNotNull(memoryChunkPool, "failed to get pool for chunk type: " + i);
            this.mPooledByteBufferFactory = new com.facebook.imagepipeline.memory.MemoryPooledByteBufferFactory(memoryChunkPool, getPooledByteStreams());
        }
        return this.mPooledByteBufferFactory;
    }

    public com.facebook.common.memory.PooledByteStreams getPooledByteStreams() {
        if (this.mPooledByteStreams == null) {
            this.mPooledByteStreams = new com.facebook.common.memory.PooledByteStreams(getSmallByteArrayPool());
        }
        return this.mPooledByteStreams;
    }

    public com.facebook.imagepipeline.memory.SharedByteArray getSharedByteArray() {
        if (this.mSharedByteArray == null) {
            this.mSharedByteArray = new com.facebook.imagepipeline.memory.SharedByteArray(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
        }
        return this.mSharedByteArray;
    }

    public com.facebook.common.memory.ByteArrayPool getSmallByteArrayPool() {
        if (this.mSmallByteArrayPool == null) {
            this.mSmallByteArrayPool = new com.facebook.imagepipeline.memory.GenericByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getSmallByteArrayPoolParams(), this.mConfig.getSmallByteArrayPoolStatsTracker());
        }
        return this.mSmallByteArrayPool;
    }

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.memory.MemoryChunkPool getMemoryChunkPool(int i) {
        if (i == 0) {
            return getNativeMemoryChunkPool();
        }
        if (i == 1) {
            return getBufferMemoryChunkPool();
        }
        if (i == 2) {
            return getAshmemMemoryChunkPool();
        }
        throw new java.lang.IllegalArgumentException("Invalid MemoryChunkType");
    }
}
