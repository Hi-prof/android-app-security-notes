package com.facebook.imagepipeline.cache;

/* JADX INFO: compiled from: BitmapMemoryCacheTrimStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheTrimStrategy;", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "<init>", "()V", "getTrimRatio", "", "trimType", "Lcom/facebook/common/memory/MemoryTrimType;", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapMemoryCacheTrimStrategy implements com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy {
    private static final java.lang.String TAG = "BitmapMemoryCacheTrimStrategy";

    /* JADX INFO: compiled from: BitmapMemoryCacheTrimStrategy.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.facebook.common.memory.MemoryTrimType.values().length];
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInBackgroundLowSeverity.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy
    public double getTrimRatio(com.facebook.common.memory.MemoryTrimType trimType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(trimType, "trimType");
        int i = com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy.WhenMappings.$EnumSwitchMapping$0[trimType.ordinal()];
        if (i == 1) {
            return com.facebook.common.memory.MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
        }
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            return 1.0d;
        }
        com.facebook.common.logging.FLog.wtf(TAG, "unknown trim type: %s", trimType);
        return 0.0d;
    }
}
