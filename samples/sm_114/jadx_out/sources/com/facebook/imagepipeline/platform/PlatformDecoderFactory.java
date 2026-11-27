package com.facebook.imagepipeline.platform;

/* JADX INFO: compiled from: PlatformDecoderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/platform/PlatformDecoderFactory;", "", "<init>", "()V", "buildPlatformDecoder", "Lcom/facebook/imagepipeline/platform/PlatformDecoder;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "gingerbreadDecoderEnabled", "", "useDecodeBufferHelper", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "createPool", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformDecoderFactory {
    public static final com.facebook.imagepipeline.platform.PlatformDecoderFactory INSTANCE = new com.facebook.imagepipeline.platform.PlatformDecoderFactory();

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.platform.PlatformDecoder buildPlatformDecoder(com.facebook.imagepipeline.memory.PoolFactory poolFactory, boolean z, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        return buildPlatformDecoder$default(poolFactory, z, false, platformDecoderOptions, 4, null);
    }

    private PlatformDecoderFactory() {
    }

    public static /* synthetic */ com.facebook.imagepipeline.platform.PlatformDecoder buildPlatformDecoder$default(com.facebook.imagepipeline.memory.PoolFactory poolFactory, boolean z, boolean z2, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return buildPlatformDecoder(poolFactory, z, z2, platformDecoderOptions);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.platform.PlatformDecoder buildPlatformDecoder(com.facebook.imagepipeline.memory.PoolFactory poolFactory, boolean gingerbreadDecoderEnabled, boolean useDecodeBufferHelper, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            com.facebook.imagepipeline.memory.BitmapPool bitmapPool = poolFactory.getBitmapPool();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapPool, "getBitmapPool(...)");
            return new com.facebook.imagepipeline.platform.OreoDecoder(bitmapPool, createPool(poolFactory, useDecodeBufferHelper), platformDecoderOptions);
        }
        com.facebook.imagepipeline.memory.BitmapPool bitmapPool2 = poolFactory.getBitmapPool();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapPool2, "getBitmapPool(...)");
        return new com.facebook.imagepipeline.platform.ArtDecoder(bitmapPool2, createPool(poolFactory, useDecodeBufferHelper), platformDecoderOptions);
    }

    @kotlin.jvm.JvmStatic
    public static final androidx.core.util.Pools.Pool<java.nio.ByteBuffer> createPool(com.facebook.imagepipeline.memory.PoolFactory poolFactory, boolean useDecodeBufferHelper) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        if (useDecodeBufferHelper) {
            com.facebook.common.memory.DecodeBufferHelper INSTANCE2 = com.facebook.common.memory.DecodeBufferHelper.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        androidx.core.util.Pools.SynchronizedPool synchronizedPool = new androidx.core.util.Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads);
        for (int i = 0; i < flexByteArrayPoolMaxNumThreads; i++) {
            java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(com.facebook.common.memory.DecodeBufferHelper.getRecommendedDecodeBufferSize());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
            synchronizedPool.release(byteBufferAllocate);
        }
        return synchronizedPool;
    }
}
