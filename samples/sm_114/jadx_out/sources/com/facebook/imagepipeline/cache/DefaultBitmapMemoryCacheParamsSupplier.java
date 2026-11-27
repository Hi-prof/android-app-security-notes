package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = 256;
    private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    private static final long PARAMS_CHECK_INTERVAL_MS = java.util.concurrent.TimeUnit.MINUTES.toMillis(5);
    private final android.app.ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(android.app.ActivityManager activityManager) {
        this.mActivityManager = activityManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public com.facebook.imagepipeline.cache.MemoryCacheParams get() {
        return new com.facebook.imagepipeline.cache.MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, PARAMS_CHECK_INTERVAL_MS);
    }

    private int getMaxCacheSize() {
        int iMin = java.lang.Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (iMin < 33554432) {
            return 4194304;
        }
        if (iMin < 67108864) {
            return 6291456;
        }
        return iMin / 4;
    }
}
