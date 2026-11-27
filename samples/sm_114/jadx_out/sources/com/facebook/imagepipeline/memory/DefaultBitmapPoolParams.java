package com.facebook.imagepipeline.memory;

/* JADX INFO: compiled from: DefaultBitmapPoolParams.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/imagepipeline/memory/DefaultBitmapPoolParams;", "", "<init>", "()V", "MAX_SIZE_SOFT_CAP", "", "maxSizeHardCap", "getMaxSizeHardCap", "()I", "DEFAULT_BUCKETS", "Landroid/util/SparseIntArray;", "get", "Lcom/facebook/imagepipeline/memory/PoolParams;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultBitmapPoolParams {
    private static final int MAX_SIZE_SOFT_CAP = 0;
    public static final com.facebook.imagepipeline.memory.DefaultBitmapPoolParams INSTANCE = new com.facebook.imagepipeline.memory.DefaultBitmapPoolParams();
    private static final android.util.SparseIntArray DEFAULT_BUCKETS = new android.util.SparseIntArray(0);

    private DefaultBitmapPoolParams() {
    }

    private final int getMaxSizeHardCap() {
        int iMin = (int) java.lang.Math.min(java.lang.Runtime.getRuntime().maxMemory(), 2147483647L);
        if (iMin > 16777216) {
            return (iMin / 4) * 3;
        }
        return iMin / 2;
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.memory.PoolParams get() {
        return new com.facebook.imagepipeline.memory.PoolParams(0, INSTANCE.getMaxSizeHardCap(), DEFAULT_BUCKETS);
    }
}
