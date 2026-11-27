package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class NativeMemoryCacheTrimStrategy implements com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy {
    private static final java.lang.String TAG = "NativeMemoryCacheTrimStrategy";

    /* JADX INFO: renamed from: com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$common$memory$MemoryTrimType;

        static {
            int[] iArr = new int[com.facebook.common.memory.MemoryTrimType.values().length];
            $SwitchMap$com$facebook$common$memory$MemoryTrimType = iArr;
            try {
                iArr[com.facebook.common.memory.MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType[com.facebook.common.memory.MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType[com.facebook.common.memory.MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType[com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType[com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInBackgroundLowSeverity.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy
    public double getTrimRatio(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        int i = com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy.AnonymousClass1.$SwitchMap$com$facebook$common$memory$MemoryTrimType[memoryTrimType.ordinal()];
        if (i == 1) {
            return 0.0d;
        }
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            return 1.0d;
        }
        com.facebook.common.logging.FLog.wtf(TAG, "unknown trim type: %s", memoryTrimType);
        return 0.0d;
    }
}
