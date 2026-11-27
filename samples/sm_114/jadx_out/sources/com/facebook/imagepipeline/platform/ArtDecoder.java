package com.facebook.imagepipeline.platform;

/* JADX INFO: compiled from: ArtDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/facebook/imagepipeline/platform/ArtDecoder;", "Lcom/facebook/imagepipeline/platform/DefaultDecoder;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "decodeBuffers", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "<init>", "(Lcom/facebook/imagepipeline/memory/BitmapPool;Landroidx/core/util/Pools$Pool;Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;)V", "getBitmapSize", "", "width", "height", "options", "Landroid/graphics/BitmapFactory$Options;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArtDecoder extends com.facebook.imagepipeline.platform.DefaultDecoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtDecoder(com.facebook.imagepipeline.memory.BitmapPool bitmapPool, androidx.core.util.Pools.Pool<java.nio.ByteBuffer> decodeBuffers, com.facebook.imagepipeline.platform.PlatformDecoderOptions platformDecoderOptions) {
        super(bitmapPool, decodeBuffers, platformDecoderOptions);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int width, int height, android.graphics.BitmapFactory.Options options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        android.graphics.Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        return com.facebook.imageutils.BitmapUtil.getSizeInByteForBitmap(width, height, config);
    }
}
